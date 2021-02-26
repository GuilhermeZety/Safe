<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="content=width=device-width, initial-scale=1.0">
    <title>Enviar</title>
    <link rel="icon" href="view/img/logo-r-p.png">

    <!-- inicio imports -->


    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="view/css/atividades.css">

    <script src="https://code.jquery.com/jquery-1.11.2.js"></script>
    <script type="text/javascript">
        jQuery(window).load(function($) {
            atualizaRelogio();
        });
    </script>
</head>



<body style="background-image: url(view/img/background.jpg); ">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    <!-- fim imports -->

    <!-- inicio navbar -->
    <header>
        <div class="container-fluid px-0 ">
            <nav class="navbar navbar-expand-lg navbar-dark shadow" style="background-color: #1e294c;">
                <a href="<%=request.getContextPath() %>/paginaInicial"><img src="view/img/logo-safe.png" class="img-fluid" alt="logo" width="90px"></a>

                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Alterna navegação"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                    <div class="navbar-nav mr-auto nav-tabs">
                        <a class="nav-item nav-link" href="<%=request.getContextPath() %>/professor?action=paginaInicial" style=" color: #fff;">Pagina Inicial</a>
                        <a class="nav-item nav-link" href="<%=request.getContextPath() %>/professor?action=enviarAtividade" style=" color: #fff;">Enviar</a>
                        <a class="nav-item nav-link" href="<%=request.getContextPath() %>/professor?action=chamada" style=" color: #fff;">Chamada</a>
                        <a class="nav-item nav-link" href="<%=request.getContextPath() %>/professor?action=perfil" style=" color: #fff;">Perfil</a>
                    </div>
                </div>
            </nav>
        </div>
    </header>
    <!-- fim navbar -->

    <!-- começo main -->
    <div class="container" style="margin-top: 40px;">
        <main class="container" id="contact">
            <form id="contact" action="<%=request.getContextPath() %>/professor?action=atividadeEnviada" method="POST">

                <h3 style="text-align: center;">Enviar Atividade/Resumo</h3>
                <hr style="border-width: 3px; border-color: #1e294c;">

                <label for="turma">Turma</label>
                <select class="form-control" id="turma" name="turma">
                	<c:forEach var="turma" items="${turmas}">
                 		<option value="${turma.id}">${turma}</option>
                 	</c:forEach>
                </select>
                
                <label for="materia">Mat�ria</label>
                <input class="form-control" type="text" id="materia" name="materia">
                
                <label for="nome">Nome</label>
                <input class="form-control" type="text" id="nome" name="nome">
                
                <hr>
                <div style="text-align: center;">
                    <output type="date" id="data"></output>
                </div>

                <hr>


                <div class="form-row">
                    <div class="col-md-6" style="text-align: center;">
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="checkbox" id="checkbox1" value="atividade" required>
                            <label class="form-check-label" for="inlineRadio1">Atividade</label>
                        </div>
                    </div>
                    <div class="col-md-6" style="text-align: center;">
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="checkbox" id="checkbox1" value="resumo" required>
                            <label class="form-check-label" for="inlineRadio2">Resumo</label>
                        </div>
                    </div>
                </div>
                <hr>
                <br>

                <h3 style="text-align: center;">Escreva o Trabalho</h3>
                
                <div class="col-md-12" style="margin-bottom: 2%;">
                    <label for="alter" class="form-label" style="text-align: center;"></label>
                    <textarea class="form-control" id="alter" rows="8" name="conteudo"></textarea>
                </div>
                <hr>
                <button type="submit" id="alter" class="btn btn-primary">Enviar</button>
            </form>
        </main>
    </div>
    <!-- fim do main -->
</body>
<script type="text/javascript" src="view/js/hora.js"></script>

</html>