<%-- 
0319_
 Q) Controller2의 JSP view 부분
 2. View: JSP 
   - Model, View의 역활을 전부하는 콘트롤러
   - '/WebContent/season/images' 폴더에 이미지 4장을 저장
   
   Q) view.jsp에서 링크 클릭시 주소 해당 주소로 변경
   <A href='/mvc/controller2/spring.do2'>Spring</A> 
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
 <% 
//Object season = "봄";
String title = (String)request.getAttribute("title");
String fname = (String)request.getAttribute("fname");
 %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>view.jsp</title>
<style type="text/css">
  *{ font-family: Malgun Gothic; font-size: 26px;}
</style>
</head>
<body>
 <!-- 경로는 모두 절대 경로 지정 -->
<DIV style='text-align: center;'>
  <H1>Controller 2</H1>
  <A href='/mvc/controller2/spring.do2'>Spring</A> | 
  <A href='/mvc/controller2/summer.do2'>Summer</A> |
  <A href='/mvc/controller2/fall.do2'>Fall</A> |
  <A href='/mvc/controller2/winter.do2'>Winter</A>
  <br>
  <H2><%=title %></H2> 
  <IMG src='/mvc/season/images/<%=fname %>' style="width: 90%;">
</DIV>
</body>
</html>