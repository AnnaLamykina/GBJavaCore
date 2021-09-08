import java.util.ArrayList;

public class Member extends Human{
    protected String id;
    ArrayList<String> arrayList = new ArrayList<>();

   Member(int energyHuman, String id){
       super(energyHuman);
       this.id = id;
    }

@Override
    public void array () {
        System.out.println("Поздравляем!");
    }

}
