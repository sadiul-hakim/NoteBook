<%-- 
    Document   : AddNote
    Created on : Oct 24, 2022, 10:57:02 AM
    Author     : Hakim
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@page import="com.hakim.dao.user.User" %>
<%@page import="com.hakim.entities.SecurityContext" %>


<%
    
    User user=SecurityContext.getCurrentUser(request);
    System.out.println(user.getFullname());
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

        <main class="container my-5">
            <h2>Add Your Notes</h2>
            <div class="row">
                <div class="col-12">
                    <form action="AddNoteServlet" method="post">
                        <div class="form-group my-2">
                            <label form="title">Title</label>
                            <input type="text" class="form-control" name="title" required="true"/>
                        </div>
                        <div class="form-group my-2">
                            <label form="note">Note Content</label><br/>
                            <mark>You can use HTML tags in this field.</mark>
                            <textarea rows="5" class="form-control" name="description">
                                
                            </textarea>
                        </div>
                        <div class="form-group my-2">
                            <input type="hidden" name="uid" value="<%= user.getId()%>"/>
                        </div>
                        <div class="form-group my-2">
                            <button class="btn btn-dark"><i class="fa fa-check"></i> Add Note</button>
                        </div>
                    </form>
                </div>
            </div>
        </main>

        <%@include file="Footer.jsp" %>
    </body>
</html>
