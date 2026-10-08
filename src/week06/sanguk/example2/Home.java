package week06.sanguk.example2;

public class Home {
    private HomeAppliance[] devices; //배열 선언
    private int count = 0;

    public Home(int capacity) {
        this.devices = new HomeAppliance[capacity]; //방을 만들었다 -> 안에 내용물을 채워넣어야한다.
    }
    public void addHA(HomeAppliance ha){
        if(this.count < devices.length){
            devices[count++] = ha;
        } else
            System.out.println("더이상 배치 불가");
    }

    public void showAllStatus(){
        for(HomeAppliance ha : devices){
            if(ha != null){
                ha.showStatus();
            }else
                break;
        }
    }

    public void open(){
        while(true){
            System.out.println("우리집 가전제품 선택");
            for(int i=0;i<count;i++){
                System.out.println((i+1) + ")" + devices[i].getHAName());
            }
            System.out.println("0) 종료");
            System.out.print("선택 : ");
            int choice = HomeAppliance.scan.nextInt(); // HomeAppliance의 static를 사용하여 scan사용
            if(choice == 0){
                System.out.println("제어종료");
                System.out.println();
                return;
            }
            devices[choice-1].menu();
            showAllStatus();
        }
    }

}
