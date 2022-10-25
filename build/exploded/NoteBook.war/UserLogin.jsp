<%-- 
    Document   : UserLogin
    Created on : Oct 24, 2022, 10:56:13 AM
    Author     : Hakim
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@page import="com.hakim.entities.SecurityContext" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    
    boolean isAuthenticated=SecurityContext.isAuthenticated(request);
    
    if(isAuthenticated){
        request.getRequestDispatcher("UserDashboard.jsp").forward(request,response);
    }
    
%>

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
                        <input type="email" name="email" class="form-control" required="true"/>
                        <c:if test="${errors.email!=null}">
                            <p class="text-danger mt-1"><c:out value="${errors.email}"/></p>
                        </c:if>
                    </div>
                    <div class="form-group mb-2">
                        <label for="password">Password</label>
                        <input type="password" name="password" class="form-control" required="true"/>
                        <c:if test="${errors.password!=null}">
                            <p class="text-danger mt-1"><c:out value="${errors.password}"/></p>
                        </c:if>
                    </div>
                    <div class="form-group mb-2">
                        <button type="submit" class="btn btn-dark">Login</button>
                    </div>
                </form>
            </div>
        </main>
        
    </body>
</html>
