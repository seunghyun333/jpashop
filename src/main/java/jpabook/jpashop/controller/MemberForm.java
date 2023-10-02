package jpabook.jpashop.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberForm {

  @NotEmptiy(message = " 회원이름은 필수 없니다.")
  private  String name;
  private String street;
  private String zipcode;

}
