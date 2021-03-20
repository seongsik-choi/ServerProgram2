/*
0319
0318 복습 + 정리
 Q1) Stduy2.java, FestivalReq.java가 java class 파일이지만 web상에서 실행되는 이유
 A1) 부모클래스인 HttpServlet에 doGet, doPost 함수가 있으며, 
     HttpServletRequest와 HttpServletResponse를 @Override하여 사용

 Q2) 서블릿은 클래스인데 실행시 웹에서 실행되려면 url을 어디에 선언?
 A2) @WebServlet("/form/festival_req.seoul")     // annotation(특정 기능을 갖는 선언문의 일종)

 Q3) private static final long serialVersionUID = 1L; 의 의미
 A3) 생략가능하며 서블릿 클래스의 버전을 명시, 업데이트 발생시 숫자를 증가, 선택적(생략가능)

 Q4) Servlet에서 GET 방식과 POST 방식을 처리하는 Method
 A4) DoGet Method와 DoPost Method <-> JSP는 통합하여 처리

 Q5) Servlet에서 출력 시 생성해야하는 객체는?
 A5) PrintWriter out = response.getWriter();

 Q6) RequestDispatcher interfacae의 사용 목적은?
 A6) request, response 객체를 JSP로 보내기위하여 사용

 Q7) request를 보내는 이유?
 Q7) JSP 페이지로 초기값 전달 기능

 Q8) request.getParmeter()를 이용하여 폼의 데이터를 가져오는것으로 아는데, 
      Request 객체의 데이터를 저장하고 가져오는 방법은?
  A8) request.getParameter("title"): 폼에서 데이터 수집
   A8) request.setAttribute("title", "연꽃축제"): 데이터를 저장
   A8) request.getAttribute("title"): 저장된 데이터의 회수

 Q9) 서블릿의 사용 목적?
 A9) Web에서의 데이터 처리, JSP도 서버에서 서블릿으로 변경되어 실행

 Q10) 서블릿 실행시 GET방식이 호출되는 이유는?
 A10) http://localhost:9090/mvc/form/study2 주소가 브러우저에 입력되어 실행되기 때문에 GET 방식으로처리
     + GET 방식(Broswer에 주소를 입력) +POST방식(form에서 진행
---------------------------------------------------------------------------------------------------------------

0319_[03] JSP Model 2(MVC) 개론, Model/JSP View가 결합된 MVC Controller version 1.0       
 [01] JSP Model 2 개발 패턴

 1. 소프트웨어공학에서의 개발 패턴인 기본적인 MVC 패턴
   - 클라이언트의 요청, 처리, 출력을 구성 요소별로 분리하여 개발함으로써
    대규모 프로젝트 개발에 최적화된 방법론
    예) 최근의 언어들은 대부분 MVC 기반의 구조(Java Spring, Python Django, NodeJS등)

   - Model: DBMS 접근 SQL 실행 java 로직, DTO(VO), DAO,
               Helper class(Tool, Utility, DBOpen, DBClose, SearchDTO)
               , Manager class(Process, Service class, 제어문 구성 로직), 일반적인 클래스, Beans.

   - View: Web publisher(HTML5, CSS3, JavaScript, jQuery, Bootstrap, Vue.js),
             JSP, EL, JSTL, Thymeleaf 등 브러우저에 값을 나타내는 역할

   - Controller: Java Servlet, 접속자의 주소를 전송받아 GET/POST 방식을 구분하여
                   로직을 실행하는 기능, 관련 로직을 호출하는 기능, 로깅, 보안등 공통 로직을 실행

  2. 자바 서블릿 기반  MVC(JSP Model 2) 패턴
   1) Client로부터 전송된 주소를 받을 수 있는 자바 기술은?
       - JSP: 파일명과 일치하는 하나의 요청만 받을 수 있음, 파일명이 다르면 404 발생
           ex) form.jsp --> proc.jsp
       - Servlet: 설정에따라 무한대의 요청을 받아 처리 가능, 실제 존재하지 않는 파일 지정 가능,
                    접근 주소를 명령어로 이용, URI Command Pattern이라 함

  1) BROWSER: 접속자, Chrome등 브러우저
  2) Servlet(Controller): 사용자의 요청을 받아 주소를 분석하여 해당하는 빈을 실행
                            JSP 처럼 GET, POST 방식 요청 접수 처리
  3) Java Beans(Model): 데이터를 처리하며, SQL을 실행합니다. DAO
  4) JSP(View): 처리 결과를 출력 합니다.
                 <Form>태그등을 이용하여 사용자와 입출력을 담당
  5) Data Sources: Oracle, MariaDB(MySQL 개발자가 만든 free DB), MySQL,


 3. JSP Model 2(MVC) 패턴
   - 실제 파일명이 아닌 명령어 기반 요청 처리 프로세스를 가짐
    . 서버로 특정 주소를 보낼때 그 주소는 실제 존재하는 파일no
      Model 1 처럼 404에러(폴더나 파일명이 존재하지 않는경우(오타등))가 나야하나 발생이 안됨
    . 파일명의 형식등으로 구성된 인터넷 주소를 명령어로 사용
    . 확장자를 생략하는 경우도 많음
    . 객체 설계 디자인 패턴에서 인터넷 주소를 명령어로 사용하는 패턴(URI Command Pattern)
       
 [02] 'Hello MVC'를 출력하는 콘트롤러를 제작.
      - Model/JSP View가 결합된 MVC Controller 서블릿 Ver 1.0 
 
  STS Setting
  name: mvc 프로젝트 계속 사용
  
-----------------------------------------------------------------------------------------------
실습)
 1. 실행시 호출 주소
   - JSP에서는 실제 존재하는 jsp 파일 호출, 존재하지 않으면 404 에러 발생
   - MVC에서는 실제 존재하지 않는 파일을 호출하여 처리
     요청 주소는 파일명이 아니라 명령어의 의미를 가짐
    - URI Command 패턴: 주소를 명령어처럼 사용하는 기법
     . Gallery 목록: http://localhost:9090/mvc/gallery/list.do1ex
     . 상품 목록: http://localhost:9090/mvc/product/list.do1ex
     . QnA 목록: http://localhost:9090/mvc/qna/list.do1ex
     . 회원 목록: http://localhost:9090/mvc/member/list.do1ex
     . 설문 목록: http://localhost:9090/mvc/survey/list.do1ex
   - *.do1: 요청 주소의 확장자가 'do1'인 경우 처리하는 서블릿
     http://127.0.0.1:9090/mvc/controller/apple.do1   ← O
     http://127.0.0.1:9090/mvc/controller/xmas.do1    ← O
     http://127.0.0.1:9090/mvc/controller/hello.dox    ← X

 2. Controller, Servlet 3.0 이상 환경 
   - Model, View의 역활을 전부하는 콘트롤러
   - urlPatterns="*.do1": 브러우저에서 확장자가 do1로 끝나는 모든 요청을 처리
   - loadOnStartup=1: 서블릿 중에 1순위로 자동 실행 
      ex) @WebServlet(urlPatterns="*.do1", loadOnStartup=1)  
  // loadOnStartup = 실행시 주기억장치에 상주시킬것인지 = true 
    
  - 서블릿에서 Web으로의 출력
    response.setContentType("text/html;charset=utf-8");
    request.setCharacterEncoding("utf-8");
    PrintWriter out =  response.getWriter();
    out.println("<h2>문자열 출력</h2>");
    
 Q1) JAVA 코드를 입력하기 위한 방법
    // " +JAVA CODE+ " 
   // URI : 고정IP 제외 나머지 주소
  
  Q2) Tomcat만 실행시켜도 생성자 출력부분 호출 이유
  A) loadOnStartup = 1
  
  Q3) http://localhost:9090/mvc/*.do1  : JSP에서는 생각할수 없는 구조
  
  Q4) 해당 구조가 Controller를 이용한 Servlet 구조, Servlet만 Controller를 생성 가능
  
 */
package dev.controller; 
import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
// urlPatterns="*.do1": 브러우저에서 확장자가 do1로 끝나는 모든 요청을 처리
// Tomcat 실행 후 서블릿 중 최우선 적으로 실행 : loadOnStartup = 1
@WebServlet(urlPatterns = "*.do1", loadOnStartup = 1)

public class Controller1 extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
  public Controller1() {
    System.out.println("-> Controller1 created.");
  }
 
  // 예외 발뱅시 ServletException, IOException 호출 (throws)
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=utf-8");
    request.setCharacterEncoding("utf-8");
    PrintWriter out =  response.getWriter();  // Servlet에서 출력 시 생성
    
    System.out.println("->Controller doGet()");
    out.println("<h1>Hello MVC</h1>");  // 문자열 들
    
 // JAVA 코드를 입력하기 위한 방법
 // " +JAVA CODE+ " 
 // URI : 고정IP 제외 나머지 주소
    out.println("<h1>URL : "+request.getRequestURL()+"</h1>");  // URL : http://localhost:9090/mvc/*.do1
    out.println("<h1>URI : "+request.getRequestURI()+" </h1>"); // URI : /mvc/*.do1
  }

}// class end