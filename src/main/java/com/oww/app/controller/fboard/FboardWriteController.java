package com.oww.app.controller.fboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oww.app.Execute;
import com.oww.app.Result;
import com.oww.app.dao.UserDAO;

public class FboardWriteController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("test1");
		UserDAO userDAO = new UserDAO();
		HttpSession session = request.getSession();
		Integer userNumber = (Integer)session.getAttribute("userNumber");
		String path = null;

		System.out.println("test2");
        if (userNumber == null) {
        	//사용자 번호가 없으면 로그인 페이지로 이동하고, 사용자 번호가 있으면 글 작성 페이지로 이동합니다.
            path = "/member/project/login.jsp";
            //사용자 번호가 없으면 로그인 페이지로 이동
            System.out.println("test2-1");
        } else {
            path = "/board/project/writing.jsp";
            request.setAttribute("userNickname", userDAO.getUserNickname(userNumber));
            //사용자 번호가 있으면 글 작성 페이지로 이동
            System.out.println("test2-2");
            
        }
        System.out.println("test3");
        // 여기서 return 값은 null로 설정하면 됩니다.
        // return null;

        // 요청을 지정된 경로로 전달합니다.
        request.getRequestDispatcher(path).forward(request, response);
        System.out.println("test4");
        // 리턴 타입에 맞게 필요한 작업을 수행하세요.

        return new Result(); 
    }

}