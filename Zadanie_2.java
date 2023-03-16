package Home_Work_Jv5;
// Пусть дан список сотрудников: Иван, Пётр, Антон и так далее. Написать программу, которая найдет и выведет
// повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.

// import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
// import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
// import java.util.stream.Stream;

public class Zadanie_2 {
    public static void main(String[] args) {
        ArrayList<String> people = new ArrayList<String>();
        Map<String, Integer> personal = new HashMap<>();

        // добавим в список ряд элементов
        int count = 0;
        people.add("Jack");
        people.add("Jack");

        people.add("Alice");
        people.add("Alice");
        people.add("Alice");

        people.add("Kate");
        people.add("Kate");
        people.add("Kate");

        people.add("Sam");
        people.add("Sam");

        people.add("Tom");

        people.add("Nikola");

        for (String name : people) {
            System.out.println(name);
        }
        System.out.println();
        Collections.sort(people);
        String temp = people.get(0);
        for (int i = 0; i < people.size(); i++)
            if (temp.equals(people.get(i))) {
                count++;
            } else {
                personal.put(temp, count);
                temp = people.get(i);
                count = 1;
                if (i == people.size() - 1)
                    personal.put(temp, count);

            }

        System.out.println(sortByValues(personal));

    }

    public static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) {
        Comparator<K> valueComparator = new Comparator<K>() {
            public int compare(K k1, K k2) {
                int compare = map.get(k2).compareTo(map.get(k1));
                if (compare == 0)
                    return 1;
                else
                    return compare;
            }
        };
        Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
        sortedByValues.putAll(map);
        return sortedByValues;
    }

}
