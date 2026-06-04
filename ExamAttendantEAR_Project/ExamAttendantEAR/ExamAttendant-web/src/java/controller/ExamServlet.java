package controller;

import entity.Exam;
import session.ExamService;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "ExamServlet", urlPatterns = {"/exams"})
public class ExamServlet extends HttpServlet {

    @EJB
    private ExamService examService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Exam> examsList = examService.findAllExams();
        request.setAttribute("exams", examsList);
        request.getRequestDispatcher("listExams.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        int duration = Integer.parseInt(request.getParameter("duration"));
        String description = request.getParameter("description");

        examService.saveExam(name, duration, description);

        response.sendRedirect("exams");
    }
}