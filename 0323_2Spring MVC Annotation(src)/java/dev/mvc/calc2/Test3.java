/*
0323
3) @Controller 에노테이션을 선언했지만 패키지가 달라 객체 생성이 안됨.
▷ /src/main/java/dev.mvc.calc2.Test3.java

 -> 해결 방법
 ▷ /src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml
 ▶ servlet-contex.xml에 선언하여  @Controller Annotation이 선언된 클래스를 자동 생성
<context:component-scan base-package="dev.mvc.cal2" />
 */
package dev.mvc.calc2;
import org.springframework.stereotype.Controller;
 
@Controller
public class Test3 {
 
  public Test3() {
    System.out.println("--> test3 객체 생성됨.");
  }
 
}