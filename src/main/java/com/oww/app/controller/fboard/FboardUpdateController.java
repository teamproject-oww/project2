package com.oww.app.controller.fboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oww.app.Execute;
import com.oww.app.Result;
import com.oww.app.dao.FboardDAO;

public class FboardUpdateController implements Execute{
	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	int fboardNumber = Integer.valueOf(request.getParameter("fboardNumber"));
	FboardDAO fboardDAO = new FboardDAO();
	
	//selectAll2 에서 fboardNumber 정보를 받아와야 하므로 selectall2메소드를 selectone 함수를 사용해서 하나만 불러온다
	request.setAttribute("fboard", fboardDAO.selectAll2(fboardNumber));

	request.getRequestDispatcher("/board/views/rewriting.jsp").forward(request, response);
		
		
	return null;
	}
}