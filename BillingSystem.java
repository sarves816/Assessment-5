package com.billing;

public class BillingSystem {

    public static final double[] BASIC = {30.0, 50.0, 2.0};
    public static final double[] STANDARD = {50.0, 100.0, 1.5};
    public static final double[] PREMIUM = {80.0, 200.0, 1.0};

    public static double calculateBill(String planType, double dataConsumed) {
        double[] selectedPlan;

        switch (planType.toLowerCase().trim()) {
            case "basic":
                selectedPlan = BASIC;
                break;

            case "standard":
                selectedPlan = STANDARD;
                break;

            case "premium":
                selectedPlan = PREMIUM;
                break;

            default:
                throw new IllegalArgumentException("Invalid plan type.");
        }

        double baseCost = selectedPlan[0];
        double dataLimit = selectedPlan[1];
        double excessFeePerGB = selectedPlan[2];

        double excessData = Math.max(0, dataConsumed - dataLimit);
        double excessCharge = excessData * excessFeePerGB;

        return baseCost + excessCharge;
    }
}
