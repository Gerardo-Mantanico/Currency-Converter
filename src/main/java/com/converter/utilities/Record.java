package com.converter.utilities;
import com.converter.model.Change;
import java.io.*;
import java.util.List;

public class Record {
    private String filePath = "Historial.txt";
    private File file = new File(filePath);

    public void save(List<Change> list){
        try (FileWriter escribir = new FileWriter(file, true)) {
            for (Change items: list){
                escribir.write(items.toString());
            }
        } catch (IOException e) {
            System.err.println("Ocurrió un error al escribir en el archivo: " + e.getMessage());
        }
        list.clear();
    }

    public void read(){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            System.out.println("\t Historial de conversiones");
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }
        System.out.println("\n");
    }

}
