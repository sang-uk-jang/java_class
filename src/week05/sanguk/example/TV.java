package week05.sanguk.example;

public class TV {
    public static final int MAX_CHANNEL = 5;
    public static final int MIN_CHANNEL = 0;
    public boolean power;
    public int channel;
    public int volume;
    public TV(boolean p){
        power = p;
    }
    public TV(boolean p, int c){
        power = p;
        channel = c;
    }

    public TV() {}

    public TV(TV tv) {
        this(tv.power, tv.channel);
    }

    public void powerOnOff(){
        power = !power;
        showTV();
    }
    public void channelUp(){
        if(power){
            ++channel;
            if(channel > MAX_CHANNEL){
                channel = MIN_CHANNEL;
            }
        }
        showTV();

    }
    public void channelDown(){
        if(power){
            --channel;
            if(channel < MIN_CHANNEL){
                channel = MAX_CHANNEL;
            }
        }
        showTV();
    }
    public void showTV(){
        if(power){
            System.out.println("전원 : "+power);
            System.out.println(("채널 : "+channel));
            System.out.println("볼륨 : "+volume);
            System.out.println("-".repeat(10));
        }else{
            System.out.println("전원이 꺼져있습니다");
            System.out.println("-".repeat(10));
        }
    }
    public void volumeUp(){
        if(power){
            if(volume!=MAX_CHANNEL){
                ++volume;
            }
        }
        showTV();
    }
    public void volumeDown(){
        if(power){
            if(volume!=MIN_CHANNEL){
                --volume;
            }
        }
        showTV();
    }
}
