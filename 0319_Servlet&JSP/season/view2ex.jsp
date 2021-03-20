<%-- 
0319
 - Controller2ex의 JSP view 부분
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
 <% 
// getAttribute를 String으로 형변환 필요
String title = (String)request.getAttribute("title");
String fname = (String)request.getAttribute("fname");
 %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>view2ex.jsp</title>
<style type="text/css">
  *{ font-family: Malgun Gothic; font-size: 26px;}
  .img_style{
    width: 80%;
  }
</style>
</head>
<body>
 <!-- 경로는 모두 절대 경로 지정 -->
<DIV style='text-align: center;'>
  <H1>좋아하는 음식 사진 출력</H1>
  <A href='/mvc/controller2ex/food1.do2ex'>치킨</A> | 
  <A href='/mvc/controller2ex/food2.do2ex'>피자</A> |
  <A href='/mvc/controller2ex/food3.do2ex'>족발</A> |
  <A href='/mvc/controller2ex/food4.do2ex'>햄버거</A>
  <br>
  <H2><%=title %></H2> 
  <IMG class='img_style' src='/mvc/season/images/<%=fname %>'>
</DIV>
</body>
</html>