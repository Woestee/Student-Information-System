// Alexander Woeste

class Course {
    private int id;
    private String name;
    private String department;
    private String number;
    private String instructor;

    public Course(int id, String name, String department, String number, String instructor) {   // Constructor
        this.id = id;
        this.name = name;
        this.department = department;
        this.number = number;
        this.instructor = instructor;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getNumber() {
        return number;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
}