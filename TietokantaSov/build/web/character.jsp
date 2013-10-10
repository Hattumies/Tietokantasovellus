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
        <div class ="Character">${Character.nimi}</div>
        <div class ="Character">${Character.pelaaja}</div>
        <div class ="Character">${Character.mental}</div>
        <div class ="Character">${Character.physical}</div>
        <div class ="Character">${Character.social}</div>
        <div class ="Character">${Character.template}</div>
        <div class ="Character">${Character.advantage}</div>
        <br>
    </c:forEach>
</ul>
<form action = "char" method = "POST">
    <input type ="text" name ="charName" />
    <button type ="submit" name ="searchButton" value ="search">Search</button>
</form>
<li class="active"><a href="newCharacter.jsp">New Character</a></li>
</t:tagi>