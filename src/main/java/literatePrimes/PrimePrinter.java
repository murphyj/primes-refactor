package literatePrimes;

public class PrimePrinter {

    public static String generateOutput(PrintConfiguration configuration, int[] primes) {
        StringBuffer primesOutput = new StringBuffer();

        int pageNumber;
        int pageOffset;
        int rowOffset;
        int currentColumnNum;
        pageNumber = 1;
        pageOffset = 1;

        while (pageOffset <= configuration.getMaxNumPrimes()) {
            primesOutput.append("The First " + configuration.getMaxNumPrimes() + " Prime Numbers --- Page " + pageNumber);
            primesOutput.append("\n");
            for (rowOffset = pageOffset; rowOffset < pageOffset + configuration.getRowsPerPage(); rowOffset++) {
                for (currentColumnNum = 0; currentColumnNum < configuration.getColsPerPage(); currentColumnNum++)
                    if (rowOffset + currentColumnNum * configuration.getRowsPerPage() <= configuration.getMaxNumPrimes()) {
                        String offset = String.format("%10d", primes[rowOffset + currentColumnNum * configuration.getRowsPerPage()]);
                        primesOutput.append(offset);
                    }
                primesOutput.append("\n");
            }
            pageNumber = pageNumber + 1;
            pageOffset = pageOffset + configuration.getRowsPerPage() * configuration.getColsPerPage();
        }
        return primesOutput.toString();
    }
}
