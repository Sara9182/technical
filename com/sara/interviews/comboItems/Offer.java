package com.sara.interviews.comboItems;

import java.util.List;

class Offer {
    private final List<Item> items;
    private final double price;

    public Offer (List<Item> items, double price) {
        this.items = items;
        this.price = price;
    }

    public List<Item> getItems() {
        return items;
    }

    public double getPrice() {
        return price;
    }

    public boolean coversNewItem(BestOfferFinder.CoveredItems coveredItems) {
        for (Item item:items) {
            if (coveredItems.occurrenceCount(item) == 0) {
                return true;
            }
        }
        return false;
    }
}
