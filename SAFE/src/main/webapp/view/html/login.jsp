<!DOCTYPE html><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="content=width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="icon" href="view/img/logo-r-p.png">

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="view/css/main.css">
</head>

<body>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>


    <main class="container">
        <h2>Login</h2>
        <form action="">
            <div class="menu">
                <ul class="row">
                	<div class="col">
                    <li><a href="<%=request.getContextPath() %>/professor?action=login">Professor</a></li>
                    </div>
                    <div class="col">
                    <li><a href="<%=request.getContextPath() %>/aluno?action=login">Aluno</a></li>
                    </div>
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