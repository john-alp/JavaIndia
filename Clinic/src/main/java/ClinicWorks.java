
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.*;

/**
 * @author  demiurg
 * @since  12.03.2020
 * @version 1.9
 *
 *  Создать программу для обслуживания клиники домашних питомцев
 *
 * - Должна быть возможность добавлять клиентов
 * - Указывать какой питомец есть у клиента
 * - Возможность искать по кличке питомца, по имени клиента
 * - Редактировать имя клиента, имя питомца
 * - Удалять клиента и питомца
 * - Возможность проверки
 */
public class ClinicWorks implements Serializable {
    public ClinicWorks(){}
    public List<Clients> arrayList = new ArrayList<>();
        public List<Clients> getArrayList() {
        return arrayList;
    }
    // case 1
    public void addClient(){
        String nameClient = getFromKeyboard("Enter name the clients: ");
        for (int i = 0; i < arrayList.size(); i++) {
            if (nameClient.equals(arrayList.get(i).getClientIdName())){
                System.out.println("A client with this name already exists... Please, repeat the new name of the client ");
                return;
            }
        }
//         Clients client = new Clients(nameClient, new Pets (getFromKeyboard("Input name pets: "),
//                                                            getFromKeyboard("Input type pets: ")));
        Clients client = new Clients("Tatiana",new Pets("Varya","Cat"));
   //     Clients client1 = new Clients("Daria",new Pets("May","Dog"));
          arrayList.add(client);
 //       arrayList.add(client1);
//


       // for (int i = arrayList.size(); ;){
            System.out.println("Client add successfully: \n " + arrayList.get(arrayList.size() - 1));
        }

    // case 2
    public void delClient(){
        ClinicWorks clinicWorks = new ClinicWorks();
        String nameClient = clinicWorks.getFromKeyboard("Deleting the client: ").trim();
        for(int i = 0; i < arrayList.size(); i++){
            if (nameClient.equals(arrayList.get(i).getClientIdName())){
                String removeClient = arrayList.get(i).getClientIdName();
                arrayList.remove(i);
                System.out.println("The client was successfully deleted! " + removeClient);
                return;
            }
        }
        System.out.println("Sorry, not found...");
    }

    // case 3
    public void findClient(){
        ClinicWorks clinicWorks = new ClinicWorks();
        String clientName = clinicWorks.getFromKeyboard("What are we looking? ");
        for (int i = 0; i < arrayList.size(); i++){
            if(clientName.equals(arrayList.get(i).getClientIdName())){
                System.out.println("The search is successful.. \n " + " Client " + arrayList.get(i).getClientIdName() +
                        ". Pets " + arrayList.get(i).getPets() +
                        ". Pets type " + arrayList.get(i).getPetType() + ".");
                return;
            }
        }
        System.out.println("Sorry, not found...");
    }
    // case 4
    public void findPet() {
        ClinicWorks clinicWorks = new ClinicWorks();
        String clientName = clinicWorks.getFromKeyboard("Pet: What are we looking?");
        for (int i = 0; i < arrayList.size(); i++)
            if(clientName.equals(arrayList.get(i).getPets())){
                System.out.println("The search is successful.." + arrayList.get(i).getPets());
                return;
            }
        System.out.println("Sorry, not found...");
    }
    public void renameClient(){
        ClinicWorks clinicWorks = new ClinicWorks();
        String clientName = clinicWorks.getFromKeyboard("Find rename client: ").trim();
        for (int i = 0; i < arrayList.size(); i++){
            if (clientName.equals(arrayList.get(i).getClientIdName())){
                arrayList.get(i).setClientIdName(getFromKeyboard("New name "));
                //Client client = new Client(clinicWorks.getFromKeyboard("find successful.. new name "),new Pet(arrayList.get(i).getPetName(),arrayList.get(i).getPetType()));
                //arrayList.remove(i);
                //arrayList.add(client);
                System.out.println("Rename successful! ");
                return;
            }
        }
        System.out.println("Sorry, not found...");
    }
    public void renamePet(){
        ClinicWorks clinicWorks = new ClinicWorks();
        String petName = clinicWorks.getFromKeyboard("Find rename pet: ").trim();
        for (int i = 0; i < arrayList.size(); i++){
            if (petName.equals(arrayList.get(i).getPets())){
                arrayList.get(i).setPets(getFromKeyboard("Enter new name a pet :"));
                System.out.println("Rename successful! \n" + arrayList.get(i));
                return;
            }
        }
        System.out.println("Sorry, not found...");
    }
    public void showAll(){
        // ClinicWorks clinicWorks = new ClinicWorks();
        System.out.println("All clients and their Pets: ");
        for (int i = 0; i < arrayList.size(); i++){
//           System.out.println("Client: " + arrayList.get(i).getClientIdName() +
//                            ", Pet name: " + arrayList.get(i).getPetName() +
//                            ", Pet type: " + arrayList.get(i).getPetType());
            System.out.println(arrayList.get(i));
        }
    }


    public String getFromKeyboard(String input) {
        System.out.println(input);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return reader.readLine();
        } catch (IOException e) {
            return "Something went wrong.. " + e.getStackTrace();
        }
    }



    @Override
    public String toString() {
        return "ClinicWorks{" +
                "arrayList=" + arrayList +
                '}';
    }
}

