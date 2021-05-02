package com.OSL.rules;

import com.OSL.Cart;
import com.OSL.PricingRule;
import com.OSL.model.Item;
import com.OSL.model.Product;

import java.math.BigDecimal;
import java.util.List;

public class RuleFreeBundle implements PricingRule {

    private Product sku;
    private Product skuFreeItem;

    public RuleFreeBundle(Product sku, Product skuFreeItem) {
        this.sku = sku;
        this.skuFreeItem = skuFreeItem;
    }

    @Override
    public void applyRule(Cart cart) {
        List<Item> items = cart.getItemsBySKU(sku);
        List<Item> itemsFree = cart.getItemsBySKU(skuFreeItem);
        for (int i = 0; i < itemsFree.size(); i++) {
            //free item for every base item
            if (i < items.size() ) {
                Item item = itemsFree.get(i);
                item.amendPrice(new BigDecimal(0));
            }
        }
    }
}
