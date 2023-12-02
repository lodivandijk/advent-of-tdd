package org.advent.day2;

import java.util.regex.Pattern;

public class Draw {
    public final int red;
    public final int green;
    public final int blue;

    private static final Pattern redPattern = Pattern.compile("(\\d+) red");
    private static final Pattern greenPattern = Pattern.compile("(\\d+) green");
    private static final Pattern bluePattern = Pattern.compile("(\\d+) blue");


    public static Draw drawFromString(String drawString) {
        var red = 0;
        var green = 0;
        var blue = 0;

        var valueStrings = drawString.split(",");

        for(var valueString : valueStrings) {
            var redMatcher = redPattern.matcher(valueString);
            if(redMatcher.find()) {
                red = Integer.parseInt(redMatcher.group(1));
            }
            var greenMatcher = greenPattern.matcher(valueString);
            if(greenMatcher.find()) {
                green = Integer.parseInt(greenMatcher.group(1));
            }
            var blueMatcher = bluePattern.matcher(valueString);
            if(blueMatcher.find()) {
                blue = Integer.parseInt(blueMatcher.group(1));
            }
        }

        return new Draw(red, green, blue);
    }

    public Draw(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public boolean isImpossible() {
        return red > 12 || green > 13 || blue > 14;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + red;
        result = prime * result + green;
        result = prime * result + blue;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Draw other = (Draw) obj;
        if (red != other.red)
            return false;
        if (green != other.green)
            return false;
        if (blue != other.blue)
            return false;
        return true;
    }

    public int power() {
        return red * green * blue;
    }
}