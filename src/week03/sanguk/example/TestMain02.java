package week03.sanguk.example;

public class TestMain02 {
    static void selectionSort(int[] arr){
        for(int i=0; i<arr.length-1; i++){
            int minIndex = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[j]<arr[minIndex]){
                    minIndex = j;
                }
            }
            if(i!=minIndex){
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
    static void printArr(int[] arr){
        for(int n : arr){
            System.out.print(n + "\t");
        }
        System.out.println();
    }
    static void main() {
        int[] arr = {10,5,9,4,6,7};
        System.out.print("정렬 전 : ");
        printArr(arr);
        selectionSort(arr); //주소값이 넘어가서 공유가 되어 정렬이 이루어진다.
        System.out.print("정렬 후 : ");
        printArr(arr);
    }
}
//로또 번호 정렬해서 출력하기
//1부터 45사이의 로또 번호 6개 생성하여 출력
//단 로또번호 중복되면 안되고
//오름차순 정렬
//메소드 => 로또 생성 매소드(배열 방 생성 후 리턴), 선택 정렬 매소드, 출력 매소드
//출력 예시 => 로또번호 : 8 12 28 36 40 41

