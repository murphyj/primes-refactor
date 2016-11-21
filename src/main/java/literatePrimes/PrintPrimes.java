package literatePrimes;

public class PrintPrimes {

    public static String print() {
        final int MAX_NUM_PRIMES = 1000;
        final int ROWS_PER_PAGE = 50;
        final int COLS_PER_PAGE = 4;
        final int ORDMAX = 30;
        int[] P = new int[MAX_NUM_PRIMES + 1];
        int pageNumber;
        int pageOffset;
        int rowOffset;
        int C;

        int J;
        int K;
        boolean JPRIME;
        int ORD;
        int SQUARE;
        int N;
        int MULT[] = new int[ORDMAX + 1];

        J = 1;
        K = 1;
        P[1] = 2;
        ORD = 2;
        SQUARE = 9;

        StringBuffer primesOutput = new StringBuffer();
        while(K < MAX_NUM_PRIMES) {
            do {
                J = J + 2;
                if (J == SQUARE) {
                    ORD = ORD + 1;
                    SQUARE = P[ORD] * P[ORD];
                    MULT[ORD - 1] = J;
                }

                N = 2;
                JPRIME = true;
                while (N < ORD && JPRIME) {
                    while (MULT[N] < J)
                        MULT[N] = MULT[N] + P[N] + P[N];
                    if (MULT[N] == J)
                        JPRIME = false;
                    N = N + 1;
                }
            } while (!JPRIME);
            K = K + 1;
            P[K] = J;
        }

        {
            pageNumber = 1;
            pageOffset = 1;
            while (pageOffset <= MAX_NUM_PRIMES) {
                primesOutput.append("The First " + MAX_NUM_PRIMES +
                        " Prime Numbers --- Page " + pageNumber);
                primesOutput.append("\n");
                for (rowOffset = pageOffset; rowOffset < pageOffset + ROWS_PER_PAGE; rowOffset++) {
                    for (C = 0; C < COLS_PER_PAGE; C++)
                        if (rowOffset + C * ROWS_PER_PAGE <= MAX_NUM_PRIMES) {
                            String offset = String.format("%10d", P[rowOffset + C * ROWS_PER_PAGE]);
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