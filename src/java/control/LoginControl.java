package control;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import dao.DAO;
import dao.LoginDAO;
import entity.Account;
import entity.Category;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "LoginControl", urlPatterns = {"/LoginControl"})
public class LoginControl extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String userName = request.getParameter("user");
        String password = request.getParameter("pass");

        HttpSession session = request.getSession();
        session.setAttribute("userName", userName);
        session.setAttribute("password", password);

        LoginDAO loginDao = new LoginDAO();
        Account account = loginDao.checkLogin(userName, password);
        System.out.println(account);

        if (account == null || account.getRole() == 0) {
            
            session.setAttribute("message", "Đăng nhập không thành công");
            if (userName == null && password == null) {

                session.setAttribute("message", null);
            }
            RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/Views/Login.jsp");
            dispatch.forward(request, response);
        } else {

            DAO dao = new DAO();
            List<Product> list = dao.getAllProduct();
            List<Category> listC = dao.getAllCategory();
            Product last = dao.getLast();

            //b2: set data to jsp
            request.setAttribute("listP", list);
            request.setAttribute("listCC", listC);
            request.setAttribute("p", last);

            RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/Views/MainHome.jsp");
            dispatch.forward(request, response);

        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
