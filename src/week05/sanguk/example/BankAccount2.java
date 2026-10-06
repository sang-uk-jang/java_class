package week05.sanguk.example;

public class BankAccount2 {
    private static int count=100;
    private int accountNumber;
    private String customerName;
    private double accountBalance;

    {
        this.accountNumber=count++;
    }

    private BankAccount2(String customerName) {
        this(customerName, 0.0);
    }

    private BankAccount2(String customerName, double accountBalance) {
        this.customerName = customerName;
        this.accountBalance = accountBalance;
        //System.out.println("생성자 : "+this); //클래스 내부에서의 객체 주소값 => this
    }

    public static BankAccount2 getInstance(String customerName, double accountBalance){
        return new BankAccount2(customerName, accountBalance);
    } //객체 생성과정을 클래스가 통제할 수 있다는 점이 public 생성자와 가장 큰 차이이다.

    public static BankAccount2 getInstance(String customerName){
        return new BankAccount2(customerName, 0.0);
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public static int getCount() {
        return count;
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
    public void transfer(BankAccount2 account, double amount){
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

    @Override
    public String toString() {
        String str = "-".repeat(20)+"\n";
        str+= "고객이름 : "+this.customerName+"\n";
        str+= "계좌번호 : "+ this.accountNumber+"\n";
        str+= "잔   액 : "+this.accountBalance+"\n";
        str+= "-".repeat(20)+"\n";
        return str;
        //return super.toString();
    }
}
