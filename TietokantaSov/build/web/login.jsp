<%-- 
    Document   : jsp
    Created on : 19-Sep-2013, 15:40:38
    Author     : ilmarihu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Welcome to the login page!</h1>
        <form action="login" method="POST">
            Käyttäjänimi: <input type="text" name="username" />
            Salasana: <input type="password" name="password" />
            <button type="submit">Kirjaudu</button>
        </form>
        <p>${virhe}</p>
    </body>
</html>
