public class students {

    String id;
    String name;
    String skill;

    students(String id, String name, String skill) {

        this.id = id;
        this.name = name;
        this.skill = skill;
    }

    void displayStudent() {

        System.out.println("ID : " + id);
        System.out.println("NAME : " + name);
        System.out.println("SKILL : " + skill);
        System.out.println("----------------------");
    }
}