package literatePrimes;

public class PrintConfiguration {

    private int maxNumPrimes;
    private int rowsPerPage;
    private int colsPerPage;

    public PrintConfiguration(int maxNumPrimes, int rowsPerPage, int colsPerPage) {
        this.maxNumPrimes = maxNumPrimes;
        this.rowsPerPage = rowsPerPage;
        this.colsPerPage = colsPerPage;
    }

    public int getMaxNumPrimes() {
        return maxNumPrimes;
    }

    public int getRowsPerPage() {
        return rowsPerPage;
    }

    public int getColsPerPage() {
        return colsPerPage;
    }
}
