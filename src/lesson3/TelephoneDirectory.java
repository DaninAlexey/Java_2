package lesson3;

import java.util.*;

public class TelephoneDirectory {
    private final Map<String, Set<String>> phoneDirectory = new TreeMap<>();


    public void add(String surname, String phoneNumber) {
//        Set<String> phones = phoneDirectory.get(surname);
//        if (phones == null) {
//            Set<String> phoneSet = new HashSet<>();
//            phoneSet.add(phoneNumber);
//            phoneDirectory.put(surname, phoneSet);
//        }
//        else
//        {
//            phones.add(phoneNumber);
//            phoneDirectory.put(surname, phones);
//        }
        Set<String> phones = phoneDirectory.getOrDefault(surname, new HashSet<>());
        phones.add(phoneNumber);
        phoneDirectory.put(surname, phones);
    }

    public Set<String> get(String surname) {
        return this.phoneDirectory.get(surname);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TelephoneDirectory that = (TelephoneDirectory) o;
        return Objects.equals(phoneDirectory, that.phoneDirectory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneDirectory);
    }
}
