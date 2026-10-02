package HW.sanguk;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 이 클래스는 car클래스를 관리하기 위한 클래스입니다.
 * @author sanguk jang
 * @version 1.0
 * @since 2026-10-02
 */
public class ParkingArea {
    public Car[][] parkArea;
    public int Row;
    public int Col;
    public Scanner scanner;
    public PriorityQueue<AbstractCar> queue = new PriorityQueue<>(
            new Comparator<AbstractCar>() {
                @Override
                public int compare(AbstractCar o1, AbstractCar o2) {
                    return Integer.compare(o1.weight, o2.weight);
                }
            }
    );
    /**
     * parkingArea 클래스의 생성자입니다,
     * 내부에서는 parkArea의 객체 배열을 초기화하고 주차추천 기능에 사용될 priority queue의 초기화를 담당하고 있습니다.
     * @param textFile 주차장 정보를 담고 있는 text file
     */
    public ParkingArea(String textFile){
        File file = new File(textFile);
        try {
            scanner = new Scanner(file);
            Row = scanner.nextInt();
            Col = scanner.nextInt();
            parkArea = new Car[Row][Col];
            while(scanner.hasNext()){
                int carRow = scanner.nextInt();
                int carCol = scanner.nextInt();
                parkArea[carRow][carCol] = new Car(scanner.next(), scanner.next(), scanner.next());
            }
            for(int i=0;i<Row;i++){
                for(int j=0;j<Col;j++){
                    if(parkArea[i][j]==null){
                        queue.add(new AbstractCar(i,j));
                    }
                }
            }//빈 주차공간 queue에 넣기
        }catch (FileNotFoundException e){
            System.out.println("파일을 찾을 수 없습니다, 경로를 다시 확인해주세요");
        }
    }
    /**
     * parkingArea 클래스의 주차장을 시각적으로 보여주는 매소드입니다.
     * 내부에서는 parkArea의 객체 배열을 보고 시각적으로 주차장을 보여줍니다.
     */
    public void showArea(){
        System.out.println("-".repeat(20));
        for(int i=0;i<Row;i++){
            System.out.print((i+1)+"층\t");
            for(int j=0;j<Col;j++){
                if(parkArea[i][j]!=null){
                    System.out.print("■\t");
                }else {
                    System.out.print("□\t");
                }
            }
            System.out.println();
        }
        System.out.println("-".repeat(20));
    }
    /**
     * parkingArea 클래스의 주차 매소드입니다.
     * 내부에서는 parkArea의 객체 배열을 보고 주차장이 먼저 가득 차 있지 않은지 확인합니다,
     * 이후 가득 찼으면 출차를 먼저 하라는 문구를 출력하고 매소드를 종료합니다.
     * queue을 사용해서 추천 주차 공간을 보여주고 주차 공간을 입력 받습니다.
     * 올바른 주차공간이 입력되면 이미 주차 돼 있는 공간은 아닌지 확인하고 아닐시 parkArea와 quqeue를 업데이트 합니다.
     */
    public void parkCar(){
        int fullFlag = 1;
        scanner = new Scanner(System.in);
        System.out.println("------차량 주차------");
        for(int i=0;i<Row;i++){
            for(int j=0;j<Col;j++){
                if(parkArea[i][j]==null){
                    fullFlag = 0;
                }
            }
        }
        if(fullFlag==1){
            System.out.println("주차 공간이 꽉 찼습니다, 출차 먼저 해주세요.");
            return;
        }
        AbstractCar choiceCarArea = queue.peek();
        if(choiceCarArea != null){
            System.out.println("추천 주차 공간 : " + (choiceCarArea.abstractRow + 1) + "층 "
                    + (choiceCarArea.abstractCol+1));
        }else{
            System.out.println("시스템 문제가 발생했습니다, 시스템을 종료합니다");
            return;
        }
        System.out.println("차량 주차 공간을 선택해주세요");
        System.out.println("현재 주차장의 크기는 "+ Row +"," + Col + "입니다");
        System.out.print("주차하고 싶은 층 : ");
        int parkCarRow;
        if(scanner.hasNextInt()){
            parkCarRow = scanner.nextInt();
        }
        else{
            System.out.println("잘못된 입력입니다.");
            return;
        }
        if(parkCarRow>Row || parkCarRow<=0){
            System.out.println("주차장의 크기에 맞지 않습니다.");
            return;
        }
        System.out.print("주차하고 싶은 공간 : ");
        int parkCarCol = scanner.nextInt();
        if(parkCarCol>Col || parkCarCol<=0){
            System.out.println("주차장의 크기에 맞지 않습니다.");
            return;
        }
        if(parkArea[parkCarRow-1][parkCarCol-1]!=null){
            System.out.println("차량이 이미 있어 주차가 불가능합니다");
        }else {
            System.out.print("차량 번호를 입력해주세요 : ");
            String carNumber = scanner.next();
            System.out.print("차량 모델을 입력해주세요 : ");
            String carModel = scanner.next();
            System.out.print("차량 소유주 전화번호를 입력해주세요 : ");
            String carOwner = scanner.next();
            Car parkCar = new Car(carNumber, carModel, carOwner);
            parkArea[parkCarRow-1][parkCarCol-1] = parkCar;
            boolean d = queue.removeIf(AbstractCar -> AbstractCar.abstractRow == parkCarRow-1
                    && AbstractCar.abstractCol ==parkCarCol-1 && AbstractCar.weight == (parkCarRow + parkCarCol)-2 );
            System.out.println("차량주차가 완료되었습니다");
        }
    }
    /**
     * parkingArea 클래스의 출차 매소드입니다.
     * 내부에서는 출차할 차량 번호를 입력받고
     * 올바른 번호가 입력되면 객체 배열과 queue를 업데이트 합니다.
     */
    public void outCar(){
        int find=0;
        System.out.println("------차량 출차------");
        scanner = new Scanner(System.in);
        System.out.print("출차 차량 번호를 입력하세요 : ");
        String outCarNumber = scanner.next();
        for(int i=0;i<Row;i++){
            for(int j=0;j<Col;j++){
                if(parkArea[i][j]!=null && parkArea[i][j].carNumber.equals(outCarNumber)){
                    //자바에서 == 를 쓰면 같은 객체를 가리키는지 비교를 한다
                    //그래서 문자열 비교를 하려면 equal를 써야함
                    find=1;
                    parkArea[i][j]=null;
                    System.out.println(queue);
                    queue.add(new AbstractCar(i, j));
                    System.out.println(queue);
                    System.out.println(outCarNumber + " 차량이 출차하였습니다");
                }
            }
        }
        if(find == 0){
            System.out.println("차량 번호를 확인해주세요");
        }
    }

    /**
     * parkingArea 클래스의 차를 찾는 매소드입니다.
     * 내부에서는 차량 번호 또는 소유자 전화번호를 입력받고,
     * 객체 배열을 순회하면서 동일한 객체를 찾고 표시를 해줍니다.
     */
    public void findCar(){
        int find = 0;
        System.out.println("------차량 검색------");
        scanner = new Scanner(System.in);
        System.out.print("찾을 차량 번호 또는 소유자 전화번호를 입력하세요 : ");
        String userInput = scanner.next();
        for(int i=0;i<Row;i++){
            System.out.print((i+1)+"층\t");
            for(int j=0;j<Col;j++){
                if(parkArea[i][j]!=null){
                    if(parkArea[i][j].carNumber.equals(userInput) || parkArea[i][j].carOwner.equals(userInput)){
                        find = 1;
                        System.out.print("★\t");
                    }else{
                        System.out.print("■\t");
                    }
                }else{
                    System.out.print("□\t");
                }
            }
            System.out.println();
        }
        if(find ==0){
            System.out.println("차량을 찾지 못했습니다.");
        }
    }
    /**
     * parkingArea 클래스의 주차돼 있는 차를 출력하는 매소드입니다.
     * 내부에서는 parkArea의 객체 배열을 보고 Car내부 toString을 통해 주차장 내부 차의 정보에 대해서 보여줍니다.
     */
    public void showAllCar(){
        for(int i=0;i<Row;i++){
            for(int j=0;j<Col;j++){
                if(this.parkArea[i][j]!=null){
                    System.out.println("--------------------");
                    System.out.println("위치 : "+(i+1)+"층 "+(j+1));
                    System.out.println(parkArea[i][j].toString());
                }
            }
        }
    }

    /**
     * parkingArea 클래스의 메뉴매소드입니다.
     * 내부에서는 메뉴를 보여주고 위의 함수를 실행합니다
     */
    public void memu(){
        while(true){
            showArea();
            scanner = new Scanner(System.in);
            System.out.println("1. 차량 주차\t2. 차량 출차\t3. 차량 검색\t4. 주차장 정보 출력\t5. 종료");
            System.out.print("입력 : ");
            int userInput;
            if(scanner.hasNextInt()){
                userInput = scanner.nextInt();
            }else {
                System.out.println("잘못된 입력입니다.");
                continue;
            }
            switch (userInput) {
                case 1 -> parkCar();
                case 2 -> outCar();
                case 3 -> findCar();
                case 4 -> showAllCar();
                case 5 -> {
                    System.out.println("시스템을 종료합니다.");
                    return;
                }
                default -> System.out.println("잘못된 입력입니다, 다시 입력해주세요.");
            }
        }
    }

    /**
     * parkingArea 클래스의 toString을 오버라이드 하는 매소드입니다.
     * 코딩을 하며 확인하는 용도로 사용하였습니다.
     */
    @Override
    public String toString() {
        String str ="";
        for(int i=0;i<Row;i++){
            for(int j=0;j<Col;j++){
                if(this.parkArea[i][j]!=null){
                    str+="--------------------\n";
                    str+="위치 : "+(i+1)+"층 "+(j+1)+"\n";
                    str+=parkArea[i][j].toString();
                }
            }
        }
        return str;
    }
}
