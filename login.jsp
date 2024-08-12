<%-- 
    Document   : login
    Created on : 9 Jun, 2024, 9:26:51 PM
    Author     : Hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="LoginController" method="post">
        <table>
            <tr>
                <td>UserName:</td>
                <td><input type="text" name="un"></td>
            </tr>
              <tr>
                <td>Password:</td>
                <td><input type="text" name="ps"></td>
            </tr>
             <tr>
                <td>&nbsp;</td>
                <td><input type="submit" name="login"></td>
            </tr>


        </table>
        </form>
    </body>
</html>
