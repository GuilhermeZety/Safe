<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="content=width=device-width, initial-scale=1.0">
    <title>Atividades</title>
    <link rel="icon" href="view/img/logo-r-p.png">

    <!-- inicio imports -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="view/css/aluno-atividade.css">
</head>



<body style="background-image: url(view/img/background.jpg);">

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    <!-- fim imports -->

    <!-- inicio navbar -->
    <header>
        <div class="container-fluid px-0 ">
            <nav class="navbar navbar-expand-lg navbar-dark shadow" style="background-color: #1e294c;">
                <a href="<%=request.getContextPath() %>/paginaInicial"><img src="view/img/logo-safe.png" class="img-fluid" alt="logo" width="90px"></a>

                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Alterna navega��o"><span class="navbar-toggler-icon"></span></button>
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

    <!-- fim navbar -->


    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-5 " id="resumos">
                <h2 style="text-align: center;">ATIVIDADES</h2>
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th scope="col">Materia</th>
                            <th scope="col" style="margin-right: 20px;">Data</th>
                            <th scope="col">Entregue</th>
                            <th scope="col">Ver Atividade</th>
                        </tr>
                    </thead>
                    <tbody>
                       	<c:forEach var="atividade" items="${atividades}">
							<tr>
                            	<th scope="row" id="materia">${atividade.materia}</th>
                            	<td id="data">${atividade.dataPostagem}</td>
                            	<c:if test="${atividade.entregue == false}">
                            		<td id="entregue">N�o</td>
                            	</c:if>
                            	<c:if test="${atividade.entregue == true}">
                            		<td id="entregue">Sim</td>
                            	</c:if>
                            	<td>
                                	<a class="btn" href="<%=request.getContextPath() %>/aluno?action=infoAtividade&id=${atividade.id}" id="atividade1"><button id="alter">Entrar na Atividade</button></a>
                            	</td>
                        	</tr>
						</c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col-sm-5 ml-auto " id="resumos">
                <h2 style="text-align: center;">RESUMOS</h2>
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th scope="col">Materia</th>
                            <th scope="col">Data</th>
                            <th scope="col">Arquivo</th>
                        </tr>
                    </thead>
					<tbody>
						<c:forEach var="resumo" items="${resumos}">
							<tr>
                            	<th scope="row" id="materia">${resumo.materia}</th>
                            	<td id="data">${resumo.dataPostagem}</td>
                            	<td>
                                	<a class="btn" href="#" id="alter">Arquivo</a>
                            	</td>
                        	</tr>
						</c:forEach>
                    </tbody>
                </table>
            </div>

        </div>
    </div>
</body>

</html>