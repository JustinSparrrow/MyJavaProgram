package lab4_1;

public class GraduateCourses extends Course{

    String requiredCourse_1 = "GR1";
    String requiredCourse_2 = "GR2";

    String electiveCourses_1 = "GE1";
    String electiveCourses_2 = "GE2";
    public GraduateCourses(){
        setRequiredCourse_1(requiredCourse_1);
        setRequiredCourse_2(requiredCourse_2);
        setElectiveCourses_1(electiveCourses_1);
        setElectiveCourses_2(electiveCourses_2);
    }
}
