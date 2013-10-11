<%-- 
    Document   : character
    Created on : 19-Sep-2013, 17:23:23
    Author     : ilmarihu
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:tagi title="Characters">
<ul>
    <c:forEach var ="Character" items = "${hahmot}">
        Character: <div class ="Character">${Character.nimi}</div>
        Player: <div class ="Character">${Character.pelaaja}</div>
        Mental attributes: <div class ="Character">${Character.mental}</div>
        Physical attributes: <div class ="Character">${Character.physical}</div>
        Social attributes: <div class ="Character">${Character.social}</div>
        Template: <div class ="Character">${Character.template}</div>
        Metanormal advantage: <div class ="Character">${Character.advantage}</div>
        <br>
    </c:forEach>
</ul>
<form action = "char" method = "POST">
    <input type ="text" name ="charName" />
    <button type ="submit" name ="searchButton" value ="search">Search</button>
    <button type ="submit" name ="deleteButton" value ="delete">Delete</button>
</form>
<li class="active"><a href="newCharacter.jsp">New Character</a></li>
</t:tagi>