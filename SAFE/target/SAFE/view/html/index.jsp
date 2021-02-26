<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="view/img/logo-r-p.png">
    <title>Safe</title>

    <!-- imports -->

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.13.0/css/all.css">
    <link rel="stylesheet" href="view/css/home.css">

</head>

<body>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    <!-- final imports -->

    <!-- navbar -->
    <header>
        <div class="container-fluid px-0">
            <nav class="navbar navbar-expand-lg navbar-dark shadow" style="background-color: #1e294c;">
                <a href="<%=request.getContextPath() %>/paginaInicial"><img src="view/img/logo-safe.png" class="img-fluid" alt="logo" width="90px"></a>

                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Alterna navegaÃ§Ã£o"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                    <div class="navbar-nav mr-auto nav-tabs">
                        <a class="nav-item nav-link" href="#login" style=" color: #fff;">Fui Cadastrado</a>
                        <a class="nav-item nav-link" href="#adm" style=" color: #fff;">ADM</a>
                        <a class="nav-item nav-link" href="#sobre_nos" style=" color: #fff;">Sobre Nós</a>
                        <a class="nav-item nav-link" href="#contac" style=" color: #fff;">Contate-nos</a>
                    </div>
                    <div class="navbar-nav ml-auto">
                        <a class="btn btn-light" href="<%=request.getContextPath() %>/login" role="button" style="border-color: #1e294c;">Logar</a>
                        <a class="btn btn-light" style="border-color: #1e294c;" href="<%=request.getContextPath() %>/cadastro" role="button">Cadastrar</a>
                    </div>
                </div>
            </nav>
        </div>
    </header>


    <!-- final navbar -->

    <!-- inicio da intro -->

    <div class="jumbotron jumbotron-fluid intro" style="background-color: #fff;">
        <div class="container-fluid mb-0" style="background-color: #fff;" id="back">
            <div class="form-row">
                <div class="col-md-5" style="margin-left: 10%;">
                    <h1> <img src="view/img/logo-p.png" class="img-fluid" alt="logo" width="80px" height="80px"> Safe Project</h1>
                    <hr>
                    <br><br>
                    <h3> Aprimore a qualidade e a praticidade do ensino de sua instituição por meio do SAFE, utilizando a internet como um diferencial para o ensino.
                    </h3>
                    <br>
                    <h3>
                        Auxiliando o ensino a distancia, o SAFE auxiliará no processo de recuperação de matéria, revisão, remarcamento e realização de atividades/provas perdidas.
                    </h3>
                    <br>
                    <h3>
                        Pensando em Instituições de ensino, criamos um diferencial de pensar em todos, implementando um sistema para auxiliar à distancia por meio de trabalhos e resumos auto-explicativos para tirar as duvidas e fazer com que o aluno não perca nenhuma matéria
                        e sempre esteja em dia com seus estudos.
                    </h3>
                    <br>

                </div>

                <div class="col-sm-4 mb-0" id="bac"></div>
            </div>
        </div>
    </div>



    <section id="sobre_nos">
        <div class="jumbotron jumbotron-fluid main mt-auto mb-0 " style="background-color: #fff;">
            <div class="container-fluid " id="contact">
                <div class="form-row ">
                    <div class="col " style="margin-left: 10%; ">
                        <h1>
                            <i class="fas fa-users "></i> Sobre Nós
                        </h1>
                        <hr>
                        <h4>
                            Somos um grupo de estudantes do programa Entra21 em Blumenau/SC organizado pela Blusoft. Com nossa primeira experiência na área criamos nosso primeiro site, o Safe, projeto desenvolvido por nós com algumas referencias em outros projetos, criamos com o
                            intuito de ajudar alunos à não perderem a matéria, para sempre estar em dia com seus estudos.
                        </h4>
                        <br>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <hr>

    <section id="login">
        <div class="jumbotron jumbotron-fluid main mt-auto mb-0" style="background-color: #fff;">
            <div class="container-fluid" id="contact">

                <div class="col " style="margin-left: 10%;">
                    <br>
                    <h1>
                        <i class="far fa-user-circle"></i>Logar
                    </h1>
                    <hr>
                    <h4>
                        Caso ja esteja cadastrado no programa, Clique neste botão para acessar seu portal:
                        <br>
                        <br>
                        <a class="btn " href="<%=request.getContextPath() %>/login" id="button"> Logar-se</a>
                        <br>
                    </h4>
                </div>
            </div>
        </div>
    </section>
    <hr>
    <section id="adm">
        <div class="jumbotron jumbotron-fluid main mt-auto mb-0  " style="background-color: #fff;">
            <div class="container-fluid " id="contact">
                <div class="form-row ">
                    <div class="col " style="margin-left: 10%; ">
                        <br>
                        <h1>
                            <i class="far fa-address-card"></i> ADM
                        </h1>
                        <hr>
                        <h4>
                            Caso tenha sido cadastrado como um administrador acesse este painel: <br>
                            <br>
                            <a class="btn " href="<%=request.getContextPath() %>/administrador?action=login" id="button"> Logar-se</a>
                        </h4>
                        <br>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- final do main -->


    <!-- comeÃ§o rodapÃ© -->

    <footer class="jumbotron bg-dark mb-0 " id="contac">

        <div class="col-sm-4 ">
            <h5 class="text-center " style="color: aliceblue; ">Email de contato: <a href="mailto:safeprojectfac@gmail.com?subject=OlÃ¡%20gostaria%20de%20efetuar%20cadastro%20no%20safe%20project ">safeprojectfac@gmail.com </a></h5>

        </div>

        <!-- final rodapÃ© -->
</body>

</html>