package OliverBark;

import java.io.FileWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        menu();
    }

    public static void menu() {

        Scanner input = new Scanner(System.in);
        System.out.println("___//Marios PizzaBar\\\\___");
        System.out.println("Mine valgmuligheder");
        System.out.println("Tast v for vis menu");
        System.out.println("Tast o for opret ordre");
        System.out.println("Tast b for at vise bestillingsliste");
        System.out.println("Tast s for at slette en ordre");

        String s = input.next();

        switch (s) {
            case "v":
                visMenu();
                break;
            case "o":
                opretOrdre();
                break;
            case "b":
                visBestillingsliste();
                break;
            case "s":
                sletOrdre();
                break;


        }

    }

    public static void visMenu() {
        try {
            File menu = new File("src/OliverBark/menuKort.txt");
            Scanner myReader = new Scanner(menu);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void opretOrdre() {
        Scanner console = new Scanner(System.in);

        System.out.println("Indtast tid");
        int tid = console.nextInt();
        System.out.println("Indtast pizza number");
        int pizzaNr = console.nextInt();
        System.out.println("Indtast navn");
        String name = console.next();
        System.out.println("Indtast telefon nr ");
        int tlf = console.nextInt();
        System.out.println("Indtast bestillings nr ");
        int id = console.nextInt();

        Bestilling b1 = new Bestilling(tid, pizzaNr, name, tlf, id);

        System.out.println(b1);
        console.next();

        try {
            File file = new File("src/OliverBark/bestillinger");
            FileWriter fw = new FileWriter(file, true);
            //konverter en int til en string
            fw.append(b1.toString());
            fw.append("\n");

            //close document
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void visBestillingsliste() {


        try {
            File liste = new File("src/OliverBark/bestillinger");
            Scanner listReader = new Scanner(liste);
            while (listReader.hasNextLine()) {
                String input = listReader.nextLine();
                System.out.println(input);
            }
            listReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sletOrdre() {
        /*try {
            Files.delete(Paths.get("src/OliverBark/bestillinger"));
        } catch (NoSuchFileException e) {
            System.out.println("No such file/directory exists");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Ordren er slettet");
*/

        try {
            File inputFile = new File("src/OliverBark/bestillinger");   // Your file
            File tempFile = new File("src/OliverBark/bestillinger1");// temp file

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            Scanner scanner = new Scanner(System.in);
            System.out.println("Indtast navn");
            String navn = scanner.nextLine();

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {

                if (currentLine.contains(navn)) {

                    writer.write(currentLine);
                }

                writer.close();
                boolean successful = tempFile.renameTo(inputFile);
                System.out.println(successful);
            }
            if (inputFile.delete()) {
                // Rename the output file to the input file
                if (!tempFile.renameTo(inputFile)) {
                    throw new IOException("Could not rename " + tempFile + " to " + inputFile);
                }
            } else {
                throw new IOException("Could not delete original input file " + inputFile);
            }
        } catch (IOException ex) {
            // Handle any exceptions
            ex.printStackTrace();

        }
    }
}