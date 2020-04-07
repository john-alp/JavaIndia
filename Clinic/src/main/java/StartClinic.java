import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.Scanner;

public class StartClinic {
    String exit = "no";
    WriteAndReadJson writeAndReadJson = new WriteAndReadJson();

    public static void main(String[] args) throws IOException {
StartClinic startClinic = new StartClinic();
        System.out.println("Pet clinic...  (c) demiurg");
        startClinic.start();

    }
        public void start() throws IOException {
            ClinicWorks clinicWorks = new ClinicWorks();
            ClinicWorks temp = readJsonFile();
            System.out.println(temp);
//ClinicWorks clinicWorks = new ClinicWorks();
      //      clinicWorks = writeAndReadJson.readJsonFile();
            while (exit.equals("no")) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println();
        System.out.println("Selected action: ");
        System.out.println("1 - add a client, " + " 2 - delete client, " + " 3 - Find client, " + " 4 - Find pet. \n" + "5 - rename client, " + " 6 - rename pet, " +
                "7 - Watch all the clients, " + " 9 - Exit to program...");
        switch (Integer.parseInt(reader.readLine())){
            case 0 : writeAndReadJson.writeJsonFile(clinicWorks);
                break;
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
    public static ClinicWorks readJsonFile() throws FileNotFoundException, JsonProcessingException {
        //ClinicWorks clinicWorks;
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("jsonFile");
        Scanner scanner = new Scanner(file);
        String result = scanner.nextLine();
        ClinicWorks clinicWorks = objectMapper.readValue(result, ClinicWorks.class);
        System.out.println(clinicWorks);
        scanner.close();
        return clinicWorks;
    }
}
