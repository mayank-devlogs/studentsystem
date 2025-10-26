import java.util.*;

class Student {
    private int id;
    private String name;
    private int age;
    private String course;

    public Student(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getCourse() { return course; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setCourse(String course) { this.course = course; }

    @Override
    public String toString() {
        return String.format("ID: %d | Name: %s | Age: %d | Course: %s", id, name, age, course);
    }
}

class StudentManagementSystem {
    private final List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("✅ Student added successfully!\n");
    }

    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("⚠️ No students found.\n");
            return;
        }
        System.out.println("=== Student List ===");
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println();
    }

    public void updateStudent(int id, String newName, int newAge, String newCourse) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setName(newName);
                s.setAge(newAge);
                s.setCourse(newCourse);
                System.out.println("🔄 Student details updated successfully!\n");
                return;
            }
        }
        System.out.println("❌ Student not found.\n");
    }

    public void deleteStudent(int id) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == id) {
                iterator.remove();
                System.out.println("🗑️ Student deleted successfully!\n");
                return;
            }
        }
        System.out.println("❌ Student not found.\n");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();

        while (true) {
            System.out.println("=== STUDENT MANAGEMENT SYSTEM ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // clear buffer
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    sms.addStudent(new Student(id, name, age, course));
                }
                case 2 -> sms.viewAllStudents();
                case 3 -> {
                    System.out.print("Enter Student ID to Update: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter New Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Course: ");
                    String course = sc.nextLine();

                    sms.updateStudent(id, name, age, course);
                }
                case 4 -> {
                    System.out.print("Enter Student ID to Delete: ");
                    int id = sc.nextInt();
                    sms.deleteStudent(id);
                }
                case 5 -> {
                    System.out.println("👋 Exiting Student Management System. Goodbye!");
                    return;
                }
                default -> System.out.println("⚠️ Invalid choice! Try again.\n");
            }
        }
    }
}
