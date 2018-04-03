package serenitylabs.tutorials.vetclinic.sales;

import serenitylabs.tutorials.vetclinic.sales.model.LineItem;

import java.util.function.Function;

public interface TaxRateCalculator extends Function<LineItem, TaxRate> {}
