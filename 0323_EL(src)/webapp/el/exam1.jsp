<%-- 
0323
 [과제 2] GET 방식으로 3개의 정수 데이터를 전달하고 합을 출력하는 프로그램을 작성
- 값을 전달받아 50을 더해서 출력합니다.
 [실행 화면]
- http://localhost:9090/test/el/exam1.jsp?su1=100&su2=200&su3=300 
 
  스크립틀릿 출력
  수1: 150    ← 100 + 50
  수2: 250    ← 200 + 50
  수3: 350    ← 300 + 50
 
  EL 출력
  수1: 150    ← 100 + 50
  수2: 250    ← 200 + 50
  수3: 350    ← 300 + 50
 
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
int su1 = Integer.parseInt(request.getParameter("su1"));
int su2 = Integer.parseInt(request.getParameter("su2"));
int su3 = Integer.parseInt(request.getParameter("su3"));
%>
 스크립틀릿 출력<br>
 수1: <%= su1 + 50 %><br>
 수2: <%= su2 + 50 %><br>
 수3: <%= su3 + 50 %><br>
 <br> 
 EL 출력<br>
 수1: ${param.su1 +50 }<br>
 수2: ${param.su2 + 50 }<br>
 수3: ${param.su3 + 50 }<br>
</DIV> <!-- content END -->
</DIV> <!-- container END -->
</body>
</html>
     