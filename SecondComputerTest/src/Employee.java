public class Employee {

    private int id;
    private String name;
    private String section;
    private int jobLevel;

    public Employee(int id, String name, String section, int jobLevel) {
        this.id = id;
        this.name = name;
        this.section = section;
        this.jobLevel = jobLevel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public int getJobLevel() {
        return jobLevel;
    }

    public void setJobLevel(int jobLevel) {
        this.jobLevel = jobLevel;
    }
}
