package SingleTon;
class  SingleTon{
    private int num= 3;
    private static SingleTon instance ; //static 메모리에 instance를 설정한다.
    
    public static SingleTon getInstance(){
        if(instance==null){ //값이 없을 때만 new SingleTon();하나를 만든다
            instance = new SingleTon(); 
        }
        return instance; //이미 생성된 sigleton이 있다면, 새로 만들수 없고 이전 메모리를 활용하여 쓸 수 있도록 같은 instance를 return해준다.
    }

    public static void main(String[] args)  {
        

        SingleTon aa = new SingleTon();
        aa.num++;
        System.out.println("aa = " +aa);
        System.out.println("num = " +aa.num);
        System.out.println();
        
        SingleTon bb = new SingleTon();
        bb.num++;
        System.out.println("bb = " +bb);
        System.out.println("num = " +bb.num);
        System.out.println();

        System.out.println("\n** 싱글톤 **");
        SingleTon cc = SingleTon.getInstance();
        cc.num++;
        System.out.println("cc = " +cc);
        System.out.println("num = " +cc.num);
        System.out.println();

        System.out.println("\n** 싱글톤 **");  //  싱글톤으로 처리한 애들은 같은 instance를 사용하기 때문에 주소 값과 num를 공유한다.
        SingleTon dd = SingleTon.getInstance();
        dd.num++;
        System.out.println("dd = " +dd);
        System.out.println("num = " +dd.num); 
        System.out.println();

    }
}
