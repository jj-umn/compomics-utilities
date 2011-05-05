package com.compomics.util.experiment.massspectrometry;

import com.compomics.util.experiment.personalization.ExperimentObject;

/**
 * This class models a charge.
 *
 * Created by IntelliJ IDEA.
 * User: Marc
 * Date: Jun 23, 2010
 * Time: 10:01:29 AM
 */
public class Charge extends ExperimentObject {

    /**
     * The version UID for Serialization/Deserialization compatibility
     */
    static final long serialVersionUID = -7119215126058492261L;
    /**
     * static int to modele a positive charge
     */
    public final static int PLUS = +1;
    /**
     * static int to modele a negative charge
     */
    public final static int MINUS = -1;
    /**
     * static int to modele a neutral component
     */
    public final static int NEUTRAL = 0;
    /**
     * sign of the charge according to the static fields
     */
    public int sign;
    /**
     * value of the charge
     */
    public int value;

    /**
     * constructor for a charge
     *
     * @param sign  sign of the charge as specified in static fields
     * @param value value of the charge
     */
    public Charge(int sign, int value) {
        this.sign = sign;
        this.value = value;
    }

    /**
     * returns a string representing the charge
     * 
     * @return charge as a string
     */
    public String toString() {
        switch (sign) {
            case PLUS:
                return value + "+";
            case MINUS:
                return value + "-";
            default:
                return "";
        }
    }

    /**
     * Returns the charge as a string of +. One for each charge.
     * A charge of 1 however returns the empty string.
     *
     * @return  the charge as a string of +
     */
    public String getChargeAsFormattedString() {

        String temp = "";

        for (int i = 0; i < value; i++) {
            temp += "+";
        }

        if (value == 1) {
            temp = "";
        }

        return temp;
    }
}
