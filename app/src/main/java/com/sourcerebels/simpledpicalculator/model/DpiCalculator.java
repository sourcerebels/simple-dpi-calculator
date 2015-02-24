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
     * @param value         Source value.
     * @return Results list.
     */
    public static List<Result> calculate(ScreenDensity sourceDensity, float value) {

        value = toMdpi(sourceDensity, value);

        List<Result> result = new ArrayList<>();
        for (ScreenDensity density : ScreenDensity.values()) {

            result.add(new Result(density, value * density.getFactor()));
        }
        return result;
    }

    /**
     * Converts a value in given density to mdpi.
     *
     * @param sourceDensity Source density.
     * @param value         Source value.
     * @return MDPI value.
     */
    private static float toMdpi(ScreenDensity sourceDensity, float value) {

        if (sourceDensity == ScreenDensity.MDPI) {

            return value;
        }

        float factor = sourceDensity.getFactor();
        if (sourceDensity.greaterThan(ScreenDensity.MDPI)) {

            return value / factor;
        }
        return value * factor;
    }
}
