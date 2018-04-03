package serenitylabs.tutorials.vetclinic.sales;

import serenitylabs.tutorials.vetclinic.sales.model.LineItem;

public class ReducedRateCalculator implements TaxRateCalculator {
    @Override
    public TaxRate rateFor(LineItem item) {
        double rate = 0.09;

        if (item.getTotal() > 100) {
            rate = 0.135;
        }

        return new TaxRate(rate, "Reduced");
    }
}
