<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="content=width=device-width, initial-scale=1.0">
    <title>Perfil</title>
    <link rel="icon" href="view/img/logo-r-p.png">

    <!-- inicio imports -->


    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="view/css/perfil.css">
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

                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Alterna navegaÃ§Ã£o"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                    <div class="navbar-nav mr-auto nav-tabs">
                        <a class="nav-item nav-link" href="<%=request.getContextPath() %>/administrador?action=paginaInicial" style=" color: #fff;">Pagina Inicial</a>
                        <a class="nav-item nav-link" href="<%=request.getContextPath() %>/administrador?action=turmas" style=" color: #fff;">Atividades</a>
                        <a class="nav-item nav-link" href="<%=request.getContextPath() %>/administrador?action=cadastros" style=" color: #fff;">Cadastrar</a>
                        <a class="nav-item nav-link" href="<%=request.getContextPath() %>/administrador?action=perfil" style=" color: #fff;">Perfil</a>s

                    </div>
                </div>
            </nav>
        </div>
    </header>

    <!-- fim navbar -->

    <!-- comeÃ§o main -->
    <div class="container" style="margin-top: 80px;">
        <main class="container" id="contact">
            <form id="contact" action="<%=request.getContextPath() %>/administrador?action=atualizar" method="POST">

                <h3 style="text-align: center;">Dados Cadastrados</h3>
                <hr style="border-width: 3px; border-color: #1e294c;">

                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="nome">Nome</label>
                        <input type="text" class="form-control" id="nome" name="nome" value="${administrador.nome}" required>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="sobrenome">sobrenome</label>
                        <input type="text" class="form-control" id="sobrenome" name="sobrenome" value="${administrador.sobrenome}" required>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="cpf">CPF</label>
                        <input type="text" class="form-control" id="cpf" name="cpf" value="${administrador.cpf}" placeholder="XXX.XXX.XXX-XX" required>
                    </div>
                    <div class="col-md-6">
                        <label for="email">Email</label>
                        <input type="text" class="form-control" id="email" name="email" value="${administrador.email}" placeholder="email@email.com" required>
                    </div>

                    <div class="form-group col-md-6">
                        <label for="senha">Senha</label>
                        <input type="text" class="form-control" id="senha" name="senha" value="${administrador.senha}" placeholder="************" required>
                    </div>
                    <input type="hidden" name="id" value="${administrador.id}">

                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" value="" id="checkbox" required>
                        <label class="form-check-label" for="flexCheckIndeterminate">
                         Confirmo<hr>
                        </label>
                    </div>
                    <button type="submit" class="btn btn-primary">Alterar Informações</button>
                </div>
            </form>
        </main>
    </div>
    <!-- fim do main -->
</body>

</html>