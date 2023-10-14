package com.repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.controller.Controller;
import com.model.Productmodel;
import com.service.Productservice;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;


@WebServlet({"/index","/login","/show","/update","/updaterecord","/delete"})
@MultipartConfig(maxFileSize = 10000000, fileSizeThreshold = 10000000, maxRequestSize = 10000000)
public class Main extends HttpServlet {
	Productservice ps;
	 
	@Override
	public void init() throws ServletException {
		ps=new Controller();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getServletPath().equals("/login")) {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String mobile=req.getParameter("mobile");
		String file=req.getPart("file").getSubmittedFileName();
		
		for(Part p:req.getParts()) {
			p.write("C:\\Users\\Rudraa\\eclipse-workspace\\Watchshop-complete\\src\\main\\webapp\\image\\"+file);
		}
		Productmodel pm=new Productmodel(0, name, email, mobile, file);
		System.out.println(pm);
		ps.Insert(pm);
		resp.sendRedirect("login.jsp");
	}
		if(req.getServletPath().equals("/updaterecord")) {
			int usno=Integer.parseInt(req.getParameter("sno"));
			String uname=req.getParameter("name");
			String uemail=req.getParameter("email");
			String umobile=req.getParameter("mobile");
			String oldfile=req.getParameter("oldfile");
			String ufile=req.getPart("file").getSubmittedFileName();
			for(Part q:req.getParts()) {
				q.write("C:\\Users\\Rudraa\\eclipse-workspace\\Watchshop-complete\\src\\main\\webapp\\image\\"+ufile);
			}
			Productmodel um=new Productmodel(usno, uname, uemail, umobile, ufile);
			ps.updaterecord(um);
			File file=new File("C:\\Users\\Rudraa\\eclipse-workspace\\Watchshop-complete\\src\\main\\webapp\\image\\"+oldfile);
			file.delete();

		}
		
	}	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Productservice ps= new Controller();
		if (req.getServletPath().equals("/show")) {
		ArrayList<Productmodel> data=ps.fetchalldata();
		req.setAttribute("data", data);
		RequestDispatcher rd= req.getRequestDispatcher("show.jsp");
		rd.forward(req, resp);
		}
		
		if(req.getServletPath().equals("/update")) {
			String id= req.getParameter("id");	
			ArrayList<Productmodel> data=ps.fetchdata();
			req.setAttribute("data", data);
			req.setAttribute("id", id);
			RequestDispatcher rd=req.getRequestDispatcher("update.jsp");
			rd.forward(req, resp);
		}	
		if (req.getServletPath().equals("/delete")) {
			int sno= Integer.parseInt(req.getParameter("sno"));
			String oldfile=req.getParameter("file");
			File f=new File("C:\\Users\\Rudraa\\eclipse-workspace\\Watchshop-complete\\src\\main\\webapp\\image\\"+oldfile);
			ps.delete(sno);	
			f.delete();
			RequestDispatcher rd=req.getRequestDispatcher("show");
			rd.forward(req, resp);
		}
	}
}
