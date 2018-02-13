<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->
        <link rel="stylesheet" href="/webjars/bootstrap/4.0.0/css/bootstrap.min.css" />

    </head>
    
    <body>
        <header class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
            <a class="navbar-brand" href="/">ENSTA LDAP</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
              <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                  <a class="nav-link" href="/">Home</a>
                </li>
                <li class="nav-item active">
                  <a class="nav-link" href="/userSettings">User Settings</a>
                </li>
              </ul>
            </div>
        </header>
        <div class="container">
            <a href="/googleAuthenticatorQRCode"> View Google Authenticator QR Code</a>

            <div class="jumbotron">
                <div class="container">
                    <h1>Change user info</h1>
                    <form method="post" action="/changeInfo">
                      <div class="form-group">
                        <label for="name">Name:</label>
                        <input type="text" class="form-control" name="name" id="name" value="${loggedUser.name}" required>
                      </div>
                      <div class="form-group">
                        <label for="surname">Surname:</label>
                        <input type="text" class="form-control" name="surname" id="surname" value="${loggedUser.surname}" required>
                      </div>
                      <div class="form-group">
                        <label for="mail">Email:</label>
                        <input type="email" class="form-control" name="mail" id="mail" <#if loggedUser.mail??>value="${loggedUser.mail}"</#if> required>
                      </div>
                      <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>
            </div>
            <div class="jumbotron">
                <div class="container">
                    <h1>Change security information</h1>
                    <form method="post" action="/changePass">
                      <div class="form-group">
                        <label for="password">New password:</label>
                        <input type="password" class="form-control" id="password" name="password" >
                      </div>
                      <div class="form-group">
                        <label for="question">Secret question:</label>
                        <input type="text" class="form-control" id="question" name="question" required <#if loggedUser.question??> value="${loggedUser.question}"</#if>>
                      </div>
                      <div class="form-group">
                        <label for="answer">Secret Answer:</label>
                        <input type="text" class="form-control" id="answer" name="answer" required <#if loggedUser.answer??>value="${loggedUser.answer}"</#if>>
                      </div>
                      <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>
            </div>
        </div>
        
        
    </body>

    <script src="/webjars/jquery/3.0.0/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</html>