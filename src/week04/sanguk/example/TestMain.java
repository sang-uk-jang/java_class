package week04.sanguk.example;

public class TestMain {
    static void main() {
        TV tv = new TV();
        System.out.println("202211359 장상욱");
        tv.powerOnOff();
//        tv.channelUp();
//        tv.channelUp();
//        tv.channelUp();
//        tv.channelUp();
//        tv.channelUp();
//        tv.channelUp();
//        tv.channelDown();
//        tv.channelDown();
        tv.volumeDown();
        tv.volumeUp();
        tv.volumeUp();
        tv.volumeUp();
        tv.volumeUp();
        tv.volumeUp();
        tv.volumeUp();
        tv.volumeUp();

//        TV tv2 = tv; //주소를 복사하기 때문에 객체를 공유한다
//        tv2.powerOnOff();
//        tv.channelUp();

//        TV tv2 = new TV();
//        tv2 = tv;
//        System.out.println("tv : "+tv);
//        System.out.println(("tv2 : "+tv2));
    }
}
