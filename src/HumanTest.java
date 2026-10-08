import java.util.*;

public class HumanTest {
    public static void humanTest(String[] args) {
        List<Human> humans = Arrays.asList(
                new Human("Иван", "Петров", 25),
                new Human("Анна", "Сидорова", 30),
                new Human("Петр", "Иванов", 22),
                new Human("Мария", "Петрова", 28),
                new Human("Сергей", "Иванов", 35),
                new Human("Елена", "Сидорова", 27),
                new Human("Дмитрий", "Петров", 40)
        );

        System.out.println("Исходный список:");
        humans.forEach(System.out::println);


        // 1. HashSet - неупорядоченная коллекция
        Set<Human> hashSet = new HashSet<>(humans);
        System.out.println("HashSet (неупорядоченная коллекция):");
        hashSet.forEach(System.out::println);


        // 2. LinkedHashSet - сохраняет порядок вставки
        Set<Human> linkedHashSet = new LinkedHashSet<>(humans);
        System.out.println("LinkedHashSet (сохраняет порядок вставки):");
        linkedHashSet.forEach(System.out::println);

        // 3. TreeSet с естественным порядком (Comparable)
        Set<Human> treeSet = new TreeSet<>(humans);
        System.out.println("TreeSet (естественный порядок - Comparable):");
        treeSet.forEach(System.out::println);


        // 4. TreeSet с компаратором по фамилии
        Set<Human> treeSetByLastName = new TreeSet<>(new HumanComparatorByLastName());
        treeSetByLastName.addAll(humans);
        System.out.println("TreeSet с компаратором HumanComparatorByLastName:");
        treeSetByLastName.forEach(System.out::println);


        // 5. TreeSet с анонимным компаратором по возрасту
        Set<Human> treeSetByAge = new TreeSet<>((h1, h2) -> {
            int result = Integer.compare(h1.getAge(), h2.getAge());
            // Если возраст одинаковый, сравниваем по фамилии и имени,
            // чтобы не потерять людей с одинаковым возрастом
            if (result == 0) {
                result = h1.getLastname().compareTo(h2.getLastname());
                if (result == 0) {
                    result = h1.getFirstname().compareTo(h2.getFirstname());
                }
            }
            return result;
        });

        treeSetByAge.addAll(humans);
        System.out.println("TreeSet с анонимным компаратором по возрасту:");
        treeSetByAge.forEach(System.out::println);
    }
}
