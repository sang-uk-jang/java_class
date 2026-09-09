package week02.example01;

import java.io.IOException;
import java.util.Scanner;
//예외처리를 하지 않으면 read가 컴파일이 아예되지 않는다.
//java.lang => 자바에 무조건 필요하기 때문에, import를 하지 않아도 쓸 수 있는것이다.

public class TestMain {
    static void example01(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("학번 : ");
        String sid = scanner.next();
        System.out.print("이름 : ");
        scanner.nextLine();//줄바꿈 찾아서 초기화
        String name = scanner.nextLine();
        System.out.print("나이 : ");
        int sold = scanner.nextInt();
        System.out.print("주소 : ");
        scanner.nextLine();
        String saddress = scanner.nextLine();

        System.out.println("학번 : "+sid);
        System.out.println("이름 : "+name);
        System.out.println("나이 : "+sold);
        System.out.println("주소 : "+saddress);
    }
    static void main() throws IOException {
        example01();

//        int code;
//        while((code = System.in.read()) != -1){
//            System.out.println("코드 : " + code + "-->" + (char)code);
//        }
//        code = System.in.read();
//        System.out.println("코드 : " + code + "-->" + (char)code);
//        code = System.in.read();
//        System.out.println("코드 : " + code + "-->" + (char)code);
        }
}
