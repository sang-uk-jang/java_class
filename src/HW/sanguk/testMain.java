package HW.sanguk;

/**
 * 이 클래스는 메인 클래스입니다.
 * @author sanguk jang
 * @version 1.0
 * @since 09-02
 */
public class testMain {
    /**
     * 프로그램 시작을 위한 메인 함수입니다.
     * 요구사항
     * 1. 주차장 클래스 만들기 만족 여부 : yes
     * 2. 파일에서 주차장 초기화 만족 여부 : yes
     * 3. 차량 클래스 만족 여부 : yes
     * 4. 주차 상태 출력 만족 여부 : yes
     * 5. 차량 주차 기능 만족 여부 : yes
     * 6. 차량 출차 기능 만족 여부 : yes
     * 7. 차량 검색 기능 만족 여부 : yes
     * 8. 주차장 정보 출력 만족 여부 : yes
     * 9. 메뉴 운영 만족 여부 : yes
     * 10. 추가기능(선택사항 - 5점) 만족 여부 : yes
     */
    static void main() {
        System.out.println("202211359 장상욱");
        ParkingArea area = new ParkingArea("res/park.txt");
        area.memu();
    }


}
