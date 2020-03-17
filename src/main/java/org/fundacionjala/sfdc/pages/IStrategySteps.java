package org.fundacionjala.sfdc.pages;

/**
 * Interface to perform Steps.
 */
@FunctionalInterface
public interface IStrategySteps {

    /**
     * Perform the assigned step.
     */
    void performStep();
}
