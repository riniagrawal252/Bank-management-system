<%-- 
    Document   : transfer
    Created on : 9 Jun, 2024, 9:27:08 PM
    Author     : Hp
--%>

<%@page import="com.rini.bank.bean.AccountBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        AccountBean ac=(AccountBean)session.getAttribute("username");
        %>
        <hr color="green">
        <h1 align="right">Welcome:<%=ac.getCustomer_name()%></h1>
        <hr color="red">
        <form action="AccountController" method="post">
        <table bgcolor="green" align="center">
            
            <tr>
                <td>Account Number: </td>
                <td><input type="text" readonly="true" name="acno" value=<%=ac.getAccount_Number()%>></td>
            </tr>
            <tr>
                <td>To Account Number: </td>
                <td><input type="text"  name="toacno" </td>
            </tr>
            <tr>
                <td>Transaction Date: </td>
                <td><input type="date" name="tdate"></td>
            </tr>
             <tr>
                <td>Transaction Amount: </td>
                <td><input type="text" name="tamt"></td>
            </tr>

            <tr>
                <td>&nbsp; </td>
                <td><input type="submit" name="Transfer Amount" value="Transfer Amount"></td>
            </tr>   
        </table>
          </form>

        
    </body>
</html>
