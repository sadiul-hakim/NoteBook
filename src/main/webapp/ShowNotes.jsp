<%-- 
    Document   : ShowNotes
    Created on : Oct 24, 2022, 3:54:12 PM
    Author     : Hakim
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@page import="com.hakim.dao.user.User" %>
<%@page import="com.hakim.dao.note.Note" %>
<%@page import="com.hakim.entities.SecurityContext" %>
<%@page import="com.hakim.entities.ServerCalls" %>
<%@page import="java.util.List" %>

<%
    
    User user=SecurityContext.getCurrentUser(request);
    boolean isAuthenticated=SecurityContext.isAuthenticated(request);
    
    if(!isAuthenticated){
        request.getRequestDispatcher("UserLogin.jsp").forward(request,response);
    }
    
    List<Note> notes=ServerCalls.getAllNotesOfAUser(user.getId());
    
%>
<!DOCTYPE html>
<html>
    <%@include file="Head.jsp" %>
    <body>
        <%@include file="UserNavbar.jsp" %>
        <main class="container my-3">
            <h1 class="my-2" style="border-bottom:2px solid #333;padding-bottom: 4px;margin-bottom: 4px;">You have <%= notes.size()%> notes:</h1>
            <ul class="list-group">
                <%for(Note n:notes){%>
                <li class="list-group-item row d-flex">
                    <div class="col-10">
                        <h4><%= n.getTitle()%> | <%= n.getDate()%></h4>
                        <p><%= n.getDescription()%></p>
                    </div>
                    <div class="d-flex col-2 justify-content-between align-items-center">
                        <a href="" class="btn btn-dark"><i class="fa fa-edit"></i></a>
                        <a href="ShareNote.jsp?id=<%=n.getId()%>" class="btn btn-dark"><i class="fa fa-share-alt"></i></a>
                        <a href="DeleteNoteServlet?id=<%= n.getId()%>" class="btn btn-danger"><i class="fa fa-trash"></i></a>
                    </div>
                </li>

                <%}%>
            </ul>
        </main>


    </body>
</html>
