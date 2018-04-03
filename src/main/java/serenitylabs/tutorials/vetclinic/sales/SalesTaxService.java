package serenitylabs.tutorials.vetclinic.sales;

import serenitylabs.tutorials.vetclinic.sales.model.LineItem;
import serenitylabs.tutorials.vetclinic.sales.model.ProductCategory;
import serenitylabs.tutorials.vetclinic.sales.model.SalesTax;

import java.util.HashMap;
import java.util.Map;

public class SalesTaxService {

    public SalesTax salesTaxEntryFor(LineItem item) {

        TaxRate applicableTaxRate = taxRateFor(item);

        return SalesTax.atRateOf(applicableTaxRate.getRate())
                .withName(applicableTaxRate.getName())
                .forAnAmountOf(NumberUtils.round(item.getTotal() * applicableTaxRate.getRate(), 2));
    }

    static TaxRateCalculator STANDARD_RATE = (item) -> new TaxRate(0.23, "Standard");
    static TaxRateCalculator ZERO_RATE = (item) -> new TaxRate(0.00, "Zero");
    static TaxRateCalculator REDUCED_RATE = (item) -> {
        double rate =  (item.getTotal() > 100) ? 0.135 : 0.09;
        return new TaxRate(rate, "Reduced");
    };

    private static Map<ProductCategory, TaxRateCalculator> taxRateCalculatorMap = new HashMap<>();

    static {
        taxRateCalculatorMap.put(ProductCategory.Snacks, REDUCED_RATE);
        taxRateCalculatorMap.put(ProductCategory.Books, ZERO_RATE);
        taxRateCalculatorMap.put(ProductCategory.Medicine, ZERO_RATE);
        taxRateCalculatorMap.put(ProductCategory.SoftDrinks, REDUCED_RATE);

    }

    private TaxRate taxRateFor(LineItem item) {
        return taxRateCalculatorMap.getOrDefault(item.getCategory(), STANDARD_RATE)
                .apply(item);
    }
}
