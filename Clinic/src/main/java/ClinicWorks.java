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
    String notFound = "Sorry, not found...";

    List<Clients> arrayList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ClinicWorks clinicWorks = new ClinicWorks();
        System.out.println("Pet clinic...  (c) demiurg");
        clinicWorks.start();
    }

    public void start() throws IOException {
        ClinicWorks clinicWorks = new ClinicWorks();
        while (exit.equals("no")) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println();
            System.out.println("Selected action: ");
            System.out.println("1 - add a client, " + " 2 - delete client, " + " 3 - Find client, " + " 4 - Find pet. \n" + "5 - rename client, " + " 6 - rename pet, " +
                    "7 - Watch all the clients, " + " 9 - Exit to program...");
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
    // case 1
    public void addClient(){
        String nameClient = getFromKeyboard("Enter name the clients: ");
        for (int i = 0; i < arrayList.size(); i++) {
            if (nameClient.equals(arrayList.get(i).getClientIdName())){
                System.out.println("A client with this name already exists... Please, repeat the new name of the client ");
                return;
            }
        }
         Clients client = new Clients(nameClient, new Pets (getFromKeyboard("Input name pets: "),
                                                            getFromKeyboard("Input type pets: ")));
//        Clients client = new Clients("Ta",new Pets("Varya","Cat"));
//        Clients client1 = new Clients("Da",new Pets("kroko","Dog"));
          arrayList.add(client);
//        arrayList.add(client1);
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
        System.out.println(notFound);
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
        System.out.println(notFound);
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
        System.out.println(notFound);
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
        System.out.println(notFound);
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
        System.out.println(notFound);
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

