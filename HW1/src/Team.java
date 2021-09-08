public class Team {
Member teamArray[] = new Member[4];
private String nameTeam;
  public Team(String nameTeam) {
      this.nameTeam=nameTeam;
        this.teamArray[0] = new Member(100, "Member1");
        this.teamArray[1] = new Member(70, "Member2");
        this.teamArray[2] = new Member(110, "Member3");
        this.teamArray[3] = new Member(90, "Member4");

    }

    public void showResultsCourse(String course) {
        System.out.println("Информация о членах команды, прошедших дистанцию");
        for (int i=0; i < teamArray.length; i++) {
            for (int j=0; j < teamArray[i].arrayList.size(); j++) {
        if (course == teamArray[i].arrayList.get(j)){
                System.out.println("Номер члена команды: " + teamArray[i].id+ " " + "Показатель энергии: " + teamArray[i].energyHuman);
            teamArray[i].array();
            }}
        }


}

    public void showResultsAllTeam() {
        System.out.println("Информация обо всех членах команды");
        System.out.println("Название команды: " + nameTeam);
        for (int i = 0; i < teamArray.length; i++) {
            System.out.println("Номер члена команды: " + teamArray[i].id+ " " + "Показатель энергии: " + teamArray[i].energyHuman);
        }
    }




}
