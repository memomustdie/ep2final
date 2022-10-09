<%-- 
    Document   : index
    Created on : 08-oct-2022, 21:38:35
    Author     : Guillermo Hurtado
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Main Menu</h1>
        
        <ul>
            <li><a href="<%= request.getContextPath()%>/UserServlet">Add User</a></li>
            <li><a href="<%= request.getContextPath()%>/EditUserServlet">Edit User</a></li>
            
        </ul>
    </body>
</html>
