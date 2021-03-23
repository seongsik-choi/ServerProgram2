<%-- 
0323
 5. GET 방식 파라미터의 접근
   - http://localhost:9090/test/el/param.jsp?money=100000&month=24
 ▶ url에 데이터 전달 : GET 방식
 
 [실행 화면]
 스크립틀릿 출력
 월 입금액: 100000 원
 입금 기간: 24 개월
 수령 금액: 2400000 원

 EL을 사용하면 requetgetParameter 필요 no
 월 입금액: ${param.money} 원
 입금 기간: ${param.month} 개월
 수령 금액: ${param.money * param.month}

 EL 출력
 월 입금액: 원
 월 입금액: 100000 원
 입금 기간: 24 개월
 수령 금액: 2400000 원
--%>
<%@page import="java.text.DecimalFormat"%>
<%@ page contentType="text/html; charset=UTF-8" %> 
<!DOCTYPE html> 
<html lang="ko"> 
<head> 
<meta charset="UTF-8"> 
<title></title> 
<style type="text/css">
  *{ font-family: Malgun Gothic; font-size: 30px;}
</style>
</head> 
 
<body>
스크립틀릿 출력<br>
<%
// Get 방식의 Static method 사용
int money = Integer.parseInt(request.getParameter("money"));
int month = Integer.parseInt(request.getParameter("month"));
DecimalFormat df = new DecimalFormat("￦#,###,###원");  // 월 입금액, 수령금액 대한 DecimalFormat
%>
월 입금액: <%=df.format(money) %> 원<br>
입금 기간: <%=month %> 개월<br>
수령 금액: <%=df.format(money*month) %><br><br>
 
<hr>
EL 출력<br>
월 입금액: ${param.money} 원<br>
입금 기간: ${param.month} 개월<br>
수령 금액: ${param.money * param.month}<br><br>

</body>
</html> 