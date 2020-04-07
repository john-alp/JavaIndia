import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WorkClass implements Serializable {
    List <Clients> arrayList = new ArrayList<Clients>(10);

    //case 1
    public void newClientAdd() throws IOException {
        String people = enterKeybord("Enter name: ");
        Pets pet = new Pets("Varya", "Cat");
        Clients clients = new Clients(people, pet);

        arrayList.add(clients);
        System.out.println(arrayList.get(0));
    }
    //case 7
    public void showAllClients(){
        for (int i = 0; i < arrayList.size(); i++){
            System.out.println(arrayList.get(i));
        }
        }
    public static String enterKeybord(String text) throws IOException {
        System.out.println(text);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return bufferedReader.readLine();
    }
}
