package org.advent.day1;

import java.util.HashMap;

public class Calibrator {
    public int getCaliValue(String line){
        String caliValue;
        int result = 0;

        HashMap<String, String> spelledToDigit= new HashMap<>();
        String[] spellings = {"one", "two", "three", "four", "five","six", "seven", "eight", "nine"};
        String[] digitStrings = new String[9];

        //populates digitStrings with "1", "2" etc and creates the mapping of spelling -> digitString
        for (int i =1; i < 10; i++){
            digitStrings[i-1] = String.valueOf(i);
            spelledToDigit.put(spellings[i-1], digitStrings[i-1]);
        }

        int idx = 0;
        int currentMinIdx = line.length()-1;
        String currentMinIdxDigit = "";
        int currentMaxIdx = 0;
        String currentMaxIdxDigit = "";

        //loops to find the index at which each spelling is found. if the idx is higher/lower than the current highest/lowest index, then replaces the respective idx and digit. keeps looking until there are no more of that spelling (-1 returned)
        for (String key : spelledToDigit.keySet()){
            while ( (idx = line.indexOf(key, idx) )>= 0) {
                if (idx <= currentMinIdx){
                    currentMinIdx = idx;
                    currentMinIdxDigit = spelledToDigit.get(key);
                }
                if (idx >= currentMaxIdx){
                    currentMaxIdx = idx;
                    currentMaxIdxDigit = spelledToDigit.get(key);
                }
                idx ++;
            }
            idx = 0;
        }
        
        //same as above but with ints 1-9
        for (String digitString: digitStrings){
            while ( (idx = line.indexOf(digitString, idx) ) >= 0){
                if (idx <= currentMinIdx){
                    currentMinIdx = idx;
                    currentMinIdxDigit = digitString;
                }
                if (idx >= currentMaxIdx){
                    currentMaxIdx = idx;
                    currentMaxIdxDigit = digitString;
                }                
                idx++;
            }
            idx = 0;
        }

        //finds the lowest and highest idx at which a number was found, concats them. if there are no digits then error printed and 0 returned
        try {
            caliValue = currentMinIdxDigit.concat(currentMaxIdxDigit);
            result = Integer.valueOf(caliValue);
        }
        catch (NumberFormatException e){
            System.err.println("There are no digits on this line!");
        }
        return result;
    }

            


}