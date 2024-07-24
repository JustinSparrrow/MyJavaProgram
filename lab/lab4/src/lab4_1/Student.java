package lab4_1;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private  String Id;
    private  String Name;
    private  int ClassName;
    private ArrayList<String> classList = new ArrayList<>();

    public Student(String id, String name, int className) {
        Id = id;
        Name = name;
        ClassName = className;
    }

    protected void AddRequiredCourse(String requiredCourse_1, String requiredCourse_2){
        classList.add(requiredCourse_1);
        classList.add(requiredCourse_2);
    }

    protected void AddElectiveCourse(String electiveCourse){
        classList.add(electiveCourse);
        System.out.println("选课成功！");
    }

    public void printClassList(){
        System.out.print(Id+" "+ClassName+" "+Name+"选课信息：");
        for(String course: classList){
            System.out.print(course+"  ");
        }
        System.out.println();
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getClassName() {
        return ClassName;
    }

    public void setClassName(int className) {
        ClassName = className;
    }

    public ArrayList<String> getClassList() {
        return classList;
    }

    public void setClassList(ArrayList<String> classList) {
        this.classList = classList;
    }
}
