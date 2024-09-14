
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Database gymDatabase = new Database();

        // Reads GymMembers.txt and updates database
        // Note: Skips first line. This assumes that the txt file includes "#IDNumber,FirstName,LastName,YearTheyJoined,Dues,Age"
        try {
            Scanner scanner = new Scanner(new File("GymMembers.txt"));
            scanner.nextLine(); //skips first line
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(",");
                int idNumber = Integer.parseInt(line[0]);
                String firstName = line[1];
                String lastName = line[2];
                int yearJoined = Integer.parseInt(line[3]);
                double monthlyDues = Double.parseDouble(line[4]);
                int age = Integer.parseInt(line[5]);

                // Create a member object with the data and add it to the database
                Member member = new Member(idNumber, firstName, lastName, yearJoined, monthlyDues, age);
                gymDatabase.Add(member);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }

        // Get the info for the member with ID#:1400 and print their info
        Member member = gymDatabase.Find(1400);
        System.out.println(member.getFirstName() + " " + member.getLastName() + ":");
        System.out.println("ID Number: " + member.getIdNumber());
        System.out.println("Year Joined: " + member.getYearJoined());
        System.out.println("Monthly Dues: $" + member.getMonthlyDues());
        System.out.println("Age: " + member.getAge());

        // Print out all the gym members names in alphabetical order of last name
        String sortedNames = gymDatabase.NamesString();
        System.out.println("-----------------------");
        System.out.println("Registered Gym Members:\n" + sortedNames);
    }
}
