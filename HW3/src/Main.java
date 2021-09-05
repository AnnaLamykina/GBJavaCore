import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("------------------\ntask 1\n");
        ArrayList<String> t1arr = new ArrayList<>();
        t1arr.add("First");
        t1arr.add("Second");
        t1arr.add("Third");
        printStringArr(t1arr);
        printStringArr(interchange(t1arr));

        System.out.println("------------------\ntask 2\n");
        Box<Orange> orangeBox1 = new Box<>(new Orange());
        Box<Orange> orangeBox2 = new Box<>(new Orange());
        Box<Apple> appleBox = new Box<>(new Apple());

        orangeBox1.addObject(10);
        orangeBox2.addObject(30);
        appleBox.addObject(20);

        System.out.println(orangeBox1.toString());
        System.out.println(orangeBox2.toString());
        System.out.println(appleBox.toString());
        System.out.println(orangeBox1.compare(appleBox));
        System.out.println(orangeBox1.putToAnother(appleBox));
        System.out.println(orangeBox1.putToAnother(orangeBox2));
    }

    public static void printStringArr(ArrayList<String> print) {
        String res = "Array has next elements in next order";
        for (String str : print) {
            res += " " + str;
        }
        System.out.println("Array has next elements in next order:" + res);
    }

    public static ArrayList<String> interchange(ArrayList<String> in) {
        String i1 = in.get(0);
        String i2 = in.get(2);
        in.set(0, i2);
        in.set(2, i1);
        return in;
    }

}