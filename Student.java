// Alexander Woeste

class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;

    public Student(int id, String firstName, String lastName, String address, String city, String state, String zip) {  // Constructor
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }


    // Getters and setters
    public int getId() {    
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) { 
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) { 
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getStudentFullName() {
        return firstName + " " + lastName;
    }
}