<%-- 
    Document   : UserRegister
    Created on : Oct 24, 2022, 10:55:59 AM
    Author     : Hakim
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <%@include file="Head.jsp" %>
    <body>
        <%@include file="DefaultNavbar.jsp" %>
        
        <main class="card w-25 mx-auto my-5">
            <div class="card-header">
                <h2>User Register</h2>
            </div>
            <div class="card-body">
                <form action="RegisterServlet" method="post">
                    <div class="form-group mb-2">
                        <label for="fullname">Full Name</label>
                        <input type="text" name="fullname" class="form-control"/>
                        
                    </div>
                    <div class="form-group mb-2">
                        <label for="email">Email</label>
                        <input type="email" name="email" class="form-control"/>
                        
                    </div>
                    <div class="form-group mb-2">
                        <label for="password">Password</label>
                        <input type="password" name="password" class="form-control"/>
                        
                    </div>
                    <div class="form-group mb-2">
                        <button type="submit" class="btn btn-dark">Register</button>
                    </div>
                </form>
            </div>
        </main>
        
    </body>
</html>
