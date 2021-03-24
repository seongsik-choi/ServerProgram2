<%-- 
0324
 -> CalcVO.java의 Getter와 Setter를 통한 값 전달
 CalcCont2.java의 View 부분
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>calc_vo.jsp</title>
<style type="text/css">
  *{ font-family: Malgun Gothic; font-size: 30px;}
</style>
</head>
<body>
<DIV class='container_main'>
<DIV class='content'>
 <H1>EL calc_vo.jsp</H1>
  ${calcVO.msg } 계산기 <br>        <!-- setAttritube(addObject) -->
  수1: ${calcVO.no1 }<br>           <!--  getParameter : url로 입력 ?no1=100&no2=50-->
  수2: ${calcVO.no2 }<br>
  결과: ${calcVO.result }<br><br> <!-- requestScope.result == result  -->
</DIV> <!-- content END -->
</DIV> <!-- container END -->
</body>
</html>