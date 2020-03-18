package Clinic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
public class ClinicWorks {
    String exit = "no";
    List<Client> arrayList = new ArrayList<>();
//    ClinicWorks clinicWorks = new ClinicWorks();

    public static void main(String[] args) throws IOException {
        ClinicWorks clinicWorks = new ClinicWorks();
        System.out.println("Pet clinic...  (c)demiurg");
        clinicWorks.start();

    }

    public void start() throws IOException {
        ClinicWorks clinicWorks = new ClinicWorks();
        while (exit.equals("no")) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println();
            System.out.println("Selected action: ");
            System.out.println("1 - add a client \n" + "2 - delete client \n" + "3 - Find client. \n" + "4 - find pet \n" + "5 - rename client \n" + "6 - rename pet \n" +
                    "7 - to watch all the clients and pets \n" + "9 - Exit to program...");
            switch (Integer.parseInt(reader.readLine())){
                case 1 : clinicWorks.addClient();
                    break;
                case 2 : clinicWorks.delClient();
                    break;
                case 3 : clinicWorks.findClient();
                    break;
                case 4 : clinicWorks.findPet();
                    break;
                case 5 : clinicWorks.renameClient();
                    break;
                case 6 : clinicWorks.renamePet();
                    break;
                case 7 : clinicWorks.showAll();
                    break;
                case 9 : exit = "yes";
                    break;
                default:
                    System.out.println("default");
            }
        }
    }
    public void addClient(){
        // Client client = new Client(getFromKeyboard("Input name clients: "),
        //              new Pet (getFromKeyboard("Input name pets: "), getFromKeyboard("Input type pets: ")));
        Client client = new Client("Ta",new Pet("Varya","Cat"));
        Client client1 = new Client("Da",new Pet("kroko","Dog"));
        arrayList.add(client);
        arrayList.add(client1);

        for (int i = 0; i < arrayList.size(); i++){
            System.out.println(arrayList.get(i));
        }
    }

    public void delClient(){
        ClinicWorks clinicWorks = new ClinicWorks();
        String nameClient = clinicWorks.getFromKeyboard("Deleting the client: ").trim();
        for(int i = 0; i < arrayList.size(); i++){
            if (nameClient.equals(arrayList.get(i).getClientIdName())){
                arrayList.remove(i);
                System.out.println("The client was successfully deleted!");
            }
        }
    }
    // case 3
    public void findClient(){
        ClinicWorks clinicWorks = new ClinicWorks();
        String clientName = clinicWorks.getFromKeyboard("What are we looking? ");
        for (int i = 0; i < arrayList.size(); i++){
            if(clientName.equals(arrayList.get(i).getClientIdName())){
                System.out.println("The search is successful.. \n " + " Client " + arrayList.get(i).getClientIdName() +
                        ". Pets " + arrayList.get(i).getPetName() +
                        ". Pets type " + arrayList.get(i).getPetType() + ".");
                return;
            }
        }
        System.out.println("Sorry, name not found... ");
    }
    // case
    public void findPet() {
        ClinicWorks clinicWorks = new ClinicWorks();
        String clientName = clinicWorks.getFromKeyboard("Pet: What are we looking?");
        for (int i = 0; i < arrayList.size(); i++)
            if(clientName.equals(arrayList.get(i).getPetName())){
                System.out.println("The search is successful.." + arrayList.get(i).getPetName());
            }else{
                System.out.println("Sorry, not found...");
            }
    }
    public void renameClient(){
        ClinicWorks clinicWorks = new ClinicWorks();
        for (int i = 0; i < arrayList.size(); i++){
            if (clinicWorks.getFromKeyboard("find rename client: ").equals(arrayList.get(i).getClientIdName())){
                arrayList.get(i).setClientIdName(getFromKeyboard("New name "));
                //Client client = new Client(clinicWorks.getFromKeyboard("find successful.. new name "),new Pet(arrayList.get(i).getPetName(),arrayList.get(i).getPetType()));
                //arrayList.remove(i);
                //arrayList.add(client);
                System.out.println("rename successful! ");
                return;
            }else{
                System.out.println("not found ");
                return;
            }
        }
    }

    public void renamePet(){

    }

    public void showAll(){
        // ClinicWorks clinicWorks = new ClinicWorks();
        for (int i = 0; i < arrayList.size(); i++){
//           System.out.println("Client: " + arrayList.get(i).getClientIdName() +
//                            ", Pet name: " + arrayList.get(i).getPetName() +
//                            ", Pet type: " + arrayList.get(i).getPetType());
            System.out.println(arrayList.get(i));
        }
    }
    public void exit(String exit) {
        System.out.println(exit);
        this.exit = exit;
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


}

