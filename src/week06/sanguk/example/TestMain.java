package week06.sanguk.example;

public class TestMain {
    static void main() {
//        Ticket ticket1 = new Ticket(1, 1000);
//        System.out.println(ticket1);
//        ticket1.setPrice(2000);
//        System.out.println(ticket1);
//        GeneralTicket ticket1 = new GeneralTicket(1, 1000.0, false);
//        GeneralTicket ticket2 = new GeneralTicket(2, 2000.0, true);
//        System.out.println(ticket1);
//        System.out.println(ticket2);
//        AdvanceTicket ticket1 = new AdvanceTicket(1, 1000.0, 32);
//        AdvanceTicket ticket2 = new AdvanceTicket(2, 1000.0, 20);
//        System.out.println(ticket1);
//        System.out.println(ticket2);
        TicketManager ticketManager = new TicketManager("아이유 콘서트", 100);
        ticketManager.register(new Ticket(1, 1000.0));
        ticketManager.register(new GeneralTicket(2, 2000.0, true));
        ticketManager.register(new GeneralTicket(3, 3000.0, false));
        ticketManager.register(new AdvanceTicket(4, 2000.0, 35));
        ticketManager.register(new AdvanceTicket(5, 3000.0, 15));
        ticketManager.register(new GeneralTicket(6, 3000.0, true));
        System.out.println(ticketManager);

        ticketManager.showGeneralTicket(true);
        ticketManager.showAdvanceTicket(20);
    }
}
