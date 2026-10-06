package week06.sanguk.example;

public class TicketManager {
    private String name;
    private final int NUMBER;
    private Ticket[] tickets;
    private int count=0;

    public TicketManager(String name, int NUMBER) {
        this.name = name;
        this.NUMBER = NUMBER;
        if(this.NUMBER>0){
            tickets = new Ticket[NUMBER];
        }
    }

    public void register(Ticket ticket) {
        if(this.count < tickets.length){
            tickets[count++] = ticket;
        }else{
            System.out.println("티켓 판매 완료");
        }
    }

    public double getTotal() {
        double total = 0;
        for(Ticket ticket : tickets){
            if(ticket!=null){
                total += ticket.getPrice(); //=> 다형성
            }else
                break;
        }//ticket타입으로 배열이 있지만 매소드는 실제 객체의 매소드가 호출이 된다. => 다형성
        return total;
    }

    public void showGeneralTicket(boolean payByCredit){
        for(Ticket ticket:tickets){
            if(ticket!=null && ticket instanceof GeneralTicket t){
                //GeneralTicket t = (GeneralTicket) ticket; //다운 캐스팅
                if(t.isPayByCredit()==payByCredit){//자식 매소드를 통해 비교를 해야해서 다운캐스팅을 해줘야한다.
                    System.out.println(t);
                }
            }
        }
    }

    public void showAdvanceTicket(int advanceDays){
        for(Ticket ticket:tickets){
            if(ticket != null && ticket instanceof AdvanceTicket t){
                if(t.getAdvanceDays()<advanceDays){
                    System.out.println(t);
                }
            }
        }
    }

    @Override
    public String toString() {
        String str ="공연명 : "+this.name+"\n";
        str += "좌석수 : "+ this.NUMBER +"\n";
        str += "총 판매티켓 수 : "+ this.count + "\n";
        str +="=====================\n";
        for(Ticket ticket:tickets) {
            if(ticket!=null) {
                str += ticket.toString();
                str +="\n-------------\n";
            }else
                break;
        }
        str +="=====================\n";
        str += "총 티켓 판매 금액 : "+this.getTotal()+"\n";
        return str;
    }

}














