// Alexander Woeste

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class StudentFileManager {
    private ArrayList<Student> students;    // Declares array to hold student objects
    private static final String STUDENT_FILE = "Students.txt";  // Declares the file name

    public StudentFileManager() {    // Constructor
        students = new ArrayList<>();
        loadStudents();  // Load students on initialization
    }

    private void loadStudents() {
        File file = new File(STUDENT_FILE);
        if (!file.exists()) {
            return; // Exit if the file doesn't exist
        }
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) { // Loops through all existing lines
                String[] parts = fileScanner.nextLine().split(","); // Splits current line by commas and stores in array
                if (parts.length == 7) {    // Checks if has 7 parts
                    int id = Integer.parseInt(parts[0]);
                    String firstName = parts[1];
                    String lastName = parts[2];
                    String address = parts[3];
                    String city = parts[4];
                    String state = parts[5];
                    String zip = parts[6];
                    students.add(new Student(id, firstName, lastName, address, city, state, zip));  // Creates student object and adds to list
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    
    public Student getStudent(int id) { // Retrieves student from ID
            return students.stream()    // Converts list into stream
                        .filter(student -> student.getId() == id)    // Filters only matching ID
                        .findFirst() // Returns Optional
                        .orElse(null);  // Returns null if no student matches ID
        }

    public boolean addStudent(int id, String firstName, String lastName, String address, String city, String state, String zip) {
        if (getStudent(id) == null) {
            students.add(new Student(id, firstName, lastName, address, city, state, zip));
            writeToFile();
            return true;
        } else {
            System.out.println("Student with ID " + id + " already exists.");
            return false;
        }
    }

    public boolean updateStudent(int id, String firstName, String lastName, String address, String city, String state, String zip) {    // Updates student
        Student student = getStudent(id);   // Retrieves student with matching ID
        if (student != null) {  // Checks if student exist
            // Updates student details
            student.setFirstName(firstName);
            student.setLastName(lastName);
            student.setAddress(address);
            student.setCity(city);
            student.setState(state);
            student.setZip(zip);
            writeToFile();  // Updates file
            return true;
        } else {
        System.out.println("Student with id " + id + " not found."); // Prompts no sid was found
        }
        return false;
    }

    private void writeToFile() {
        try (PrintWriter outputFile = new PrintWriter(new FileWriter(STUDENT_FILE))) {
            for (Student student : students) {
                outputFile.println(student.getId() + "," + student.getFirstName() + "," + student.getLastName() + "," +
                                   student.getAddress() + "," + student.getCity() + "," + student.getState() + "," + student.getZip());
            }
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}