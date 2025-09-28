package grader;

public class Converter {
    private static final String regex = "/n";
    public static String[] convert(String input){
        return input.split(regex);
    }
}
