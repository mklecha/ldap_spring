<!DOCTYPE html>
<html lang="en">
<head>
    <title>ENSTA LDAP - Google Authentication</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="stylesheet" href="/webjars/bootstrap/4.0.0/css/bootstrap.min.css"/>

</head>

<body>
<header class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
    <a class="navbar-brand" href="/">ENSTA LDAP</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
            aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/userSettings">User Settings</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/googleAuthentication">Google Authentification</a>
            </li>
        </ul>
        <form action="/logout">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Log out</button>
        </form>
    </div>
</header>
<div class="container">
    <div class="jumbotron">
        <#if loggedUser.ga>
            <div id="qr">
                <h2>Google Authentication is on</h2>
                <p>
                    Scan this Barcode using Google Authenticator app on your phone
                    to use it later in login
                </p>
                <img src="${qr}"/>
            </div>
            <div class="mt-2">
                <a href="/changeGA-off">
                    <button class="btn btn-secondary">Click here to turn it off</button>
                </a>
            </div>
        <#else>
            <h2>Google Authentication is off</h2>
            <div class="mt-2">
                <a href="/changeGA-on">
                    <button class="btn btn-secondary">Click here to turn it on</button>
                </a>
            </div>
        </#if>
    </div>
</div>
</body>
<script src="/webjars/jquery/3.0.0/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</html>
