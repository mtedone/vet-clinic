package serenitylabs.tutorials.vetclinic.sales;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import serenitylabs.tutorials.vetclinic.sales.model.LineItem;
import serenitylabs.tutorials.vetclinic.sales.model.ProductCategory;
import serenitylabs.tutorials.vetclinic.sales.model.SalesTax;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static serenitylabs.tutorials.vetclinic.sales.model.ProductCategory.*;

@RunWith(Parameterized.class)
public class WhenApplyingSalesTax {

    private final static double NINE_PERCENT = 0.09;
    private final static double THIRTHEEN_POINT_FIVE_PERCENT = 0.135;
    private final int quantity;
    private final String name;
    private final ProductCategory category;
    private final double unitPrice;
    private final double expectedRate;
    private final String expectedRateName;
    private final double expectedAmount;

    public WhenApplyingSalesTax(int quantity, String name, ProductCategory category, double unitPrice,
                                double expectedRate, String expectedRateName, double expectedAmount) {

        this.quantity = quantity;
        this.name = name;
        this.category = category;
        this.unitPrice = unitPrice;
        this.expectedRate = expectedRate;
        this.expectedRateName = expectedRateName;
        this.expectedAmount = expectedAmount;
    }

    @Parameterized.Parameters(name = "{0} x {1} in category {2} costing €{3}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {1, "crisps", Snacks, 3.00, 0.09, "Reduced", 0.27},
                {50, "crisps", Snacks, 3.00, 0.135, "Reduced", 20.25},
                {1, "training dogs", Books, 5.00, 0.00, "Zero", 0.00},
                {1, "pills", Medicine, 5.00, 0.00, "Zero", 0.00},
                {1, "rubber bone", Toys, 10.00, 0.23, "Standard", 2.30}

        });
    }

    @Test
    public void items_should_be_charged_at_the_correct_rate() {
        // GIVEN
        LineItem crisps = LineItem.forASaleOf(quantity)
                                       .itemCalled(name)
                                       .inCategory(category)
                                       .withAUnitPriceOf(unitPrice);

        // WHEN
        SalesTaxService salesTaxService = new SalesTaxService();
        SalesTax calculatedSalesTax = salesTaxService.salesTaxEntryFor(crisps);

        // THEN
        SalesTax expectedSalesTax = SalesTax.atRateOf(expectedRate)
                .withName(expectedRateName)
                .forAnAmountOf(expectedAmount);

        assertThat(calculatedSalesTax, equalTo(expectedSalesTax));

    }


}
