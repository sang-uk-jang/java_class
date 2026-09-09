package week02.lab;

public class TestMain {
    static final int COFFEE = 100;//그냥 final로 사용하면 객체가 없기 떄문에 사용을 할 수 없다.
    static final int MILK = 50;//즉, static를 사용해야 main에서 사용을 할 수 있다.
    static final int WATER = 10;

    static int getCost(int price, int count){
        return price * count;
    }//static를 붙이지 않으면 객체를 만들지 않아 사용이 불가하다

    static void main() {
        int coffeeOrder = 5;
        int milkOrder = 2;
        int waterOrder = 1;

        TestMain greenjoa = new TestMain();

        int coffeeCost = getCost(COFFEE,coffeeOrder);
        int milkCost = getCost(MILK , milkOrder);
        int waterCost = getCost(WATER , waterOrder);

        int totalCost = coffeeCost + milkCost + waterCost;

        System.out.println("202211359 장상욱");
        System.out.println("**** 주문 내역 ****");
        System.out.println("커피  : " + coffeeOrder + "잔 " + coffeeCost + "원");
        System.out.println("우유  : " + milkOrder + "잔 " + milkCost + "원");
        System.out.println("물  : " + waterOrder + "잔 " + waterCost + "원");
        System.out.println("*".repeat(20));
        System.out.println("총 주문 금액 : " + totalCost+"원");
    }
}
