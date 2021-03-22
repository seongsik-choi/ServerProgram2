/*
0322
- Controller3.java & Controller3Model.java & form, proc.jsp 로 나뉘는 MVC 2.0 예제
 2. Controller: Servlet 3.0 이상 환경
   - Model, View의 역활을 전부하는 콘트롤러
  ▶ Controller3.java (Model, View)/ form.jsp(View) / proc.jsp(결과) 
  ▶ 실행 순서
 .jsp Model2(MVC) : Controller3.java의 doGet() -> form.jsp -> post submit 
                            -> Controller3.java의 doPost() -> Beans -> proc.jsp
 
 1)
  doPost{  // Controller3Model.java의 SetData Method로 전달 
    this.model.setData(request);  // request 객체를 model로 전달(Call By Reference)
                                              // HashCode(≒Memory address) 전달
                                               
  2) 주기억장치에서 공유되는 request 객체
       Controller3Model.java의 request 객체 = doPost()의 request 객체
   -> Controller3Model.java의 request로 전달 
   -> doPost()의 request 객체 = setData()의 request 객체는 결국 같은 메모리
   A) Call by Reference를 의미  = Return이 필요 no                      
 
 */
package dev.controller;
 
import java.io.IOException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
// http://localhost:9090/mvc/controller3/img.do3
@WebServlet(urlPatterns="/controller3/img.do3", loadOnStartup=3)
public class Controller3 extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private Controller3Model model =null;
  
  public Controller3() {
    System.out.println("-> Controller3 created.");
    model = new Controller3Model(); // 모델 객체 생성
 
  }
 
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute("title", "오스트리아의 4계절");
    
    String view = "/controller3/form.jsp"; // /WebContents 기준
    
    RequestDispatcher dispatcher = request.getRequestDispatcher(view);
    dispatcher.forward(request, response);
  }
 
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.model.setData(request); // Call By Reference, Hashcode 전달(≒메모리 주소)
 
    // System.out.println("title: " + request.getAttribute("title"));
    String view = "/controller3/proc.jsp"; // /WebContents 기준
    
    RequestDispatcher dispatcher = request.getRequestDispatcher(view);
    dispatcher.forward(request, response);
    
  }
  
}
 




