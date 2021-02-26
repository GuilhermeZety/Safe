<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="content=width=device-width, initial-scale=1.0">
    <title>Cadastrar</title>
    <link rel="icon" href="view/img/logo-r-p.png">

    <link rel="stylesheet" href="view/css/main.css">
</head>

<body>
    <main class="container">
        <h2>Cadastrar</h2>
        <form action="">
            <div class="menu">
                <ul>
                    <li><a href="<%=request.getContextPath() %>/professor?action=cadastro">Professor</a></li>
                    <li><a href="<%=request.getContextPath() %>/aluno?action=cadastro">Aluno</a></li>
                </ul>
            </div>
            <div class="footer">
                <span>SAFE</span>
                <span>Sistema auxiliar de frequencias escolares</span>
            </div>
            <div class="logo">
                <a href="<%=request.getContextPath() %>/paginaInicial"><img src="view/img/logo-r-p.png" href="" width="130px" height="130px"></a>


            </div>
        </form>


        <input id="Voltar" type="button" value="Voltar" onClick="history.go(-1)" style="background-color: #fff;">

        <a href="<%=request.getContextPath() %>/login" style="padding-left: 170px;"><button style="background-color: #fff;">Logar-se</button></a>



    </main>
</body>

</html>