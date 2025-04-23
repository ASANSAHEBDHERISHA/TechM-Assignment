package controller;
 
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import models.Student;
import java.util.ArrayList;
import java.util.List;
 
@WebServlet("/StudentServlet")
public class studentServlet extends HttpServlet{
	private static List<Student> students = new ArrayList<>();
	//public static final
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,
	IOException {
		   String name = request.getParameter("name");
		   String reg = request.getParameter("reg");
		   int age= Integer.parseInt(request.getParameter("age"));
		   float per = Float.parseFloat(request.getParameter("per"));
		   students.add(new Student(name,reg,age,per));
		   System.out.println("Added Student");
		   request.setAttribute("students", students);
		   request.getRequestDispatcher("viewStudent.jsp").forward(request, response);
		   
		   
	}
	
}