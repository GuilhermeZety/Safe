<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="content=width=device-width, initial-scale=1.0">
    <title>Cadastro</title>
    <link rel="icon" href="view/img/logo-r-p.png">

    <!-- I = Inicio / F = Final -->

    <!-- I imports -->

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="view/css/cadastro.css">

</head>



<body id="back">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    <!-- F imports -->

    <!-- I navbar -->
    <header>
        <div class="container-fluid px-0 ">
            <nav class="navbar navbar-expand-lg navbar-dark shadow" style="background-color: #1e294c;">
                <a href="<%=request.getContextPath() %>/paginaInicial"><img src="view/img/logo-safe.png" class="img-fluid" alt="logo" width="90px"></a>

                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Alterna navegação"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                    <div class="navbar-nav mr-auto nav-tabs">

                        <!-- I definindo itens da navbar -->
                        <a class="nav-item nav-link" href="<%=request.getContextPath() %>/administrador?action=paginaInicial" style=" color: #fff;">Pagina Inicial</a>
                        <a class="nav-item nav-link" href="<%=request.getContextPath() %>/administrador?action=turmas" style=" color: #fff;">Atividades</a>
                        <a class="nav-item nav-link" href="<%=request.getContextPath() %>/administrador?action=cadastros" style=" color: #fff;">Cadastrar</a>
                        <a class="nav-item nav-link" href="<%=request.getContextPath() %>/administrador?action=perfil" style=" color: #fff;">Perfil</a>
                        <!-- F definindo itens da navbar -->
                    </div>
                </div>
            </nav>
        </div>
    </header>
    <!-- F navbar -->

    <!-- I conteúdo -->

    <div class="container" style="margin-top: 40px;">
        <main class="container" id="contact">
            <form id="contact" action="<%=request.getContextPath() %>/administrador?action=cadastrarAluno" method="POST">

                <h3 style="text-align: center;">Cadastrando</h3>
                <hr style="border-width: 3px; border-color: #1e294c;">
                <!-- I seleção de Tipo de Cadastro -->
                <!-- F seleção de Tipo de Cadastro -->
                <hr>
                <!-- I Info Cadastro -->
                <div class="form-row">
                    <!-- I Definindo Uma informação -->
                    <div class="form-group col-md-6">

                        <label for="name">Nome</label>
                        <input type="text" class="form-control" id="name" name="nome" placeholder="Roberto" required>
                    </div>
                    <!-- F Definindo Uma informação -->
                    <!-- I Definindo Uma informação -->
                    <div class="form-group col-md-6">
                        <label for="sobrenome">Sobrenome</label>
                        <input type="text" class="form-control" id="sobrenome" name="sobrenome" placeholder="Santos" required>
                    </div>
                    <!-- F Definindo Uma informação -->
                </div>
                <div class="form-row">
                    <!-- I Definindo Uma informação -->
                    <div class="form-group col-md-2">
                        <label for="idade">Idade</label>
                        <input type="text" class="form-control" id="idade" name="idade" placeholder="16" required>
                    </div>
                    <!-- F Definindo Uma informação -->
                    <!-- I Definindo Uma informação -->
                    <div class="form-group col-md-5">
                        <label for="cpf">CPF</label>
                        <input type="text" class="form-control" id="cpf" name="cpf" placeholder="xxx.xxx.xxx-xx" required>
                    </div>
                    <!-- F Definindo Uma informação -->
                    <!-- I Definindo Uma informação -->
                    <div class="form-group col-md-5">
                        <label for="matricula">Matricula</label>
                        <input type="text" class="form-control" id="matricula" name="matricula" placeholder="xxxxx-xxxxx" required>
                    </div>
                    <!-- F Definindo Uma informação -->
                    <!-- I Definindo Uma informação -->
                    <div class="form-group col-md-6">
                        <label for="responsavel">Nome Responsável</label>
                        <input type="text" class="form-control" id="responsavel" name="responsavel" placeholder="Regina Almeida">
                    </div>
                    <div class="form-group col-md-6">
                    	<label for="turma">Turma</label>
	                    <select class="form-control" id="turma" name="turma">
		                    <c:forEach var="turma" items="${turmas}">
		                    	<option value="${turma.id}">${turma}</option>
		                    </c:forEach>
	                    </select>
                    </div>
                    <!-- F Definindo Uma informação -->
                    <!-- I Definindo Uma informação -->
                    <div class="form-group col-md-6">
                        <label for="email">Email</label>
                        <input type="text" class="form-control" id="email" name="email" placeholder="joaozinho321@gmail.com" required>
                    </div>
                    <!-- F Definindo Uma informação -->
                    <!-- I Definindo Uma informação -->
                    <div class="form-group col-md-6">
                        <label for="senha">Senha</label>
                        <input type="text" class="form-control" id="senha" name="senha" placeholder="joaozinho321" required>
                    </div>
                    <!-- F Definindo Uma informação -->
                </div>
                <!-- F Info Cadastro -->
                <!-- I Confirmações -->
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="" id="checkbox" required>
                    <label class="form-check-label" for="checkbox">
                     Confirmo<hr>
                    </label>
                </div>
                <button type="submit" value="alterar" name="btnAcao" class="btn btn-primary pull-right">Cadastrar</button>
                <!-- F Confirmações -->
            </form>
        </main>
    </div>
    <!-- F conteúdo -->
</body>

</html>