package com.rays.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//enotation @WebServlet("/FirstServlet")

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in dopost method");
		
		String fname = request.getParameter("firstName");
		
		String lname = request.getParameter("lastName");
		
		System.out.println(fname);
		System.out.println(lname);
	}

}
