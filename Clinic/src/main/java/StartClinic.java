import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StartClinic {
    String exit = "no";
    WriteAndReadJson writeAndReadJson = new WriteAndReadJson();

    public static void main(String[] args) throws IOException {
StartClinic startClinic = new StartClinic();
        System.out.println("Pet clinic...  (c) demiurg");
        startClinic.start();

    }
        public void start() throws IOException {
         //   ClinicWorks clinicWorks = new writeAndReadJson.readJsonFile();
ClinicWorks clinicWorks = new ClinicWorks();
clinicWorks = writeAndReadJson.readJsonFile();
            while (exit.equals("no")) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println();
        System.out.println("Selected action: ");
        System.out.println("1 - add a client, " + " 2 - delete client, " + " 3 - Find client, " + " 4 - Find pet. \n" + "5 - rename client, " + " 6 - rename pet, " +
                "7 - Watch all the clients, " + " 9 - Exit to program...");
        switch (Integer.parseInt(reader.readLine())){
            case 0 : writeAndReadJson.writeJsonFile(clinicWorks);
                break;
            case 11 : writeAndReadJson.readJsonFile();
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
}
