package controller;

import com.example.crudproduct.service.UserService;
import com.example.crudproduct.service.imp.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "loginservlet", value = "/login")
public class LoginController extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        RequestDispatcher view = req.getRequestDispatcher("/jsp/login.jsp");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserService userService = new UserServiceImpl();
        if (userService.authenUser(username, password)) {
            //todo: redirect -> login controller
            //todo: server return access_token (ttl) -> client lưu ở storage;
            res.sendRedirect(req.getContextPath() + "/home");
        } else {
            String stringErr = "";
            req.setAttribute("error", stringErr);
            view.forward(req, res);
        }
    }
}
