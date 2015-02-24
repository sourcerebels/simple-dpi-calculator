package com.sourcerebels.simpledpicalculator.model;

import android.test.AndroidTestCase;

import java.util.List;

/**
 * DpiCalculator tests.
 */
public class DpiCalculatorTest extends AndroidTestCase {


    public void testShouldConvert48Mdpi() throws Exception {

        List<Result> result = DpiCalculator.calculate(ScreenDensity.MDPI, 48);
        assertResultContains(result, new Result(ScreenDensity.LDPI, 36));
        assertResultContains(result, new Result(ScreenDensity.MDPI, 48));
        assertResultContains(result, new Result(ScreenDensity.HDPI, 72));
        assertResultContains(result, new Result(ScreenDensity.XHDPI, 96));
        assertResultContains(result, new Result(ScreenDensity.XXHDPI, 144));
        assertResultContains(result, new Result(ScreenDensity.XXXHDPI, 192));
    }

    public void testShouldConvert72hdpi() throws Exception {

        List<Result> result = DpiCalculator.calculate(ScreenDensity.HDPI, 72);
        assertResultContains(result, new Result(ScreenDensity.LDPI, 36));
        assertResultContains(result, new Result(ScreenDensity.MDPI, 48));
        assertResultContains(result, new Result(ScreenDensity.HDPI, 72));
        assertResultContains(result, new Result(ScreenDensity.XHDPI, 96));
        assertResultContains(result, new Result(ScreenDensity.XXHDPI, 144));
        assertResultContains(result, new Result(ScreenDensity.XXXHDPI, 192));
    }

    public void testShouldConvert0mdpi() throws Exception {

        List<Result> result = DpiCalculator.calculate(ScreenDensity.HDPI, 0);
        assertResultContains(result, new Result(ScreenDensity.LDPI, 0));
        assertResultContains(result, new Result(ScreenDensity.MDPI, 0));
        assertResultContains(result, new Result(ScreenDensity.HDPI, 0));
        assertResultContains(result, new Result(ScreenDensity.XHDPI, 0));
        assertResultContains(result, new Result(ScreenDensity.XXHDPI, 0));
        assertResultContains(result, new Result(ScreenDensity.XXXHDPI, 0));
    }

    private void assertResultContains(List<Result> results, Result result) throws Exception {

        assertNotNull(result);
        assertNotSame("Results should not be empty", 0, results.size());
        assertTrue("Results must contains " + result, results.contains(result));
    }
}
