package numberrangesummarizer;

import java.util.*;

public class NumberRangeSummarizerImpl implements NumberRangeSummarizer {
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

    //Assumes numbers are always in ascending order
    @Override
    public String summarizeCollection(Collection<Integer> input) {
        int i = 0;
        boolean range = false;
        StringBuilder output = new StringBuilder();
        Iterator<Integer> it = input.iterator();

        if (it.hasNext()) {
            i = it.next();
            output.append(i);
            ++i;
        }

        while (it.hasNext()) {
            int tmp = it.next();

            if (i == tmp) {
                range = true;           //open a new range
                ++i;
            } else {
                if (range) {            //closes up a range once we look at a number that is not also sequential
                    output.append('-');
                    output.append(--i); //decrement to get last in order number
                    output.append(", ");
                    output.append(tmp);
                    range = false;
                } else {
                    output.append(", ");
                    output.append(tmp);
                }
                i = tmp + 1;        //init i to look for next in order number
            }
        }

        if (range) {            //closes up a range in case last numbers were sequential
            output.append('-');
            output.append(--i); //decrement to get last in order number
        }

        return output.toString();
    }
}
