<%-- 
    Document   : delete
    Created on : 09-oct-2022, 10:26:26
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
        <h1>Ingrese el DNI que desea eliminar </h1>
        
        <form action="<%= request.getContextPath()%>/DeleteUserServlet" method="post">
        <table style="width:80%">
        
        <tr>
            <td>Nro documento</td>
            <td><input type="text" name="nroDoc" placeholder="Ingrese el DNI a eliminar" /></td>
        </tr>
        

        <tr>
            <td><input type="submit" value="Eliminar" /></td>
        </tr>
        </table>
        </form>
    </body>
</html>
