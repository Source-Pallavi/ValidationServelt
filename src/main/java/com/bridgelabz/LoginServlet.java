package com.bridgelabz;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(
        description = "Login Validation",
        urlPatterns = {"/LoginServlet"}
)
public class LoginServlet extends HttpServlet {
    private static final String USER_PATTERN = "^([A-Z]){1}[a-zA-Z]{3,}$";
    private static final String PASSWORD_PATTERN = "((?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,})";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("user");
        String password = req.getParameter("password");

        Pattern pattern= Pattern.compile(USER_PATTERN);
        boolean userName = pattern.matcher(user).matches();
        Pattern pattern1= Pattern.compile(PASSWORD_PATTERN);
        boolean password1 = pattern1.matcher(password).matches();

        if(userName &&  password1){
            req.setAttribute("user",user);
            req.getRequestDispatcher("LoginSuccess.jsp").forward(req,resp);
        }
        else{
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out = resp.getWriter();
            out.println("<font color=red>Bad Credentials.</font>");
            rd.include(req,resp);
        }
    }
}
