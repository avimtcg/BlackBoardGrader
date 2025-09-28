package grader;

public class Converter {
    private static final String regex = "\n";
    public static String[] convert(String input){
        System.out.println(input.split(regex).length);
        return input.split(regex);
    }
}
