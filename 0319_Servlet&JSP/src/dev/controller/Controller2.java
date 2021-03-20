/*
0319
 [04] JSP View가 분리된 MVC Controller version 2.0 실습
 [01] JSP View가 분리된 MVC Controller version 2.0 실습
  - UI 구현은 JSP로 분리하는 구조 
  - 사용 코드
    String view = "/season/view.jsp"; // "/WebContent" 폴더 기준
    RequestDispatcher dispatcher = request.getRequestDispatcher(view);
    dispatcher.forward(request, response);   
    
    STS Setting
    name: mvc 프로젝트 계속 사용

  1. Controller: Servlet 2.0이상 환경
   - Model의 역활을 포함하는 Controller
   
   - <jsp:forward~~, /WebContent 폴더 하위의 폴더부터 명시
      String view = "/season/view.jsp";
      RequestDispatcher dispatcher = request.getRequestDispatcher(view);
      dispatcher.forward(request, response);   
       
    - Access http://127.0.0.1:9090/mvc/controller2/spring.do2
                http://127.0.0.1:9090/mvc/controller2/summer.do2
                http://127.0.0.1:9090/mvc/controller2/fall.do2
                http://127.0.0.1:9090/mvc/controller2/winter.do2
                
    Q) MVC 중 View(jsp) / Controller(Servlet)으로 분리
 */
package dev.controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "*.do2", loadOnStartup = 1)
public class Controller2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public Controller2() {
	  System.out.println("-> Controller2 created");
	}

	@Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
	  String uri = request.getRequestURI();  // URI 값 
	  
	  if (uri.equals("/mvc/controller2/spring.do2")) {
	    // 출력이 아닌 로직처리만, 출력은 view.jsp 쪽에서
	    request.setAttribute("title", "봄");                    // 데이터를 저장(Key, value)
	    request.setAttribute("fname", "spring.jpg");	   // 데이터를 저장(Key, value)
	    
	  } else if (uri.equals("/mvc/controller2/summer.do2")) {
	    request.setAttribute("title", "여름");
      request.setAttribute("fname", "summer.jpg");     
      
    } else if (uri.equals("/mvc/controller2/fall.do2")) {
      request.setAttribute("title", "가을");
      request.setAttribute("fname", "fall.jpg");     
      
    } else if (uri.equals("/mvc/controller2/winter.do2")) {
      request.setAttribute("title", "겨울");
      request.setAttribute("fname", "winter.jpg");    
      
    } else {
      request.setAttribute("title", "이미지가 등록되지 않았습니다.");
      request.setAttribute("fname", "img.png");  
    }
	  
	// "WebContent" 폴더 기준
	  String view = "/season/view.jsp"; 
	  RequestDispatcher dispatcher = request.getRequestDispatcher(view);
	  dispatcher.forward(request, response);   
    
    }// end doGet()
}// end Class