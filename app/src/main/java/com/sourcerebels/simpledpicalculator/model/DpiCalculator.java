package com.sourcerebels.simpledpicalculator.model;

import java.util.ArrayList;
import java.util.List;

/**
 * DPI calculator class.
 */
public class DpiCalculator {

    /**
     * Calculate given value for each density.
     *
     * @param sourceDensity Source density.
     * @param value   Source value.
     * @return Results list.
     */
    public static List<Result> calculate(ScreenDensity sourceDensity, float value) {

        value = toMdpi(sourceDensity, value);

        List<Result> result = new ArrayList<>();
        for (int i = 0; i < ScreenDensity.values().length; i++) {

            ScreenDensity density = ScreenDensity.values()[i];
            result.add(new Result(density, value * density.getFactor()));
        }
        return result;
    }

    private static float toMdpi(ScreenDensity sourceDensity, float value) {

        if (sourceDensity != ScreenDensity.MDPI) {

            if (sourceDensity.ordinal() > ScreenDensity.MDPI.ordinal()) {

                return value / sourceDensity.getFactor();

            }
            return value * sourceDensity.getFactor();
        }
        return value;
    }
}
