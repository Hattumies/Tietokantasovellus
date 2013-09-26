<%-- 
    Document   : tagi
    Created on : 19-Sep-2013, 15:48:00
    Author     : ilmarihu
--%>

<%@tag description="Template for Characterlist" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="title"%>

<!DOCTYPE HTML>
<html>
    <head>
        <title>${title}</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/bootstrap-theme.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <script src="http://code.jquery.com/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-3">
                    <h1>Pages</h1>
                    <div class="panel panel-default">
                        <ul clas="nav">
                            <li class="active"><a href="char">Characters</a></li>
                            <li><a href="player">Players</a></li>
                            <li><a href="attribute">Attributes</a></li>
                            <li><a href="skill">Skills</a></li>
                            <li><a href="merit">Merits</a></li>
                            <li><a href="item">Items</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
