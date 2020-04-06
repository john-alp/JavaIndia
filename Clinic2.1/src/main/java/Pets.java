import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serializable;
@JsonAutoDetect
public class Pets implements Serializable {
    public Pets(){}
    public Pets(String namePet, String typePet){
        this.namePet = namePet;
        this.typePet = typePet;
    }
    private String namePet = "Myrka";
    private String typePet = "Cat";

    public String getNamePet(){
        return namePet;
    }
    public String getTypePet(){
        return typePet;
    }
    public void setNamePet(String namePet){
        this.namePet = namePet;
    }
    public void setTypePet(String typePet){
        this.typePet = typePet;
    }
    public String toString(){
        return "pet: " + namePet + ", type " + typePet;
    }
}
