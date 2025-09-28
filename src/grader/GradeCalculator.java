

package grader;

public class GradeCalculator {

    public double calculate(String[] scores, String[] weights) {
        double total = 0, totalWeight = 0;
        for (int i = 0; i < scores.length; i++) {
            if(parse(scores[i]) != -1) {
                double score = parse(scores[i]);
                double weight = parse(weights[i]);
                total += score * weight;
                totalWeight += weight;
            }
            else{
                continue;
            }
        }
        return total / totalWeight * 100;
    }

    private double parse(String str) {
        if (str.contains("/")) {
            String[] parts = str.split("/");
            return Double.parseDouble(parts[0]) / Double.parseDouble(parts[1]);
        }
        double num = Double.parseDouble(str.replace("%", ""));
        return str.contains("%") ? num / 100 : num > 1 ? num / 100 : num;
    }
}