<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="content=width=device-width, initial-scale=1.0">
    <title>Turmas Atividades</title>
    <link rel="icon" href="view/img/logo-r-p.png">

    <!-- I = Inicio / F = Final -->

    <!-- inicio imports -->


    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="view/css/atividades.css">
</head>



<body id="back" style="background-image: url(view/img/background.jpg); ">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    <!-- fim imports -->

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

    <!-- começo main -->
    <div class="container" style="margin-top: 40px;">
        <main class="container" id="contact">

            <h3 style="text-align: center;">Turmas</h3>
            <hr style="border-width: 3px; border-color: #1e294c;">
            <br>

            <!-- I Info Turmas -->
            <div class="form-row" >
                <div class="col-md-12" id="contact">
                    <div id="contact2">
                        <table class="table table-responsive table-striped table-hover" id="alunos" >
                            <thead>
                                <tr>
                                    <th scope="col">Turma</th>
                                    <th scope="col">Ultima atualização</th>
                                    <th scope="col">Atividades</th>
                                </tr>
                            </thead>
                            <tbody>
								<c:forEach var="turma" items="${turmas}">
									<tr>
		                            	<th id="turma0">${turma}</th>
		                            	<td id="data0">17/02/2021</td>
		                            	<td id="atvdd0">
		                                	<a class="btn" href="<%=request.getContextPath() %>/administrador?action=atividades&id=${turma.id}" id="alter">Ver Atividades da Turma</a>
		                            	</td>
		                        	</tr>
								</c:forEach>
                            </tbody>
                        </table>
                         <p style="font-size: 14px">Caso esteja no celular... a tabela é movivel caso não encontre o botão.</p>
                    </div>
                </div>

            </div>

            <!-- F Info Turmas -->
        </main>
    </div>
    <!-- fim do main -->
</body>

</html>