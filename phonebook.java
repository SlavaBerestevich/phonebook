import java.util.*;

public class phonebook {
    public static void main(String[] args) {
        Map<String, List<String>> phonebook = new HashMap<>();

        // добавляем записи в телефонную книгу
        addContact(phonebook, "Иванов", "1234567890");
        addContact(phonebook, "Петров", "9876543210");
        addContact(phonebook, "Сидоров", "10443448790");
        addContact(phonebook, "Петров", "19283454590");

        sortPhoneBook(phonebook);
    }

    public static void addContact(Map<String, List<String>> phonebook, String name, String phone) {

        if (phonebook.containsKey(name)) {
            List<String> phones = phonebook.get(name);
            phones.add(phone);
        } else {
            // если имя нет в книге, создаем новую запись
            List<String> phones = new ArrayList<>();
            phones.add(phone);
            phonebook.put(name, phones);
        }
    }

    public static void sortPhoneBook(Map<String, List<String>> phonebook) {
        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(phonebook.entrySet());
        Collections.sort(entries, (e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()));
        for (Map.Entry<String, List<String>> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}