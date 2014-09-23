package com.sara.interviews.comboItems;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BestOfferFinderTest extends TestCase {
    private Offer[] offers;
    private final Item a = new Item("A");
    private final Item b = new Item("B");
    private final Item c = new Item("C");
    private final Item d = new Item("D");
    private final Item e = new Item("E");
    private BestOfferFinder finder;

    private void testItems(LinkedList<Item> items, List<Integer> expectedSolution) {
        List<Integer> solution = finder.find(items);
        assertEquals("Incorrect solution found by the algorithm", expectedSolution, solution);
    }

    public void testFind() {
        offers = new Offer[6];
        offers[0] = new Offer(new LinkedList<>(Arrays.asList(a)), 1.2);
        offers[1] = new Offer(new LinkedList<>(Arrays.asList(a,b)), 2.0);
        offers[2] = new Offer(new LinkedList<>(Arrays.asList(b,c,d)), 2.1);
        offers[3] = new Offer(new LinkedList<>(Arrays.asList(d)), 0.9);
        offers[4] = new Offer(new LinkedList<>(Arrays.asList(c)), 1.9);
        offers[5] = new Offer(new LinkedList<>(Arrays.asList(c,d)), 2.2);
        finder = new BestOfferFinder(offers);
        testItems(new LinkedList<>(Arrays.asList(a,b,c,d)), new LinkedList<>(Arrays.asList(0,2)));
        testItems(new LinkedList<>(Arrays.asList(a)), new LinkedList<>(Arrays.asList(0)));
        testItems(new LinkedList<>(Arrays.asList(b)), new LinkedList<>(Arrays.asList(1)));
        testItems(new LinkedList<>(Arrays.asList(c)), new LinkedList<>(Arrays.asList(4)));
        testItems(new LinkedList<>(Arrays.asList(d)), new LinkedList<>(Arrays.asList(3)));
        testItems(new LinkedList<>(Arrays.asList(c,d)), new LinkedList<>(Arrays.asList(2)));
        testItems(new LinkedList<>(Arrays.asList(e)), new LinkedList<>());
        testItems(new LinkedList<>(), new LinkedList<>());
    }
}