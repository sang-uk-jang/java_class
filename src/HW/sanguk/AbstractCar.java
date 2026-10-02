package HW.sanguk;

/**
 * 이 클래스는 queue를 만들기 위한 객체 클래스입니다.
 * 내부 객체의 필드로는 객체의 행과 열 가중치가 들어있습니다.
 * 가중치는 행과 열의 더한것으로 구성을 했습니다.
 * 가중치를 기준으로 queue에 넣어 작은 순으로 뽑도록 하였습니다
 * 그 이유는 0,0을 기준으로 가까운것을 하였을때, 연결되는 edge를 1로 보고 가중치를 주차공간 마다 부여를 하였습니다.
 * 그래서 가중치가 적은 순으로 queue에서 뽑혀 가장 가까운 주차공간이 나오게 됩니다.
 * @author sanguk jang
 * @version 1.0
 * @since 2026-10-02
 */
public class AbstractCar {
    public int abstractRow;
    public int abstractCol;
    public int weight;
    /**
     * AbstractCar 클래스의 생성자입니다,
     * 내부에서는 필드의 초기화를 담당하고 있습니다.
     * @param row,col 주차 정보를 담고 있는 정보입니다.
     */
    public AbstractCar(int row, int col){
        this.abstractRow = row;
        this.abstractCol = col;
        this.weight = row + col;
    }

    /**
     * AbstractCar 클래스의 toString 오버라이드 매소드입니다,
     * 확인용으로 사용하였습니다.
     */
    @Override
    public String toString() {
        String str ="abstracRow : "+this.abstractRow + "\n";
        str += "abstracCol : "+ this.abstractCol + "\n";
        str += "weight : "+ this.weight + "\n";
        return str;
    }
}
