package com.sara.interviews.comboItems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class BestOfferFinder {
    private final Offer[] offers;
    private double bestPrice;
    private LinkedList<Integer> bestOffer;
    private List<Item> items;
    private CoveredItems coveredItems;
    private LinkedList<Integer> chosenOffers;

    public BestOfferFinder(Offer... offers) {
        this.offers = offers;
    }

    class CoveredItems {

        private HashMap<Item, Integer> covered = new HashMap<>();;

        public CoveredItems() {
            for (Item item : items) {
                covered.put(item, 0);
            }
        }

        public int occurrenceCount(Item item) {
            Integer value = covered.get(item);
            return value == null ? 0 : value;
        }

        public void updateCovered(int offerId, boolean offerIncluded) {
            for (Item item:offers[offerId].getItems()) {
                int value = offerIncluded ? coveredItems.occurrenceCount(item)+1 : coveredItems.occurrenceCount(item)-1;
                covered.put(item, value);
            }
        }

        public boolean allCovered() {
            for (Item item : items) {
                Integer value = covered.get(item);
                if (value == null || value == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    private double calculatePrice(List<Integer> offerIds) {
        if (offerIds == null) {
            return Double.MAX_VALUE;
        }
        double price = 0.0;
        for (int offerId : offerIds) {
            price += offers[offerId].getPrice();
        }
        return price;
    }

    private void processOffer(int offerId) {
        if (offerId < offers.length) {
            if (coveredItems.allCovered()) {
                double price = calculatePrice(chosenOffers);
                if (price < bestPrice) {
                    bestPrice = price;
                    bestOffer = (LinkedList) chosenOffers.clone();
                }
            }
            else {
                if (offers[offerId].coversNewItem(coveredItems)) {
                    chosenOffers.add(offerId);
                    coveredItems.updateCovered(offerId, true);
                    processOffer(offerId+1);
                    chosenOffers.pollLast();
                    coveredItems.updateCovered(offerId, false);
                }
                processOffer(offerId+1);
            }
        }
    }

    public LinkedList<Integer> find(List<Item> items) {
        this.items = items;
        coveredItems = new CoveredItems();
        chosenOffers = new LinkedList<>();
        bestPrice = Double.MAX_VALUE;
        bestOffer = new LinkedList<>();
        processOffer(0);
        return bestOffer;
    }

}
