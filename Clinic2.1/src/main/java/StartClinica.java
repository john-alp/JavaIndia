
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class StartClinica {
    //WorkingClinic workingClinic = new WorkingClinic();
    WorkingClinic workingClinic;
    Serializable serializable = new Serializable();
    @JsonIgnore
    String exit = "no";

    public StartClinica() throws FileNotFoundException {
        try {
            workingClinic = serializable.readJohnOfFile();
        } catch (JsonProcessingException e) {
            workingClinic = new WorkingClinic();
        }
    }

    public static void main (String[] args) throws FileNotFoundException, JsonProcessingException {
        StartClinica startClinica = new StartClinica();
        System.out.println("Clinica run...  (c) demiurg ");
        startClinica.start();
    }
    public void start () throws FileNotFoundException, JsonProcessingException {

            while (exit.equals("no")) {
                System.out.println("Select the action: \n" + "1 - Add client, 2 - Find client, 3 - Find pet, 4 - Rename client, 5 - Delete client, \n "
                        + " 7 - Show all clients and pets " );
                Scanner scanner = new Scanner(System.in);
                switch (Integer.parseInt(scanner.nextLine())) {
                    case 0 : serializable.writeJsonToFile(workingClinic);
                        break;
                    case 1 :  workingClinic.addClient(workingClinic.enterOfKeybord("Enter the client name: "),
                              workingClinic.enterOfKeybord("Enter the pet's name: "),
                              workingClinic.enterOfKeybord("Enter the pet's type: "));
                        break;
                    case 2  : workingClinic.findClient("Name of the client we are looking for: ");
                        break;
                    case 3 : workingClinic.findPet();
                        break;
                    case 4 : workingClinic.renameClient();
                        break;
                    case 5 : workingClinic.deleteClient();
                        break;
                    case 7 : workingClinic.showAllClientsAndPets();
                        break;
                    case 9 : exit = "yes";
                    default:
                }
            }
        }
    }
