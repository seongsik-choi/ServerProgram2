<%-- 
0323
[과제 3] GET 방식을 사용하지말고 3개의 정수를 request 객체에 저장한 후 추출하여 합과 평균을 출력하는 프로그램을 작성
 -> EL의 특징 : 나눴을때 소수점을 자르지않고 남김
 [Code]
  request.setAttribute("no1", 150);
  int no1 = (Integer)request.getAttribute("no1"); // 형변환 필요, 원래 Object 타입이기에
 
 [실행 화면]
  스크립틀릿
  수1: 100
  수2: 130
  수3: 150
  총점: 380
  평균: 126
 
 EL 
  수1: 100
  수2: 130
  수3: 150
  총점: 380
  평균: 126.66666666666667
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
  request.setAttribute("no1", 100);
  request.setAttribute("no2", 130);
  request.setAttribute("no3", 150);
  %>
  
  스크립틀릿<br>
  <%
  int no1 = (Integer)request.getAttribute("no1");
  int no2 = (Integer)request.getAttribute("no2");
  int no3 = (Integer)request.getAttribute("no3");
  int tot = no1+no2+no3;
  double avg = (double)tot/3;
  %>
  수1: <%=no1 %><br>
  수2: <%=no2 %><br>
  수3: <%=no3 %><br>
  총점: <%=tot %><br>
  평균: <%=avg %><br>
  <br>
  EL<br>
  수1:    ${no1 }   <br>
  수2:    ${no2 }   <br>
  수3:    ${no3 }   <br>
  총점:   ${no1+no2+no3 }   <br>
  평균:   ${(no1+no2+no3)/3 }   <br>
  
</DIV> <!-- content END -->
</DIV> <!-- container END -->
</body>
</html>