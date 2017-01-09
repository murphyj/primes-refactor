package literatePrimes;

public class PrintPrimes {

    public static String print() {
        final int MAX_NUM_PRIMES = 1000;
        final int ROWS_PER_PAGE = 50;
        final int COLS_PER_PAGE = 4;
        final int ORDMAX = 30;
        int[] primes = new int[MAX_NUM_PRIMES + 1];
        int pageNumber;
        int pageOffset;
        int rowOffset;
        int currentColumnNum;

        int nextNumber;
        int currentPrimeNumber;
        boolean isPrime;
        int ordinal;
        int square;
        int primeNumber;
        int squares[] = new int[ORDMAX + 1];

        nextNumber = 1;
        currentPrimeNumber = 1;
        primes[1] = 2;
        ordinal = 2;
        square = 9;

        StringBuffer primesOutput = new StringBuffer();
        while(currentPrimeNumber < MAX_NUM_PRIMES) {
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

        {
            pageNumber = 1;
            pageOffset = 1;
            while (pageOffset <= MAX_NUM_PRIMES) {
                primesOutput.append("The First " + MAX_NUM_PRIMES +
                        " Prime Numbers --- Page " + pageNumber);
                primesOutput.append("\n");
                for (rowOffset = pageOffset; rowOffset < pageOffset + ROWS_PER_PAGE; rowOffset++) {
                    for (currentColumnNum = 0; currentColumnNum < COLS_PER_PAGE; currentColumnNum++)
                        if (rowOffset + currentColumnNum * ROWS_PER_PAGE <= MAX_NUM_PRIMES) {
                            String offset = String.format("%10d", primes[rowOffset + currentColumnNum * ROWS_PER_PAGE]);
                            primesOutput.append(offset);
                        }
                    primesOutput.append("\n");
                }
                pageNumber = pageNumber + 1;
                pageOffset = pageOffset + ROWS_PER_PAGE * COLS_PER_PAGE;
            }
        }
        return primesOutput.toString();
    }
}