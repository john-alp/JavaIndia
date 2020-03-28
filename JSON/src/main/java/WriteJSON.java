import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class WriteJSON {
    public WriteJSON(){}

    public static void main(String[] args) throws IOException {
      WriteJSON writeJSON = new WriteJSON();
      writeJSON.start();
    }

    public void start() throws IOException {
        Clients clients = new Clients();
        ObjectMapper mapper = new ObjectMapper();
      //  ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        // 1 Куда, 2 Что
        //writer.writeValue (new File("jsonFile"), Clients.class);
        String temp = mapper.writeValueAsString(clients);
        PrintWriter printWriter = new PrintWriter(new File("jsonFile"));
        printWriter.println(temp);
        printWriter.close();

    // mapper.writeValue(new File("jsonFile"),Clients.class);
// сама сериализация: 1-куда, 2-что
    //    mapper.writeValue(writer, cat);
    }
}
