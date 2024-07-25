package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import model.UserList;

@WebServlet("/CreateAccount")
public class CreateAccount extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserList userList = UserList.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (userList.addUser(new User(username, password))) {
            response.sendRedirect("login.html");
        } else {
            request.setAttribute("error", "既に同名のユーザが登録されています。");
            request.getRequestDispatcher("newAccount.jsp").forward(request, response);
        }
    }
}
