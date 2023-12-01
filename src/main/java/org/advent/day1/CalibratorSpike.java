package org.advent.day1;

import java.util.Collections;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class CalibratorSpike {
    public int getCaliValue(String line){
        String caliValue;
        String innerLine;
        int result =0;
        // spelledToDigit.put(new StringBuilder("one"), new StringBuilder("1"));
        // spelledToDigit.put(new StringBuilder("two"), new StringBuilder("2"));
        // spelledToDigit.put(new StringBuilder("three"), new StringBuilder("3"));
        // spelledToDigit.put(new StringBuilder("four"), new StringBuilder("4"));
        // spelledToDigit.put(new StringBuilder("five"), new StringBuilder("5"));
        // spelledToDigit.put(new StringBuilder("six"), new StringBuilder("6"));
        // spelledToDigit.put(new StringBuilder("seven"), new StringBuilder("7"));
        // spelledToDigit.put(new StringBuilder("eight"), new StringBuilder("8"));
        // spelledToDigit.put(new StringBuilder("nine"), new StringBuilder("9"));

        

        HashMap<String, String> spelledToDigit= new HashMap<>();
        String[] spellings = {"one", "two", "three", "four", "five","six", "seven", "eight", "nine"};
        String[] digitStrings = new String[9];
        for (int i =1; i < 10; i++){
            digitStrings[i-1] = String.valueOf(i);
            spelledToDigit.put(spellings[i-1], digitStrings[i-1]);
        }

        // spelledToDigit.put("one", "1");
        // spelledToDigit.put("two", "2");
        // spelledToDigit.put("three", "3");
        // spelledToDigit.put("four", "4");
        // spelledToDigit.put("five", "5");
        // spelledToDigit.put("six", "6");
        // spelledToDigit.put("seven", "7");
        // spelledToDigit.put("eight", "8");
        // spelledToDigit.put("nine", "9");
        // HashMap<Integer, String> idxDigit = new HashMap<>();
        // spelledToDigit.forEach((key, value) -> {
        //     innerLine = Pattern.compile(".").matcher(line).replaceAll(" ");
        //    // line = line.replaceAll(key, value);
        //     });

        // for (String key : spelledToDigit.keySet()){
        //     line = line.replaceAll(key, spelledToDigit.get(key));
        // }
        Integer idx = 0;
        int currentMinIdx = line.length();
        String currentMinIdxDigit = "";
        int currentMaxIdx = 0;
        String currentMaxIdxDigit = "";

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
                // idxDigit.put(idx, spelledToDigit.get(key));
                idx ++;
            }
            idx = 0;
        }

        // for (int i = 0; i < 10 ; i++){
        //     String iString = String.valueOf(i);
        //     while ( (idx = line.indexOf(iString, idx)) >= 0){
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
             //   idxDigit.put(idx, String.valueOf(i));
                idx++;
            }
            idx = 0;
        }

        //try to get the first and last digits (as a String) - if there are no digits then error printed and 0 returned
        try {
            caliValue = currentMinIdxDigit.concat(currentMaxIdxDigit);
            result = Integer.valueOf(caliValue);
            // int minIdx = Collections.min(idxDigit.keySet());
            // int maxIdx = Collections.max(idxDigit.keySet());
            // caliValue = idxDigit.get(minIdx).concat(idxDigit.get(maxIdx));
        }
        catch (NumberFormatException e){
    //    catch (NoSuchElementException e){
            System.err.println("There are no digits on this line!");
     //       caliValue = "0";
        }

        // line = line.replaceAll("[^[0-9]+]", "");
        // try {
        //     caliValue = line.substring(0,1).concat(line.substring(line.length() -1));

        // }
        // catch (IndexOutOfBoundsException ie){
        //     System.err.println("There are no digits on this line!");
        //     caliValue = "0";
        // }


        // //filters out all the digits in the string, adds them all to a list
        // List<String> digits = line.chars()
        //     .mapToObj(ch -> (char) ch)
        //     .filter(ch -> Character.isDigit(ch))
        //     .map(ch -> String.valueOf(ch))
        //     .collect(Collectors.toList());

        // //try to get the first and last digits (as a String) - if there are no digits then error printed and 0 returned
        // try {
        //     caliValue = digits.get(0).concat(digits.get(digits.size() - 1));
        // }
        // catch (IndexOutOfBoundsException ie){
        //     System.err.println("There are no digits on this line!");
        //     caliValue = "0";
        // }
    //    return Integer.valueOf(caliValue);

    return result;
    }
}
    // public HashMap<Integer,String> getMinMax(String line, String[] search, String[] digit, HashMap<Integer, String> currentMinMax){
    //     int idx = 0;
    //     int currentMinIdx = Collections.min(currentMinMax.keySet());
    //     String currentMinIdxDigit = currentMinMax.get(currentMinIdx);
    //     int currentMaxIdx = Collections.min(currentMinMax.keySet());
    //     String currentMaxIdxDigit = currentMinMax.get(currentMaxIdx);
        
    //     for (String element: search){
    //         while ( (idx = line.indexOf(element, idx) ) >= 0){
    //             if (idx <= currentMinIdx){
    //                 currentMinIdx = idx;
    //                 currentMinIdxDigit = digitString;
    //             }
    //             if (idx >= currentMaxIdx){
    //                 currentMaxIdx = idx;
    //                 currentMaxIdxDigit = digitString;
    //             }                
    //             idx++;
    //         }
    //         idx = 0;
    //     }
    // }