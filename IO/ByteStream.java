package IO;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

class ByteStream {
    public static void main(String[] args) throws IOException   {

    BufferedInputStream bis = new BufferedInputStream(new FileInputStream("data.txt"));

    int data;
    while( (data=bis.read()) != -1){
        System.out.print((char)data);
        }//while
       bis.close();
    }
}
