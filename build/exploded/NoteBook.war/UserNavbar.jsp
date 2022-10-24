<%-- 
    Document   : UserNavbar
    Created on : Oct 24, 2022, 3:47:37 PM
    Author     : Hakim
--%>


<header class="header">

    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="index.jsp"><i class="fa fa-book"></i> NoteBook</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#">
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
                     <li class="nav-item btn">
                         <a class="nav-link active" aria-current="page" href="UserLogin.jsp">
                            <i class="fa fa-sign-in"></i> UserName
                        </a>
                    </li>
                     <li class="nav-item btn">
                         <a class="nav-link active" aria-current="page" href="UserRegister.jsp">
                            <i class="fa fa-sign-out"></i> Logout
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>