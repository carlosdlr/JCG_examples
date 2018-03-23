package com.spothero.rate.service.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MicroservicesServlet", urlPatterns = { "/microservices" })
public class MicroservicesServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public MicroservicesServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletOutputStream out = response.getOutputStream();
		out.write("<html><h2>Hello from C2B2 Tomcat Microservices Blog</h2></html>".getBytes());
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
