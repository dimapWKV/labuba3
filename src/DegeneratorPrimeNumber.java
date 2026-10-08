import java.util.*;


public class DegeneratorPrimeNumber implements Iterable<Integer>{
    private List<Integer> primes;

    private static boolean isPrime(int n) {
        if (n <= 1) return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public DegeneratorPrimeNumber(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("N не может быть отрицательным");
        }

        primes = new ArrayList<>();

        int number = 2;

        while (primes.size() < n) {
            if (isPrime(number)) {
                primes.add(number);
            }
            number++;
        }
    }

    public Iterator<Integer> iterator() {
        return primes.iterator();
    }

}
