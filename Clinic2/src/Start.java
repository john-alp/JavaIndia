import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;

public class Start implements Serializable {

    public static void main(String[] args) throws IOException {
        System.out.println("The clinic..\n" + "Choose..");
        WorkClass workClass = new WorkClass();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
         switch (Integer.parseInt(bufferedReader.readLine())){
             case 0 : writeJsonFile(workClass);
             break;
             case 1 : workClass.newClientAdd();
             break;
             case 7 : workClass.showAllClients();
             break;
         }
     }
    }
    public static void writeJsonFile(WorkClass workClass){

    }
}
