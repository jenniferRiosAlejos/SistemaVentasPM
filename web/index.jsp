<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sistema QuickMarket</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <style>
        .container-center {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
    </style>
</head>
<body>
    <div class="container container-center">
        <div class="card mt-4 col-lg-4">
            <div class="card-body text-center">
                <form class="form-sing" action="Validar" method="POST">
                    <fieldset>
                        <legend>Login</legend>
                        <img src="img/LOGO.png" alt="Logo" width="170">
                        <p>Bienvenidos al Sistema</p>
                    
                        <div class="form-group mb-3">
                            <input type="text" name="txtuser" class="form-control" placeholder="Usuario">
                        </div>
                                             
                        <div class="form-group mb-3">
                            <input type="password" name="txtpass" class="form-control" placeholder="Contraseña">
                        </div>
                        
                        <div class="form-group">
                            <input type="submit" name="accion" value="Ingresar" class="btn btn-primary btn-block w-100">
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js" integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS" crossorigin="anonymous"></script>
</body>
</html>