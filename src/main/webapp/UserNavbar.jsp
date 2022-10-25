<%-- 
    Document   : UserNavbar
    Created on : Oct 24, 2022, 3:47:37 PM
    Author     : Hakim
--%>


<header class="header">

    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="UserDashboard.jsp"><i class="fa fa-book"></i> NoteBook</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="UserDashboard.jsp">
                            <i class="fa fa-home"></i> Home
                        </a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="AddNote.jsp">
                            <i class="fa fa-plus-square"></i> Add Note
                        </a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="ShowNotes.jsp">
                            <i class="fa fa-sticky-note"></i> Show Notes
                        </a>
                    </li>
                </ul>
                <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                    <li class="nav-item btn nav-link" data-bs-toggle="modal" data-bs-target="#exampleModal">
                        <i class="fa fa-user-circle-o"></i> <%= user.getFullname()%>
                    </li>
                    <li class="nav-item btn">
                        <a class="nav-link active" aria-current="page" href="UserLogoutServlet">
                            <i class="fa fa-sign-out"></i> Logout
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>

<%--Modal--%>

<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">User Profile</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <table class="table">
                    <tbody>
                        <tr>
                            <td>User Name</td>
                            <td><%= user.getFullname()%></td>
                        </tr>
                        <tr>
                            <td>User Email</td>
                            <td><%= user.getEmail()%></td>
                        </tr>
                        <tr>
                            <td>Unique Id</td>
                            <td><%= user.getUniqueid()%></td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
