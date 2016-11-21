package literatePrimes;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class PrintPrimesTest {

    @Test
    public void equalsFirstThousandPrimesOutput() throws Exception {
        String outputPrimes = new String(Files.readAllBytes(Paths.get("src/test/java/literatePrimes/output.txt"))).trim();
        assertEquals(outputPrimes.replaceAll("\n", ""), PrintPrimes.print().replaceAll("\n", ""));
    }
}
