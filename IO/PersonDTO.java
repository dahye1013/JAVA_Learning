package IO;

public class PersonDTO implements java.io.Serializable{ //한번밖에 안쓰면 import하지 않고, 이처럼 쓸수 있다.
    private String name;
    private int age;
    private double height;
    
    PersonDTO(String name , int age , double height){
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public double getHeight() {
        return height;
    }
    
}
