<%-- 
    Document   : ShareNotes
    Created on : Oct 24, 2022, 4:05:11 PM
    Author     : Hakim
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <%@include file="Head.jsp" %>
    <body>
        <%@include file="UserNavbar.jsp" %>
        
        <main class="container">
            <h1 class="text-center my-3">Share Notes with Friends</h1>
            <div class="row my-3">
                <div class="col-md-10 offset-1">
                    <form action="SearchUserServlet" method="post" class="row">
                        <div class="form-group col-10">
                            <input type="search" class="form-control" name="search" placeholder="Search Friend By Unique Id"/>
                        </div>
                        <div class="form-group col-2">
                            <input type="submit" class="btn btn-dark" value="Search"/>
                        </div>
                    </form>
                </div>
            </div>
        </main>
        
    </body>
</html>