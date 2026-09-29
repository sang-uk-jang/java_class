package week05.sanguk.example;

public class Vehicle {
    public String color;
    public int speed;
    public int totalDistance;
    public char gear;
    public TV tv;

    public Vehicle() {
        this("red", 1, 0, 'P');
    }

    public Vehicle(String color, int totalDistance) {
        this(color, 1, totalDistance, 'P');
    }

    public Vehicle(String color, int speed, int totalDistance, char gear) {
        this(color,speed,totalDistance,gear,null);
    }

    public Vehicle(String color, int speed, int totalDistance, char gear, TV tv) {
        this.color = color;
        this.speed = speed;
        this.totalDistance = totalDistance;
        this.gear = gear;
        this.tv = tv;
    }

    public Vehicle(Vehicle car) {
        this(car.color, car.speed, car.totalDistance, car.gear, new TV(car.tv));//얕은복사
    }

    public void accelerate(int speed){
        if((this.gear!='P')&&(this.gear!='N')){
            this.speed+=speed;
            this.totalDistance+=speed;
        }else {
            System.out.println("현재 기어상태는 "+this.gear+" 상태입니다");
        }
    }
    public void brake(int speed){
        if((this.gear!='P')&&(this.gear!='N')){
            this.speed-=speed;
            this.totalDistance+=speed;
        }else {
            System.out.println("현재 기어상태는 "+this.gear+" 상태입니다");
        }
    }
    public void changeGear(char gear){
        this.gear = gear;
        this.speed = switch (this.gear){
            case 'P', 'N' ->0;
            case '1'->20;
            case '2' -> 30;
            default -> this.speed;
        };
    }
    public void showStatus(){
        System.out.println("차량색상 : " + this.color);
        System.out.println("차량속도 : " + this.speed);
        System.out.println("주행거리 : " + this.totalDistance);
        System.out.println("기어상태 : " + this.gear);
        System.out.println("-".repeat(20));
        String status = switch (this.gear){
            case 'P' -> "주차중";
            case 'N' -> "중립모드";
            case 'D' -> "주행중";
            case '1' -> "1단 저속 운행중";
            case '2' -> "2단 저속 운행중";
            default -> "기어상태 확인요함";
         };
        System.out.println(status);
        if(tv!=null){
            tv.showTV();
        }
        System.out.println("-".repeat(20));
    }
}
