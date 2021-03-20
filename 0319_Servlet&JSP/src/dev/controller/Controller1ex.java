/*
0319
 [실습] 주어진 URL을 참고하여 하나의 이미지를 출력하는 콘트롤러를 제작하세요.
  STS Setting
  name: mvc 프로젝트 계속 사용

 1. Controller, Servlet 
   - Model, View의 역활을 전부하는 콘트롤러

  ▷ dev.controller.Controller1ex.java
    - 서블릿에서 Web으로의 출력
      response.setContentType("text/html;charset=utf-8");
      request.setCharacterEncoding("utf-8");
      PrintWriter out =  response.getWriter();
    - Annotation: @WebServlet(urlPatterns = "*.do1ex", loadOnStartup = 1)
    - Access
      http://127.0.0.1:9090/mvc/controller1/img1.do1ex   <-- spring01.jpg 출력
      http://127.0.0.1:9090/mvc/controller1/img2.do1ex   <-- spring01.jpg 출력
      http://127.0.0.1:9090/mvc/controller1/img3.do1ex   <-- spring01.jpg 출력
   - 이미지 저장 위치: /WebContent/form/images/spring01.jpg
   - 이미지 위치 절대 경로: /mvc/form/images/spring01.jpg
   
   Q) 실제 경로 : http://localhost:9090/mvc/*.do1ex 
   Q) http://localhost:9090/mvc/controller1/*.do1ex : controller1를 경로에 추가해도 실행가능
  
   A) controller1이라는 가상의 폴더를 만들어서 분류(아무 폴더나 입력 가능)
   A) http://localhost:9090/mvc/spring.do1ex : 처럼 가상의 폴더.url pattern name 입력해도 가능
   -> 결국 urlPatterns 값 : do1ex로 파일명이 끝나면 경로 수정해도 전부 실행
 */
package dev.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "*.do1ex", loadOnStartup = 1)
public class Controller1ex extends HttpServlet {
	private static final long serialVersionUID = 1L;

  public Controller1ex() {
    System.out.println("-> Controller1ex created.");
  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  response.setContentType("text/html;charset=utf-8");
    request.setCharacterEncoding("utf-8");
    PrintWriter out =  response.getWriter();  // Servlet에서 출력 시 생성
    
    out.println("<h1>Hello Controller1.ex</h1>");  // 문자열 들
    String uri = request.getRequestURI();
    out.println("<h1>URI : "+uri+" </h1>"); // URI : /mvc/*.do1
    
    // URL을 참고하여 하나의 이미지를 출력하는 콘트롤러를 제작
    if (uri.equals("/mvc/controller1/img1.do1ex")) {
      out.println("<IMG src='/mvc/form/images/spring01.jpg' style='width: 50%;'>");
    } 
    else if (uri.equals("/mvc/controller1/img2.do1ex")) {
      out.println("<IMG src='/mvc/form/images/spring02.jpg' style='width: 50%;'>");
    } 
    else if (uri.equals("/mvc/controller1/img3.do1ex")) {
      out.println("<IMG src='/mvc/form/images/spring03.jpg' style='width: 50%;'>");
    } 
    else {
      out.println("<h1>해당 이미지가 없습니다.</h1>");
    }// end else

	}// doGet() end
}
