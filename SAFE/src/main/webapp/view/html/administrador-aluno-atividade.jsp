<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="content=width=device-width, initial-scale=1.0">

    <title>Atividade Aluno</title>
    <link rel="icon" href="view/img/logo-r-p.png">

    <!-- I = Inicio / F = Final -->

    <!-- I imports -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="view/css/atividades.css">
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
                        <a class="nav-item nav-link" href="<%=request.getContextPath() %>/administrador?action=modificar" style=" color: #fff;">Modificar Perfil</a>
                        <a class="nav-item nav-link" href="<%=request.getContextPath() %>/administrador?action=cadastros" style=" color: #fff;">Cadastrar</a>
                        <a class="nav-item nav-link" href="<%=request.getContextPath() %>/administrador?action=perfil" style=" color: #fff;">Perfil</a>
                        <!-- F definindo itens da navbar -->
                    </div>
                </div>
            </nav>
        </div>
    </header>
    <!-- F navbar -->

    <!-- I Conteúdo -->
    <div class="container" style="margin-top: 40px;">
        <main class="container" id="contact">
            <div>
                <form id="contact" action="/action_page.php" method="">

                    <!-- I Nome Aluno -->
                    <div class="row">
                        <div class="col-md-6" style="text-align: right;">
                            <h3 id="nome">${aluno.nome}</h3>
                        </div>
                        <div class="col-md-6" style="text-align: start;">
                            <h3 id="sobrenome">${aluno.sobrenome}</h3>
                        </div>
                    </div>
                    <hr style="border-width: 3px; border-color: #1e294c;">
                    <!-- F Nome Aluno -->

                    <!-- I Info Atividade -->
                    <div class="form-row">
                        <table class="table table-striped table-hover">
                            <thead>
                                <tr>
                                    <th scope="col">Data</th>
                                    <th scope="col">Mat�ria</th>
                                    <th scope="col">Entregue</th>
                                    <th scope="col">Corrigido</th>
                                    <th scope="col">Nota</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td id="data0">${atividade.dataPostagem}</td>
                                    <td id="materia0">${atividade.materia}</td>
									<c:forEach var="atividadeAluno" items="${aluno.atividades}">
										<c:if test="${atividadeAluno.id == atividade.id}">
			                            	<c:if test="${atividadeAluno.entregue == false}">
			                            		<td id="entregue0">N�o</td>
			                            	</c:if>
			                            	<c:if test="${atividadeAluno.entregue == true}">
			                            		<td id="entregue0">Sim</td>
			                            	</c:if>
			                            	<c:if test="${atividadeAluno.corrigido == false}">
			                            		<td id="corrigido0">N�o</td>
			                            	</c:if>
			                            	<c:if test="${atividadeAluno.corrigido == true}">
			                            		<td id="corrigido0">Sim</td>
			                            	</c:if>
			                            	<td id="nota0">${atividadeAluno.nota}</td>
										</c:if>								
									</c:forEach>
                                    
                                </tr>
                            </tbody>
                        </table>
                        <hr>

                    </div>
                    <!-- F Info Atividade -->

                    <!-- I Arquivos Atividade-->
                    <div class="form-row">
                        <div class="col-md-6">
                            <a class="btn" href="#" id="alter">Aquivo Original Professor</a>
                        </div>
                        <div class="col-md-6">
                            <a class="btn" href="#" id="alter">Aquivo Resolução Entregue Pelo Aluno</a>
                        </div>
                    </div>
                    <!-- F Arquivos Atividade -->
                </form>
            </div>
        </main>
    </div>
    <!-- F Conteúdo -->
</body>

</html>