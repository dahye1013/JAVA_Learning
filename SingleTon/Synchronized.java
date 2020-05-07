package SingleTon;

public class Synchronized extends Thread {

    private static int count = 0;

    public static void main(String[] args) {
        Synchronized aa = new Synchronized(); // 스레드 생성
        Synchronized bb = new Synchronized();
        Synchronized cc = new Synchronized();

        aa.setName("aa");
        bb.setName("bb");
        cc.setName("cc");
        // 스레드 시작 - 스레드 실행
        aa.start();
        bb.start();
        cc.start();

    }

//    public synchronized void run() { // 동기화가 되고 있지않음 . count 출력값을 보면 알 수 있다.
    public void run() {
//        synchronized (this) { 동기화 불가. 
        synchronized (Synchronized.class) { //이런 식으로 동기화 가능하다.
            for (int i = 0; i < 5; i++) {
                count++;
                System.out.println(Thread.currentThread().getName() + " count= " + count);
            }
        }
    }
}
