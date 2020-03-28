import java.io.Serializable;
import java.util.List;

public class Clients implements Serializable {
    public Clients(){}
    private String name = "Tatiana";
    private int age = 30;

    public void setName(String name){
        this.name = name;
    }
    public int getAge(){
        return this.age;
    }
    public String getName(){
        return this.name;
    }
    @Override
    public String toString(){
        return "Name " + name + ", Age " + age;
    }
}
