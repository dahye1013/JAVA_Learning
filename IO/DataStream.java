package IO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class  DataStream{
    public static void main(String[] args) throws IOException {
//      DataOutputStream dos = new DataOutputStream(new FileOutputStream("result.txt")); 
        FileOutputStream fos = new FileOutputStream("result.txt");
        DataOutputStream dos = new DataOutputStream(fos);
        dos.writeUTF("홍길동");
        dos.writeInt(25);
        dos.writeDouble(185.3);
        dos.close();
        
        FileInputStream fis = new FileInputStream("result.txt");
        @SuppressWarnings("resource")
        DataInputStream dis = new DataInputStream(fis);
        System.out.println("이름 = "+dis.readUTF());
        System.out.println("나이 = "+dis.readInt());
        System.out.println("키 = "+dis.readDouble());
    }
}
