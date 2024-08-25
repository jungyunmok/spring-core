package hello.core.singleton;

public class StatefulService {

//    private int price; // 상태를 유지하는 필드

    // 해결법 중 하나 - price를 반환해서 지역변수로 사용하는 것
    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        return price;
//        this.price = price; // 여기가 문제!
    }

    /*public int getPrice() {
        return price;
    }*/
}
