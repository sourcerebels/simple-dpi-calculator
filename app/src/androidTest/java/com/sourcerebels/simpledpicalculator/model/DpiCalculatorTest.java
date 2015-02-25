/*
Copyright 2015 Eduardo Manuel Rodríguez Castillo

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
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
