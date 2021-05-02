package com.OSL.rules;

import com.OSL.Cart;
import com.OSL.PricingRule;
import com.OSL.model.Item;
import com.OSL.model.Product;

import java.math.BigDecimal;
import java.util.List;

public class RuleBulkDiscount implements PricingRule {

    private Product sku;
    private int quantity;
    private BigDecimal discountPrice;

    public RuleBulkDiscount(Product sku, int quantity, BigDecimal discountPrice) {
        this.sku = sku;
        this.quantity = quantity;
        this.discountPrice = discountPrice;
    }

    @Override
    public void applyRule(Cart cart) {
        List<Item> items = cart.getItemsBySKU(sku);
        if (items.size() > quantity) {
            for (int i = 0; i < items.size(); i++) {
                Item item = items.get(i);
                item.amendPrice(discountPrice);
            }
        }
    }
}
