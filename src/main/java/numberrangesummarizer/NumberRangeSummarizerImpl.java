package numberrangesummarizer;

import java.util.*;

public class NumberRangeSummarizerImpl implements NumberRangeSummarizer {
    @Override
    public Collection<Integer> collect(String input) {
        List<Integer> numberList = new ArrayList<>();

        //split the input into an array of strings
        String[] stringArray = input.split(",");

        //convert the strings into integers and drops non integer values
        for (String s : stringArray) {
            try {
                numberList.add(Integer.parseInt(s));
            }catch (Exception e){
                System.out.println("Collection error." +
                                 "\nCould not convert \"" + s + "\" into an Integer" +
                                 "\nCollection may have missing values");
            }
        }

        return numberList;
    }

    //Formats negatives to have parenthesis around them for clarity
    String formatNumber(int number){
        if (number < 0){
            return "(" + number + ")";
        }else{
            return String.valueOf(number);
        }
    }

    //Assumes number ranges are always in ascending order
    @Override
    public String summarizeCollection(Collection<Integer> input) {
        int nextValue = 0;                      //denotes the next value we are looking for if it is sequential
        boolean range = false;
        StringBuilder output = new StringBuilder();
        Iterator<Integer> it = input.iterator();

        if (it.hasNext()) {                     //gets the first value in the collection
            nextValue = it.next();
            output.append(formatNumber(nextValue));
            ++nextValue;
        }

        while (it.hasNext()) {
            int tmp = it.next();

            if (nextValue == tmp) {
                range = true;                   //open a new range
                ++nextValue;
            } else {
                if (range) {                    //closes up a range once we look at a number that is not also sequential
                    output.append('-');
                    output.append(formatNumber(--nextValue)); //decrement to get last in order number
                    output.append(", ");
                    output.append(formatNumber(tmp));
                    range = false;
                } else {
                    output.append(", ");
                    output.append(formatNumber(tmp));
                }
                nextValue = tmp + 1;            //init nextValue to look for next in order number
            }
        }

        if (range) {                            //closes up a range in case last numbers were sequential
            output.append('-');
            output.append(formatNumber(--nextValue));         //decrement to get last in order number
        }

        return output.toString();
    }
}
