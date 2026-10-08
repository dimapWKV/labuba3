import java.util.*;

public class PrimesGeneratorTest {
    public static void test() {

        int N = 10;

        DegeneratorPrimeNumber generator = new DegeneratorPrimeNumber(N);

        // Прямой порядок
        System.out.println("Первые " + N + " простых чисел:");

        Iterator<Integer> iterator = generator.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        System.out.println();

        // Сохраняем числа для обратного порядка
        List<Integer> primes = new ArrayList<>();

        iterator = generator.iterator();

        while (iterator.hasNext()) {
            primes.add(iterator.next());
        }

        Collections.reverse(primes);

        // Обратный порядок
        System.out.println("В обратном порядке:");

        Iterator<Integer> reverseIterator = primes.iterator();

        while (reverseIterator.hasNext()) {
            System.out.print(reverseIterator.next() + " ");
        }
    }
}
