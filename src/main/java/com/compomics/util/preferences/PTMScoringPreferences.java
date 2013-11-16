package com.compomics.util.preferences;

import com.compomics.util.experiment.identification.ptm.PtmScore;
import java.io.Serializable;

/**
 * This class contains the PTM scoring preferences.
 *
 * @author Marc Vaudel
 */
public class PTMScoringPreferences implements Serializable {

    /**
     * Serial number for backward compatibility.
     */
    static final long serialVersionUID = -6656074270981104708L;
    /**
     * Boolean indicating whether the A-score should be calculated.
     *
     * @deprecated use probabilitsticScoreCalculation instead
     */
    private boolean aScoreCalculation = true;
    /**
     * Boolean indicating whether neutral losses shall be accounted in the
     * calculation of the A-score.
     *
     * @deprecated use probabilisticScoreNeutralLosses instead
     */
    private boolean aScoreNeutralLosses = false;
    /**
     * The FLR threshold in percent
     */
    private double flr = 1.0;
    /**
     * Boolean indicating whether a probabilitstic score is to be calculated.
     */
    private Boolean probabilitsticScoreCalculation = true;
    /**
     * The probabilistic score selected.
     */
    private PtmScore selectedProbabilisticScore = PtmScore.AScore;
    /**
     * Boolean indicating whether the threshold should be FLR based.
     */
    private boolean estimateFlr = true;
    /**
     * The probabilistic score threshold.
     */
    private double probabilisticScoreThreshold = 99;
    /**
     * Boolean indicating whether neutral losses shall be accounted for in the
     * calculation of the probabilistic score.
     */
    private Boolean probabilisticScoreNeutralLosses = false;

    /**
     * Constructor.
     */
    public PTMScoringPreferences() {
    }

    /**
     * Indicates whether a probabilistic PTM score is required.
     *
     * @return a boolean indicating whether a probabilistic PTM score is
     * required
     */
    public Boolean isProbabilitsticScoreCalculation() {
        if (probabilitsticScoreCalculation == null) {
            // Backward compatibility check
            probabilitsticScoreCalculation = aScoreCalculation;
        }
        return probabilitsticScoreCalculation;
    }

    /**
     * Sets whether a probabilistic PTM score is required.
     *
     * @param probabilitsticScoreCalculation a boolean indicating whether a
     * probabilistic PTM score is required
     */
    public void setProbabilitsticScoreCalculation(boolean probabilitsticScoreCalculation) {
        this.probabilitsticScoreCalculation = probabilitsticScoreCalculation;
    }

    /**
     * Returns the selected probabilistic score.
     *
     * @return the selected probabilistic score
     */
    public PtmScore getSelectedProbabilisticScore() {
        return selectedProbabilisticScore;
    }

    /**
     * Sets the selected probabilistic score.
     *
     * @param selectedProbabilisticScore the selected probabilistic score
     */
    public void setSelectedProbabilisticScore(PtmScore selectedProbabilisticScore) {
        this.selectedProbabilisticScore = selectedProbabilisticScore;
    }

    /**
     * Indicates whether the threshold is FLR based
     *
     * @return a boolean indicating whether the threshold is FLR based
     */
    public boolean isEstimateFlr() {
        return estimateFlr;
    }

    /**
     * Sets whether the threshold is FLR based.
     *
     * @param estimateFlr indicates whether the threshold is FLR based
     */
    public void setEstimateFlr(boolean estimateFlr) {
        this.estimateFlr = estimateFlr;
    }

    /**
     * Returns the probabilistic score threshold.
     *
     * @return the probabilistic score threshold
     */
    public double getProbabilisticScoreThreshold() {
        return probabilisticScoreThreshold;
    }

    /**
     * Sets the probabilistic score threshold.
     *
     * @param probabilisticScoreThreshold the probabilistic score threshold
     */
    public void setProbabilisticScoreThreshold(double probabilisticScoreThreshold) {
        this.probabilisticScoreThreshold = probabilisticScoreThreshold;
    }

    /**
     * Indicates whether the neutral losses shall be taken into account for
     * spectrum annotation when calculating the probabilistic score.
     *
     * @return a boolean indicating whether the neutral losses shall be taken
     * into account for spectrum annotation when calculating the probabilistic
     * score
     */
    public Boolean isProbabilisticScoreNeutralLosses() {
        if (probabilisticScoreNeutralLosses == null) {
            // Backward compatibility check
            probabilisticScoreNeutralLosses = aScoreNeutralLosses;
        }
        return probabilisticScoreNeutralLosses;
    }

    /**
     * Sets whether the neutral losses shall be taken into account for spectrum
     * annotation when calculating the probabilistic score.
     *
     * @param probabilisticScoreNeutralLosses indicates whether the neutral
     * losses shall be taken into account for spectrum annotation when
     * calculating the probabilistic score
     */
    public void setProbabilisticScoreNeutralLosses(boolean probabilisticScoreNeutralLosses) {
        this.probabilisticScoreNeutralLosses = probabilisticScoreNeutralLosses;
    }

    /**
     * Returns a boolean indicating whether the A-score should be calculated.
     *
     * @deprecated use isProbabilitsticScoreCalculation instead
     * @return a boolean indicating whether the A-score should be calculated
     */
    public boolean aScoreCalculation() {
        return aScoreCalculation;
    }

    /**
     * Sets whether the A-score should be calculated.
     *
     * @deprecated use setProbabilitsticScoreCalculation instead
     * @param aScoreCalculation a boolean indicating whether the A-score should
     * be calculated
     */
    public void setaScoreCalculation(boolean aScoreCalculation) {
        this.aScoreCalculation = aScoreCalculation;
    }

    /**
     * Indicates whether the A-score calculation should take neutral losses into
     * account.
     *
     * @deprecated use isProbabilisticScoreNeutralLosses instead
     * @return a boolean indicating whether the A-score calculation should take
     * neutral losses into account
     */
    public boolean isaScoreNeutralLosses() {
        return aScoreNeutralLosses;
    }

    /**
     * Sets whether the A-score calculation should take neutral losses into
     * account.
     *
     * @deprecated use setProbabilisticScoreNeutralLosses instead
     * @param aScoreNeutralLosses a boolean indicating whether the A-score
     * calculation should take neutral losses into account
     */
    public void setaScoreNeutralLosses(boolean aScoreNeutralLosses) {
        this.aScoreNeutralLosses = aScoreNeutralLosses;
    }

    /**
     * Returns the FLR threshold.
     *
     * @return the FLR threshold
     */
    public double getFlrThreshold() {
        return flr;
    }

    /**
     * Sets the FLR threshold.
     *
     * @param flr the FLR threshold
     */
    public void setFlrThreshold(double flr) {
        this.flr = flr;
    }
}
