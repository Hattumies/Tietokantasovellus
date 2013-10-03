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
    </c:forEach>
</ul>
<li class="active"><a href="newCharacter.jsp">New Character</a></li>
</t:tagi>