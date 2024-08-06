// Alexander Woeste

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIProgram extends JFrame implements ActionListener {


    // Declares file managers
    private StudentFileManager studentFileManager;
    private CourseFileManager courseFileManager;
    private EnrollmentFileManager enrollmentFileManager;
    

    // Declares variables for panels
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private JPanel studentPanel;
    private JPanel viewStudentPanel;
    private JPanel editStudentPanel;
    private JPanel coursePanel;
    private JPanel viewCoursePanel;
    private JPanel editCoursePanel;
    private JPanel enrollmentPanel;
    private JPanel viewEnrollmentPanel;
    private JPanel editEnrollmentPanel;
    private JPanel reportPanel;

    public GUIProgram() {   // Constructor initializes the GUI
        // Initializes file managers
        studentFileManager = new StudentFileManager();
        courseFileManager = new CourseFileManager();
        enrollmentFileManager = new EnrollmentFileManager();

        setTitle("CS 213 Final Project");   // Titles the JFrame
        setSize(750, 750);  // Sets JFrame size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Closes application when window closes

        // Creates main panel and layout
        mainPanel = new JPanel();
        cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);

        // Adds welcome page to main panel
        JLabel welcomeLabel = new JLabel("Welcome to University Enrollment");
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(welcomeLabel, "welcome");

        // Creates panels for adding, viewing, and editing student
        studentPanel = createAddStudentPanel();
        viewStudentPanel = createViewStudentPanel();
        editStudentPanel = createAddStudentPanel();

        // Creates panels for adding, viewing, and editing course
        coursePanel = createAddCoursePanel();
        viewCoursePanel = createViewCoursePanel();
        editCoursePanel = createAddCoursePanel();

        // Create panels for adding, viewing, and editing enrollment
        enrollmentPanel = createAddEnrollmentPanel();
        viewEnrollmentPanel = createViewEnrollmentPanel();
        editEnrollmentPanel = createAddEnrollmentPanel();

        // Create panel for generating report
        reportPanel = createReportPanel();

        // Adds student panels to main panel
        mainPanel.add(studentPanel, "student");
        mainPanel.add(viewStudentPanel, "view student");
        mainPanel.add(editStudentPanel, "edit student");

        // Adds course panels to main panel
        mainPanel.add(viewCoursePanel, "view course");
        mainPanel.add(coursePanel, "course");
        mainPanel.add(editCoursePanel, "edit course");

        // Adds enrollment panels to main panel
        mainPanel.add(viewEnrollmentPanel, "view enrollment");
        mainPanel.add(enrollmentPanel, "enrollment");
        mainPanel.add(editEnrollmentPanel, "edit enrollment");
        
        // Adds report panel to main panel
        mainPanel.add(reportPanel, "generate report");

        setJMenuBar(createMenuBar());   // Creates menu bar

        add(mainPanel); // Adds main panel to the frame
        setVisible(true);   // Makes it visible
    }

    private JMenuBar createMenuBar() {  // Method creates menu bar
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File"); // Creates file menu
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));    // Exit ActionListener exits application
        fileMenu.add(exitItem);

        JMenu studentMenu = new JMenu("Student");   // Creates student menu
        JMenuItem addStudentItem = new JMenuItem("Add Student");
        JMenuItem viewStudentItem = new JMenuItem("View Student");
        JMenuItem editStudentItem = new JMenuItem("Edit Student");
        addStudentItem.addActionListener(this);
        viewStudentItem.addActionListener(this);
        editStudentItem.addActionListener(this);
        studentMenu.add(addStudentItem);
        studentMenu.add(viewStudentItem);
        studentMenu.add(editStudentItem);

        JMenu courseMenu = new JMenu("Course"); // Creates course menu
        JMenuItem addCourseItem = new JMenuItem("Add Course");
        JMenuItem viewCourseItem = new JMenuItem("View Course");
        JMenuItem editCourseItem = new JMenuItem("Edit Course");
        addCourseItem.addActionListener(this);
        viewCourseItem.addActionListener(this);
        editCourseItem.addActionListener(this);
        courseMenu.add(addCourseItem);
        courseMenu.add(viewCourseItem);
        courseMenu.add(editCourseItem);

        JMenu enrollmentMenu = new JMenu("Enrollment"); // Creates enrollment menu
        JMenuItem addEnrollmentItem = new JMenuItem("Add Enrollment");
        JMenuItem viewEnrollmentItem = new JMenuItem("View Enrollment");
        JMenuItem editEnrollmentItem = new JMenuItem("Edit Enrollment");
        addEnrollmentItem.addActionListener(this);
        viewEnrollmentItem.addActionListener(this);
        editEnrollmentItem.addActionListener(this);
        enrollmentMenu.add(addEnrollmentItem);
        enrollmentMenu.add(viewEnrollmentItem);
        enrollmentMenu.add(editEnrollmentItem);

        JMenu reportMenu = new JMenu("Reports");   // Creates reports menu
        JMenuItem addReportItem = new JMenuItem("Generate Report");
        addReportItem.addActionListener(this);
        reportMenu.add(addReportItem);

        // Adds menus to the bar
        menuBar.add(fileMenu);
        menuBar.add(studentMenu);
        menuBar.add(courseMenu);
        menuBar.add(enrollmentMenu);
        menuBar.add(reportMenu);

        return menuBar;
    }

    private JPanel createAddStudentPanel() {    // Method creates panel for adding student
        // Configures panel
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;  // Specifies the column index
        gbc.gridy = 0;  // Specifies the row index
        gbc.insets = new Insets(5, 5, 5, 5);

        panel.add(new JLabel("New Student Information"), gbc);

        gbc.gridy++;    // Increments row
        panel.add(new JLabel("Student ID:"), gbc);
        gbc.gridx++;    // Increments column
        JTextField studentIdField = createFixedSizeTextField(20);
        panel.add(studentIdField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("First Name:"), gbc);
        gbc.gridx++;
        JTextField firstNameField = createFixedSizeTextField(20);
        panel.add(firstNameField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("Last Name:"), gbc);
        gbc.gridx++;
        JTextField lastNameField = createFixedSizeTextField(20);
        panel.add(lastNameField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("Address:"), gbc);
        gbc.gridx++;
        JTextField addressField = createFixedSizeTextField(20);
        panel.add(addressField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("City:"), gbc);
        gbc.gridx++;
        JTextField cityField = createFixedSizeTextField(20);
        panel.add(cityField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("State:"), gbc);
        gbc.gridx++;
        String[] states = {"", "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};
        JComboBox<String> stateComboBox = new JComboBox<>(states);  // Declares combo box and fills with array of strings
        panel.add(stateComboBox, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("Zip Code:"), gbc);
        gbc.gridx++;
        JTextField zipField = createFixedSizeTextField(20);
        panel.add(zipField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        JButton submitButton = new JButton("Create Student");   // Creates Create Student button
        submitButton.addActionListener(new ActionListener() {   // Triggers when button is clicked 
            public void actionPerformed(ActionEvent e) {    // Retrieves student info from input fields 
                int id = Integer.parseInt(studentIdField.getText());
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String address = addressField.getText();
                String city = cityField.getText();
                String state = (String) stateComboBox.getSelectedItem();
                String zip = zipField.getText();

                if (studentFileManager.addStudent(id, firstName, lastName, address, city, state, zip)) {    // Adds student
                    JOptionPane.showMessageDialog(null, "Student added");   // Displays confirmation
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to add student");   // Displays error
                }
            }
        });
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(submitButton, gbc);

        return panel;
    }

    private JPanel createViewStudentPanel() {   // Method creates panel for viewing student
        // Configures panel
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
    
        panel.add(new JLabel("View Student Information"), gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("Student ID:"), gbc);
        gbc.gridx++;
        JTextField studentIdField = createFixedSizeTextField(20);
        panel.add(studentIdField, gbc);
    
        gbc.gridx++;
        JButton searchButton = new JButton("Search");   // Search button
        panel.add(searchButton, gbc);
    
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("First Name:"), gbc);
        gbc.gridx++;
        JTextField firstNameField = createFixedSizeTextField(20);
        firstNameField.setEditable(false); // Makes field not editable
        panel.add(firstNameField, gbc);
    
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("Last Name:"), gbc);
        gbc.gridx++;
        JTextField lastNameField = createFixedSizeTextField(20);
        lastNameField.setEditable(false);
        panel.add(lastNameField, gbc);
    
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("Address:"), gbc);
        gbc.gridx++;
        JTextField addressField = createFixedSizeTextField(20);
        addressField.setEditable(false);
        panel.add(addressField, gbc);
    
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("City:"), gbc);
        gbc.gridx++;
        JTextField cityField = createFixedSizeTextField(20);
        cityField.setEditable(false);
        panel.add(cityField, gbc);
    
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("State:"), gbc);
        gbc.gridx++;
        JTextField stateField = createFixedSizeTextField(20);
        stateField.setEditable(false);
        panel.add(stateField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("Zip Code:"), gbc);
        gbc.gridx++;
        JTextField zipCodeField = createFixedSizeTextField(20);
        zipCodeField.setEditable(false);
        panel.add(zipCodeField, gbc);

        searchButton.addActionListener(new ActionListener() {   // Triggers when button is clicked
            public void actionPerformed(ActionEvent e) {
                String idText = studentIdField.getText();   // Retrieves ID from input field
                int id = Integer.parseInt(idText);  // Converts text to integer
                Student student = studentFileManager.getStudent(id);    // Parses for mathcing student ID
                if (student != null) {
                    // Sets input fields with student info
                    firstNameField.setText(student.getFirstName());
                    lastNameField.setText(student.getLastName());
                    addressField.setText(student.getAddress());
                    cityField.setText(student.getCity());
                    stateField.setText(student.getState());
                    zipCodeField.setText(student.getZip());
                } else {
                    JOptionPane.showMessageDialog(panel, "No student found with ID: " + id);    // Displays if no students found
                }
            }
        });
    
        return panel;
    }

    private JPanel createEditStudentPanel() {   // Method creates panel for editing student
        // Configures panel
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
    
        panel.add(new JLabel("Edit Student Information"), gbc);
    
        gbc.gridy++;
        panel.add(new JLabel("Student ID:"), gbc);
        gbc.gridx++;
        JTextField studentIdField = createFixedSizeTextField(20);
        panel.add(studentIdField, gbc);

        gbc.gridx++;
        JButton searchButton = new JButton("Search");   // Search button
        panel.add(searchButton, gbc);
    
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("First Name:"), gbc);
        gbc.gridx++;
        JTextField firstNameField = createFixedSizeTextField(20);
        panel.add(firstNameField, gbc);
    
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("Last Name:"), gbc);
        gbc.gridx++;
        JTextField lastNameField = createFixedSizeTextField(20);
        panel.add(lastNameField, gbc);
    
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("Address:"), gbc);
        gbc.gridx++;
        JTextField addressField = createFixedSizeTextField(20);
        panel.add(addressField, gbc);
    
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("City:"), gbc);
        gbc.gridx++;
        JTextField cityField = createFixedSizeTextField(20);
        panel.add(cityField, gbc);
    
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("State:"), gbc);
        gbc.gridx++;
        String[] states = {"", "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};
        JComboBox<String> stateComboBox = new JComboBox<>(states);
        panel.add(stateComboBox, gbc);
    
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("Zip Code:"), gbc);
        gbc.gridx++;
        JTextField zipField = createFixedSizeTextField(20);
        panel.add(zipField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
    
        searchButton.addActionListener(new ActionListener() {   // Triggers when button is clicked
            public void actionPerformed(ActionEvent e) {
                String idText = studentIdField.getText(); // Retrieves ID from input field
                try {
                int id = Integer.parseInt(idText);  // Converts text to integer
                Student student = studentFileManager.getStudent(id);    // Parses for mathcing student ID
                if (student != null) {
                    // Sets input fields with student info
                    firstNameField.setText(student.getFirstName());
                    lastNameField.setText(student.getLastName());
                    addressField.setText(student.getAddress());
                    cityField.setText(student.getCity());
                    stateComboBox.setSelectedItem(student.getState());
                    zipField.setText(student.getZip());
                    studentIdField.setEditable(false);  // Sets field uneditable if search successful
                } else {
                    JOptionPane.showMessageDialog(panel, "No student found with ID: " + id);    // Displays if no students found
                    studentIdField.setEditable(true);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(panel, "Invalid student ID");
            }
            }
        });

        JButton updateButton = new JButton("Update");   // Update button
        panel.add(updateButton, gbc);

        updateButton.addActionListener(new ActionListener() {   // Triggers when button is clicked
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(studentIdField.getText());    // Retrieves student info from input fields 
                    String firstName = firstNameField.getText();
                    String lastName = lastNameField.getText();
                    String address = addressField.getText();
                    String city = cityField.getText();
                    String state = (String) stateComboBox.getSelectedItem();
                    String zip = zipField.getText();

                    if (studentFileManager.updateStudent(id, firstName, lastName, address, city, state, zip)) { // Updates student
                        JOptionPane.showMessageDialog(null, "Student updated"); // Displays confirmation
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to update student");    
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error Invalid ID");
                }
            }
        });

        return panel;
    }

    private JPanel createAddCoursePanel() {     // Method creates panel for adding course
        // Configures panel
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);

        panel.add(new JLabel("New Course Information"), gbc);
    
        gbc.gridy++;
        panel.add(new JLabel("Course ID:"), gbc);
        gbc.gridx++;
        JTextField courseIdField = createFixedSizeTextField(20);
        panel.add(courseIdField, gbc);
    
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("Course Name:"), gbc);
        gbc.gridx++;
        JTextField courseNameField = createFixedSizeTextField(20);
        panel.add(courseNameField, gbc);
    
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("Department:"), gbc);
        gbc.gridx++;
        String[] departments = {"", "Art", "Business", "Co Sci", "English", "History", "Math", "Science"};
        JComboBox<String> departmentComboBox = new JComboBox<>(departments);
        panel.add(departmentComboBox, gbc);
    
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("Course Number:"), gbc);
        gbc.gridx++;
        JTextField courseNumberField = createFixedSizeTextField(20);
        panel.add(courseNumberField, gbc);
    
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("Instructor Name:"), gbc);
        gbc.gridx++;
        JTextField instructorNameField = createFixedSizeTextField(20);
        panel.add(instructorNameField, gbc);
    
        gbc.gridy++;
        gbc.gridx = 0;

        JButton submitButton = new JButton("Create Course");    // Creates Create Course Button
        submitButton.addActionListener(new ActionListener() {   // Triggers when button is clicked
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(courseIdField.getText()); // Retrieves course info from input fields
                    String name = courseNameField.getText();
                    String department = (String) departmentComboBox.getSelectedItem();
                    String number = courseNumberField.getText();
                    String instructor = instructorNameField.getText();

                    if (courseFileManager.addCourse(id, name, department, number, instructor)) {    // Adds course
                        JOptionPane.showMessageDialog(null, "Course added");    // Displays confirmation
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to add course");    // Displays error
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error adding course: " + ex.getMessage()); // Handles errors
                }
            }
        });
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(submitButton, gbc);
    
        return panel;
    }

    private JPanel createViewCoursePanel() {    // Method creates panel for viewing course
        // Configures panel
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
    
        panel.add(new JLabel("View Course Information"), gbc);

        gbc.gridy++;
        gbc.gridx = 0;

        panel.add(new JLabel("Course ID:"), gbc);
        gbc.gridx++;
        JTextField courseIdField = createFixedSizeTextField(20);
        panel.add(courseIdField, gbc);

        gbc.gridx++;
        JButton searchButton = new JButton("Search");   // Search button
        panel.add(searchButton, gbc);
    
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("Course Name:"), gbc);
        gbc.gridx++;
        JTextField courseNameField = createFixedSizeTextField(20);
        courseNameField.setEditable(false);
        panel.add(courseNameField, gbc);
    
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("Department:"), gbc);
        gbc.gridx++;
        JTextField departmentField = createFixedSizeTextField(20);
        departmentField.setEditable(false);
        panel.add(departmentField, gbc);
    
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("Course Number:"), gbc);
        gbc.gridx++;
        JTextField courseNumberField = createFixedSizeTextField(20);
        courseNumberField.setEditable(false);
        panel.add(courseNumberField, gbc);
    
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("Instructor Name:"), gbc);
        gbc.gridx++;
        JTextField instructorNameField = createFixedSizeTextField(20);
        instructorNameField.setEditable(false);
        panel.add(instructorNameField, gbc);
    
        searchButton.addActionListener(new ActionListener() {   // Triggers when button is clicked
            public void actionPerformed(ActionEvent e) {
                String idText = courseIdField.getText();    // Retrieves ID from input field
                int id = Integer.parseInt(idText);  // Converts text to integer
                Course course = courseFileManager.getCourse(id);    // Parses for matching course ID
                if (course != null) {
                    // Sets inputs fields with student info
                    courseNameField.setText(course.getName());
                    departmentField.setText(course.getDepartment());
                    courseNumberField.setText(course.getNumber());
                    instructorNameField.setText(course.getInstructor());
                } else {
                    JOptionPane.showMessageDialog(panel, "No course found with ID: " + id); // Displays if no course found
                }
            }
        });

        return panel;
    }

    private JPanel createEditCoursePanel() {    // Method creates panel for editing course
        // Configures panel
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
    
        panel.add(new JLabel("Edit Course Information"), gbc);
    
        gbc.gridy++;
        panel.add(new JLabel("Course ID:"), gbc);
        gbc.gridx++;
        JTextField courseIdField = createFixedSizeTextField(20);
        panel.add(courseIdField, gbc);

        gbc.gridx++;
        JButton searchButton = new JButton("Search");   // Search button
        panel.add(searchButton, gbc);
    
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("Course Name:"), gbc);
        gbc.gridx++;
        JTextField courseNameField = createFixedSizeTextField(20);
        panel.add(courseNameField, gbc);
    
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("Department:"), gbc);
        gbc.gridx++;
        String[] departments = {"", "Art", "Business", "Co Sci", "English", "History", "Math", "Science"}; // Example departments
        JComboBox<String> departmentComboBox = new JComboBox<>(departments);
        panel.add(departmentComboBox, gbc);
    
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("Course Number:"), gbc);
        gbc.gridx++;
        JTextField courseNumberField = createFixedSizeTextField(20);
        panel.add(courseNumberField, gbc);
    
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("Instructor Name:"), gbc);
        gbc.gridx++;
        JTextField instructorNameField = createFixedSizeTextField(20);
        panel.add(instructorNameField, gbc);
    
        gbc.gridy++;
        gbc.gridx = 0;
    
        searchButton.addActionListener(new ActionListener() {   // Triggers when button is clicked
            public void actionPerformed(ActionEvent e) {
                String idText = courseIdField.getText();    // Retrieves ID from input field
                try {
                int id = Integer.parseInt(idText);  // Converts text to integer
                Course course = courseFileManager.getCourse(id);    // Parses for matching course ID
                if (course != null) {
                    // Sets input fields with course info
                    courseNameField.setText(course.getName());
                    departmentComboBox.setSelectedItem(course.getDepartment());
                    courseNumberField.setText(course.getNumber());
                    instructorNameField.setText(course.getInstructor());
                    courseIdField.setEditable(false);   // Sets field uneditable if search successful
                } else {
                    JOptionPane.showMessageDialog(panel, "No course found with ID: " + id); // Displays if no course found
                    courseIdField.setEditable(true);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(panel, "Invalid course ID");
            }
            }
        });

        gbc.gridx = 0;
        gbc.gridy++;
        JButton updateButton = new JButton("Update Course");    // Update button
        panel.add(updateButton, gbc);

        updateButton.addActionListener(new ActionListener() {   // Triggers when button is clicked
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(courseIdField.getText()); // Retrieves course info from input fields
                    String name = courseNameField.getText();
                    String department = (String) departmentComboBox.getSelectedItem();
                    String number = courseNumberField.getText();
                    String instructor = instructorNameField.getText();

                    if (courseFileManager.updateCourse(id, name, department, number, instructor)) { // Updates course
                        JOptionPane.showMessageDialog(null, "Course updated");  // Displays confirmation
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to update course"); // Displays error   
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid course ID");
                }
            }
        });

        return panel;
    }

    private JPanel createAddEnrollmentPanel() { // Method creates panel for adding enrollment
        // Configures panel
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
    
        panel.add(new JLabel("New Enrollment Information"), gbc);
    
        gbc.gridy++;
        panel.add(new JLabel("Enrollment ID:"), gbc);
        gbc.gridx++;
        JTextField enrollmentIdField = createFixedSizeTextField(20);
        panel.add(enrollmentIdField, gbc);
    
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("Student ID:"), gbc);
        gbc.gridx++;
        JTextField studentIdField = createFixedSizeTextField(20);
        panel.add(studentIdField, gbc);
    
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("Course ID:"), gbc);
        gbc.gridx++;
        JTextField courseIdField = createFixedSizeTextField(20);
        panel.add(courseIdField, gbc);
    
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("Year:"), gbc);
        gbc.gridx++;
        JTextField yearField = createFixedSizeTextField(20);
        panel.add(yearField, gbc);
    
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("Semester:"), gbc);
        gbc.gridx++;
        String[] semesters = {"", "Spring", "Summer", "Fall", "Winter"};
        JComboBox<String> semesterComboBox = new JComboBox<>(semesters);
        panel.add(semesterComboBox, gbc);
    
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("Grade:"), gbc);
        gbc.gridx++;
        JTextField gradeField = createFixedSizeTextField(20);
        panel.add(gradeField, gbc);
    
        gbc.gridy++;
        gbc.gridx = 0;
        JButton submitButton = new JButton("Create Enrollment");    // Submit button
        panel.add(submitButton, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        JLabel studentNameLabel = new JLabel();
        panel.add(studentNameLabel, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        JLabel courseNameLabel = new JLabel();
        panel.add(courseNameLabel, gbc);

        studentIdField.addActionListener(e -> {
            int studentId = Integer.parseInt(studentIdField.getText()); // Parses student ID
            Student student = studentFileManager.getStudent(studentId); // Retrieves student object by ID
            if (student != null) {
                studentNameLabel.setText("Student Name: " + student.getStudentFullName());  // Displays if found
            } else {
                studentNameLabel.setText("Student not found");  // Displays not found
            }
        });

        courseIdField.addActionListener(e -> {
            int courseId = Integer.parseInt(courseIdField.getText());   // Parses course ID
            Course course = courseFileManager.getCourse(courseId);  // Retirves course object by ID
            if (course != null) {
                courseNameLabel.setText("Course Name: " + course.getName());    // Displays if found
            } else {
                courseNameLabel.setText("Course not found");    // Displays not found
            }
        });
    
        submitButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(enrollmentIdField.getText()); // Retrieves enrollment info from input fields
                int studentId = Integer.parseInt(studentIdField.getText());
                int courseId = Integer.parseInt(courseIdField.getText());
                int year = Integer.parseInt(yearField.getText());
                String semester = (String) semesterComboBox.getSelectedItem();
                char grade = gradeField.getText().charAt(0);

                Student student = studentFileManager.getStudent(studentId);
                Course course = courseFileManager.getCourse(courseId);
    
                if (student != null && course != null) {    // Checks if student and course exist
                    if (enrollmentFileManager.addEnrollment(id, studentId, courseId, year, semester, grade, student.getStudentFullName(), course.getName())) {  // Adds enrollment
                        studentNameLabel.setText("Student: " + student.getStudentFullName());   // Displays student name
                        courseNameLabel.setText("Course: " + course.getName()); // Displays course name
                        JOptionPane.showMessageDialog(panel, "Enrollment added successfully."); // Displays confirmation
                    } else {
                        JOptionPane.showMessageDialog(panel, "Failed to add enrollment.");
                    }
                } else {
                    JOptionPane.showMessageDialog(panel, "Invalid student ID or course ID.");   // Displays if no student or course exist
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(panel, "Please ensure all fields are correctly filled and IDs are numeric.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Error adding enrollment: " + ex.getMessage());
            }
        });
    
        return panel;
    }

    private JPanel createViewEnrollmentPanel() { // Method creates panel for viewing enrollment
        // Configures panel
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
    
        panel.add(new JLabel("View Enrollment Information"), gbc);
    
        gbc.gridy++;
        panel.add(new JLabel("Enrollment ID:"), gbc);
        gbc.gridx++;
        JTextField enrollmentIdField = createFixedSizeTextField(20);
        panel.add(enrollmentIdField, gbc);
    
        gbc.gridx++;
        JButton searchButton = new JButton("Search");   // Search button
        panel.add(searchButton, gbc);
    
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("Student ID:"), gbc);
        gbc.gridx++;
        JTextField studentIdField = createFixedSizeTextField(20);
        studentIdField.setEditable(false);
        panel.add(studentIdField, gbc);
    
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("Course ID:"), gbc);
        gbc.gridx++;
        JTextField courseIdField = createFixedSizeTextField(20);
        courseIdField.setEditable(false);
        panel.add(courseIdField, gbc);
    
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("Year:"), gbc);
        gbc.gridx++;
        JTextField yearField = createFixedSizeTextField(20);
        yearField.setEditable(false);
        panel.add(yearField, gbc);
    
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("Semester:"), gbc);
        gbc.gridx++;
        JTextField semesterField = createFixedSizeTextField(20);
        semesterField.setEditable(false);
        panel.add(semesterField, gbc);
    
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("Grade:"), gbc);
        gbc.gridx++;
        JTextField gradeField = createFixedSizeTextField(20);
        gradeField.setEditable(false);
        panel.add(gradeField, gbc);

        searchButton.addActionListener(new ActionListener() {   // Triggers when button is clicked
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(enrollmentIdField.getText());
                    Enrollment enrollment = enrollmentFileManager.getEnrollmentById(id);    // Parses for macthing enrollment ID
                    if (enrollment != null) {
                        studentIdField.setText(String.valueOf(enrollment.getStudentId()));  // Sets input fields with enrollment info
                        courseIdField.setText(String.valueOf(enrollment.getCourseId()));
                        yearField.setText(String.valueOf(enrollment.getYear()));
                        semesterField.setText(enrollment.getSemester());
                        gradeField.setText(String.valueOf(enrollment.getGrade()));
                    } else {
                        JOptionPane.showMessageDialog(panel, "No enrollment found with ID: " + id); // Displays if no enrollment found
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel, "Please enter a valid ID.");
                }
            }
        });
    
        return panel;
    }

    private JPanel createEditEnrollmentPanel() {    // Method creates panel for editing enrollment
        // Configures panel
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
    
        panel.add(new JLabel("Edit Enrollment Information"), gbc);
    
        gbc.gridy++;
        panel.add(new JLabel("Enrollment ID:"), gbc);
        gbc.gridx++;
        JTextField enrollmentIdField = createFixedSizeTextField(20);
        panel.add(enrollmentIdField, gbc);

        gbc.gridx++;
        JButton searchButton = new JButton("Search");   // Search button
        panel.add(searchButton, gbc);
    
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("Student ID:"), gbc);
        gbc.gridx++;
        JTextField studentIdField = createFixedSizeTextField(20);
        panel.add(studentIdField, gbc);
    
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("Course ID:"), gbc);
        gbc.gridx++;
        JTextField courseIdField = createFixedSizeTextField(20);
        panel.add(courseIdField, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("Year:"), gbc);
        gbc.gridx++;
        JTextField yearField = createFixedSizeTextField(20);
        panel.add(yearField, gbc);
    
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("Semester:"), gbc);
        gbc.gridx++;
        String[] semesters = {"", "Spring", "Summer", "Fall", "Winter"};
        JComboBox<String> semesterComboBox = new JComboBox<>(semesters);
        panel.add(semesterComboBox, gbc);
    
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("Grade:"), gbc);
        gbc.gridx++;
        JTextField gradeField = createFixedSizeTextField(20);
        panel.add(gradeField, gbc);
    
        gbc.gridy++;
        gbc.gridx = 0;
        JButton updateButton = new JButton("Update Enrollment");    // Update button
        panel.add(updateButton, gbc);

        searchButton.addActionListener(new ActionListener() {   // Triggers when button is clicked
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(enrollmentIdField.getText());
                    Enrollment enrollment = enrollmentFileManager.getEnrollmentById(id);    // Parses for matching enrollment ID
                    if (enrollment != null) {
                        // Sets input fields with student info
                        studentIdField.setText(Integer.toString(enrollment.getStudentId()));
                        courseIdField.setText(Integer.toString(enrollment.getCourseId()));
                        yearField.setText(Integer.toString(enrollment.getYear()));
                        semesterComboBox.setSelectedItem(enrollment.getSemester());
                        gradeField.setText(Character.toString(enrollment.getGrade()));
                        enrollmentIdField.setEditable(false);   // Sets field uneditable if search successful
                    } else {
                        JOptionPane.showMessageDialog(panel, "No enrollment found with ID: " + id); // Displays if no enrollments found
                        enrollmentIdField.setEditable(true);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel, "Invalid enrollment ID");
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {   // Triggers when button is clicked
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(enrollmentIdField.getText()); // Retrieves enrollment info from input fields
                    int studentId = Integer.parseInt(studentIdField.getText());
                    int courseId = Integer.parseInt(courseIdField.getText());
                    int year = Integer.parseInt(yearField.getText());
                    String semester = (String) semesterComboBox.getSelectedItem();
                    char grade = gradeField.getText().charAt(0);

                    if (enrollmentFileManager.updateEnrollment(id, studentId, courseId, year, semester, grade)) {   // Update enrollment
                        JOptionPane.showMessageDialog(panel, "Enrollment updated");    // Displays confirmation
                    } else {
                        JOptionPane.showMessageDialog(panel, "Failed to update enrollment");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel, "Error updating enrollment: " + ex.getMessage());
                }
            }
        });

        return panel;
    }

    private JPanel createReportPanel() {    // Method creates panel for generating report
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
    
        panel.add(new JLabel("Year:"), gbc);
        JTextField yearField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(yearField, gbc);
    
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Semester:"), gbc);
        JComboBox<String> semesterComboBox = new JComboBox<>(new String[]{" ", "Spring", "Summer", "Fall", "Winter"});
        gbc.gridx = 1;
        panel.add(semesterComboBox, gbc);
    
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Course Name:"), gbc);
        JTextField courseNameField = new JTextField(20);
        gbc.gridx = 1;
        panel.add(courseNameField, gbc);
    
        gbc.gridx = 0;
        gbc.gridy++;
        JButton generateReportButton = new JButton("Generate Report");  // Generate report button
        panel.add(generateReportButton, gbc);
    
        JTextArea reportArea = new JTextArea(20, 50);   // Creates area to display report
        reportArea.setEditable(false);
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        panel.add(new JScrollPane(reportArea), gbc);    // Adds scroll pane
    
        generateReportButton.addActionListener(e -> {
            // Retrieves input values
            String year = yearField.getText();
            String semester = (String) semesterComboBox.getSelectedItem();
            String courseName = courseNameField.getText();
            if (enrollmentFileManager != null) {    // Checks if enrollmentFileManager is there
                String report = enrollmentFileManager.generateReport(year, semester, courseName); // Generates report using parameters
                reportArea.setText(report); // Generates report in created area
            } else {
                reportArea.setText("Failed generating report"); // Displays error
            }
        });
    
        return panel;
    }

    private JTextField createFixedSizeTextField(int columns) {  // Method creates text field with fixed size
        JTextField textField = new JTextField(columns);
        Dimension preferredSize = textField.getPreferredSize();
        preferredSize.width = 20; // Sets the desired width
        textField.setPreferredSize(preferredSize);
        return textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {    // Method for ActionListener to handle clicks
        switch (e.getActionCommand()) {
            case "Add Student":
                cardLayout.show(mainPanel, "student");
                break;
            case "View Student":
                cardLayout.show(mainPanel, "view student");
                break;
            case "Edit Student":
                editStudentPanel = createEditStudentPanel(); // Creates edit student panel
                mainPanel.add(editStudentPanel, "edit student"); // Adds it to main panel
                cardLayout.show(mainPanel, "edit student"); // Shows edit student panel
                break;
            case "Add Course":
                cardLayout.show(mainPanel, "course");
                break;
            case "View Course":
                cardLayout.show(mainPanel, "view course");
                break;
            case "Edit Course":
                editCoursePanel = createEditCoursePanel(); // Creates edit course panel
                mainPanel.add(editCoursePanel, "edit course"); // Adds it to main panel
                cardLayout.show(mainPanel, "edit course"); // Shows edit course panel
                break;
            case "Add Enrollment":
                cardLayout.show(mainPanel, "enrollment");
                break;
            case "View Enrollment":
                cardLayout.show(mainPanel, "view enrollment");
                break;
            case "Edit Enrollment":
                editEnrollmentPanel = createEditEnrollmentPanel(); // Creates edit enrollment panel
                mainPanel.add(editEnrollmentPanel, "edit enrollment"); // Adds it to main panel
                cardLayout.show(mainPanel, "edit enrollment"); // Shows edit enrollment panel
                break;
            case "Generate Report":
                cardLayout.show(mainPanel, "generate report");
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {
        new GUIProgram();   // Creates instance for the GUIPorgram class
    }
}