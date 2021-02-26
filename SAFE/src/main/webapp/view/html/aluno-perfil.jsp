<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">
	<head>
	    <meta charset="UTF-8">
	    <meta name="viewport" content="content=width=device-width, initial-scale=1.0">
	    <title>Perfil</title>
	    <link rel="icon" href="view/img/logo-r-p.png">
	
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	    <link rel="stylesheet" href="view/css/perfil.css">
	</head>
	
	<body style="background-image: url(view/img/background.jpg); ">
	    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
	    <header>
	        <div class="container-fluid px-0 ">
	            <nav class="navbar navbar-expand-lg navbar-dark shadow" style="background-color: #1e294c;">
	                <a href="<%=request.getContextPath() %>/paginaInicial"><img src="view/img/logo-safe.png" class="img-fluid" alt="logo" width="90px"></a>
	
	                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Alterna navegaÃ§Ã£o"><span class="navbar-toggler-icon"></span></button>
	                <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
	                    <div class="navbar-nav mr-auto nav-tabs">
	                        <a class="nav-item nav-link" href="<%=request.getContextPath() %>/aluno?action=paginaInicial" style=" color: #fff;">Pagina Inicial</a>
	                        <a class="nav-item nav-link" href="<%=request.getContextPath() %>/aluno?action=atividades" style=" color: #fff;">Atividades</a>
	                        <a class="nav-item nav-link" href="<%=request.getContextPath() %>/aluno?action=perfil" style=" color: #fff;">Perfil</a>
	                    </div>
	                </div>
	            </nav>
	        </div>
	    </header>
	    
	    <div class="container" style="margin-top: 80px;">
	        <main class="container">
	            <form id="contact" action="<%=request.getContextPath() %>/aluno?action=atualizar" method="POST">
	                <h3 style="text-align: center;">Dados Cadastrados</h3>
	                <hr style="border-width: 3px; border-color: #1e294c;">
	
	                <div class="form-row">
	                    <div class="form-group col-md-6">
	                        <label for="name">Nome</label>
	                        <input type="text" class="form-control" id="name" name="nome" value="${aluno.nome}" placeholder="Roberto">
	                    </div>
	                    <div class="form-group col-md-6">
	                        <label for="sobrenome">Sobrenome</label>
	                        <input type="text" class="form-control" id="sobrenome" name="sobrenome" value="${aluno.sobrenome}" placeholder="Santos">
	                    </div>
	                </div>
	                <div class="form-row">
	                    <div class="form-group col-md-2">
	                        <label for="idade">Idade</label>
	                        <input type="text" class="form-control" id="idade" name="idade" value="${aluno.idade}" placeholder="16">
	                    </div>
	                    <div class="form-group col-md-5">
	                        <label for="cpf">CPF</label>
	                        <input type="text" class="form-control" id="cpf" name="cpf" value="${aluno.cpf}" placeholder="xxx.xxx.xxx-xx">
	                    </div>
	                    <div class="form-group col-md-5">
	                        <label for="matricula">Matrícula</label>
	                        <input type="text" class="form-control" id="matricula" name="matricula" value="${aluno.matricula}" placeholder="xxxxx-xxxxx">
	                    </div>
	                    <hr>
	                    <div class="form-group col-md-6">
	                        <label for="responsavel">Responsável</label>
	                        <input type="text" class="form-control" id="responsavel" name="responsavel" value="${aluno.nomeResponsavel}" placeholder="Regina Almeida">
	                    </div>
	                    <hr>
	                    <div class="form-group col-md-6">
	                        <label for="email">Email</label>
	                        <input type="text" class="form-control" id="email" name="email" value="${aluno.email}" placeholder="joaozinho321@gmail.com">
	                    </div>
	                    <div class="form-group col-md-6">
	                        <label for="senha">Senha</label>
	                        <input type="text" class="form-control" id="senha" name="senha" value="${aluno.senha}" placeholder="joaozinho321">
	                    </div>
	                    <input type="hidden" name="id" value="${aluno.id}">
	                </div>
	
	                <div class="form-check">
	                    <input class="form-check-input" type="checkbox" value="" id="checkbox" required>
	                    <label class="form-check-label" for="flexCheckIndeterminate">
	                     Confirmo<hr>
	                    </label>
	                </div>
	                <button type="submit" value="alterar" name="btnAcao" class="btn btn-primary pull-right">Alterar dados</button>    
				</form>
	        </main>
	
	</body>
</html>