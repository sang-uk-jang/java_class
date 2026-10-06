package week05.sanguk.example;

import java.util.Scanner;

public class BankManager {
    private String branchName;
    private final int SIZE;
    private BankAccount2[] bankAccount = null;//아직 배열 생성 안했다. 생성하고 안에 객체도 넣어줘야 한다.
    private int count = 0;//개설된 계좌의 수
    private static Scanner scan = new Scanner(System.in);

    public BankManager(String branchName, int SIZE) {
        this.branchName = branchName;
        this.SIZE = SIZE;
        if(this.SIZE > 0){
            this.bankAccount = new BankAccount2[this.SIZE];//무조건 이렇게 방을 확보해야한다!!!!(강조)
        }else{
            System.out.println("계좌 개설 불가");
        }
    }

    public void createAccount(){
        System.out.println("----------계좌 개설----------");
        if(this.count < this.SIZE){
            System.out.print("고객 이름 : ");
            String name = scan.next();
            System.out.print("임금 금액 : ");
            double amount = scan.nextDouble();
            bankAccount[count++] = BankAccount2.getInstance(name, amount);
        }else{
            System.out.println("계좌 개설 불가");
        }
    }

    public void deposit(){
        System.out.println("----------임금----------");
        System.out.print("임금할 계좌번호 : ");
        int target  = scan.nextInt();
        BankAccount2 acc = findAccount(target);
        if(acc!=null){
            System.out.print("임금할 금액 : ");
            double amount = scan.nextDouble();
            acc.deposit(amount);
        }else {
            System.out.println("계좌번호 확인 요망");
        }
    }

    public void withdraw(){
        System.out.println("----------출금----------");
        System.out.print("출금할 계좌번호 : ");
        int target  = scan.nextInt();
        BankAccount2 acc = findAccount(target);
        if(acc!=null){
            System.out.print("출금할 금액 : ");
            double amount = scan.nextDouble();
            acc.withdraw(amount);
        }else {
            System.out.println("계좌번호 확인 요망");
        }
    }

    public BankAccount2 findAccount(int target){
        System.out.println("-----계좌 검색-----");
        if(this.count>0){
            for(BankAccount2 acc : bankAccount){
                if(acc != null){//객체가 null인지 아닌지 체크를 해줘야 한다.
                    if(acc.getAccountNumber() == target){
                        return acc;
                    }
                }else
                    break;
            }
        }
        return null;
    }

    public void transfer(){
        System.out.println("-----계좌이체-----");
        System.out.print("출금 계좌번호 : ");
        int withdraw_account = scan.nextInt();
        System.out.print("임금 계좌번호 : ");
        int deposit_account = scan.nextInt();
        System.out.print("임금할 금액 : ");
        double amount = scan.nextDouble();
        BankAccount2 acc1 = findAccount(withdraw_account);
        BankAccount2 acc2 = findAccount(deposit_account);
        if(acc1 != null && acc2 != null){
            acc1.transfer(acc2, amount);
        }else {
            System.out.println("계좌 확인 요망");
        }
    }

    @Override
    public String toString() {
        String str ="----------\n";
        str+="지점명 : "+this.branchName+"\n";
        str+="계좌수 : "+this.count+"\n";
        for(BankAccount2 acc : this.bankAccount){
            if(acc!=null){//null체크 무조건 해야한다.(객체 배열을 사용할 때는)
                str += acc.toString()+"\n";//toString이 자동으로 호출이 된다
            }else {
                break;
            }
        }
        return str;
    }
}
