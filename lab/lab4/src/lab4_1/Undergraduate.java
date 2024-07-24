package lab4_1;

import java.util.Objects;

public class Undergraduate extends Student{

    UndergraduateCourse course = new UndergraduateCourse();
    public Undergraduate(String id, String name, int className) {
        super(id, name, className);
        AddRequiredCourse(course.requiredCourse_1, course.requiredCourse_2);
    }

    public boolean CourseSelection(String electiveCourses){
        if (Objects.equals(electiveCourses, "q")) {
            System.out.println("选课完成。");
            return true;
        }
        else if(electiveCourses.equals(course.electiveCourses_1) || electiveCourses.equals(course.electiveCourses_2)){
            AddElectiveCourse(electiveCourses);
            return true;
        } else if (getClassList().size() == 4) {
            System.out.println("已经选满课了！");
            return true;
        } else {
            System.out.println("本科生没有这门选修课。");
            return false;
        }
    }

}
