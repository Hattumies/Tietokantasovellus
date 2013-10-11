<%-- 
    Document   : item
    Created on : 9.10.2013, 16:23:42
    Author     : Ilmu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:tagi title="Items">
       <ul>
        <c:forEach var = "Item" items = "${items}">
            Item: <div class ="Item">${Item.item}</div>
            Owner: <div class ="Item">${Item.owner}</div>
            <br>
        </c:forEach>
    </ul>
    <form action ="item" method ="POST">
        <input type ="text" name ="item"/>
        <Button type ="submit" name ="searchButton" value ="search">search</button>
        <Button type ="submit" name ="deleteButton" value ="delete">delete</button>
    </form>
    <li class ="active" ><a href="newItem.jsp" >New Item</a></li>
</t:tagi>
