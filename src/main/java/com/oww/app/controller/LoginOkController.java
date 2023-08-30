package com.oww.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oww.app.Execute;
import com.oww.app.Result;
import com.oww.app.dao.UserDAO;
import com.oww.app.dto.UserDTO;

public class LoginOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		UserDAO userDAO = new UserDAO();
		UserDTO userDTO = new UserDTO();
		UserDTO result = null;
		
		userDTO.setUserEmail(request.getParameter("userEmail"));
		userDTO.setUserPassword(request.getParameter("userPassword"));
		
		result = userDAO.login(userDTO);
		
		System.out.println(result.getUserNickname());
		System.out.println(result.getUserNumber());

		//회원의 번호, 이름을 세션에 저장한다
		HttpSession session = request.getSession();
		session.setAttribute("userNumber", result.getUserNumber());
		session.setAttribute("userNickname", result.getUserNickname());
		
		response.sendRedirect(request.getContextPath());
		
		return null;
	}

}
