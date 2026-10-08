import java.util.*;

public class CollectionsDemo {
    public static void runCollections(){

    }

    private void createArray() {
        int n = 15;
        Integer[] arr = new Integer[n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(101);
        }

        List<Integer> list = new ArrayList<>(Arrays.asList(arr));

        Collections.sort(list);
        System.out.println("\n3. После сортировки по возрастанию (Collections.sort):");
        System.out.println("   " + list);

        // === 4. Сортировка в обратном порядке ===
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("\n4. После сортировки в обратном порядке (Collections.reverseOrder):");
        System.out.println("   " + list);

        // === 5. Перемешивание списка ===
        Collections.shuffle(list);
        System.out.println("\n5. После перемешивания (Collections.shuffle):");
        System.out.println("   " + list);

        // === 6. Циклический сдвиг на 1 элемент ===
        Collections.rotate(list, 1);
        System.out.println("\n6. После циклического сдвига на 1 (Collections.rotate):");
        System.out.println("   " + list);

        List<Integer> listBeforeFilter = new ArrayList<>(list);

        //7
        List<Integer> uniqueList = new ArrayList<>();

        for (Integer num : list) {
            if (Collections.frequency(list, num) == 1) {
                uniqueList.add(num);
            }
        }
        list = uniqueList;
        System.out.println("\n7. Только уникальные элементы (через Collections.frequency):");
        System.out.println("   " + list);

        //8

        List<Integer> duplicateList = new ArrayList<>();
        Set<Integer> alreadyAdded = new HashSet<>();
        for (Integer num : list) {
            if (Collections.frequency(list, num) > 1 && !alreadyAdded.contains(num)) {
                duplicateList.add(num);
                alreadyAdded.add(num);
            }
        }
        list = duplicateList;
        System.out.println("\n8. Только дублирующиеся элементы (через Collections.frequency):");
        System.out.println("   " + list);

        //9

        // Восстанавливаем список для шага 9
        list = new ArrayList<>(listBeforeFilter);

        // === 9. Из списка получаем массив ===
        Object[] resultArray = list.toArray();
        System.out.println("\n9. Массив из списка (list.toArray()):");
        System.out.println("   " + Arrays.toString(resultArray));

        // === 10. Подсчёт количества вхождений каждого числа ===
        System.out.println("\n10. Количество вхождений каждого числа (Collections.frequency):");
        Set<Integer> uniqueNumbers = new LinkedHashSet<>(list);
        for (Integer num : uniqueNumbers) {
            int count = Collections.frequency(list, num);
            System.out.println("    Число " + num + " встречается " + count + " раз(а)");
        }
    }

}
