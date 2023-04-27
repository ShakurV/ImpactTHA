package numberrangesummarizer;

public class NumberRange {
    private int first;
    private int last;

    public NumberRange(int number){
        this.first = number;
        this.last = number;
    }

    //Formats negative numbers to have parenthesis around them
    private String formatNumber(int number){
        if (number < 0){
            return("(" + number + ")");
        }else{
            return String.valueOf(number);
        }
    }

    //Returns the string representing the content of the range
    public String getString() {
        if (last > first) {
            return formatNumber(first) + "-" + formatNumber(last);
        }else{
            return formatNumber(first);
        }
    }

    //Extends the range if possible
    public boolean inRange(int number){
        if(number == last + 1){
            last = number;
            return true;
        }
        return false;
    }
}
