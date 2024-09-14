
public class Member {

    private int idNumber;
    private String firstName;
    private String lastName;
    private int yearJoined;
    private double monthlyDues;
    private int age;

    public Member(int idNumber, String firstName, String lastName, int yearJoined, double monthlyDues, int age) {
        this.idNumber = idNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearJoined = yearJoined;
        this.monthlyDues = monthlyDues;
        this.age = age;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getYearJoined() {
        return yearJoined;
    }

    public double getMonthlyDues() {
        return monthlyDues;
    }

    public int getAge() {
        return age;
    }
}
