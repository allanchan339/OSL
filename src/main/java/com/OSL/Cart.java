package com.OSL;

import com.OSL.model.Item;
import com.OSL.model.Product;

import java.math.BigDecimal;
import java.util.*;

public class Cart {
    private List<Item> cartItems = new ArrayList();
    public void addCartItem(Item item) {
        cartItems.add(item);
    }

    public List<Item> getItemsBySKU(Product sku) {
        List<Item> matchingItems = new ArrayList<>();
        for (Item item : this.cartItems) {
            if (item.getSku().equals(sku)) {
                matchingItems.add(item);
            }
        }
        return matchingItems;
    }

    public List<Item> getCartItems() {
        return cartItems;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < cartItems.size() - 1){
            sb.append(cartItems.get(i).getSku());
            sb.append(" ");
            ++i;
        }
        return sb.toString();
    }

    public BigDecimal getTotal() {
        BigDecimal cartTotal = new BigDecimal(0);
        for (Item item : this.cartItems) {
            cartTotal = cartTotal.add(item.getPrice());
        }
        return cartTotal;
    }
}
