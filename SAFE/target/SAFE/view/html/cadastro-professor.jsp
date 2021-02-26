<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="content=width=device-width, initial-scale=1.0">
    <title>Cadastro</title>
    <link rel="icon" href="view/img/logo-r-p.png">

    <link rel="stylesheet" href="view/css/login.css">
</head>



<body>
    <main class="container">
        <h2>Professor</h2>
        <h3>ENTRE EM CONTATO COM A SUA INSTITUI√«√ÉO DE ENSINO</h3>
        <hr>
        <br>
        <br><br>
        <h3>PARA EFETUAR O SEU CADASTRO...</h3>
        <br><br><br><br>



        <input id="Voltar" type="button" value="Voltar" onClick="history.go(-1)" style="background-color: #fff;">

        <a href="<%=request.getContextPath() %>/login" style="padding-left: 170px;"><button style="background-color: #fff;">Logar-se</button></a>

        <script type="text/javascript" src="view/js/moSenha.js"></script>
    </main>
</body>

</html>