package com.sara.interviews;

import java.util.List;

public class Offer {
    public List<Item> items;
    public double price;

    public Offer (List<Item> items, double price) {
        this.items = items;
        this.price = price;
    }

    public boolean coversNewItem(BestOfferFinder.CoveredItems coveredItems) {
        boolean coversNew = false;
        for (Item item:items) {
            if (coveredItems.occurenceCount(item) == 0) {
                return true;
            }
        }
        return false;
    }
}
