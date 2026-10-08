package week06.sanguk.example2;

public class Refrigerator extends HomeAppliance{
    private int temp = 4;

    public Refrigerator(String HAName) {
        super(HAName);
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    @Override //이 어노테이션은 없어도 되지만 있으면 오류를 잡아준다.
    void showStatus() {
        System.out.println("가전제품 이름 : " + this.getHAName());
        System.out.println("전원 상태 : " + this.isHAPower());
        if(this.isHAPower()){
            System.out.println("현재 온도 : " + this.getTemp());
            System.out.println();
        }else
            System.out.println();
    }

    @Override
    void menu() {
        while(true){
            System.out.print("1) 전원   2) 온도설정     3) 제어종료     선택 : ");
            int choice = scan.nextInt();
            switch (choice){
                case 1 -> setHAPower(!isHAPower());
                case 2 -> {
                    if(isHAPower()){
                        System.out.print("설정 온도 : ");
                        setTemp(scan.nextInt());
                    }else
                        System.out.println("전원이 꺼져있습니다, 전원을 먼저 켜주세요");
                }
                case 3 -> {
                    System.out.println(this.getHAName() + " 제어종료");
                    return;
                }
                default -> System.out.println("메뉴를 다시 선택하세요.");
            }
            showStatus();
        }
    }
}
