<%-- 
0324
 -> proc(POST 방식의 처리 페이지)
 2) 결과
 [실행 화면]
  수1: 1
  수2: 10
  합계: 55
 ▷ /src/main/webapp/WEB-INF/views/calc/tot_proc.jsp 
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
 
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>tot_proc.jsp</title>
<link href="/calc/resources/css/style.css" rel="Stylesheet" type="text/css">
</head>
<body>
<DIV class='container_main'>
<DIV class='content'>
  <DIV class='panel'>
  <H1>${calcVO.msg } 계산기</H1>
    수1: ${calcVO.no1 } <br>
    수2: ${calcVO.no2 } <br>
    결과: ${calcVO.result } <br>
  </DIV>

</DIV> <!-- content END -->
</DIV> <!-- container END -->
</body>
</html>