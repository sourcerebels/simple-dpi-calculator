package com.sourcerebels.simpledpicalculator.model;

/**
 * Result class.
 */
public class Result {

    private ScreenDensity mDensity;
    private float mValue;

    /**
     * Constructor.
     *
     * @param density Screen Density.
     * @param value   Value in pixels.
     */
    public Result(ScreenDensity density, float value) {

        mDensity = density;
        mValue = value;
    }

    /**
     * Gets the screen density associated with this result.
     *
     * @return Screen density.
     */
    public ScreenDensity getDensity() {

        return mDensity;
    }

    /**
     * Gets the value in pixels associated with this result.
     *
     * @return Value in pixels.
     */
    public float getValue() {

        return mValue;
    }

    @Override
    public boolean equals(Object o) {

        if (!(o instanceof  Result)) {
            return false;
        }
        Result other = (Result) o;
        return mDensity == other.mDensity && mValue == other.mValue;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("Result. density: ");
        sb.append(mDensity.toString());
        sb.append(" value: ");
        sb.append(mValue);
        return sb.toString();
    }
}
