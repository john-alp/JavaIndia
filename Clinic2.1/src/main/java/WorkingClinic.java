import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WorkingClinic implements Serializable {
 public     List<Clients> arrayList = new ArrayList<Clients>();
// case 1
    public void addClient(String nameClient, String namePet, String typePet){
        Clients clients = new Clients(nameClient, new Pets(namePet,typePet));
        arrayList.add(clients);
        System.out.println(clients);
    }
// case 2
    public void findClient(String nameClient){
    for (int i = 0; i < arrayList.size(); i++){
        if (arrayList.get(i).getNamePeople().equals(nameClient)){
            System.out.println("The client found! " + arrayList.get(i).getNamePeople() + ". And his Pets: "
                                                    + arrayList.get(i).getPet().getNamePet() + " Type: "
                                                    + arrayList.get(i).getPet().getTypePet());
        return;
        }
        System.out.println("Sorry.. The client not found! ");
        System.out.println();
    }
    }
    //case 3
    public void findPet(){
        String nameClient = enterOfKeybord("Name of the client we are looking for: ");
        for (int i = 0; i < arrayList.size(); i++){
            if (arrayList.get(i).getPet().getNamePet().equals(nameClient)){
                System.out.println("The pet found! " + arrayList.get(i).getPet().getNamePet() + " Type: "
                                                     + arrayList.get(i).getPet().getTypePet());
            return;
            }
            System.out.println("Sorry.. The client not found! ");
            System.out.println();
        }
    }
    // case 4
    public void renameClient(){
        String nameClient = enterOfKeybord("Name of the client we are looking for to rename: ");
        for (int i = 0; i < arrayList.size(); i++){
            if (arrayList.get(i).getNamePeople().equals(nameClient)){
                System.out.println("The client found! ");
                System.out.println(arrayList.get(i).getNamePeople() + ". And his Pets: "
                                 + arrayList.get(i).getPet().getNamePet() + " Type: "
                                 + arrayList.get(i).getPet().getTypePet());
                String temp = enterOfKeybord("Enter a new client name: ");
                arrayList.get(i).setNamePeople(temp);
                System.out.println("Success! ");
                System.out.println(arrayList.get(i).getNamePeople());
                System.out.println();
            }
        }
        System.out.println("Sorry.. The client not found! ");
        System.out.println();
    }
    // case 7
    public void showAllClientsAndPets(){
        System.out.println("All Clients and Pets of this Clinica");
            for (int i = 0; i < arrayList.size(); i++ ){
            System.out.println(arrayList.get(i));
        }
    }
    public void deleteClient(){
        String nameClient = enterOfKeybord("Which client should I delete? ");
          for (int i = 0; i < arrayList.size(); i++){
              if (arrayList.get(i).getNamePeople().equals(nameClient)){
                  System.out.println("The client was found: " + arrayList.get(i).getNamePeople() + ".");
                  String temp = enterOfKeybord(" Remove? yes/no ");
                  if (temp.equals("yes")){
                  arrayList.remove(i);
                      System.out.println("Deleting the client was successful! ");
                      System.out.println();
                  return;
                  }
                  System.out.println(" Canceled ..");
              }
          }
    }


public static String enterOfKeybord(String text){
    System.out.println(text);
    Scanner scanner = new Scanner(System.in);
    String result = scanner.nextLine();
    return result;
}

}
