import java.util.*;

public class Main {
    public static void main(String[] args) {
        taskInfo(1);
        task1();
        taskInfo(2);
        task2();
    }

    public static void task1() {
        ArrayList<String> setWordArray = new ArrayList<>();
        setWordArray.add("test");
        setWordArray.add("set");
        setWordArray.add("java");
        setWordArray.add("idea");
        setWordArray.add("all");
        setWordArray.add("TEST");
        setWordArray.add("idea");
        setWordArray.add("word");
        setWordArray.add("test");
        setWordArray.add("array");
        setWordArray.add("array");

        System.out.println("Исходный массив:");
        for (String element : setWordArray)
            System.out.println(element);

        System.out.println("Каждое слово встречается:");

        Set<String> uniqueWords = new HashSet<>(setWordArray);
        for (String word : uniqueWords) {
            System.out.println(word + ": " + Collections.frequency(setWordArray, word));
        }

        Set<String> linkedSet = new LinkedHashSet<>(setWordArray);
        setWordArray.clear();
        setWordArray.addAll(linkedSet);
        System.out.println("Массив с уникальными элементами:");
        for (String element : setWordArray)
            System.out.println(element);
    }

    public static void task2() {
        YellowPages yp = new YellowPages();
        yp.add("+123456789", "Фамилия1");
        yp.add("+123456789", "Фамилия1");
        yp.add("+13456789", "Фамилия1");
        yp.add("+123456789", "Фамилия2");
        yp.get("Фамилия1");
        yp.get("Фамилия2");
        yp.get("Фамилия3");
    }

    public static void taskInfo(Integer n) {
        System.out.println("\nЗадание " + n + "\n-----------\n");
    }
}
