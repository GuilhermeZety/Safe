<!DOCTYPE html><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="content=width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="icon" href="view/img/logo-r-p.png">

    <link rel="stylesheet" href="view/css/main.css">
</head>

<body>
    <main class="container">
        <h2>Login</h2>
        <form action="">
            <div class="menu">
                <ul>
                    <li><a href="<%=request.getContextPath() %>/professor?action=login">Professor</a></li>
                    <li><a href="<%=request.getContextPath() %>/aluno?action=login">Aluno</a></li>
                </ul>
            </div>
            <div class="footer">
                <span>SAFE</span>
                <span>Sistema auxiliar de frequências escolares</span>
            </div>
            <div class="logo">
                <img src="view/img/logo-r-p.png" width="130px" height="130px">


            </div>
        </form>


        <input id="Voltar" type="button" value="Voltar" onClick="history.go(-1)" style="background-color: #fff;">

        <a href="<%=request.getContextPath() %>/cadastro" style="padding-left: 170px;"><button style="background-color: #fff;">Cadastre-se</button></a>



    </main>
</body>

</html>