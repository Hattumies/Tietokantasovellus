<%-- 
    Document   : player
    Created on : 4.10.2013, 20:19:54
    Author     : Ilmu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:tagi title="Players">
    <ul>
        <c:forEach var = "Player" items = "${players}">
            <div class ="Player">${Player.name}</div>
            <br>
        </c:forEach>
    </ul>
    <form action ="player" method ="POST">
        <input type ="text" name ="playerName"/>
        <Button type ="submit" name ="searchButton" value ="search">Search</button>
        <Button type ="submit" name ="deleteButton" value ="delete">Delete</button>
    </form>
    <li class ="active" ><a href="newPlayer.jsp" >New Player</a></li>
</t:tagi>
