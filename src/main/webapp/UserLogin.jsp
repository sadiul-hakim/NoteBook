<%-- 
    Document   : UserLogin
    Created on : Oct 24, 2022, 10:56:13 AM
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
                <h2>User Login</h2>
            </div>
            <div class="card-body">
                <form action="LoginServlet" method="post">
                    <div class="form-group mb-2">
                        <label for="email">Email</label>
                        <input type="email" name="email" class="form-control"/>
                        
                    </div>
                    <div class="form-group mb-2">
                        <label for="password">Password</label>
                        <input type="password" name="password" class="form-control"/>
                        
                    </div>
                    <div class="form-group mb-2">
                        <button type="submit" class="btn btn-dark">Login</button>
                    </div>
                </form>
            </div>
        </main>
        
    </body>
</html>
