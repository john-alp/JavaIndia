import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Serializable {
    public void writeJsonToFile(WorkingClinic workingClinic) throws JsonProcessingException, FileNotFoundException {
        ObjectMapper objectMapper = new ObjectMapper();
        String result = objectMapper.writeValueAsString(workingClinic);
        File file = new File("JsonFile");
        PrintWriter printWriter = new PrintWriter(file);
        printWriter.println(result);
        printWriter.close();
    }
    public WorkingClinic readJohnOfFile() throws FileNotFoundException, JsonProcessingException {
       WorkingClinic workingClinic = new WorkingClinic();
         ObjectMapper objectMapper = new ObjectMapper();
        Scanner scanner = new Scanner(new File("JsonFile"));
        workingClinic = objectMapper.readValue(scanner.nextLine(), WorkingClinic.class);
        return workingClinic;
}

}
