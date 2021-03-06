package com.OSL;

import com.OSL.model.Item;
import com.OSL.model.Product;

import java.util.*;

public class Catalogue {

    private Map<Product, Item> products = new HashMap<>();

    public Item newItem(Product sku) {
        Item item = products.get(sku);
        //create a new item (return a clone)
        return new Item(item.getSku(), item.getPrice());
    }

    public void addProduct(Item item) {
        products.put(item.getSku(), item);
    }
}
