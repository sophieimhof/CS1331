import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 *Represents the veternary clinic.
 *
 *@author simhof3
 *@version 1331
 */
public class Clinic {
    /**
    *Creates a clinic.
    */
    private Clinic() { }
    /**
     *Creates a list of appointments from a file with appointment data.
     *
     *@param filename name of file with appointment data
     *
     *@return a list of appointments with appointment data
     */
    public static ArrayList<Appointment> readAppointments(String filename)
            throws FileNotFoundException, ParseException {
        File file = new File(filename);
        Scanner scan = new Scanner(file);
        ArrayList<Appointment> app = new ArrayList<Appointment>();
        String s;
        String[] sArray;
        String petType;
        String name;
        double health;
        int painLevel;
        double droolRate;
        int miceCaught;
        Dog d;
        Cat c;
        int minutes;
        String entryTime;
        String exitTime;
        Appointment a;
        while (scan.hasNextLine()) {
            s = scan.nextLine();
            sArray = s.split(",");
            petType = sArray[0];
            if (petType.equalsIgnoreCase("Dog")) {
                name = sArray[1];
                health = Double.parseDouble(sArray[2]);
                painLevel = Integer.parseInt(sArray[3]);
                droolRate = Double.parseDouble(sArray[4]);
                d = new Dog(name, health, painLevel, droolRate);
                d.speak();
                minutes = d.treat();
                entryTime = sArray[5];
                exitTime = addTime(entryTime, minutes);
                a = new Appointment(d, entryTime, exitTime);
                app.add(a);
            } else if (petType.equalsIgnoreCase("Cat")) {
                name = sArray[1];
                health = Double.parseDouble(sArray[2]);
                painLevel = Integer.parseInt(sArray[3]);
                miceCaught = Integer.parseInt(sArray[4]);
                c = new Cat(name, health, painLevel, miceCaught);
                c.speak();
                minutes = c.treat();
                entryTime = sArray[5];
                exitTime = addTime(entryTime, minutes);
                a = new Appointment(c, entryTime, exitTime);
                app.add(a);
            } else {
                throw new InvalidPetException();
            }
        }
        return app;
    }
    /**
     *Creates a file with appointment list information.
     *
     *@param treated an array list of appointment information
     *@param filename of file to write appointment inforamtion to
     *
     *@return if the file was written successfully
     */
    public static boolean writeTreatedPets(ArrayList<Appointment> treated, String filename) {
        File file = new File(filename);
        try {
            PrintWriter outFile = new PrintWriter(file);
            for (Appointment a : treated) {
                outFile.println(a.toString());
            }
            outFile.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    /**
     *Calculates the exit time for an pet at the clinic.
     *
     *@param entryTime time pet enters clinic
     *@param treatmentTime time it takes to treat the pet
     *
     *@return the exit time of the pet from the clinic
     */
    private static String addTime(String entryTime, int treatmentTime) throws ParseException {
        DateFormat df = new SimpleDateFormat("HHmm");
        Date date = df.parse(entryTime);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, treatmentTime);
        return df.format(calendar.getTime());
    }
}
