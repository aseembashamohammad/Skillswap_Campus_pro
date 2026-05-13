import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class skillservice {

    ArrayList<students> students = new ArrayList<>();

    void addStudent(students s) {
        students.add(s);
        System.out.println("Student Added Successfully");
    }

    void displayStudents() {
        for(students s : students) {
            s.displayStudent();
        }
    }

    void searchSkill(String skill) {

        int found = 0;

        for(students s : students) {

            if(s.skill.equalsIgnoreCase(skill)) {
                System.out.println("Mentor Found");
                s.displayStudent();
                found = 1;
            }
        }

        if(found == 0) {
            System.out.println("No Mentor Found");
        }
    }

    void sendRequest(String name) {

        int found = 0;

        for(students s : students) {

            if(s.name.equalsIgnoreCase(name)) {
                System.out.println("Request Sent Successfully To " + s.name);
                found = 1;
            }
        }

        if(found == 0) {
            System.out.println("Mentor Not Found");
        }
    }

    void deleteStudent(String id) {

        int found = 0;

        for(int i = 0; i < students.size(); i++) {

            if(students.get(i).id.equalsIgnoreCase(id)) {

                students.remove(i);
                System.out.println("Student Deleted Successfully");
                found = 1;
                break;
            }
        }

        if(found == 0) {
            System.out.println("Student Not Found");
        }
    }

    void updateStudent(String id) {

        Scanner sc = new Scanner(System.in);

        int found = 0;

        for(students s : students) {

            if(s.id.equalsIgnoreCase(id)) {

                System.out.print("Enter New Name : ");
                s.name = sc.nextLine();

                System.out.print("Enter New Skill : ");
                s.skill = sc.nextLine();

                System.out.println("Student Updated Successfully");
                found = 1;
                break;
            }
        }

        if(found == 0) {
            System.out.println("Student Not Found");
        }
    }

    // SAVE DATA TO FILE
    void saveToFile() {

        try {

            FileWriter fw = new FileWriter("students.txt");

            for(students s : students) {

                fw.write(s.id + "," + s.name + "," + s.skill + "\n");
            }

            fw.close();

            System.out.println("Data Saved Successfully");

        } catch(Exception e) {
            System.out.println("Error Saving File");
        }
    }

    // LOAD DATA FROM FILE
    void loadFromFile() {

        try {

            File file = new File("students.txt");

            if(!file.exists()) return;

            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;

            while((line = br.readLine()) != null) {

                String[] data = line.split(",");

                students s = new students(data[0], data[1], data[2]);

                students.add(s);
            }

            br.close();

        } catch(Exception e) {
            System.out.println("Error Loading File");
        }
    }
}