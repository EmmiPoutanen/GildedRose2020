package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {

	@Test
	public void testTheTruth() {
		assertTrue(true);
	}
	@Test
	public void decreaseQuality() {
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("+5 Dexterity Vest", 10, 20));
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		//assert quality has decreased by one
		assertEquals("Failed quality for Dexterity Vest", 19, quality);
	}
	
	@Test
	public void increaseQualityOver50() {
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Aged Brie", 10, 45));
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		
		List<Item> items = inn.getItems();
		int quality_brie = items.get(0).getQuality();
		
		// assert quality has stopped increasing to 50
		assertEquals("Failed quality for Aged Brie", 50, quality_brie);
	}
	
	@Test
	public void decreaseQualityBelow0() {
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Elixir of the Mongoose", 10, 5));
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		
		List<Item> items = inn.getItems();
		int quality_mongoose = items.get(0).getQuality();
		
		// assert quality has stopped decreasing to 0
		assertEquals("Failed quality for Mongoose", 0, quality_mongoose);
	}
	
	@Test
	public void ageSulfuras() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		inn.oneDay();
		inn.oneDay();
		
		List<Item> items = inn.getItems();
		int quality_sulfuras = items.get(0).getQuality();
		
		// assert quality has not altered
		assertEquals("Failed quality for Sulfuras", 80, quality_sulfuras);
	}
	
	@Test
	public void ticketValue() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		inn.oneDay();
		inn.oneDay();
		
		List<Item> items = inn.getItems();
		int quality_ticket = items.get(0).getQuality();
		
		// assert quality has not altered
		assertEquals("Failed quality for Ticket", 30, quality_ticket);
	}
	
	
}