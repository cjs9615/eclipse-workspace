package edu.pnu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/gugudan2")
public class Gugudan2 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain; charset=utf-8");
		String dir = req.getParameter("dir");
		PrintWriter out = resp.getWriter();
		if (dir.equals("ver")) {
			for(int i = 1; i < 10; i++) {
				for(int j = 1; j < 10; j++) {
					out.println(i + " * " + j + " = " + i*j);
				}
				out.println("");
			}
		}
		else if(dir.equals("hor")) {
			for(int i = 2; i <= 9; i+=8) {
				for(int j = 1; j <= 9; j++) {				
					for(int k = 0; k < 8; k++) {
						if(i+k < 10) {
							out.print((i+k) + "*" + j + "=" + (i+k)*j +  "\t");
						}					
					}
					out.println();
				}
				out.println();
			}
		}
		
		out.close();
	}
}
