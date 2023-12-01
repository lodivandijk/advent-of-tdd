public class CalibrationDocLine {
    private String line;

    public CalibrationDocLine(String line) {
        this.line = line;
    }

    public int getFirstDigit() {
        return line.chars().filter(c -> Character.isDigit(c)).findFirst().getAsInt() - '0';
    }

    public int getLastDigit() {
        var reverse = new StringBuilder(line).reverse().toString();
        return reverse.chars().filter(c -> Character.isDigit(c)).findFirst().getAsInt() - '0';
    }

    public int getCalibrationValue() {
        return getFirstDigit() * 10 + getLastDigit();
    }
}
