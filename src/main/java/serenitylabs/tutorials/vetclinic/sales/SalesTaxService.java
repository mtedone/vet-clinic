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

    private static Map<ProductCategory, TaxRateCalculator> taxRateCalculatorMap = new HashMap<>();

    static {
        taxRateCalculatorMap.put(ProductCategory.Snacks, new ReducedRateCalculator());
        taxRateCalculatorMap.put(ProductCategory.Books, new ZeroRateCalculator());
        taxRateCalculatorMap.put(ProductCategory.Medicine, new ZeroRateCalculator());
        taxRateCalculatorMap.put(ProductCategory.SoftDrinks, new ReducedRateCalculator());

    }

    private TaxRate taxRateFor(LineItem item) {
        return taxRateCalculatorMap.getOrDefault(item.getCategory(), new StandardRateCalculator())
                .rateFor(item);
    }
}
