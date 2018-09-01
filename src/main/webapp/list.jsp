<%@ page import="ru.gerkir.BaseWorker" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ru.gerkir.Hookah" %><%--
    Document   : newjsp
    Created on : 13.06.2018, 15:41:57
    Author     : gerkir
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Дымный патруль</title>
    <link rel="stylesheet" href="css/style.css">
    <link href="https://fonts.googleapis.com/css?family=Oswald" rel="stylesheet">
    <!-- <link href="https://fonts.googleapis.com/css?family=Arimo" rel="stylesheet"> -->
    <link rel="shortcut icon" href="images/DP_icon.png">
</head>
<body>
<div class="page">
    <header class="main_header">
        <div class="left_side">
            <a href="index.html"><img src="images/dymnyy_patrul.png"></a>
            <nav>
                <a href="">Новости</a>
                <a href="">Список</a>
                <a href="">Отзывы</a>
                <a href="">О проекте</a>
            </nav>
        </div>
        <div class="right_side">
            <a href="signin.jsp">Вход / Регистрация</a>
        </div>
    </header>
</div>
<div class="stripe">
    <section class="fields">
        <div class="districts">
            Все районы
            <ul class="areas">
                <li>Калининский</li>
                <li>Курчатовский</li>
                <li>Ленинский</li>
                <li>Металлургический</li>
                <li>Советский</li>
                <li>Тракторозаводский</li>
                <li>Центральный</li>
            </ul>
        </div>
        <input placeholder="Стоимость от, руб" type="text" onfocus="this.placeholder=''"
               onblur="this.placeholder='Стоимость от, руб'">
        <div class="more">
            Ещё фильтры...
        </div>
        <div class="search">
            <img src="images/icon_search.png">Найти
        </div>
    </section>
</div>
<div class="list">
    Список заведений:
</div>
<section class="elements">
    <%
        ArrayList<Hookah> arrayList = BaseWorker.getHookahs();
        for (int i = 0; i < arrayList.size(); i++) {
            Hookah h = arrayList.get(i);
            String s = "<div class=\"k_place\">\n" +
                    "        <figure class=\"k_name_body\">\n" +
                    "            <a href=\"\">" + h.getName() + "</a>\n" +
                    "            <img src=\"" + h.getPicture() + "\">\n" +
                    "        </figure>\n" +
                    "        <section class=\"k_right\">\n" +
                    "            <section class=\"k_info\">\n" +
                    "                <div class=\"adress\">" + h.getAddress() + "</div>\n" +
                    "                <div class=\"description\"> " + h.getDescription() + "</div>\n" +
                    "            </section>\n" +
                    "            <section class=\"k_details\">\n" +
                    "                <a href=\"\">Подробности</a>\n" +
                    "            </section>\n" +
                    "        </section>\n" +
                    "    </div>";
            out.print(s);
        }
    %>
</section>
<div class="primer">
</div>
</body>
</html>
