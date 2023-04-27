package numberrangesummarizer;

import java.util.Collection;

public class MainTest {
    public static void main(String[] args){
        NumberRangeSummarizer numSum = new NumberRangeSummarizerImpl();
        String testInput = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        Collection<Integer> testCollection = numSum.collect(testInput);
        String testOutput = numSum.summarizeCollection(testCollection);
        System.out.println(testOutput);
    }
}
