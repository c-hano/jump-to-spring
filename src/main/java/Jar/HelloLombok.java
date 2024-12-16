package Jar;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//Lombok은 getter, setter값을 편하게 사용가능하게 만들어준다.
public class HelloLombok {
    private String hello;
    private int lombok;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setHello("hello");
        helloLombok.setLombok(5);
        //인스턴스 이름에 따라 자동으로 set과 get이름이 정해지는 듯?

        System.out.println(helloLombok.getHello());
        System.out.println(helloLombok.getLombok());
    }
}
