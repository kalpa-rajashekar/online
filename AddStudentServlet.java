package com.simplilearn.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.simplilearn.entity.Classes;
import com.simplilearn.entity.Course;
import com.simplilearn.entity.PhoneNumber;
import com.simplilearn.entity.Student;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class AddStudentServlet
 */
@WebServlet("/add-student")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddStudentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("add-student.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Student student = populateStudent(request);

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		session.save(student);

		tx.commit();
		session.close();

		PrintWriter out = response.getWriter();
		out.append("<html><body>");
		out.println("Records saved successfully");
		out.append("</html></body>");
	}

	private Student populateStudent(HttpServletRequest request) {
		String fname = request.getParameter("sname");
		

		Student student = new Student();

		/*// Phone1
		String phoneNum1 = request.getParameter("phone_1");
		String phoneType1 = request.getParameter("types1");
		PhoneNumber phoneNumber1 = new PhoneNumber();
		phoneNumber1.setPhoneNumber(phoneNum1);
		phoneNumber1.setPhoneType(phoneType1);
		phoneNumber1.setStudent(student);

		// Phone2
		String phoneNum2 = request.getParameter("phone_2");
		String phoneType2 = request.getParameter("types2");
		PhoneNumber phoneNumber2 = new PhoneNumber();
		phoneNumber2.setPhoneNumber(phoneNum2);
		phoneNumber2.setPhoneType(phoneType2);
		phoneNumber2.setStudent(student);

		// Phone3
		String phoneNum3 = request.getParameter("phone_3");
		String phoneType3 = request.getParameter("types3");
		PhoneNumber phoneNumber3 = new PhoneNumber();
		phoneNumber3.setPhoneNumber(phoneNum3);
		phoneNumber3.setPhoneType(phoneType3);
		phoneNumber3.setStudent(student);

		List<PhoneNumber> phones = new ArrayList<>();
		phones.add(phoneNumber1);
		phones.add(phoneNumber2);
		phones.add(phoneNumber3);
		*/

		student.setStudentName(fname);
		

		List<Student> students = new ArrayList<>();
		students.add(student);

		// Add details for courses

		// Read Course1
		String courseName = request.getParameter("course_1");
		Classes course1 = new Classes();
		course1.setCname(courseName);
		

		// Read Course2
		Classes course2 = new Classes();
		String courseName2 = request.getParameter("course_2");    
		course1.setCname(courseName2);

		// Read Course3
		String courseName3 = request.getParameter("course_3");
		Classes course3 = new Classes();
		course3.setCname(courseName3);
		
		
		List<Classes> courses = new ArrayList<>();
		courses.add(course1);
		courses.add(course2);
		courses.add(course3);

		student.setClasses(courses);
		
		// Populate address object
		
		
		
		
		return student;
	}

}
