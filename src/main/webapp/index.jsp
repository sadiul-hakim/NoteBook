<%-- 
    Document   : index
    Created on : Oct 19, 2022, 3:03:03 PM
    Author     : Hakim
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <%@include file="Head.jsp" %>
    <body>
        <%@include file="DefaultNavbar.jsp" %>
        <main class="home-main">
            <div class="home-content d-flex flex-column justify-content-center align-items-center p-5">
                <h1 class="text-light">
                    <i class="fa fa-book"></i> E Notes-Save Your Notes
                </h1>
                <div class="d-flex">
                    <a class="btn btn-light mx-2" href="UserLogin.jsp">Login</a>
                    <a class="btn btn-light mx-2" href="UserRegister.jsp">Register</a>
                </div>
            </div>
        </main>
    </body>
    <%@include file="Footer.jsp" %>
</html>
