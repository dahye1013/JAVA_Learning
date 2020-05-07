package Thread;
//Thread 2개 사용하기
class Factory {
 private int product;

 //동기화를 사용해서 produce()에서는 물건을 생산만, sell()에서는 물건을 소비만 한다.
 public synchronized void produce(){
    if(product>4){
       System.out.println("생산 중단: " + product);
       try{
          wait(); // 스레드를 멈춰라
       }catch(InterruptedException e){
          e.printStackTrace();
       }
    }
    product++;
    System.out.println("생산: " + product);
    notifyAll(); //상대방 스레드를 깨워라
 }
 
 public synchronized void sell(){
    if(product < 1){
       System.out.println("판매 중단: " + product);
       try{
          wait(); // 스레드를 멈춰라
       }catch(InterruptedException e){
          e.printStackTrace();
       }
    }
    product--;
    System.out.println("소비: " + product);
    notifyAll(); //상대방 스레드를 깨워라
 }
}
//-----------------
class Worker extends Thread{
 private Factory factory;
 
 //생성자를 통해서 factory 값 받아오기
 public Worker(Factory factory){
    this.factory = factory;
 }

 public void run(){
    for(int i=0; i<10; i++){
       factory.produce();
    }
 }

}
//-----------------
class Buyer extends Thread{
 private Factory factory;

 //생성자를 통해서 factory 값 받아오기
 public Buyer(Factory factory){
    this.factory = factory;
 }

 public void run(){
    for(int i=0; i<10; i++){
       factory.sell();
    }
 }
 
}
//-----------------
class FactoryMain{
 public static void main(String[] args) {
    
    //스레드 생성 시 생성자에 들어가는 factory의 값을 받아오기 위해서
    Factory factory = new Factory();
    
    //스레드 생성
    Worker t1 = new Worker(factory); // Worker 자체가 스레드이기 때문에 Worker를 생성해준다.
    Buyer t2 = new Buyer(factory);
    t1.start();
    t2.start();
 }
}