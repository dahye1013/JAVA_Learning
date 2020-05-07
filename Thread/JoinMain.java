package Thread;
//JoinMain는 쓰레드가 되고 싶은 것이지 쓰레드는 아니다.

class JoinTest implements Runnable{

   @Override
   public void run() { //오버라이드한 것에는 throw를 못쓴다. ->catch써야함
       for(int i = 1 ; i <= 5; i++) {
           System.out.println(i);
           
           try{ 
               Thread.sleep(500); 
               }catch(InterruptedException e){
                   e.printStackTrace();
               }
       
       }
   }
}
class JoinMain{

   public static void main(String[] args) throws  InterruptedException {
       JoinTest jt = new JoinTest(); 
       Thread t =new Thread(jt); //스레스 생성. 파라미터에 만들고자 하는 스레드 명을 넣는다.
       
       System.out.println("스레드 시작");
       t.start(); //스레드 시작
       t.join();
       System.out.println("스레드 종료");       
   }
}
