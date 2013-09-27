<%-- 
    Document   : character
    Created on : 19-Sep-2013, 17:23:23
    Author     : ilmarihu
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:tagi title="Characters">
</t:tagi>
<ul>
    <c:foreach var ="Character" items = "${characters}">
        <li><a href="Character?Character=${Character.nimi}"></a></li>
    </c:foreach>
</ul>
<li class="active"><a href="newCharacter.jsp">New Character</a></li>
