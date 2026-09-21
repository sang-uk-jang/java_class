package week04.sanguk.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class example01 {
    static void example02(){
        String[] stdName = {"홍길동", "고길동", "김길동", "이길동"};
        int[][] scores  = {
                {10,20,30,0},
                {20,30,40,0},
                {10,25,30,0},
                {30,30,40,0}
        };
        getTotalScores(scores);
        printScores(stdName, scores);
    }

    static void printScores(String[] stdName, int[][] scores, double[] avgNum, int[] rank) {
        for(int i=0;i<stdName.length;i++){
            System.out.print(stdName[i]+" >> ");
            for(int j=0;j<scores[i].length;j++){
                if(j==scores[i].length-1){
                    System.out.print(": ");
                }
                System.out.print(scores[i][j]+" ");
            }
            System.out.print(" : " + avgNum[i] + " : " + rank[i]);
            System.out.println();
        }
    }

    static void printScores(String[] stdName, int[][] scores) {
        for(int i=0;i<stdName.length;i++){
            System.out.print(stdName[i]+" >> ");
            for(int j=0;j<scores[i].length;j++){
                if(j==scores[i].length-1){
                    System.out.print(": ");
                }
                System.out.print(scores[i][j]+" ");
            }
            System.out.println();
        }
    }

    static void getTotalScores(int[][] scores) {
//        for(int[] std:scores){
//            for(int i=0; i<std.length-1;i++){
//                std[std.length-1] += std[i];
//            }
//        }
        for(int i=0;i<scores.length;i++){
            for(int j=0;j<scores[i].length-1;j++){
                scores[i][scores[i].length-1] += scores[i][j];
            }
        }
    }

    static void example03() {
        String[] stdNames;
        int[][] scores;
        double[] avgNum;
        int[] rank;
        File file  = new File("res/scores.txt");
        try {
            Scanner scanner = new Scanner(file);
            final int ROW = scanner.nextInt();//4
            stdNames = new String[ROW];
            scores = new int[ROW][];

            int row =0;
            while(scanner.hasNext()){
                final int COL = scanner.nextInt();
                scores[row] = new int[COL+1];
                stdNames[row] = scanner.next();

                for(int i=0;i<COL;i++){
                    scores[row][i] = scanner.nextInt();
                }
                row++;
            }
            getTotalScores(scores);
            avgNum = getavg(scores);
            rank = getRank(avgNum);
            printScores(stdNames, scores, avgNum, rank);
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다.");
        }
    }

    private static int[] getRank(double[] avgNum) {
        int[] rank = new int[avgNum.length];
        for(int i=0;i<rank.length;i++){
            rank[i]=1;
            for(int j=0;j<rank.length;j++){
                if(avgNum[j]>avgNum[i]){
                    rank[i]++;
                }
            }
        }
        return rank;
    }

    static double[] getavg(int[][] scores) {
        double[] avgNum = new double[scores.length];
        for(int i=0;i< scores.length;i++){
            avgNum[i] = scores[i][scores[i].length-1]/(scores[i].length-1);
        }
        return avgNum;
    }




    static void main() {
        //example02();
        example03();
        //이차원 배열의 이름과 첫번째 층의 주소는 다르다
        //이차원 배열의 이름은 층을 모으고 있는 배열의 주소를 가리킨다.
        //즉 arr, arr[0]의 주소가 다르다는 것이다.
    }


}
