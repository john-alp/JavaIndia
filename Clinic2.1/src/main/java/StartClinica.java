
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class StartClinica {
    //WorkingClinic workingClinic = new WorkingClinic();
    WorkingClinic workingClinic;
    Serializable serializable = new Serializable();

    public StartClinica() throws FileNotFoundException, JsonProcessingException {
        workingClinic = serializable.readJohnOfFile();
    }

    public static void main (String[] args) throws FileNotFoundException, JsonProcessingException {
        StartClinica startClinica = new StartClinica();
        System.out.println("Clinica run...  (c) demiurg ");
        startClinica.start();
    }
    public void start () throws FileNotFoundException, JsonProcessingException {

            while (true) {
                System.out.println("Select the action: \n" + "1 - Add client, 7 - Show all clients and pets");
                Scanner scanner = new Scanner(System.in);
                switch (Integer.parseInt(scanner.nextLine())) {
                    case 0 : serializable.writeJsonToFile(workingClinic);
                    case 1 : workingClinic.addClient();
                        break;
                    case 7 :
                        workingClinic.showAllClientsAndPets();
                        break;
                    default:
                }
            }
        }
    }
