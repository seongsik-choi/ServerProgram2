<%-- 
0323
[09] EL(표현 언어, Expression Language)       
 [01] EL(표현 언어, Expression Language)

▶ JSP의 단점 : Scriptlet의 사용 
     -> 보안문제(웹 상 JAVA Code  노출) : ex) JAVA코드 오류시 코드노출 + 주석노출

  - EL은 JSP 객체의 출력을 단순화하는 용도에 사용
  - JSP 스크립틀릿(<%%>)보다 사용법이 간단
  - 값이 없는 경우 "null"값을 출력하지 않습니다. 자동으로 null 체크
  - EL은 JSP 내부 객체(request, response, session...)에 접근하여 출력을 단순화
  - 기본적으로 자바의 문법이 적용.    
  - 표현 방법: ${expr}
  - EL은 3항 연사자외에 제어문을 사용할 수 없어 JSTL을 같이 이용
 
 1. 표현 언어의 연산자   
 
   1) 연산자  
-------------------------------------------------------------------------------------
        .                  빈의 프로퍼티나 맵(Map)의 엔트리 접근 
        []                  배열이나 리스트(List) 엘리먼트 접근 
        ()                  괄호, 표현식의 연산 순서를 바꿔서 연산하게 할 때 
        a?b:c             조건 테스트 - 조건(a)? true일때 리턴 값(b),false일때 리턴값(c) 
        + , -, *           사칙 연산 :  더하기, 배기, 곱하기  
        / 또는 div       나누기 
        % 또는 Mod   나머지 
        == 또는 =      같다. =은 권장 아님 
        !=                 다르다  
        < 또는 lt         보다 작다 
        > 또는 gt        보다 크다 
        <= 또는 le       작거나 같다 
        >= 또는 ge      크거나 같다. 
        && 또는 and    논리 AND 
        || 또는 or          논리 OR 
        ! 또는 not         단항 not(true를 false로 false를 true로) 
        empty            빈 변수 값 체크, null, 빈 문자열,  
                             빈 배열등 인지를 테스트  
        func(args)      함수 호출, func 함수 이름이고 args는 인자로 없을 
                             수도 있고, 한 개 혹은 쉼표(,)로 분리된 여러 개의 
                             함수 인자를 가질수 있음 
-------------------------------------------------------------------------------------
 2) 삼항연산자 : 조건 ? 참 : 거짓
    ${colors == null ? "transparent" : colors} 
    ,
    ${status == 'A001' ? "checked='ckecked'" : "" } 
    ,
    ${msg1 != null ? img : "" } ${msg1}

   - SELECT 태그
     <select name='visible'>
       <option value='Y' ${categrpVO.visible == 'Y' ? "selected='selected'" : "" }>Y</option>
       <option value='N' ${categrpVO.visible == 'N' ? "selected='selected'" : "" }>N</option>
     </select>

 3) 그 외 예약어 : true, false, null, instanceof, empty( null이거나 공백일때 ) 
-------------------------------------------------------------------------------------  
  
 2. JSP 내부 객체(request, response, session, application등)에 
   접근하기위해 EL에서 제공하는 객체 
   - pageContext    : PageContext 객체 
   - pageScope       : page 영역에 포함된 객체 
   - requestScope    : request 영역에 포함된 객체 
   - sessionScope    : session 영역에 포함된 객체 
   - applicationScope : application 영역에 포함된 객체 
   - param          : HTTP의 파라미터들 
   - paramValues     : 하나의 파라미터의 값들 
   - header          : 헤더 정보들 
   - headerValues    : 하나의 헤더의 값들 
   - cookie              : 쿠키들 
   - initParam          :컨텐츠의 초기화 파라미터들 
 
 3. EL 객체의 사용예 
   1) ${pageContext.request.requestURI}: request URI 
   2) ${sessionScope.profile}                : session 영역에서 profile이라는 이름으로 
                                                     저장된 객체 
   3) ${param.productId}                      : productId라는 이름의 파라미터 값 
   4) ${paramValues.productId}             : productId라는 이름의 파라미터 값들 
   5) ${pageContext.request.contextPath}: Context Path 추출(request.getContextPath()과 동일)  
 
 
 4. request 접근 :  - http://localhost:9090/test/el/request.jsp

 [Code]
 ▶ Context Path: <%=request.getContextPath() %>
 ▶ 1. Scriptlet: <%= request.getAttribute("name") %><br>  <!--저장된 데이터의 회수   -->
 ▶ 2. EL(requestScope): ${requestScope.name }<br>   <!-- JSP를 EL로 대체 -->
 ▶ 3. EL: ${name }  <!--가장 좋은 EL 선언 -->
 
 [실행 화면]
 ContextPath: /test       -> 패키지명(Legacy는 a.a.test 3번째 프로젝트명 사용)
 1. 스크립틀릿: Spring 개발자
 2. EL(requestScope): Spring 개발자
 3. EL: Spring 개발자
 
 -> JSP의 치명적인 단점(EL은 그렇지 않음)
  request.setAttribute("namex", "Spring 개발자"); // 데이터를 저장(key 값, 저장된 데이터)
 -> 없는 key값 출력 시 1. Scriptlet: <%= request.getAttribute("name") %>  
 -> 1. Scriptlet: null  // null 값도 데이터로 인식 될수도
 
 A) JSP 사용시 if문을 사용해 null이 아닐때의 값을 출력하게 해줘야
 <% 
 if(request.getAttribute("name") != null) {
  out.print(request.getAttribute("name"));
  }
 %>
 
 ▷ /sts_basic/src/main/webapp/el/request.jsp 
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
 
<!DOCTYPE html> 
<html lang="ko"> 
<head> 
<meta charset="UTF-8"> 
<title>EL</title> 
<style type="text/css">
  *{ font-family: Malgun Gothic; font-size: 30px;}
</style>
</head> 
<body>
 
<DIV class='content'>
  Context Path: <%=request.getContextPath() %>
  <br><br>
<%
 request.setAttribute("name", "Spring 개발자"); // 데이터를 저장(key 값, 저장된 데이터)
%>
 1. Scriptlet: 
 <%
 if(request.getAttribute("name") != null) {
  out.print(request.getAttribute("name"));
  }
 %> <br>  
 2. EL(requestScope): ${requestScope.name }<br>   <!-- JSP를 EL로 대체 -->
 3. EL: ${name } <!--가장 좋은 EL 선언 -->
</DIV>
 
</body>
 
</html> 