import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        skillservice service = new skillservice();

        // LOAD DATA
        service.loadFromFile();

        int choice;

        do {

            System.out.println("===== SkillSwap Campus Pro =====");

            System.out.println("1. Register Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Skill");
            System.out.println("4. Send Mentor Request");
            System.out.println("5. Update Student");
            System.out.println("6. Delete Student");
            System.out.println("7. Save Data");
            System.out.println("8. Exit");

            System.out.print("Enter Choice : ");

            choice = sc.nextInt();

            switch(choice) {

                case 1:

                    System.out.print("Enter ID : ");
                    String id = sc.next();

                    sc.nextLine();

                    System.out.print("Enter Name : ");
                    String name = sc.nextLine();

                    System.out.print("Enter Skill : ");
                    String skill = sc.nextLine();

                    students s = new students(id, name, skill);

                    service.addStudent(s);

                    break;

                case 2:

                    service.displayStudents();

                    break;

                case 3:

                    sc.nextLine();

                    System.out.print("Enter Skill To Search : ");

                    String searchSkill = sc.nextLine();

                    service.searchSkill(searchSkill);

                    break;

                case 4:

                    sc.nextLine();

                    System.out.print("Enter Mentor Name : ");

                    String mentorName = sc.nextLine();

                    service.sendRequest(mentorName);

                    break;

                case 5:

                    sc.nextLine();

                    System.out.print("Enter Student ID To Update : ");

                    String updateId = sc.nextLine();

                    service.updateStudent(updateId);

                    break;

                case 6:

                    sc.nextLine();

                    System.out.print("Enter Student ID To Delete : ");

                    String deleteId = sc.nextLine();

                    service.deleteStudent(deleteId);

                    break;

                case 7:

                    service.saveToFile();

                    break;

                case 8:

                    System.out.println("Thank You 👋");

                    break;

                default:

                    System.out.println("Invalid Choice");
            }

        } while(choice != 8);
    }
}