package lab4_1;

import java.util.Objects;

public class GraduateStudent extends Student{
    private String Teacher;

    GraduateCourses courses = new GraduateCourses();

    public GraduateStudent(String id, String name, int className, String teacher) {
        super(id, name, className);
        this.Teacher = teacher;
        AddRequiredCourse(courses.requiredCourse_1, courses.requiredCourse_2);
    }

    public String getTeacher() {
        return Teacher;
    }

    public void setTeacher(String teacher) {
        Teacher = teacher;
    }

    public boolean CourseSelection(String electiveCourses){
        if (Objects.equals(electiveCourses, "q")) {
            System.out.println("选课完成。");
            return true;
        }
        else if(electiveCourses.equals(courses.electiveCourses_1) || electiveCourses.equals(courses.electiveCourses_2)){
            AddElectiveCourse(electiveCourses);
            return true;
        } else if (getClassList().size() == 4) {
            System.out.println("已经选满课了！");
            return true;
        } else {
            System.out.println("研究生没有这门选修课。");
            return false;
        }
    }
}
