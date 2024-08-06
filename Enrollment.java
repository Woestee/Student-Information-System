// Alexander Woeste

class Enrollment {
    private int id;
    private int studentId;
    private int courseId;
    private int year;
    private String semester;
    private char grade;
    private String studentName;
    private String courseName;

    public Enrollment(int id, int studentId, int courseId, int year, String semester, char grade, String studentName, String courseName) {  // Constructor
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.year = year;
        this.semester = semester;
        this.grade = grade;
        this.studentName = studentName;
        this.courseName = courseName;
    }

    // Getter and setter
    public int getId() {
        return id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }
}