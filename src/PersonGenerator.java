import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonGenerator {
    public static void main(String[] args) {
        ArrayList<person> people = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.toString(), "personData.txt");

        boolean done = false;

        String personRec = "";
        String ID = "";
        String firstName = "";
        String lastName = "";
        String title="";
        int YOB = 0;

        do{
            ID=SafeInput.getNonZeroLenString(in, "Enter the ID [6 digits]");
            firstName=SafeInput.getNonZeroLenString(in, "Enter the first name");
            lastName=SafeInput.getNonZeroLenString(in, "Enter the last name");
            title=SafeInput.getNonZeroLenString(in, "Enter the title");
            YOB=SafeInput.getRangedInt(in,"Enter the year of Birth", 1000, 9999);

            personRec=ID + ", " + firstName + ", " + lastName + ", " + title + ", " + YOB;
            person p = new person(firstName,lastName,ID,title,YOB);
            people.add(p);

            done= SafeInput.getYNConfirm(in, "Are you done? ");

        }while(!done);

        for(person p: people)
            System.out.println(p.toString());

        try
        {
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));



            for(person p : people)
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
