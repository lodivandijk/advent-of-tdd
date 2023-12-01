package org.advent.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;


public class CalibratorReader {
    private ArrayList<String> caliLines = new ArrayList<>();
    private Calibrator calibrator = new Calibrator();

    public CalibratorReader(BufferedReader caliReader){
        try {
            for (String line; (line = caliReader.readLine()) != null; ) {
                this.caliLines.add(line);
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int findCaliSum(){
        int sum = 0;
        for(String line: this.caliLines){
            sum += calibrator.getCaliValue(line);
        }
        return sum;
    }
}


