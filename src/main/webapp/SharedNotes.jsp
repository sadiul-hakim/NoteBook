<%-- 
    Document   : SharedNotes
    Created on : Oct 25, 2022, 11:29:49 PM
    Author     : Hakim
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@page import="com.hakim.dao.user.User" %>
<%@page import="com.hakim.dao.shareNote.ShareNote" %>
<%@page import="com.hakim.entities.SecurityContext" %>
<%@page import="com.hakim.entities.ServerCalls" %>
<%@page import="java.util.List" %>

<%
    
    User user=SecurityContext.getCurrentUser(request);
    boolean isAuthenticated=SecurityContext.isAuthenticated(request);
    
    if(!isAuthenticated){
        request.getRequestDispatcher("UserLogin.jsp").forward(request,response);
    }
    
    List<ShareNote> notes=ServerCalls.getAllSharedNotesOfAUser(user.getUniqueid());
    
%>
<!DOCTYPE html>
<html>
   <%@include file="Head.jsp" %>
    <body>
        <%@include file="UserNavbar.jsp" %>
         <main class="container my-3">
            <h1 class="my-2" style="border-bottom:2px solid #333;padding-bottom: 4px;margin-bottom: 4px;"><%= notes.size()%> notes have been shared with you:</h1>
            <ul class="list-group">
                <%for(ShareNote n:notes){%>
                <li class="list-group-item row d-flex">
                    <div class="col-11">
                        <h4 >Title : <%= n.getTitle()%> | Date Time : <%= n.getDate()%></h4>
                        <p style="border-bottom: 1px solid #333;"><mark>Shared By</mark> : <%= n.getAname()%> | Id : <%= n.getAid()%></p>
                        <p><%= n.getDescription()%></p>
                    </div>
                    <div class="d-flex col-1 justify-content-between align-items-center">
                        <a href="DeleteNoteServlet?id=<%= n.getId()%>" class="btn btn-danger"><i class="fa fa-trash"></i></a>
                    </div>
                </li>
                <%}%>
            </ul>
        </main>

    </body>
</html>
