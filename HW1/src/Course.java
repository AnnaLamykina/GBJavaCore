public class Course {
    Obstruction obstructionArray[] = new Obstruction[4];
    private String idCourse;
    Course (String id){
        this.idCourse=id;
        this.obstructionArray[0] = new Obstruction(10);
        this.obstructionArray[1] = new Obstruction(20);
        this.obstructionArray[2] = new Obstruction(40);
        this.obstructionArray[3] = new Obstruction(30);


    }

    public void goCourse(Team team) {
        int way = 0;

        for (int i=0; i <obstructionArray.length; i++){
            way = way + obstructionArray[i].energyCourse;
        }
        System.out.println("Длина полосы препятсявия: " + way);
        for (int i=0; i < team.teamArray.length; i++) {
            if (team.teamArray[i].energyHuman >= way) {
                team.teamArray[i].arrayList.add(idCourse);

            }
        }
    }
}
