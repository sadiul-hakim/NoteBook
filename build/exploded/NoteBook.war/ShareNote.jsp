<%-- 
    Document   : ShareNote
    Created on : Oct 26, 2022, 12:51:31 AM
    Author     : Hakim
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@page import="com.hakim.dao.user.User" %>
<%@page import="com.hakim.dao.note.Note" %>
<%@page import="com.hakim.entities.SecurityContext" %>
<%@page import="com.hakim.entities.ServerCalls" %>

<%
    
    User user=SecurityContext.getCurrentUser(request);
    boolean isAuthenticated=SecurityContext.isAuthenticated(request);
    
    if(!isAuthenticated){
        request.getRequestDispatcher("UserLogin.jsp").forward(request,response);
    }
    int id=Integer.parseInt(request.getParameter("id"));
    Note n=ServerCalls.getANote(id).get();
    
%>
<!DOCTYPE html>
<html>
    <%@include file="Head.jsp" %>
    <body>
        <%@include file="UserNavbar.jsp" %>

        <main class="container">
            <form class="row my-3" action="ShareNoteServlet" method="post">
                <div class="col-md-6 mx-auto">
                    <h1 style="border-bottom: 2px solid #333;">Share Note</h1>
                    <div class="form-group my-2">
                        <input type="text" class="form-control" name="uniqueid" placeholder="User Unique Id"/>
                    </div>

                    <div class="form-group my-2">
                        <input type="text" name="nid" class="form-control" value="<%= n.getId()%>" hidden="true"/>
                    </div>
                    <div class="form-group my-2">
                        <input type="text" name="aname" class="form-control" value="<%= user.getFullname()%>" hidden="true"/>
                    </div>
                    <div class="form-group my-2">
                        <input type="text" name="aid" class="form-control" value="<%= user.getUniqueid()%>" hidden="true"/>
                    </div>
                    <div class="form-group my-2">
                        <input type="text" name="title" class="form-control" value="<%= n.getTitle()%>" hidden="true"/>
                    </div>
                    <div class="form-group my-2">
                        <input type="text" name="description" class="form-control" value="<%= n.getDescription()%>" hidden="true"/>
                    </div>
                    <div class="form-group my-2">
                        <input type="submit" class="btn btn-dark" value="Share"/>
                    </div>
                </div>
            </form>
        </main>
    </body>
</html>
