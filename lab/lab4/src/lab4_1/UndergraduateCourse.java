package lab4_1;

public class UndergraduateCourse extends Course{
    String requiredCourse_1 = "UR1";
    String requiredCourse_2 = "UR2";

    String electiveCourses_1 = "UE1";
    String electiveCourses_2 = "UE2";
    public UndergraduateCourse(){
        setRequiredCourse_1(requiredCourse_1);
        setRequiredCourse_2(requiredCourse_2);
        setElectiveCourses_1(electiveCourses_1);
        setElectiveCourses_2(electiveCourses_2);
    }
}
