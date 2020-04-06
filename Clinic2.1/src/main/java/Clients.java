import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serializable;
@JsonAutoDetect
public class Clients implements Serializable {
    public Clients(){}
    public Clients(String namePeople, Pets pet){
        this.namePeople = namePeople;
        this.pet = pet;
    }
    private String namePeople = "people";
    private Pets pet;

    public String getNamePeople(){
        return namePeople;
    }
    public Pets getPet(){
        return pet;
    }
    public void setNamePeople(String namePeople){
        this.namePeople = namePeople;
    }
    public void setPet(Pets pet){
        this.pet = pet;
    }
    public String toString(){
        return "client: " + namePeople + ", " + pet;
    }
}
