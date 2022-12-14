package com.hakim.servlet;

import com.hakim.dao.user.LoginDTO;
import com.hakim.dao.user.User;
import com.hakim.dao.user.UserRepositoryImp;
import com.hakim.dao.user.UserService;
import com.hakim.dao.user.UserServiceImp;
import com.hakim.entities.ErrorMessage;
import com.hakim.entities.Message;
import com.hakim.entities.SecurityContext;
import com.hakim.entities.Sha256PasswordEncryptor;
import com.hakim.entities.ValidationUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Optional;

/**
 *
 * @author Hakim
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    private final Message errorMessage = new ErrorMessage();
    private final UserService service = new UserServiceImp(
            new UserRepositoryImp(errorMessage),
            errorMessage,
            new Sha256PasswordEncryptor()
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
            RequestDispatcher dispatcher = request.getRequestDispatcher("UserLogin.jsp");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            LoginDTO dto = new LoginDTO(email, password);

            Map<String, String> errors = ValidationUtil.getINSTANCE().validate(dto);

            if (!errors.isEmpty()) {
                request.setAttribute("errors", errors);
                dispatcher.forward(request, response);
            }

            Optional<User> user = service.userLogin(dto);

            if (!user.isPresent()) {
                out.print("<div class=\"alert alert-danger mb-0\">%s</div>".formatted(errorMessage.getMessage().get()));
                dispatcher.include(request, response);
            }else{
                SecurityContext.login(request, user.get());
                response.sendRedirect("UserDashboard.jsp");
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
