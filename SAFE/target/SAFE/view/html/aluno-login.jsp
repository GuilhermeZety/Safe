<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="content=width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="icon" href="view/img/logo-r-p.png">

    <link rel="stylesheet" href="view/css/login.css">
    <link rel="stylesheet" href="https://cdn.linearicons.com/free/1.0.0/icon-font.min.css">
</head>



<body>
    <main class="container">
        <h2>Aluno</h2>
        <form action="<%=request.getContextPath() %>/aluno?action=logar" method="POST">
            <div class="input-field">
                <input type="text" name="matricula" id="matricula" placeholder="Insira sua matricula">
                <div class="underline"></div>
            </div>
            <div class="input-field">
                <input type="password" name="senha" id="senha" placeholder="Insira sua senha" minlength="8" required> <span class="lnr lnr-eye" onclick="mostrarOcultarSenha()"></span>
                <div class="underline"></div>
            </div>
                <input type="submit" value="Continue">
            <div class="logo">
                <img src="view/img/logo-r-p.png" width="130px" height="130px">
            </div>
        </form>



        <input id="Voltar" type="button" value="Voltar" onClick="history.go(-1)" style="background-color: #fff;">

        <a href="<%=request.getContextPath() %>/aluno?action=cadastro" style="padding-left: 140px;"><button style="background-color: #fff;">Cadastre-se</button></a>

        <script type="text/javascript" src="view/js/moSenha.js"></script>
    </main>
</body>

</html>