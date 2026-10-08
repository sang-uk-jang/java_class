package week06.sanguk.example2;

public class TestMain {
    static void main() {
        //HomeAppliance a = new HomeAppliance("dawd"); // abstract class라서 객체를 생성할 수 없다.
        //HomeAppliance ha1 = new Refrigerator("건국냉장고"); // 상속관계라서 부모로 참조가 가능하다.
        Home home = new Home(5);
        home.addHA(new Refrigerator("건국냉장고"));
        home.addHA(new Refrigerator("대학냉장고"));
        home.addHA(new boiler("건국보일러"));
        home.open();
    }
}
