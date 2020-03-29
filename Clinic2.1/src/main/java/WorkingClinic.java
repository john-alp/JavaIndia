import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WorkingClinic implements Serializable {
 public     List<Clients> arrayList = new ArrayList<Clients>();

    public void addClient(){
   //     String nameClient = enterOfKeybord("Enter name: ");
     String nameClient = "John";
        String namePet = "Daria";
        String typePet = "Douther";
Clients clients = new Clients(nameClient, new Pets(namePet,typePet));
arrayList.add(clients);
        System.out.println(clients);
    }

public void showAllClientsAndPets(){
    System.out.println("All Clients and Pets of this Clinica");
        for (int i = 0; i < arrayList.size(); i++ ){
            System.out.println(arrayList.get(i));
        }
}


public static String enterOfKeybord(String text){
    System.out.println(text);
    Scanner scanner = new Scanner(System.in);
    String result = scanner.nextLine();
 //   scanner.close();
    return result;
}

}
