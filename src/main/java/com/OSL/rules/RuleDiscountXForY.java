package com.OSL.rules;

import com.OSL.Cart;
import com.OSL.PricingRule;
import com.OSL.model.Item;
import com.OSL.model.Product;

import java.math.BigDecimal;
import java.util.List;

public class RuleDiscountXForY implements PricingRule {

    private Product sku;
    private int baseQuantity;
    private int chargeQuantity;

    public RuleDiscountXForY(Product sku, int baseQuantity, int chargeQuantity) {
        this.sku = sku;
        this.baseQuantity = baseQuantity;
        this.chargeQuantity = chargeQuantity;
    }

    @Override
    public void applyRule(Cart cart) {
        List<Item> items = cart.getItemsBySKU(sku);
        for (int i = 0; i < items.size(); i++) {
            if ( i + 1 == baseQuantity) {
                Item item = items.get(i);
                item.amendPrice(new BigDecimal(0));
            }
        }
    }
}
