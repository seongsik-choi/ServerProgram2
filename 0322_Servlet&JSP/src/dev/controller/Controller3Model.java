/*
0322
[05] Model, JSP View가 분리된 MVC Controller version 3.0 실습       
 [01] Model, JSP View가 분리된 MVC Controller version 3.0 실습
 - logic 처리를 JAVA 파일, UI 구현을 JSP로 분리하는 구조 
 
 ▶ 실행 순서
 .jsp Model1 : form.jsp -> proc.jsp -> beans.java
  -> model1은 디자인과 처리과 섞여있어 복잡(한사람이 여러 작업하는 꼴)
  
 .jsp Model2(MVC) : Controller3.java의 doGet() -> form.jsp -> post submit 
                            -> Controller3.java의 doPost() -> Beans -> proc.jsp
 
  ▶ Controller3.java (Model, View)/ form.jsp(View) / proc.jsp(결과) 
 
 - 사용 코드
  String view = "/form/view.jsp"; // 프로젝트명 생략
  RequestDispatcher dispatcher = request.getRequestDispatcher(view);
  dispatcher.forward(request, response);   
 
 - 실행시 호출 주소
   http://localhost:9090/mvc/controller3/form.jsp 
   http://localhost:9090/mvc/controller3/form.do3
   
 */
package dev.controller;
import javax.servlet.http.HttpServletRequest;
 
class Controller3Model{
  public Controller3Model () {
    System.out.println("-> Controller3Model created.");
  }
  
  public void setData(HttpServletRequest request) { // doPost()의 request 객체와 동일.
    String code = request.getParameter("code"); // 폼에서 데이터 수집
    
    if (code.equals("img1")) {                                // form.jsp의 name과 value
      request.setAttribute("title", "봄");                    // 데이터를 저장(Key, value)
      request.setAttribute("fname", "spring.jpg");    
    } else if (code.equals("img2")) {
      request.setAttribute("title", "여름");
      request.setAttribute("fname", "summer.jpg");     
    } else if (code.equals("img3")) {
      request.setAttribute("title", "가을");
      request.setAttribute("fname", "fall.jpg");     
    } else if (code.equals("img4")) {
      request.setAttribute("title", "겨울");
      request.setAttribute("fname", "winter.jpg");     
    } else {
      request.setAttribute("title", "이미지가 등록되지 않았습니다.");
      request.setAttribute("fname", "img.png");  
    }
    
  }
}