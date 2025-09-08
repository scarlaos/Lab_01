import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductGenerator {
    public static void main(String[] args) {
        ArrayList<product> products = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.toString(), "productData.txt");

        boolean done = false;

        String productRec = "";
        String ID = "";
        String Name = "";
        String description = "";
        double cost = 0;
        int quantity = 0;

        do{
            ID=SafeInput.getNonZeroLenString(in, "Enter the ID [6 digits]");
            Name =SafeInput.getNonZeroLenString(in, "Enter the name");
            description =SafeInput.getNonZeroLenString(in, "Enter the description");
            cost =SafeInput.getRangedDouble(in, "Enter the cost",0,100000);
            quantity =SafeInput.getRangedInt(in,"Enter the quantity", 0, 9999);

            productRec =ID + ", " + Name + ", " + description + ", " + cost + ", " + quantity;
            product p = new product(Name, description,ID, cost, quantity);
            products.add(p);

            done= SafeInput.getYNConfirm(in, "Are you done? ");

        }while(!done);

        for(product p: products)
            System.out.println(p.toString());

        try
        {
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));



            for(product p : products)
            {
                writer.write(p.toCSV());

                writer.newLine();

            }
            writer.close();
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

}
