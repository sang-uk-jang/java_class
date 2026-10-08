package week06.sanguk.example2;

import java.util.Scanner;

public abstract class HomeAppliance {
    private String HAName;
    private boolean HAPower = false;

    static Scanner scan = new Scanner(System.in); //default라서 같은 pakage에서 접근이 가능하다.

    public HomeAppliance(String HAName) {
        this.HAName = HAName;
    }

    public String getHAName() {
        return HAName;
    }

    public void setHAName(String HAName) {
        this.HAName = HAName;
    }

    public boolean isHAPower() {
        return HAPower;
    }

    public void setHAPower(boolean HAPower) {
        this.HAPower = HAPower;
    }

    abstract void showStatus();
    abstract void menu();
}
