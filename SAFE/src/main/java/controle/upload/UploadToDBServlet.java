package controle.upload;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import modelo.dao.professor.ProfessorDAOImpl;
import modelo.entidade.professor.Professor;

@WebServlet("/uploadToDB")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class UploadToDBServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/view/html/uploadToDB.jsp");
 
        dispatcher.forward(request, response);
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = null;
        try {
            // Connection to Database
            // (See more in JDBC Tutorial).
        	Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cadastrosfe?useTimezone=true&serverTimezone=UTC", "root", "@senac2020");
            conn.setAutoCommit(false);
            
            Long id = Long.parseLong(request.getParameter("id"));
 
            // Part list (multi files).
            for (Part part : request.getParts()) {
                String fileName = extractFileName(part);
                if (fileName != null && fileName.length() > 0) {
                    // File data
                    InputStream is = part.getInputStream();
                    // Write to file
                    this.writeToDB(conn, fileName, is, id);
                }
            }
            conn.commit();
 
            // Upload successfully!.
//            response.sendRedirect(request.getContextPath() + "/uploadToDBResults");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/html/professor?action=enviadoAtividade");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error: " + e.getMessage());
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/html/uploadToDB.jsp");
            dispatcher.forward(request, response);
        } finally {
            this.closeQuietly(conn);
        }
    }
 
    private String extractFileName(Part part) {
        // form-data; name="file"; filename="C:\file1.zip"
        // form-data; name="file"; filename="C:\Note\file2.zip"
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                // C:\file1.zip
                // C:\Note\file2.zip
                String clientFileName = s.substring(s.indexOf("=") + 2, s.length() - 1);
                clientFileName = clientFileName.replace("\\", "/");
                int i = clientFileName.lastIndexOf('/');
                // file1.zip
                // file2.zip
                return clientFileName.substring(i + 1);
            }
        }
        return null;
    }
 
    private Long getMaxAttachmentId(Connection conn) throws SQLException {
        String sql = "Select max(a.id) from Attachment a";
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            long max = rs.getLong(1);
            return max;
        }
        return 0L;
    }
 
    private void writeToDB(Connection conn, String fileName, InputStream is, Long id) throws SQLException {
    	String sql = "UPDATE extraatividade SET arquivo_atividade = ? WHERE id_atividade = ?";
//        String sql = "Insert into Attachment(id,File_Name,File_Data,Description) values (?,?,?,?) ";
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        //Long id = this.getMaxAttachmentId(conn) + 1;
        pstm.setBlob(1, is);
        pstm.setLong(2, id);
        pstm.executeUpdate();
    }
 
    private void closeQuietly(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
        }
    }
 
}
