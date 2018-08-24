<%@ page import="com.mysql.jdbc.interceptors.SessionAssociationInterceptor" %>
<%@ page import="ru.gerkir.User" %><%--<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>--%>
<%--
    Document   : account
    Created on : 13.06.2018, 15:49:18
    Author     : gerkir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Account</title>
</head>
<body>
Hi,
<% try {
        if(request.getSession().getAttribute("user")!=null){
            User user = (User) request.getSession().getAttribute("user");
            out.println(user.getName());
        }
        else out.println("null");
    }
    catch (Exception e){
        out.println(e.toString());
    }
%>
<br><a href="logout">Выйти</a>
<br><a href="index.html">На главную</a>
</body>
</html>
