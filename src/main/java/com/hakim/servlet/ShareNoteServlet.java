package com.hakim.servlet;

import com.hakim.dao.shareNote.ShareNoteDTO;
import com.hakim.dao.shareNote.ShareNoteRepositoryImp;
import com.hakim.dao.shareNote.ShareNoteService;
import com.hakim.dao.shareNote.ShareNoteServiceImp;
import com.hakim.dao.user.UserRepositoryImp;
import com.hakim.entities.ErrorMessage;
import com.hakim.entities.Message;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Hakim
 */
@WebServlet(name = "ShareNoteServlet", urlPatterns = {"/ShareNoteServlet"})
public class ShareNoteServlet extends HttpServlet {
    private final Message errorMessage=new ErrorMessage();
    private final ShareNoteService servlet=new ShareNoteServiceImp(
            errorMessage,
            new ShareNoteRepositoryImp(errorMessage),
            new UserRepositoryImp(errorMessage)            
    );
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            int nid=Integer.parseInt(request.getParameter("nid"));
            String aid=request.getParameter("aid");
            String uniqueId=request.getParameter("uniqueid");
            String aname=request.getParameter("aname");
            String title=request.getParameter("title");
            String description=request.getParameter("description");
            
            ShareNoteDTO dto=new ShareNoteDTO(nid, aid, uniqueId, aname, title, description);
            
            boolean isSaved=servlet.share(dto);
            
            if(!isSaved){
                out.print("<div class=\"alert alert-danger mb-0\">%s</div>".formatted(errorMessage.getMessage().get()));
                request.getRequestDispatcher("ShowNotes.jsp").include(request, response);
            }else{
                out.print("<div class=\"alert alert-success mb-0\">Note sahred successfully.</div>");
                request.getRequestDispatcher("ShowNotes.jsp").include(request, response);
            }
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
