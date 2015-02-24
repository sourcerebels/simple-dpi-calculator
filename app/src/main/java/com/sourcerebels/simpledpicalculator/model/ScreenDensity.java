package com.sourcerebels.simpledpicalculator.model;

/**
 * Densities enumeration.
 */
public enum ScreenDensity {

    LDPI(0.75f),
    MDPI(1.0f),
    HDPI(1.5f),
    XHDPI(2.0f),
    XXHDPI(3.0f),
    XXXHDPI(4.0f);

    private float mFactor;

    private ScreenDensity(float factor) {

        mFactor = factor;
    }

    public float getFactor() {

        return mFactor;
    }
}
