package HW.sanguk;

/**
 * 이 클래스는 car객체 클래스입니다.
 * @author sanguk jang
 * @version 1.0
 * @since 2026-10-02
 */
public class Car {
    String carNumber;
    String carModel;
    String carOwner;
    /**
     * Car 클래스의 생성자입니다,
     * 내부에서는 필드의 초기화를 담당하고 있습니다.
     * @param carNumber, carModel, carOwner 차의 정보를 담고있는 정보입니다.
     */
    public Car(String carNumber, String carModel, String carOwner){
        this.carNumber = carNumber;
        this.carModel = carModel;
        this.carOwner = carOwner;
    }

    /**
     * Car 클래스의 toString 오버라이드 매소드입니다,
     * 출력 또는 확인용으로 사용하였습니다.
     */
    @Override
    public String toString() {
        String str = "";
        str+="차 번호 : " + carNumber+"\n";
        str += "차 모델 : " + carModel + "\n";
        str += "차 소유주 번호 : " + carOwner + "\n";
        return str;
    }
}
