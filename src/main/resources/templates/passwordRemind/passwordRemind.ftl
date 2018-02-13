<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="css/util.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <!--===============================================================================================-->

</head>
<body>

<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100">
            <#if username?has_content && question?has_content>
                <form class="login100-form validate-form validate-password" method="post" action="/passwordRemind">
                    <input type="hidden" name="username" value="${username}">
                    <span class="login100-form-title p-b-26">
                         Hello ${username}
                     </span>

                    <#if error??>
                        <div style="color: red;">
                            Wrong answer!
                        </div>
                    </#if>
                    <div class="wrap-input100">
                        Question: ${question}
                    </div>


                    <div class="wrap-input100 validate-input" data-validate="Input your answer">
                        <input class="input100" type="text" name="answer">
                        <span class="focus-input100" data-placeholder="Input your answer"></span>
                    </div>

                    <div class="wrap-input100 validate-input" data-validate="Input new password">
                        <input id="password" class="input100" type="password" name="password">
                        <span class="focus-input100" data-placeholder="New password"></span>
                    </div>

                    <div class="wrap-input100 validate-input" data-validate="Retype new password">
                        <input id="repeat-password" class="input100" type="password">
                        <span class="focus-input100" data-placeholder="Repeat new password"></span>
                    </div>

                    <div class="container-login100-form-btn">
                        <div class="wrap-login100-form-btn">
                            <div class="login100-form-bgbtn"></div>
                            <button class="login100-form-btn">
                                Send
                            </button>
                        </div>
                    </div>
                </form>
            <#else>
                 <form class="login100-form validate-form" method="get" action="/passwordRemind">
                     <span class="login100-form-title p-b-26">
                         Password reminder
                     </span>
                     <#if username?has_content>
                        <span class="login100-form-title p-b-26" style="color:red;">
                            User ${username} doesn't exist
                        </span>
                     </#if>
                     <div class="wrap-input100 validate-input" data-validate="Input username">
                         <input class="input100" type="text" name="username">
                         <span class="focus-input100" data-placeholder="Input your username"></span>
                     </div>
                     <div class="container-login100-form-btn">
                         <div class="wrap-login100-form-btn">
                             <div class="login100-form-bgbtn"></div>
                             <button class="login100-form-btn">
                                 Remind
                             </button>
                         </div>
                     </div>
                 </form>
            </#if>
        </div>
    </div>
</div>


<div id="dropDownSelect1"></div>
<!--===============================================================================================-->
<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/bootstrap/js/popper.js"></script>
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/daterangepicker/moment.min.js"></script>
<script src="vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
<script src="vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
<script src="js/main.js"></script>

</body>
</html>