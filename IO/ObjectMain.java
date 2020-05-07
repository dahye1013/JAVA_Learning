package IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.xml.crypto.Data;

public class ObjectMain {
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        PersonDTO dto = new PersonDTO("홍길동", 25, 185.3);
        //NotSerializableException 직렬화가 되어있지 않다.
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("result2.txt"));
        oos.writeObject(dto);
        
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("result2.txt"));
        PersonDTO dto2 = (PersonDTO) ois.readObject();
        System.out.println("이름 = " + dto2.getName());
        System.out.println("나이 = " + dto2.getAge());
        System.out.println("키= " +dto2.getHeight());
           
    }


}
