package com.teamtreehouse.vending;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.Assert.assertNull;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by tboland on 12/22/15.
 */
public class BinTest {

    private Bin bin;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        bin = new Bin(10);
    }

    @Test()
    public void restockingWithDifferentItemsIsNotAllowed() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Cannot restock Cheetos with Doritos");

        bin.restock("Cheetos", 1, 50, 100);
        bin.restock("Doritos", 1, 50, 100);
    }

    @Test()
    public void whenEmptyPriceIsZero() throws Exception {
        bin.isEmpty();
        assertEquals("Item Price was not 0", 0, bin.getItemPrice());
    }

    @Test
    public void whenEmptyNameIsNull() throws Exception {
        assertNull(bin.getItemName());
    }

    @Test
    public void overStockingNotAllowed() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("There are only 10 spots left");

        bin.restock("Fritos", 2600, 50, 100);
    }
}