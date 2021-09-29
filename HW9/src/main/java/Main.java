import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
    Institute institute=new Institute();
        System.out.println("--------------Part 1--------------");
    Set<String> uniqueCourseSet=institute.getUniqueCoursesForStudents(Arrays.asList("Michele", "Jack"));
        for (String c:uniqueCourseSet) {
            System.out.println(c);
        }
    System.out.println("--------------Part 2--------------");
        String[] inquisitiveStudents=institute.getInquisitiveByStringNames(Arrays.asList("Michele","Jack","Nickole","Moris"));
        for (String s:inquisitiveStudents) {
            System.out.println(s);
        }
    System.out.println("--------------Part 3--------------");
        List<String> studentsForCourse=institute.getStudentsByCourseInString(Arrays.asList("Michele","Jack","Nickole","Moris"),"Sopromat");
        for (String s:studentsForCourse) {
            System.out.println(s);
        }
    }

}
