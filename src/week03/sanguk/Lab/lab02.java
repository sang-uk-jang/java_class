package week03.sanguk.Lab;

import java.util.Random;
import java.util.Scanner;

public class lab02 {
    static void main() {
        System.out.println("202211359 장상욱");
        Random r = new Random();
        Scanner scanner = new Scanner(System.in);
        int userWin=0;
        int comWin=0;
        while(true){
            int ramdomNum = r.nextInt(100)%3;
            String comString = switch (ramdomNum){
                case 0 -> "가위";
                case 1 -> "바위";
                case 2 -> "보";
                default -> "error";
            };
            if(comString =="error"){
                System.out.println();
                continue;
            }
            System.out.println("가위(0), 바위(1), 보(2)중에 하나를 입력하세요");
            System.out.println("3판 2선승제로 진행됩니다. 먼저 2승을 하는 사람이 승리합니다!");
            System.out.println();
            System.out.println("--- 현재 스코어 ---");
            System.out.println("사용자 : " + userWin + "승, 컴퓨터 : " + comWin + "승");
            System.out.print("입력 : ");
            int user = scanner.nextInt();
            String userString = switch (user) {
                case 0 -> "가위";
                case 1 -> "바위";
                case 2 -> "보";
                default -> "error";
            };
            if(userString =="error"){
                System.out.println("입력이 잘못 되었습니다.");
                System.out.println();
                continue;
            }
            System.out.println("사용자 : " + userString +", 컴퓨터 : "+comString);
            int judge = switch (ramdomNum-user){
                case -1, 2 -> 1;
                case 1, -2 -> -1;
                case 0 -> 0;
                default -> 5;
            };
            switch (judge){
                case 1 ->{
                    System.out.println("사용자가 이겼습니다!");
                    System.out.println();
                    userWin++;
                }
                case -1 -> {
                    System.out.println("컴퓨터가 이겼습니다");
                    System.out.println();
                    comWin++;
                }
                case 0 -> {
                    System.out.println("무승부입니다.");
                    System.out.println();
                }
                default -> {
                    System.out.println("입력이 잘못 되었습니다.");
                    System.out.println();
                }
            }
            if(userWin==3 || comWin ==3){
                break;
            }
        }
        System.out.println("---최종 결과---");
        if(userWin==3){
            System.out.println("사용자의 승리입니다.");
        }
        else{
            System.out.println("아쉽지만 최종 승리자는 컴퓨터입니다.");
        }
    }
}
