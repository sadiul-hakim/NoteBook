<%-- 
    Document   : Dashboard
    Created on : Oct 24, 2022, 10:56:29 AM
    Author     : Hakim
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <%@include file="Head.jsp" %>
    <body>
        <%@include file="DefaultNavbar.jsp" %>
        
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
