import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Scanner;

public class WriteAndReadJson implements Serializable {

    public void writeJsonFile(ClinicWorks clinicWorks) throws JsonProcessingException, FileNotFoundException {
        ObjectMapper objectMapper = new ObjectMapper();
        String result =  objectMapper.writeValueAsString(clinicWorks);
        PrintWriter printWriter = new PrintWriter(new File("jsonFile"));
        printWriter.println(result);
        printWriter.close();
    }
//    public ClinicWorks readJsonFile() throws FileNotFoundException, JsonProcessingException {
//    //ClinicWorks clinicWorks;
//    ObjectMapper objectMapper = new ObjectMapper();
//    File file = new File("jsonFile");
//    Scanner scanner = new Scanner(file);
//      String result = scanner.nextLine();
//      ClinicWorks clinicWorks = objectMapper.readValue(result, ClinicWorks.class);
//        System.out.println(clinicWorks);
//        scanner.close();
//        return clinicWorks;
//    }
}
