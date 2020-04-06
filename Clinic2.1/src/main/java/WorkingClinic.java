import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WorkingClinic implements Serializable {
 public     List<Clients> arrayList = new ArrayList<Clients>();
// case 1
    public void addClient(String nameClient, String namePet, String typePet){
        /**
         * Проверка на дубликат Name People и на пустой ввод
         */
        for (int i = 0; i < arrayList.size(); i++ ){
            if (nameClient.equals(arrayList.get(i).getNamePeople())){
                System.out.println("Such a client already exists...");
            return;
            }
            if (nameClient.equals("")){
                System.out.println("Сlient name not set");
            return;
            }
        }
        /**
         * Добавляем нового клиента, имя питомца и его вид
         */
        Clients clients = new Clients(nameClient, new Pets(namePet,typePet));
        arrayList.add(clients);
        System.out.println(clients);
    }
// case 2
    public void findClient(String nameClient){
    for (int i = 0; i < arrayList.size(); i++){
        if (arrayList.get(i).getNamePeople().equals(nameClient)){
            System.out.println("The client found! " + "Client: " + arrayList.get(i).getNamePeople() + ", and his pets: "
                                                    + arrayList.get(i).getPet().getNamePet() + ", type: "
                                                    + arrayList.get(i).getPet().getTypePet() + "\n");
        return;
        }
    }
        System.out.println("Sorry.. The client not found! ");
        System.out.println();
    }
    //case 3
    public void findPet(String nameClient){
        for (int i = 0; i < arrayList.size(); i++){
            if (arrayList.get(i).getPet().getNamePet().equals(nameClient)){
                System.out.println("The pet found! " + "Pet: " + arrayList.get(i).getPet().getNamePet() + ", type: "
                                                     + arrayList.get(i).getPet().getTypePet() + ", belongs to the client: "
                                                     + arrayList.get(i).getNamePeople());
            return;
            }

        }
        System.out.println("Sorry.. The client not found! ");
        System.out.println();
    }
    // case 4
    public void renameClient(String nameClient, String newNameClient){
        for (int i = 0; i < arrayList.size(); i++){
            if (arrayList.get(i).getNamePeople().equals(nameClient)){
                System.out.println("The client found! ");
                System.out.println(arrayList.get(i).getNamePeople() + ". And his Pets: "
                                 + arrayList.get(i).getPet().getNamePet() + " Type: "
                                 + arrayList.get(i).getPet().getTypePet());
                arrayList.get(i).setNamePeople(newNameClient);
                System.out.println("Success! "+ "new name client: " + arrayList.get(i).getNamePeople());
                System.out.println();
                System.out.println();
                return;
            }
        }
        System.out.println("Sorry.. The client not found! ");
        System.out.println();
    }
    // case 5
    public void deleteClient(String nameClient){
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
                System.out.println();
                return;
            }
        }
        System.out.println("Sorry.. Client not found! ");
        System.out.println();
    }
    // case 7
    public void showAllClientsAndPets(){
        System.out.println("All Clients and Pets of this Clinics: ");
        for (Clients clients : arrayList){
            System.out.println(clients);
        }
        System.out.println("End..");
        System.out.println();
    }



public String enterOfKeybord(String text){
    System.out.println(text);
    Scanner scanner = new Scanner(System.in);
    String result = scanner.nextLine();
    return result;
}

}
