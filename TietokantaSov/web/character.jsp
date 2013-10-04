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
        <li><a href="Character?Character=${Character.nimi}">${Character.nimi}</a></li>
        <li><a href="Character?Character=${Character.pelaaja}">${Character.pelaaja}</a></li>
        <li><a href="Character?Character=${Character.mental}">${Character.mental}</a></li>
        <li><a href="Character?Character=${Character.physical}">${Character.physical}</a></li>
        <li><a href="Character?Character=${Character.social}">${Character.social}</a></li>
        <li><a href="Character?Character=${Character.template}">${Character.template}</a></li>
        <li><a href="Character?Character=${Character.advantage}">${Character.advantage}</a></li>
        <br>
    </c:forEach>
</ul>
<form action = "char" method = "POST">
    <input type ="text" name ="charName" />
    <button type ="submit" name ="searchButton" value ="search">Search</button>
</form>
<li class="active"><a href="newCharacter.jsp">New Character</a></li>
</t:tagi>