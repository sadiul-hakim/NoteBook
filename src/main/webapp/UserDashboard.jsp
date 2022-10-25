<%-- 
    Document   : Dashboard
    Created on : Oct 24, 2022, 10:56:29 AM
    Author     : Hakim
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@page import="com.hakim.dao.user.User" %>
<%@page import="com.hakim.entities.SecurityContext" %>


<%
    
    User user=SecurityContext.getCurrentUser(request);
    boolean isAuthenticated=SecurityContext.isAuthenticated(request);
    
    if(!isAuthenticated){
        request.getRequestDispatcher("UserLogin.jsp").forward(request,response);
    }
    
%>

<!DOCTYPE html>
<html>
    <%@include file="Head.jsp" %>
    <body>
        <%@include file="UserNavbar.jsp" %>
        <main class="container my-4">
            <div class="row">
                <div class="col-12 d-flex flex-column justify-content-center align-items-center">
                    <img src="img/notes.png" alt="notepad" width="300px" height="320px"/>
                    <h1>START TAKING YOUR NOTES</h1>
                    <a href="AddNote.jsp" class="btn btn-outline-dark">Start Here</a>
                </div>
            </div>
        </main>
        
        <%@include file="Footer.jsp" %>
    </body>
</html>
