package com.OSL;

import com.OSL.exception.ShopException;
import com.OSL.model.Item;
import com.OSL.model.Product;

import java.math.BigDecimal;
import java.util.Map;

public class Checkout {
    private Cart cart = new Cart();
    private Map<Product, PricingRule> pricingRules;
    private Store store;
    private StringBuilder CartList = new StringBuilder();
    public Checkout(Map<Product, PricingRule> pricingRules) {
        this.pricingRules = pricingRules;
    }

    public void scan (Product product) throws ShopException {
        if (product == null) {
            throw new ShopException("Supplied product does not exist in catalogue");
        }

        Item item = store.getCatalogue().newItem(product);
        cart.addCartItem(item);
        CartList.append(item.getSku());
        CartList.append(" ");
        PricingRule rule = pricingRules.get(product);
        if (rule != null) {
            rule.applyRule(cart);
        }
    }

    public String getCartList() {
        return CartList.toString();
    }

    public Cart getCart() {
        return cart;
    }
    public BigDecimal total() {
        return cart.getTotal();
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
