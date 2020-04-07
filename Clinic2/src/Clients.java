import java.io.Serializable;

public class Clients implements Serializable {
    public Clients(){}
    public Clients(String peopleName, Pets pet){
        this.peopleName = peopleName;
        this.pets = pet;
    }
    private String peopleName;
    private Pets pets;

    public String getPeopleName() {
        return peopleName;
    }

    public void setPeopleName(String peopleName) {
        this.peopleName = peopleName;
    }

    public Pets getPets() {
        return pets;
    }

    public void setPets(Pets pets) {
        this.pets = pets;
    }

    //    public void setPeopleName(String name){
//        this.peopleName = name;
//    }
//    public void setPetName(Pets name) {
//        this.pets = name;
//    }
//    public String getPeopleName(){
//        return this.peopleName;
//    }
//    public Pets getPetName(){
//        return this.pets;
//    }
    public String toString(){
        return "Clients: " + peopleName + " | " + pets;
    }
}

