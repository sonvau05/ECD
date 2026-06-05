package controller;

import entity.Student;
import session.StudentSession;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "StudentServlet", urlPatterns = {"/StudentServlet"})
public class StudentServlet extends HttpServlet {

    @EJB
    private StudentSession studentSession;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        if (action.equals("delete")) {
            String rollnumber = request.getParameter("rollnumber");
            studentSession.deleteStudent(rollnumber);
            response.sendRedirect("StudentServlet?action=list");
        } else {
            // action = "list"
            List<Student> list = studentSession.getAllStudents();
            request.setAttribute("studentList", list);
            request.getRequestDispatcher("list.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            String rollnumber = request.getParameter("rollnumber");
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            int age = Integer.parseInt(request.getParameter("age"));

            Student s = new Student(rollnumber, name, email, age);
            studentSession.addStudent(s);
        }
        response.sendRedirect("StudentServlet?action=list");
    }
}
