package com.OSL;

import com.OSL.model.Item;
import com.OSL.model.Product;
import com.OSL.rules.RuleBulkDiscount;
import com.OSL.rules.RuleFreeBundle;
import com.OSL.rules.RuleDiscountXForY;

import java.math.BigDecimal;
import java.util.*;

public class Store {

    private Catalogue catalogue = new Catalogue();
    private Map<Product,PricingRule> pricingRules = new HashMap<>();

    public Store() {

        //populate catalogue
        catalogue.addProduct(new Item(Product.IPD,  new BigDecimal("549.99")));
        catalogue.addProduct(new Item(Product.MBP, new BigDecimal("1399.99")));
        catalogue.addProduct(new Item(Product.ATV,  new BigDecimal("109.50")));
        catalogue.addProduct(new Item(Product.VGA,  new BigDecimal("30.00")));

        //populate pricing rules

        //We're going to have a 3 for 2 deal on Apple TVs. For example, if you buy 3 Apple TVs, you will pay the price of 2 only
        pricingRules.put(Product.ATV, new RuleDiscountXForY(Product.ATV, 3, 2));
        //The brand new Super iPad will have a bulk discounted applied, where the price will drop to $499.99 each, if someone buys more than 4
        pricingRules.put(Product.IPD, new RuleBulkDiscount(Product.IPD, 4, new BigDecimal("499.99")));
        //We will bundle in a free VGA adapter free of charge with every MacBook Pro sold
        pricingRules.put(Product.VGA, new RuleFreeBundle(Product.MBP, Product.VGA));

    }

    public Catalogue getCatalogue() {
        return catalogue;
    }

    public Map<Product, PricingRule> getPricingRules() {
        return pricingRules;
    }
}
