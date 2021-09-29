import java.util.ArrayList;
import java.util.List;

public class Learner implements Student{
    private String name;
    private List<Course> courseList=new ArrayList<>();
    public  Learner(String name){
        this.name=name;
    }

    public  String getName(){
        return this.name;
    }

    public List<Course> getAllCourses(){
        return this.courseList;
    }

    public void AddCourse(Course c){
        this.courseList.add(c);
    }
}