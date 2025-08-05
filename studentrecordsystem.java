import java.util.ArrayList;
import java.util.Scanner;

// 1. Student class with fields
class Student {
    private int id;
    private String name;
    private double marks;

    // Constructor
    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Getters and Setters (Encapsulation)
    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    public void displayStudent() {
        System.out.println("ID: " + id + " | Name: " + name + " | Marks: " + marks);
    }
}

public class StudentRecordSystem {

    // 2. Use ArrayList to store student objects
    static ArrayList<Student> studentList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- Student Record Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice (1-5): ");
            choice = sc.nextInt();

            // 3. Implement options
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid input! Please enter 1-5.");
            }

        } while (choice != 5);
    }

    // Add student
    static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        Student s = new Student(id, name, marks);
        studentList.add(s);
        System.out.println("✅ Student added successfully!");
    }

    // View all students
    static void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("⚠️ No student records found.");
            return;
        }
        System.out.println("\n--- All Student Records ---");
        for (Student s : studentList) {
            s.displayStudent();
        }
    }

    // Update a student by ID
    static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();
        boolean found = false;

        for (Student s : studentList) {
            if (s.getId() == id) {
                sc.nextLine(); // consume newline
                System.out.print("Enter new name: ");
                String name = sc.nextLine();
                System.out.print("Enter new marks: ");
                double marks = sc.nextDouble();

                s.setName(name);
                s.setMarks(marks);
                System.out.println("✅ Student updated successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("❌ Student ID not found.");
        }
    }

    // Delete student by ID
    static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();
        boolean removed = false;

        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                studentList.remove(i);
                System.out.println("✅ Student deleted successfully!");
                removed = true;
                break;
            }
        }

        if (!removed) {
            System.out.println("❌ Student ID not found.");
        }
    }
}
