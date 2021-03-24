<%-- 
0324
 [02] Controller에서의 GET, POST 분리
 -> Form(Get 방식의 값 전달 받음)
▷ /src/main/webapp/WEB-INF/views/calc/tot_form.jsp 
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
 
<!DOCTYPE html> 
<html lang="ko"> 
<head> 
<meta charset="UTF-8"> 
<title>tot_form.jsp</title>
<link href="../css/style.css" rel="Stylesheet" type="text/css">  <!-- resources dic으 css폴더의 style 적용 -->
</head> 
<body>
<DIV class='container_main'>
<DIV class='content'>
  
  <div class='panel'>
    <H1>계산기</H1>
    <form name='frm' method='post' action="/calc/calc/add3.do">
      수1: <input type='number' name='no1' value='${no1 }' autofocus="autofocus"><br><br>
      수2: <input type='number' name='no2' value='${no2 }'><br><br>
      <button type='submit'>합계</button>
    </form>
  </div>
  
</DIV> <!-- content END -->
</DIV> <!-- container END -->  
</body>
 
</html>