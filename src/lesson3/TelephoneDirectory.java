package lesson3;

import java.util.*;

public class TelephoneDirectory {
    private final Map<String, String> phoneDirectory;

    public TelephoneDirectory() {
        phoneDirectory = new HashMap<>();
    }

    public void add(String phone, String name) {
        phoneDirectory.put(phone, name);
    }

    public Set<String> get(String name) {
        Set<String> needPhoneNumber = new HashSet<>();
        for (Map.Entry<String, String> o : phoneDirectory.entrySet())
        {
            if (name.equals(o.getValue())) {
                needPhoneNumber.add(o.getKey());
                System.out.println("-------------");
            }
        }
        return (needPhoneNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TelephoneDirectory)) return false;
        TelephoneDirectory that = (TelephoneDirectory) o;
        return Objects.equals(phoneDirectory, that.phoneDirectory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneDirectory);
    }
}
