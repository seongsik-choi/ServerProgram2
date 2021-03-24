<%-- 
0324
[11] Image, JS, CSS등 정적(static) resource의 사용, 이미지 출력, sts_calc        
 [01] 기본 설정된 환경에서 이미지 출력
 - 기본 설정된 환경에서 '/WEB-INF'에서 jsp는 실행 할 수 있지만 이미지 출력, JS, CSS등 사용 할 수 없음.

 ▶ Test) 세 dic
  1) webapp/resources/calc 폴더에 이미지 저장 : webapp은 jsp 없이 단독 실행이 가능
  2) webapp/calc 폴더에 이미지 저장 : resource 없이는 실행 불가능
  3) WEB-INF/views/calc 폴더에 이미지 저장 : WEB-INF" 폴더를 접근 불가능(실행시 반드시 Spring 필요)

 ▶ A) servlet-context.xml의 설정 때문에 resources 내 정적 리소스만 사용 가능!
 -> 선언 : <rsources mapping="/resources/**" location="/resources/" />
 -> 1) static resources(정적 리소스, 이미지 출력)
 -> 2) 검색 서버 등 외부의 서버에 이미지 등 노출 방지

 1. Project Type: Spring Legacy Project(Spring Project) -> Spring MVC Project    
        Name: sts_calc 재사용
        Package: dev.mvc.calc  ← 3단 이상 패키지 설정  
        ContextPath: calc        ← 마지막 패키지 이름을 사용, URL에서 사용
        Library: 프로젝트 생성시 관련 Spring 라이브러리가 자동으로 다운로드  
                    작업 컴퓨터는 인터넷에 연결되어 있어야

 2. 자동 생성 되어 있는 환경 설정 파일 '/WEB-INF/spring/appServlet/servlet-context.xml' 

 1) 이미지, JS 파일, CSS등 파일의 경로
  ▷ /WEB-INF/spring/appServlet/servlet-context.xml

 3. index.do의 제작
 4. /WEB-INF/views/index.jsp의 제작


  ▶ HomeController의 Mapping 및 반환 값 추가
 @Controller
 public class HomeController {
  
  //3가지 주소 접속을 허용
  // http://localhost:9090/calc/index.do
  // http://localhost:9090/calc
  // http://localhost:9090/calc/
  @RequestMapping(value = {"/", "/index.do"}, method = RequestMethod.GET)
  public String home(Locale locale, Model model) {
    return "index"; // /WEB-INF/views/index.jsp의 반환
  }
}

--%>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title></title>
 <link href="../css/style.css" rel="Stylesheet" type="text/css">  <!-- resources dic으 css폴더의 style 적용 -->
<style type="text/css">
  *{ font-family: Malgun Gothic; font-size: 26px;}
  IMG{
    width : 50px;
    height : 50px;
  }
</style>
</head>
<body>
 <DIV class="container_main"> 
   <H1>Spring 계산기</H1>
   <!--  문제) calc1.jsp와 연결하기 -->
   <!--  resources는 webapp 폴더 : /webapp/resources -->
   <!--  index.jsp의 경로 :  webapp/WEB-INF/views/index.jsp -->
   <!--  href 경로(CalcCont.java의 mapping) :  webapp/WEB-INF/views/calc/calc.jsp -->
   <img src='./resources/calc/images/add.png'></img> 
   <a href="http://localhost:9090/calc/calc/add.do?no1=100&no2=50">더하기</a><BR>
   
   <img src='./resources/calc/images/sub.png'></img> 
   <a href="http://localhost:9090/calc/calc/sub.do?no1=100&no2=50">빼기</a><BR>
   <img src='./resources/calc/images/mul.png'></img> 
   <a href="http://localhost:9090/calc/calc/mul.do?no1=100&no2=50">곱하기</a><BR>
   <img src='./resources/calc/images/div.png'></img> 
   <a href="http://localhost:9090/calc/calc/mod.do?no1=10&no2=3">나누기</a><BR>
 </DIV>
</body>
</html>