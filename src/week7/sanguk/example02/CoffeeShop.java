package week7.sanguk.example02;

public class CoffeeShop {

    private Coffee americano = new Coffee("아메리카노", 2000);
    private Coffee latte = new Coffee("카페라떼", 3000);
    private Coffee mocha = new Coffee("카페모카", 4000);

    interface Payment{
        void processPayment(double amount);
    }

    static class CashPayment implements Payment{

        @Override
        public void processPayment(double amount) {
            System.out.println("현금 결재로 "+amount+"원 결재완료");
        }
    }

    static class CardPayment implements Payment{

        @Override
        public void processPayment(double amount) {
            System.out.println("카드 결재로 "+amount+"원 결재완료");
        }
    }

    static class KakaoPayment implements Payment{

        @Override
        public void processPayment(double amount) {
            System.out.println("카카오페이 결재로 "+amount+"원 결재완료");
        }
    }



    private static class Coffee {
        String name;
        int brewTime;

        public Coffee(String name, int brewTime) {//클래스 내부에서만 사용하는 클래스(중첩클래스)
            this.name = name;
            this.brewTime = brewTime;
        }

        public void brew() {
            //로컬클래스 익명 클래스에서 외부의 변수를 복사해서 사용을 하는데, 라이프사이클이 달라서 final로 복사를 해서 사용을 한다 => 로컬 클래스나 익명 클래스에서는 외부의 변수를 바꿀 수 없다.
            Thread thread = new Thread() {//익명 객체
                @Override
                public void run() {
                    System.out.println(name + " 제조 시작");
                    try {
                        Thread.sleep(brewTime);
                        System.out.println(name + " 제조 완료");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            };
            thread.start();
        }


//            class CoffeeThread extends Thread{//매소드 내부에서만 사용하는 로컬클래스
//                @Override
//                public void run() {
//                    System.out.println(name + " 제조 시작");
//                    try {
//                        Thread.sleep(brewTime);
//                        System.out.println(name + " 제조 완료");
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//            }
//            CoffeeThread coffeeThread = new CoffeeThread();
//            coffeeThread.start();//run이라는 함수 실행 됨
//        }
    }

    public void orderCoffee(String name, double amount, Payment payment){
        payment.processPayment(amount);
        switch (name){
            case "아메리카노" -> americano.brew();
            case "카페라떼" -> latte.brew();
            case "카페모카" -> mocha.brew();
            default -> System.out.println("메뉴 확인 요망");
        }
    }

    static void main() {
        CoffeeShop coffeeShop = new CoffeeShop();
        coffeeShop.orderCoffee("아메리카노", 100, new CashPayment());
        coffeeShop.orderCoffee("카페모카", 250, new CardPayment());
        coffeeShop.orderCoffee("카페라떼", 200, new CashPayment());
        coffeeShop.orderCoffee("카페라떼", 200, new KakaoPayment());
        coffeeShop.orderCoffee("카페라떼", 200, new Payment() {//익명 인터페이스
            @Override
            public void processPayment(double amount) {
                System.out.println("계좌이체로 "+amount+"원 결재완료");
            }
        });
    }
}

