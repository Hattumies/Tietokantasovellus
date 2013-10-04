<%-- 
    Document   : newPlayer
    Created on : 4.10.2013, 21:16:21
    Author     : Ilmu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:tagi title="New Player">
    Player name: <input type="text" name="player" />
    <br>
    Player id: <input type="text" name="id" />
    <br>
    <button type ="submit">Submit</button>
</t:tagi>
