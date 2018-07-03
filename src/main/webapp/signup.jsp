<%-- 
    Document   : newjsp
    Created on : 13.06.2018, 15:41:57
    Author     : gerkir
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Вход | Дымный патруль</title>
        <link rel="stylesheet" href="css/style2.css">
        <link href="https://fonts.googleapis.com/css?family=Oswald" rel="stylesheet">
        <!-- <link href="https://fonts.googleapis.com/css?family=Arimo" rel="stylesheet"> -->
        <link rel="shortcut icon" href="images/DP_icon.png">
    </head>
    <body>

        <!-- top bar -->
        <div class="vladmaxi-top">
            <lable>Регистрация</lable>
            <span class="right">
                <a href="index.html">
                    <strong>Вернуться на главную</strong>
                </a>
            </span>
            <div class="clr"></div>
        </div>
        <!--/ top bar -->

        <section class="container">
            <div class="login">
                <h1>Войти в личный кабинет</h1>

                <form form action="/NewServlet" method="post">
                    <p><input type="text" name="login" value="" placeholder="Логин или Email"></p>
                    <p><input type="password" name="password" value="" placeholder="Пароль"></p>
                    <p class="remember_me">
                        <label>
                            <input type="checkbox" name="remember_me" id="remember_me">
                            Запомнить меня
                        </label>
                    </p>
                    <p class="submit"><input type="submit" name="commit" value="Войти"></p>
                </form>
            </div>

            <div class="login-help">
                <a href="index.html">Забыли пароль?</a> / <a href="index.html">Регистрация</a>
            </div>
        </section>
    </body>
</html>