import java.util.*;

public class YellowPages {
    private Map<String, List<String>> hMap = new HashMap<String, List<String>>();

    public void add(String phone, String lastname) {
        List<String> l = hMap.get(lastname);
        if (l == null) {
            l = new ArrayList<String>();
            l.add(phone);
            hMap.put(lastname, l);
            System.out.println("Телефонный номер(" + phone + ") успешно добавлен для контакта с фамилией " + lastname);
        } else {
            if (numberExist(l, phone)) {
                System.out.println("Этот номер(" + phone + ") уже существует для контакта " + lastname);
                return;
            }
            l.add(phone);
            hMap.replace(lastname, l);
            System.out.println("Телефонный номер(" + phone + ") успешно добавлен для контакта с фамилией " + lastname);
        }
    }

    private boolean numberExist(List<String> numberList, String number) {
        for (String string : numberList) {
            if (string == number)
                return true;
        }
        return false;
    }

    public void get(String lastname) {
        List<String> l = hMap.get(lastname);
        if (l != null) {
            System.out.println("Контакт с фамилией " + lastname + " имеет следующие телефонные номера:\n-----------");
            for (String string : l) {
                System.out.println(string);
            }
        } else {
            System.out.println("В базе не найдено номеров для контакта с фамилией " + lastname);
        }
    }
}