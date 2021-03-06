package lesson3;

import java.util.ArrayList;
import java.util.Set;

public class Lesson3Main {

    public static void main(String[] args) {
        ArrayList<String> array = new ArrayList<>();
        array.add("Альфа");
        array.add("Бета");
        array.add("Гамма");
        array.add("Дельта");
        array.add("Эпсилон");
        array.add("Альфа");
        array.add("Альфа");
        array.add("Бета");
        array.add("Омега");
        array.add("Альфа");
        array.add("Эпсилон");

        searchUniqueWords(array);
        System.out.println("----------------------------");
        searchNumberAllWord(array);
        System.out.println("----------------------------");

        TelephoneDirectory telephoneDirectory = new TelephoneDirectory();
        telephoneDirectory.add("Иванов", "123-45-67");
        telephoneDirectory.add( "Петров", "123-45-68");
        telephoneDirectory.add( "Сидоров", "123-45-69");
        telephoneDirectory.add( "Иванов", "123-45-70");
        telephoneDirectory.add("Иванов", "123-45-71");
        telephoneDirectory.add( "Петров", "123-45-72");

        System.out.println(telephoneDirectory.get("Иванов"));
    }

    private static void searchUniqueWords(ArrayList array) {
        for (int i = 0; i < array.size(); i++) {
            if (array.indexOf(array.get(i)) == array.lastIndexOf(array.get(i)))
                System.out.println(array.get(i));
        }
    }

    private static void searchNumberAllWord(ArrayList array) {
        for (int i = 0; i < array.size(); i++) {
            if (i == array.indexOf(array.get(i))) {
                int number = 1;
                for (int j = i + 1; j < array.size(); j++)
                    if ((array.get(i)).equals(array.get(j)))
                        number++;
                System.out.printf("Строка <%s> встречается %d раз %n", array.get(i), number);
            }
        }
    }
}