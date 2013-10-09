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
        <c:forEach var = "Player" items = "${items}">
            <li><a href ="Item?Item=${Items.ItemName}">${Items.ItemName}</a></li>
            <li><a href ="Item?Item=${Items.CharacterName}">${Items.CharacterName}</a></li>
            <br>
        </c:forEach>
    </ul>
    <form action ="search" method ="POST">
        <input type ="text" name ="itemName"/>
        <Button type ="submit" name ="searchButton" value ="searchItem">search</button>
    </form>
    <li class ="active" ><a href="newItem.jsp" >New Item</a></li>
</t:tagi>
