/*
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
 */
package sts.basic.test;
 
public class ELDTO {
  private String movie;
  private String name;
  
  // 기본 생성자
  public ELDTO(){
    this.movie = "암살";
    this.name = "전지현";
  }
  
  public ELDTO(String movie, String name){
    this.movie = movie;
    this.name = name;
  }
 
  public String getMovie() {
    System.out.println("getMovie() 호출됨");
    return movie;
  }
 
  public void setMovie(String movie) {
    this.movie = movie;
  }
  
  public String getName() {
    System.out.println("getName() 호출됨");
    
    return name;
  }
 
  public void setName(String name) {
    this.name = name;
  }
 
} 