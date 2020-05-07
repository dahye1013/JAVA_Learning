package SingleTon;

import java.util.Scanner;

public class ATMTest implements Runnable{

    private long depositeMoney = 100000; // 잔액
    private long balance; //찾고자 하는 금액
    
    public static void main(String[] args) {
        ATMTest atm = new ATMTest();

        Thread son = new Thread(atm, "아들"); //스레드 생성. new WThread(a , b); a는 어떤 걸 스레드 시킬건지, b는 이름 명명
        Thread mom = new Thread(atm, "엄마");
        mom.start();
        son.start();

    }

    public void withDraw() {
        if(depositeMoney >= balance ) {
            if(balance%10000 == 0) {
                depositeMoney = depositeMoney - balance;
                System.out.println("잔액은 "+depositeMoney+"입니다.");
            }else System.out.println("만원 단위로 입력하세요.");
            
        }else {
            System.out.println("잔액초과");
        }
    }
    
    @Override
    public synchronized void run() { //한번에 하나씩만 처리할 수 있도록 synchronized 해준다. 
        System.out.println(Thread.currentThread().getName()+"님 안녕하세요"); //현재 선택받은 스레드Thread.currentThread()에서 .getName()
        System.out.println("찾으시려는 금액?");
        Scanner scan = new Scanner(System.in);
        balance = scan.nextLong();     
        System.out.println("찾고자 하는 금액 : "+ balance);
        withDraw();
        System.out.println("-------------");
    }
    
    
}


