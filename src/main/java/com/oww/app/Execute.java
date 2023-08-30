package com.oww.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//인터페이스
public interface Execute {
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException;
	//추상메소드 로 통일화
}