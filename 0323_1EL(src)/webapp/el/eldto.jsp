<%-- 
0323
 6. 객체의 접근  ▷ src/main/java/sts.basic.test.ELDTO.java 
  - ${} EL 선언은 기본적으로 request 객체에 접근해서 데이터를 찾으며,
    없으면 session에 접근하여 데이터를 찾아옴.

 [실행 화면]
 -> Scriptlet
 getMovie() 호출됨
 getName() 호출됨
 
 -> EL
 getMovie() 호출됨
 getName() 호출됨
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="sts.basic.test.ELDTO" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>eldto.jsp</title>
<style type="text/css">
  *{ font-family: Malgun Gothic; font-size: 30px;}
</style>
</head>
<body>

<DIV class='container'>
<DIV class='content'>
  
  스크립틀릿 출력<br>
  <%
  ELDTO dto = new ELDTO();                                      // import한 ELDTO class 사용해 객체 생성
  request.setAttribute("dto", dto);                               // 데이터를 저장(key 값, 저장된 데이터)
  ELDTO eldto = (ELDTO)request.getAttribute("dto");     // 데이터 가져오기 Type 매칭
  %>

  <% System.out.println("--> Scriptlet"); %>
  영화명: <%=eldto.getMovie() %><br>
  주   연: <%=eldto.getName() %><br> 
  <br>
  <% System.out.println("--> EL"); %>
  EL 출력<BR>
  영화명: ${dto.movie }<br>
  주   연: ${dto.name }<br> 
  
</DIV> <!-- content END -->
</DIV> <!-- container END -->
</body>
</html>