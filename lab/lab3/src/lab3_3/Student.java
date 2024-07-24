package lab3_3;

public class Student {
    private String ID;
    private String name;
    private int classNumber;
    private String phoneNumber;

    public Student(String ID, String name, int classNumber, String phoneNumber) {
        this.ID = ID;
        this.name = name;
        this.classNumber = classNumber;
        this.phoneNumber = phoneNumber;
    }

    public Student(String ID, String name, int classNumber) {
        this.ID = ID;
        this.name = name;
        this.classNumber = classNumber;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
