package week05.sanguk.example;


public class TestMain {
    static void example01(){
        Vehicle car1 = new Vehicle("빨간색", 0, 10000, 'P', new TV(true, 8));
//        Vehicle car2 = new Vehicle("검은색", 10000);
//        Vehicle car3 = new Vehicle();
        //생성자가 3가지
        System.out.println("-----car1-----");
        car1.showStatus();
        car1.changeGear('D');
        car1.accelerate(30);
        car1.accelerate(60);
        car1.brake(20);
        car1.showStatus();
        System.out.println("-----car2-----");
        Vehicle car2 = new Vehicle(car1);
        car2.tv.powerOnOff();
        car2.showStatus();
        System.out.println("-----car1-----");
        car1.showStatus();
        System.out.println("car1 : "+car1.tv);
        System.out.println("car2 : "+car2.tv);

    }

    static void example02(){
        BankAccount acc1 = new BankAccount(100,"홍길동", 1000);
        System.out.println("main : "+acc1);
        acc1.deposit(100);
        acc1.withdraw(200);
        acc1.withdraw(2000);
        acc1.showAccount();

        BankAccount acc2 = new BankAccount(101, "이길동");
        acc1.transfer(acc2, 1000);
        acc1.transfer(acc2, 500);
        acc2.showAccount();
        acc1.showAccount();



    }
    static void example03(){
        BankAccount2 acc1 = new BankAccount2("홍길동", 1000);
        System.out.println("main : "+acc1);
        acc1.deposit(100);
        acc1.withdraw(200);
        acc1.withdraw(2000);
        acc1.showAccount();

        BankAccount2 acc2 = new BankAccount2("이길동");
        acc1.transfer(acc2, 1000);
        acc1.transfer(acc2, 500);
        acc2.showAccount();
        acc1.showAccount();
        System.out.println("acc1 : "+acc1.count);
        System.out.println("acc2 : "+acc2.count);
        System.out.println("Static : "+BankAccount2.count);//static 멤버라서 공유를 하고 있다.
    }

    static void main() {
        BankManager manager = new BankManager("건국은행", 10);
        manager.createAccount();
        manager.createAccount();
//        manager.deposit();
//        manager.deposit();
//        manager.withdraw();
//        manager.withdraw();
        manager.transfer();
        System.out.println(manager);

//        BankAccount2 acc1 = new BankAccount2("홍길동", 1000);
//        System.out.println(acc1);
//        example01();
        //example02();
        //example03();
//        TV tv = new TV(false, 10);
//        System.out.println("202211359 장상욱");
//        tv.powerOnOff();
//        tv.channelUp();
//        tv.channelUp();
//        tv.channelUp();
//        tv.channelUp();
//        tv.channelUp();
//        tv.channelUp();
//        tv.channelDown();
//        tv.channelDown();
    }
}
