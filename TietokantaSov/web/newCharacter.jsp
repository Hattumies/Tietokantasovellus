<%-- 
    Document   : newCharacter
    Created on : 27.9.2013, 22:03:53
    Author     : Ilmu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%><%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<t:tagi title="New Character">
<form action = "NewCharacter" method = "POST">
    Character name: <input type="text" name="character" />
    <br>
    Player name:<input type="text" name="player" />
    <br>
    Attributes:
    Mental<input type="text" name="mental" />
    Physical<input type="text" name="physical" />
    Social<input type="text" name="social" />
    <br>
    Template:<input type="text" name="template" />
    <br>
    Metanormal advantage:<input type="text" name="advantage" />
    <br>
    <button type = "submit">Submit character information</button>
</form>
<p>${error1}</p>
<p>${error2}</p>
<p>${error3}</p>
<p>${error4}</p>
<p>${error5}</p>
</t:tagi>