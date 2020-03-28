import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadJSON {
    public ReadJSON(){}
    public static void main (String[] args) throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    Scanner scanner = new Scanner(new File("jsonFile"));
    while (scanner.hasNext()) {
        Clients clients = objectMapper.readValue(scanner.nextLine(), Clients.class);


        System.out.println(clients);
    }
        scanner.close();
    }
}