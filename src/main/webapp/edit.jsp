<%-- 
    Document   : edit
    Created on : 09-oct-2022, 0:34:09
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
        <h1>Ingrese el DNI del usuario para mofificar </h1>
        
        <form action="<%= request.getContextPath()%>/EditUserServlet" method="post">
            <table style="width:80%">
        <tr>
            <td>Name</td>
            <td><input type="text" name="name" /></td>
        </tr>
        <tr>
            <td>Lastname</td>
            <td><input type="text" name="lastname" /></td>
        </tr>
        <tr>
            <td>Username</td>
            <td><input type="text" name="username" /></td>
        </tr>
        <tr>
            <td>Pass</td>
            <td><input type="password" name="pass" /></td>
        </tr>
        <tr>
            <td>Tipo documento</td>
            <td><input type="text" name="tipDoc" /></td>
        </tr>
        <tr>
            <td>Nro documento</td>
            <td><input type="text" name="nroDoc" placeholder="Ingrese el DNI a modificar" /></td>
        </tr>
        <tr>
            <td>Enable</td>
            <td><input type="text" name="enable" /></td>
        </tr>
        <tr>
            <td>Email </td>
            <td><input type="text" name="email" /></td>
        </tr>

        <tr>
            <td><input type="submit" value="Register" /></td>
        </tr>
    </table>
        </form>
    </body>
</html>
