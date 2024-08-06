// Alexander Woeste

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class CourseFileManager {
    private ArrayList<Course> courses;  // Declares array to hold course objects
    private static final String COURSE_FILE = "Courses.txt";    // Declares the file name


    public CourseFileManager() {    // Constructor 
        courses = new ArrayList<>();
        loadCourses();  // Load courses on initialization
    }

    private void loadCourses() {
        File file = new File(COURSE_FILE);
        if (!file.exists()) {
            return; // Exit if the file doesn't exist
        }
        try (Scanner fileScanner = new Scanner(new File(COURSE_FILE))) {
            while (fileScanner.hasNextLine()) { // Loops through all existing lines
                String[] parts = fileScanner.nextLine().split(","); // Splits current line by commas and stores in array
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                String department = parts[2];
                String number = parts[3];
                String instructor = parts[4];
                courses.add(new Course(id, name, department, number, instructor));  // Creates course object and adds to list
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public Course getCourse(int id) {
            for (Course course : courses) {
                if (course.getId() == id) {
                    return course;
                }
            }
            return null;    // Returns null if no course matches ID
        }

    public boolean addCourse(int id, String name, String department, String number, String instructor) {
        if (getCourse(id) == null) {
            courses.add(new Course(id, name, department, number, instructor));
            writeToFile();
            return true;
        } else {
            System.out.println("Course with ID " + id + " already exists.");
            return false;
        }
    }

    public boolean updateCourse(int id, String name, String department, String number, String instructor) { // Updates course
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId() == id) { // Finds course by ID
                // Updates course details
                courses.get(i).setName(name);
                courses.get(i).setDepartment(department);
                courses.get(i).setNumber(number);
                courses.get(i).setInstructor(instructor);
                writeToFile(); // Updates file
                return true;
            }
        }
        System.out.println("Course with id " + id + " not found."); // Prompts no cid was found
        return false;
    }

    private void writeToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(COURSE_FILE), false)) {
            for (Course course : courses) {
                writer.println(course.getId() + "," + course.getName() + "," + course.getDepartment() + "," + course.getNumber() + "," + course.getInstructor());
            }
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}