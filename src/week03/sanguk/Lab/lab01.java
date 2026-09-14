package week03.sanguk.Lab;

import java.util.Scanner;

public class lab01 {
    static void main() {
        System.out.println("202211359 장상욱");
        Scanner scanner = new Scanner(System.in);
        System.out.print("무슨 커피 드릴까요 ? : ");
        String menu = scanner.next();
        int price = switch (menu) {
            case "아메리카노","에스프레소" -> 2500;
            case "카푸치노", "카페라떼" -> 3500;
            default -> 1;
        };
        if(price!=1){
            System.out.println(menu + "는 " + price + "원 입니다");
        }
        else System.out.println("판매하는 제품이 아닙니다.");
    }
}
