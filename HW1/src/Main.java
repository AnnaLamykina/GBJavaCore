public class Main {

    public static void main(String[] args) {
      Team team = new Team ("The best");
      Course course = new Course("hard course");
      course.goCourse(team);
      team.showResultsAllTeam();
      team.showResultsCourse("hard course");
    }
}

