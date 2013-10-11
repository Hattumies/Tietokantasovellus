<%-- 
    Document   : newItem
    Created on : 9.10.2013, 16:33:15
    Author     : Ilmu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:tagi title="New Item">
    <form action ="NewItem" method ="POST">
        Item name: <input type="text" name="item" />
        <br>
        Owner: <input type="text" name="owner" />
        <br>
        <button type ="submit">Submit</button>
    </form>
    <p>${error1}</p>
    <p>${error2}</p>
</t:tagi>