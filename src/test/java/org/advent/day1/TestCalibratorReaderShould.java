package org.advent.day1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.BufferedReader;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestCalibratorReaderShould {

    private CalibratorReader calibratorReader;

    @Test
    void throw_an_runtime_exception_when_reader_throws_io(@Mock BufferedReader mockReader) throws IOException {
        when(mockReader.readLine()).thenThrow(new IOException());
        assertThrows(RuntimeException.class, () -> new CalibratorReader(mockReader));
    }

    @Test
    void cali_sum_79(@Mock BufferedReader mockReader) throws IOException {
        when(mockReader.readLine())
                .thenReturn("hha7saa9")
                .thenReturn(null);
        calibratorReader = new CalibratorReader(mockReader);
        assertThat(calibratorReader.findCaliSum(), equalTo(79));
    }

    @Test
    void cali_sum_11_single(@Mock BufferedReader mockReader) throws IOException {
        when(mockReader.readLine())
                .thenReturn("pjjja1o")
                .thenReturn(null);
        calibratorReader = new CalibratorReader(mockReader);
        assertThat(calibratorReader.findCaliSum(), equalTo(11));
    }

    @Test
    void cali_sum_71(@Mock BufferedReader mockReader) throws IOException {
        when(mockReader.readLine())
                .thenReturn("3gh8a9")
                .thenReturn("a32fgggl198bhh2")
                .thenReturn(null);
        calibratorReader = new CalibratorReader(mockReader);
        assertThat(calibratorReader.findCaliSum(), equalTo(71));
    }

    @Test
    void cali_sum_50(@Mock BufferedReader mockReader) throws IOException {
        when(mockReader.readLine())
                .thenReturn("1abc2")
                .thenReturn("pqr3stu8vwx")
                .thenReturn(null);
        calibratorReader = new CalibratorReader(mockReader);
        assertThat(calibratorReader.findCaliSum(), equalTo(50));
    }

    @Test
    void cali_sum_142(@Mock BufferedReader mockReader) throws IOException {
        when(mockReader.readLine())
                .thenReturn("1abc2")
                .thenReturn("pqr3stu8vwx")
                .thenReturn("a1b2c3d4e5f")
                .thenReturn("treb7uchet")
                .thenReturn(null);
        calibratorReader = new CalibratorReader(mockReader);
        assertThat(calibratorReader.findCaliSum(), equalTo(142));
    }

    @Test
    void cali_sum_307(@Mock BufferedReader mockReader) throws IOException {
        when(mockReader.readLine())
                .thenReturn("6asgggsha68fffas21")
                .thenReturn("jj8assgg51ds23ffas")
                .thenReturn("aa6ss")
                .thenReturn("97")
                .thenReturn(null);
        calibratorReader = new CalibratorReader(mockReader);
        assertThat(calibratorReader.findCaliSum(), equalTo(307));
    }

    @Test
    void cali_sum_95_with_spelling(@Mock BufferedReader mockReader) throws IOException {
        when(mockReader.readLine())
                .thenReturn("1abc2five2")
                .thenReturn("eightfive12iijakknesixthreeasffgh")
                .thenReturn(null);
        calibratorReader = new CalibratorReader(mockReader);
        assertThat(calibratorReader.findCaliSum(), equalTo(95));
    }

    @Test
    void cali_sum_281_with_spelling(@Mock BufferedReader mockReader) throws IOException {
        when(mockReader.readLine())
                .thenReturn("two1nine")
                .thenReturn("eightwothree")
                .thenReturn("abcone2threexyz")
                .thenReturn("xtwone3four")
                .thenReturn("4nineeightseven2")
                .thenReturn("zoneight234")
                .thenReturn("7pqrstsixteen")
                .thenReturn(null);
        calibratorReader = new CalibratorReader(mockReader);
        assertThat(calibratorReader.findCaliSum(), equalTo(281));
    }


}
