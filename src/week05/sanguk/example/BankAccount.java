package week05.sanguk.example;

public class BankAccount {
    public int accountNumber;
    public String customerName;
    public double accountBalance;

    public BankAccount(int accountNumber, String customerName) {
        this(accountNumber, customerName, 0.0);
    }

    public BankAccount(int accountNumber, String customerName, double accountBalance) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.accountBalance = accountBalance;
        System.out.println("생성자 : "+this); //클래스 내부에서의 객체 주소값 => this
    }

    public void deposit(double amount){
        this.accountBalance+=amount;
    }
    public void withdraw(double amount){
        if(this.accountBalance>=amount){
            this.accountBalance-=amount;
        }else {
            System.out.println("출금 잔액 부족");
        }
    }
    public void transfer(BankAccount account, double amount){
        if(this.accountBalance>=amount){
            this.withdraw(amount);
            account.deposit(amount);
        }else {
            System.out.println("출금 잔액 부족");
        }
    }
    public void showAccount(){
        System.out.println("-".repeat(20));
        System.out.println("고객이름 : "+this.customerName);
        System.out.println("계좌번호 : "+ this.accountNumber);
        System.out.println("잔   액 : "+this.accountBalance);
        System.out.println("-".repeat(20));
    }
}
