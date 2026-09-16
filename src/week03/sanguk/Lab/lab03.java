package week03.sanguk.Lab;

/*로또 번호 정렬해서 출력하기
1부터 45사이의 로또 번호 6개 생성하여 출력
단 로또번호 중복되면 안되고
오름차순 정렬
메소드 => 로또 생성 매소드(배열 방 생성 후 리턴), 선택 정렬 매소드, 출력 매소드
출력 예시 => 로또번호 : 8 12 28 36 40 41*/

import java.util.Random;

public class lab03 {
    static Boolean deplicationCheck(int[] arr){
        int[] checkArr = new int[45];
        for(int i=0;i<arr.length;i++){
            if(checkArr[arr[i]-1]==0){
                checkArr[arr[i]-1]=1;
            }
            else {
                return false;
            }
        }
        return true;
    }
    static int[] createArr(){
        Random rand = new Random();
        int[] arr = new int[6];
        for(int i=0;i<arr.length;i++){
            arr[i] = rand.nextInt(45)+1;
        }
        return arr;
    }
    static int[] selectSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int minIndex = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[minIndex]>arr[j]){
                    minIndex = j;
                }
            }
            if(minIndex!=i) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
        return arr;
    }
    static void printArr(int[] arr){
        System.out.print("로또 번호 : ");
        for(int k:arr){
            System.out.print(k + " ");
        }
        System.out.println();

    }
    static void main() {
        int[] arr = createArr();
        int deChNum =0;
        while(true){
            if(deplicationCheck(arr)==true){
                break;
            }
            else{
                arr = createArr();
            }
        }
        selectSort(arr);
        printArr(arr);
    }
}
