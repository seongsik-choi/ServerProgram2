<%-- 
0323
 7. EL 문자열 함수의 사용x   ▷ /sts_basic/src/main/webapp/el/string.jsp 
[선언]
 String fname = "winter.jpg";
 request.setAttribute("fname", fname);

 [실행 화면]
 문자열 길이: 10 
 부분 문자열 길이: win
 대문자로 변환: WINTER.JPG

 equals: true
 삼항 연산자: winter.jpg
 
 * EL 코드는 jsp 페이지에서 많은 자바 코드를 감소 시켰지만 예외 상황에서
  코드가 공개되는 문제가 있음으로 향후 Spring Security에서 방지 설정을 할 필요가 있음.
 
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
  *{ font-family: Malgun Gothic; font-size: 30px;}
</style>
</head>
<body>
<DIV class='container'>
<DIV class='content'>
  <%
  String fname = "winter.jpg";
  request.setAttribute("fname", fname);
  %>
  
  ${fname.length() }<br>
  ${fname.substring(0, 3) }<br> <!-- 0번지 부터 3개  -->
  ${fname.toUpperCase() }<br>
  ${fname.equals("winter.jpg")}<br>   <!--대소문자 구분  -->
  ${fname.equalsIgnoreCase("WInter.jpg") }<br> <!-- 대소문자 무시한 비교 -->
 
  ${fname == null ? "이름이 없습니다.":fname }<br>
</DIV> <!-- content END -->
</DIV> <!-- container END -->
</body>
</html>