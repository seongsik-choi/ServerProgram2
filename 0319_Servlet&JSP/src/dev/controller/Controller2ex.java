/*
0319
  - MVC 중 View(viewex.jsp) / Controller(Controller2ex.java)으로 분리
 */
package dev.controller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "*.do2ex", loadOnStartup = 1)
public class Controller2ex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public Controller2ex() {
	  System.out.println("-> Controller2ex created");
	}

	@Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String uri = request.getRequestURI();  // URI 값 
	  
	  if (uri.equals("/mvc/controller2ex/food1.do2ex")) {
	    // 출력이 아닌 logic처리만, 출력은 view.jsp 쪽에서
	    request.setAttribute("title", "치킨");                    // 데이터를 저장(Key, value)
	    request.setAttribute("fname", "food1.jpg");	    
	  } else if (uri.equals("/mvc/controller2ex/food2.do2ex")) {
	    request.setAttribute("title", "피자");
      request.setAttribute("fname", "food2.jpg");       
    } else if (uri.equals("/mvc/controller2ex/food3.do2ex")) {
      request.setAttribute("title", "족발");
      request.setAttribute("fname", "food3.jpg");        
    } else if (uri.equals("/mvc/controller2ex/food4.do2ex")) {
      request.setAttribute("title", "햄버거");
      request.setAttribute("fname", "food4.jpg");          
    } else {
      request.setAttribute("title", "이미지가 등록되지 않았습니다.");
      request.setAttribute("fname", "img.png");  
    }
	  // WebContent 폴더 하위의 폴더부터 명시
	  String view2ex = "/season/view2ex.jsp"; 
	  RequestDispatcher dispatcher = request.getRequestDispatcher(view2ex);
	  dispatcher.forward(request, response);   
    
    }// end doGet()
}// end Class