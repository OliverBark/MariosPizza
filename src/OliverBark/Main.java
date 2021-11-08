package OliverBark;

import java.io.FileWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        do {
            menu();
        } while (true);
    }

    public static void menu() throws IOException {

        Scanner input = new Scanner(System.in);


        System.out.println("___//Marios PizzaBar\\\\___");
        System.out.println("Dine valgmuligheder");
        System.out.println("Tast m for at se menu");
        System.out.println("Tast o for at oprette ordre");
        System.out.println("Tast b for at vise bestillingsliste");
        System.out.println("Tast s for at slette en ordre");
        System.out.println("Tast h for at hente ordrehisorik");


        String s = input.next();
        switch (s) {
            case "m" -> visMenu();
            case "o" -> opretOrdre();
            case "b" -> visBestillingsliste();
            case "s" -> sletOrdre();
            case "h" -> ordreHistorik();
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

    public static void opretOrdre() throws IOException {
        Scanner console = new Scanner(System.in).useLocale(Locale.ENGLISH);

        System.out.println("Indtast tid (med punktum)");
        double tid = console.nextDouble();
        System.out.println("Indtast pizza nummer");
        int pizzaNr = console.nextInt();
        console.nextLine();
        System.out.println("Indtast navn");
        String name = console.nextLine();
        System.out.println("Indtast telefon nr ");
        int tlf = console.nextInt();
        int id = 0;
        id++;
        System.out.println("Ordrenummer: " + id);


        Bestilling b1 = new Bestilling(tid, pizzaNr, name, tlf, id);

        System.out.println(b1);
        console.next();

        try {
            File file = new File("src/OliverBark/bestillinger");
            FileWriter fw = new FileWriter(file, true);
            fw.append(b1.toString());
            fw.append("\n");
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            File ordreHistorik = new File("src/OliverBark/OrdreHistorik");
            FileWriter fe = new FileWriter(ordreHistorik, true);
            fe.append(b1.toString());
            fe.append("\n");
            fe.close();
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

    public static void sletOrdre() throws IOException { //Fået hjælp af https://stackoverflow.com/questions/1377279/find-a-line-in-a-file-and-remove-it


        try {
            File menu = new File("src/OliverBark/bestillinger");
            Scanner myReader = new Scanner(menu);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Indtast navnet på den ordre der skal slettes");


        Scanner input = new Scanner(System.in);
        File inputFile = new File("src/OliverBark/bestillinger");
        File tempFile = new File("src/OliverBark/nybestillinger");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String lineToRemove = input.nextLine();
        String currentLine;

        while ((currentLine = reader.readLine()) != null) {

            if (currentLine.contains(lineToRemove)) {
                continue;
            }
            writer.write(currentLine + System.getProperty("line.separator"));
        }
        writer.close();
        reader.close();
        inputFile.delete();
        tempFile.renameTo(inputFile);

        System.out.println("Ordren er slettet");
        System.out.println("Her er den nye bestillingsliste");
        System.out.println(" ");
        visBestillingsliste();
        System.out.println(" ");

    }

    public static void ordreHistorik() throws IOException {
        try {
            File ordreHis = new File("src/OliverBark/OrdreHistorik");
            Scanner sc = new Scanner(ordreHis);
            while (sc.hasNextLine()) {
                String input = sc.nextLine();
                System.out.println(input);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("\n\n");
    }
}