import java.io.Serializable;

public class Pets implements Serializable {
    public Pets(){}
    public Pets (String petName, String petType){
        this.petName = petName;
        this.petType = petType;
    }
    private String petName;
    private String petType;

    public void setPetName(String name){
        this.petName = name;
    }
    public void setPetType(String name){
        this.petType = name;
    }
    public String getPetName(){
        return petName;
    }
    public String getPetType(){
        return petType;
    }
    public String toString(){
        return "Pets: " + petName + " : " + petType;
    }
}
