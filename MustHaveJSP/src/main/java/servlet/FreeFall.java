package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/12Servlet/FreeFall.do")
public class FreeFall extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String t = req.getParameter("t");
		//String t1 = req.setAttribute("t1", t);
		if(t == null) return;
		double a = 9.81;
		double result = 0.5 * a * (Double.parseDouble(t)) + 1000;
		
		req.setAttribute("result", result);
		req.getRequestDispatcher("/12Servlet/FreeFall.jsp").forward(req, resp);
	}
}
