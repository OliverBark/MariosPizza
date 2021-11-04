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

    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) throws IOException {

    while (true)

        menu();
    }

    public static void menu() throws IOException {

        Scanner input = new Scanner(System.in);



        System.out.println("___//Marios PizzaBar\\\\___");
        System.out.println("Dine valgmuligheder");
        System.out.println("Tast v for at se vores menu");
        System.out.println("Tast o for at oprette din ordre");
        System.out.println("Tast b for at vise bestillingsliste");
        System.out.println("Tast s for at slette en ordre");
        System.out.println("Tast e for at afslutte din bestilling");


        String s = input.next();
        switch (s) {
            case "v" -> visMenu();
            case "o" -> opretOrdre();
            case "b" -> visBestillingsliste();
            case "s" -> sletOrdre();
            case "e" -> afslutOrdre();
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
        int id = 1;
        id++;
        System.out.println("Du har fået ordrenummer: " + id) ;

        

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

    public static void sletOrdre() throws IOException{

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

        System.out.println("Indtast dit ordrenummer");


        Scanner input = new Scanner(System.in);
        File inputFile = new File("src/OliverBark/bestillinger");
        File tempFile = new File("src/OliverBark/nybestillinger");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        int lineToRemove = input.nextInt();
        String currentLine;
        int count = 0;

        while ((currentLine = reader.readLine()) != null) {
            count++;
            if (count == lineToRemove) {
                continue;
            }
            writer.write(currentLine + System.getProperty("line.separator"));
        }
        writer.close();
        reader.close();
        inputFile.delete();
        tempFile.renameTo(inputFile);

        System.out.println("Ordren er slettet");
        System.out.println("\nHer er den nye bestillingsliste");

        try {
            File menu = new File("src/OliverBark/bestillinger");
            Scanner myReader1 = new Scanner(menu);
            while (myReader1.hasNextLine()) {
                String data = myReader1.nextLine();
                System.out.println(data);
            }
            myReader1.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(" ");

    }
    public static void afslutOrdre() {
        System.out.println("Tak for at handle hos Marios Pizza, din ordre kommer på det ønskede tidspunkt");
        System.exit(0);
    }
}



