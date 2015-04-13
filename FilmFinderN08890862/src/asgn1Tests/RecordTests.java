package asgn1Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import asgn1Index.IndexException;
import asgn1Index.Record;

public class RecordTests {
	
	  /**
     * Test method for {@link asgn1Index.Record#Record(String title, int similarity)}.
     * Checks if a valid constructor correctly sets the movie title and similarity
     * @throws IndexException 
     */
	//normal constructor
	@Test
	public void checkRecordConstructor() throws IndexException {
		String movie = "Test Movie 1";
		int sim = 5;
		
		Record test = new Record(movie, sim);
		
		assertTrue(test.getTitle().equals(movie) && test.getSimilarity() == sim);
	}
	
	  /**
     * Test method for {@link asgn1Index.Record#Record(String title, int similarity)}.
     * Checks if IndexException is thrown if the movie is null
     * @throws IndexException 
     */
	@Test(expected=IndexException.class)
	public void checkRecordConstructorNullTitle() throws IndexException {
		String movie = null;
		int sim = 5;
		
		Record test = new Record(movie, sim);
	}
	
	  /**
     * Test method for {@link asgn1Index.Record#Record(String title, int similarity)}.
     * Checks if IndexException is thrown if the movie is empty
     * @throws IndexException 
     */
	@Test(expected=IndexException.class)
	public void checkRecordConstructorEmptyTitle() throws IndexException {
		String movie = "";
		int sim = 5;
		
		Record test = new Record(movie, sim);
	}
	
	  /**
     * Test method for {@link asgn1Index.Record#Record(String title, int similarity)}.
     * Checks if IndexException if similarity is negative
     * @throws IndexException 
     */
	@Test(expected=IndexException.class)
	public void checkRecordConstructorNegativeSim() throws IndexException {
		String movie = "Test Movie 1";
		int sim = -1;
		
		Record test = new Record(movie, sim);
	}
	
	  /**
     * Test method for {@link asgn1Index.Record#Record(String title, int similarity)}.
     * Checks if IndexException if similarity is negative and movie is null
     * @throws IndexException 
     */
	@Test(expected=IndexException.class)
	public void checkRecordConstructorNegSimAndNullTitle() throws IndexException {
		String movie = null;
		int sim = -1;
		
		Record test = new Record(movie, sim);

	}
	
	  /**
     * Test method for {@link asgn1Index.Record#Record(String title, int similarity)}.
     * Checks if IndexException if similarity is negative and movie is empty
     * @throws IndexException 
     */
	@Test(expected=IndexException.class)
	public void checkRecordConstructorNegSimAndEmptyTitle() throws IndexException {
		String movie = "";
		int sim = -1;
		
		Record test = new Record(movie, sim);
	}
	
	  /**
     * Test method for {@link asgn1Index.Record#compareTo(Record r)}.
     * Checks if .this is greater than parameter
     * @throws IndexException 
     */
	@Test
	public void checkCompareTo1() throws IndexException {
		Record test = new Record("Movie 1", 10);
		Record test2 = new Record("Movie 2", 7);
		assertTrue(test.compareTo(test2) == 1);
	}
	
	  /**
     * Test method for {@link asgn1Index.Record#compareTo(Record r)}.
     * Checks if parameter is greater than .this
     * @throws IndexException 
     */
	@Test
	public void checkCompareTo2() throws IndexException {
		Record test = new Record("Movie 1", 7);
		Record test2 = new Record("Movie 2", 10);
		assertTrue(test.compareTo(test2) == -1);
	}
	
	  /**
     * Test method for {@link asgn1Index.Record#compareTo(Record r)}.
     * Checks if parameter and .this is equal
     * @throws IndexException 
     */
	@Test
	public void checkCompareTo3() throws IndexException {
		Record test = new Record("Movie 1", 7);
		Record test2 = new Record("Movie 2", 7);
		assertTrue(test.compareTo(test2) == 0);
	}
	
	  /**
     * Test method for {@link asgn1Index.Record#getTitle()} and {@link asgn1Index.Record#getSimilarity()}.
     * Checks if the title and similarity are returned correctly
     * @throws IndexException 
     */
	@Test
	public void checkGetTitleandGetSim() throws IndexException {
		String title = "Testing";
		int sim = 52;
		
		Record test = new Record(title,sim);
		
		assertTrue(test.getSimilarity() == sim && test.getTitle().equals(title));
		
	}
	
	
}
