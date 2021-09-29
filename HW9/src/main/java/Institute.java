import java.util.*;

public class Institute {
    private List<Student> studentList = new ArrayList<>();
    private List<Course> courseList = new ArrayList<>();
    private List<Student> getStudentList(List<String> studentName){
        List<Student> result=new ArrayList<>();
        for (String sName:studentName) {
            for (Student s:studentList) {
                if (s.getName()==sName){
                    result.add(s);
                }
            }
        }
        return  result;
    }

    private Set<Course> getCourse(List<Student> sl){
        Set<Course> courseSet = new HashSet<>();
        for (Student s:sl) {
            List<Course> cl=s.getAllCourses();
            for (Course c:cl) {
                courseSet.add(c);
            }
        }
        return courseSet;
    }

    public List<String> getStudentsByCourseInString(List<String> sls,String cn){
        Course c=getCourseByName(cn);
        List<Student> sl=getStudentList(sls);
        return getStudentsByCourse(sl,c);
    }

    private Course getCourseByName(String name){
        for (Course c:courseList) {
            if (((Track)c).getName()==name){
                return c;
            }
        }
        return null;
            }

    private List<String> getStudentsByCourse(List<Student> sl,Course c){
        List<String> result=new ArrayList<>();
        for (Student s:sl) {
            List<Course> cl=s.getAllCourses();
            if (cl.contains(c)){
                result.add(s.getName());
            }
        }
        return result;
    }

    public String[] getInquisitiveByStringNames(List<String> sNames){
        List<Student> sl =getStudentList(sNames);
        Student[] students = getInquisitive(sl);
        String[] result= new String[3];
        for (int i = 0; i < 3; i++){
            result[i]=students[i].getName();
        }
        return result;
    }

    private Student[] getInquisitive(List<Student> sl){
        Student[] students = new Student[3];
        for (Student s:sl) {
            for (int i = 0; i < 3; i++){
                if (students[i]==null){
                    students[i]=s;
                }
                if (students[i].getAllCourses().size()<s.getAllCourses().size()){
                    students[i]=s;
                    break;
                }
            }
        }
        return students;
    }

    public Set<String> getUniqueCoursesForStudents(List<String> sNames){
        List<Student> students=getStudentList(sNames);
        Set<Course> courseSet=getCourse(students);
        Set<String> result=new HashSet<>();
        for (Course c:courseSet) {
            String courseName=((Track)c).getName();
            result.add(courseName);
        }
        return result;
    }

    public Institute(){
        Init();
    }

    public void Init(){
        Student jack = new Learner("Jack");
        Student moris = new Learner("Moris");
        Student michele = new Learner("Michele");
        Student nickole = new Learner("Nickole");

        Course matan = new Track("Matan");
        Course linal = new Track("Linal");
        Course sopromat = new Track("Sopromat");
        courseList.add(matan);
        courseList.add(linal);
        courseList.add(sopromat);

        ((Learner)jack).AddCourse(matan);
        ((Learner)jack).AddCourse(linal);
        ((Learner)jack).AddCourse(sopromat);

        ((Learner)moris).AddCourse(matan);
        ((Learner)moris).AddCourse(linal);

        ((Learner)nickole).AddCourse(matan);
        ((Learner)nickole).AddCourse(sopromat);

        ((Learner)michele).AddCourse(matan);
        studentList.add(jack);
        studentList.add(michele);
        studentList.add(moris);
        studentList.add(nickole);
    }
}
