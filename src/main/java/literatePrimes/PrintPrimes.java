package literatePrimes;

public class PrintPrimes {

    public static String print() {
        final int MAX_NUM_PRIMES = 1000;
        final int ROWS_PER_PAGE = 50;
        final int COLS_PER_PAGE = 4;
        final int MAX_ORDINAL = 30;

        PrintConfiguration configuration = new PrintConfiguration(MAX_NUM_PRIMES, ROWS_PER_PAGE, COLS_PER_PAGE);

        int[] primes = new int[configuration.getMaxNumPrimes() + 1];

        int nextNumber;
        int currentPrimeNumber;
        boolean isPrime;
        int ordinal;
        int square;
        int primeNumber;
        int squares[] = new int[MAX_ORDINAL + 1];

        nextNumber = 1;
        currentPrimeNumber = 1;
        primes[1] = 2;
        ordinal = 2;
        square = 9;

        StringBuffer primesOutput = new StringBuffer();
        while(currentPrimeNumber < configuration.getMaxNumPrimes()) {
            do {
                nextNumber = nextNumber + 2;
                if (nextNumber == square) {
                    ordinal = ordinal + 1;
                    square = primes[ordinal] * primes[ordinal];
                    squares[ordinal - 1] = nextNumber;
                }

                primeNumber = 2;
                isPrime = true;
                while (primeNumber < ordinal && isPrime) {
                    while (squares[primeNumber] < nextNumber) {
                        squares[primeNumber] = squares[primeNumber] + primes[primeNumber] + primes[primeNumber];
                    }
                    if (squares[primeNumber] == nextNumber) {
                        isPrime = false;
                    }
                    primeNumber = primeNumber + 1;
                }
            } while (!isPrime);
            currentPrimeNumber = currentPrimeNumber + 1;
            primes[currentPrimeNumber] = nextNumber;
        }

        return PrimePrinter.generateOutput(configuration, primes, primesOutput);
    }
}