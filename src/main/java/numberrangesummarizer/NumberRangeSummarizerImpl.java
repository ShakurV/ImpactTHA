package numberrangesummarizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;

public class NumberRangeSummarizerImpl implements NumberRangeSummarizer{
    @Override
    public Collection<Integer> collect(String input) {
        List<Integer> numberList = new ArrayList<>();

        //split the input into an array of strings
        String[] stringArray = input.split(",");

        //convert the strings into integers
        for (String s : stringArray) {
            numberList.add(Integer.parseInt(s));
        }

        return numberList;
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {
        return null;
    }
}
