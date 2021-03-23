/*
0323  ▷ /sts_basic/src/main/java/sts.basic.test.NullTest.java
[과제 1] "java.lang.NullPointerException"이 발생하는 코드를 완성
 1) 정수를/null로 나누 경우
 2) 문자열형의 길이를 출력 한 경우
 */
package sts.basic.test;
public class NullTest {
  public static void main(String[] args) {
     
    Integer inte = null;    
    System.out.println(2/inte);  // null로 나눈 경우(NullPointerException)
    // Exception in thread "main" java.lang.NullPointerException

    String str = null;                  
    System.out.println(str.length()); // 문자열형의 Str의 length()를 출력한경우.
    // NullPointerException
  }
}