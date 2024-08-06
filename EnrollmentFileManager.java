// Alexander Woeste

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class EnrollmentFileManager {
    private ArrayList<Enrollment> enrollments;  // Declares array to hold course objects
    private static final String ENROLLMENT_FILE = "Enrollments.txt";    // Declares the file name

    public EnrollmentFileManager() {    // Constructor 
        enrollments = new ArrayList<>();
        loadEnrollments();  // Load enrollemtns on initialization
    }

    private void loadEnrollments() {
        File file = new File(ENROLLMENT_FILE);
        if (!file.exists()) {
            return; // Exit if the file doesn't exist
        }
        try (Scanner fileScanner = new Scanner(new File(ENROLLMENT_FILE))) {
            while (fileScanner.hasNextLine()) { // Loops through all existing lines
                String[] parts = fileScanner.nextLine().split(","); // Splits current line by commas and stores in array
                if (parts.length >= 8) {    // Checks if has 8 parts
                    int id = Integer.parseInt(parts[0]);
                    int studentId = Integer.parseInt(parts[1]);
                    int courseId = Integer.parseInt(parts[2]);
                    int year = Integer.parseInt(parts[3]);
                    String semester = parts[4];
                    char grade = parts[5].charAt(0);
                    String studentName = parts[6];
                    String courseName = parts[7];
                    enrollments.add(new Enrollment(id, studentId, courseId, year, semester, grade, studentName, courseName));   // Creates enrollment object and adds to list
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public Enrollment getEnrollmentById(int id) {   // Retireves enrollment from ID
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getId() == id) {
                return enrollment;
            }
        }
        return null; // Returns null if no enrollment matchs ID
    }

    public boolean addEnrollment(int id, int studentId, int courseId, int year, String semester, char grade, String studentName, String courseName) {
        if (!enrollmentExists(id, studentId, courseId)) {
            enrollments.add(new Enrollment(id, studentId, courseId, year, semester, grade, studentName, courseName));
            writeToFile();
            return true;
        } else {
            System.out.println("Enrollment already exists.");
            return false;
        }
    }

    public boolean updateEnrollment(int eid, int studentId, int courseId, int year, String semester, char grade) {  // Updates enrollment
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getId() == eid) {  // Finds enrollment by ID
                // Updates enrollment details
                enrollment.setStudentId(studentId);
                enrollment.setCourseId(courseId);
                enrollment.setYear(year);
                enrollment.setSemester(semester);
                enrollment.setGrade(grade);
                writeToFile();  // Updates file
                return true;
            }
        }
        System.out.println("Enrollment with id " + eid + " not found.");    // Prompts no eid was found
        return false;
    }

    private boolean enrollmentExists(int id, int studentId, int courseId) {
        return enrollments.stream().anyMatch(e -> e.getId() == id && e.getStudentId() == studentId && e.getCourseId() == courseId);
    }

    public String generateReport(String year, String semester, String courseName) { // Generates report for inputted year, semester, and course 
        StringBuilder buildReport = new StringBuilder();
        buildReport.append("Student ID\tName\tGrade\n");    // Report header
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getYear() == Integer.parseInt(year) && enrollment.getSemester().equalsIgnoreCase(semester) && enrollment.getCourseName().equalsIgnoreCase(courseName)) { // Checks if enrollment matches details
                buildReport.append(enrollment.getStudentId()).append("\t").append(enrollment.getStudentName()).append("\t").append(enrollment.getGrade()).append("\n"); // Creates details for report
            }
        }
        return buildReport.toString();  // Returns
    }

    private void writeToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ENROLLMENT_FILE))) {
            for (Enrollment e : enrollments) {
                writer.println(e.getId() + "," + e.getStudentId() + "," + e.getCourseId() + "," + e.getYear() + "," + e.getSemester() + "," + e.getGrade() + "," + e.getStudentName() + "," + e.getCourseName());
            }
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}