package numberrangesummarizertest;

import numberrangesummarizer.NumberRangeSummarizer;
import numberrangesummarizer.NumberRangeSummarizerImpl;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Collection;

public class NumberRangeSummarizerImplTest {
    private NumberRangeSummarizer numSum;

    @Before
    public void before(){
        numSum = new NumberRangeSummarizerImpl();
    }

    public void verify(String input, String expectedOutput){
        Collection<Integer> numCollection = numSum.collect(input);
        String out = numSum.summarizeCollection(numCollection);
        assertEquals(expectedOutput,out);
    }

    @Test
    public void testEmptyString(){
        verify("","");
    }

    @Test
    public void testSuppliedInput(){
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        String expectedOutput = "1, 3, 6-8, 12-15, 21-24, 31";

        verify(input,expectedOutput);
    }

    @Test
    public void testEndOnRange(){
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24";
        String expectedOutput = "1, 3, 6-8, 12-15, 21-24";

        verify(input,expectedOutput);
    }

    @Test
    public void testStartOnRange(){
        String input = "6,7,8,12,13,14,15,21,22,23,24,31";
        String expectedOutput = "6-8, 12-15, 21-24, 31";

        verify(input,expectedOutput);
    }

    @Test
    public void testDuplicates(){
        String input = "6,7,7,8,12,13,14,15,21,22,23,24,31";
        String expectedOutput = "6-7, 7-8, 12-15, 21-24, 31";

        verify(input,expectedOutput);
    }

    @Test
    public void testOneNumber(){
        String input = "6";
        String expectedOutput = "6";

        verify(input,expectedOutput);
    }

    @Test
    public void testOneRange(){
        String input = "6,7,8";
        String expectedOutput = "6-8";

        verify(input,expectedOutput);
    }

    @Test
    public void testDuplicateRanges(){
        String input = "6,7,8,6,7,8";
        String expectedOutput = "6-8, 6-8";

        verify(input,expectedOutput);
    }

    @Test
    public void testNonNumericInput(){
        String input = "6,7,8,6,K,8";
        String expectedOutput = "6-8, 6, 8";

        verify(input,expectedOutput);
    }

    @Test
    public void testNegatives(){
        String input = "-5,-4,-3,-1,0,2,5";
        String expectedOutput = "(-5)-(-3), (-1)-0, 2, 5";

        verify(input,expectedOutput);
    }

    @Test
    public void testDecimals(){
        String input = "0,0.5,1,3";
        String expectedOutput = "0-1, 3";

        verify(input,expectedOutput);
    }

    @Test
    public void testBadFormat(){
        String input = ",6,7,,8,12,13,,14,15,21,22,23,,24,31";
        String expectedOutput = "6-8, 12-15, 21-24, 31";

        verify(input,expectedOutput);
    }
}
