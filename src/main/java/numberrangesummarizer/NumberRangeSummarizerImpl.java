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

    //Assumes number ranges are always in ascending order
    @Override
    public String summarizeCollection(Collection<Integer> input) {
        Iterator<Integer> inputItr = input.iterator();
        List<NumberRange> numberRanges= new ArrayList<>();

        //initializes the first numberRange
        if(inputItr.hasNext()){
            numberRanges.add(new NumberRange(inputItr.next()));
        }

        //build the list of number ranges
        while (inputItr.hasNext()){
            int k = inputItr.next();

            //Creates new numberRange when number cannot be added to the last numberRange
            if ( !numberRanges.get(numberRanges.size()-1).inRange(k)){
                numberRanges.add(new NumberRange(k));
            }
        }

        StringJoiner output = new StringJoiner(", ");

        for (NumberRange numberRange : numberRanges) {
            output.add(numberRange.getString());
        }

        return output.toString();
    }
}
