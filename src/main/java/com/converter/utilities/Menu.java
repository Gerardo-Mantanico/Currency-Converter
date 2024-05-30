package com.converter.utilities;
import com.converter.model.Change;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    ConsultApi consultApi= new ConsultApi();
    Scanner scanner = new Scanner(System.in);
    List<Change> list= new ArrayList<>();
    Record record = new Record();
    public void selectOption(){
        boolean continuar =true;
        while(continuar){
            System.out.println("""
        Bienvendio  al convertidor de monedas!
        Seleccione una opción: 
        1. GTQ a USD 
        2. GTQ a MXN 
        3. USD a GTQ 
        4. USD a MXN 
        5. MXN a GTQ 
        6. MXN a USD 
        7. Otros países 
        8. Historial de conversiones
        9. Salir
          """);
            System.out.print("Opción: ");
            int option= scanner.nextInt();
            switch (option){
                case 1:
                      enterAmount("GTQ", "USD");
                    break;
                case 2:
                    enterAmount("GTQ", "MXN");
                    break;
                case 3:
                    enterAmount("USD", "GTQ");
                    break;
                case 4:
                    enterAmount("USD", "MXN");
                    break;
                case 5:
                    enterAmount("MXN", "GTQ");
                    break;
                case 6:
                    enterAmount("MXN", "USD");
                    break;
                case 7:
                    otherCountries();
                    break;
                case 8:
                    record.save(list);
                    record.read();
                    clear();
                    break;
                case 9:
                    continuar =false;
                    record.save(list);
                    break;
                default:
                    System.out.println("Opcion no valida");
            }

        }
    }

    public void enterAmount(String base , String target){
        System.out.println("Ingrese la cantidad a convertir");
        double amount=scanner.nextDouble();
        Change change= new Change(consultApi.search(base, target,amount),amount);
        list.add(change);
        System.out.println(change.toString());
        clear();
    }

    void otherCountries(){
        System.out.println("Ingrese el nombre del primer país:");
        String fromCountry = scanner.next();
        System.out.println("Ingrese el nombre del segundo país:");
        String toCountry = scanner.next();
        try {
            enterAmount( consultApi.searchCountry(fromCountry), consultApi.searchCountry(toCountry));
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    void clear(){
        try {
            System.out.println("Presione enter para continuar...");
            new java.util.Scanner(System.in).nextLine();
            String sistemaOperativo = System.getProperty("os.name");
            ArrayList<String> comando= new ArrayList<>();
            if(sistemaOperativo.contains("Windows")){
                comando.add("cmd");
                comando.add("/C");
                comando.add("cls");

            } else {
                comando.add("clear");
            }

            ProcessBuilder pb = new ProcessBuilder(comando);
            Process iniciarProceso = pb.inheritIO().start();
            iniciarProceso.waitFor();

        } catch (Exception e) {
            System.out.println("Error al limpiar la pantalla"+e.getMessage());
        }
    }
}
