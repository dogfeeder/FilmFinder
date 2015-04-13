package asgn1Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import asgn1Index.Record;
import asgn1Index.RecordCollection;
import asgn1Index.IndexException;
public class RecordCollectionTests {
	
	  /**
     * Test method for {@link asgn1Index.RecordCollection#addRecord(Record r)}.
     * Checks that a valid record is added correctly to the collection
     * @throws IndexException 
     */
	@Test
	public void checkAddRecord() throws IndexException {
		RecordCollection testCollection = new RecordCollection();
		Record testMovie = new Record("Test Movie 1", 20);
		testCollection.addRecord(testMovie);
		testCollection.sortCollection();
		assertTrue(testCollection.findClosestRecord().equals(testMovie));
	}
	
	  /**
     * Test method for {@link asgn1Index.RecordCollection#addRecord(Record r)}.
     * Checks that IndexException is thrown if the record is null
     * @throws IndexException 
     */
	@Test(expected=IndexException.class)
	public void checkAddRecordNull() throws IndexException {
		RecordCollection testCollection = new RecordCollection();
		Record testMovie = null;
		testCollection.addRecord(testMovie);
	}
	
	  /**
     * Test method for {@link asgn1Index.RecordCollection#addRecord(Record r)}.
     * Checks that IndexException is thrown if the collection is not sorted
     * @throws IndexException 
     */
	@Test(expected=IndexException.class)
	public void checkAddRecordNotSorted() throws IndexException {
		RecordCollection testCollection = new RecordCollection();
		Record testMovie = new Record("Test Movie 1", 20);
		testCollection.addRecord(testMovie);
		testCollection.findClosestRecord();
	}
	
	  /**
     * Test method for {@link asgn1Index.RecordCollection#addRecord(Record r)}.
     * Checks that IndexException is thrown if a record is added after sorting without resorting
     * @throws IndexException 
     */
	@Test(expected=IndexException.class)
	public void checkAddRecordAfterSorting() throws IndexException {
		RecordCollection testCollection = new RecordCollection();
		
		Record testMovie = new Record("Test Movie 1", 20);
		Record testMovie2 = new Record("Test Movie 2", 40);
		
		testCollection.addRecord(testMovie);
		testCollection.findClosestRecord();
		testCollection.addRecord(testMovie2);
	}
	
	  /**
	 * Method by: samuelbr
     * Test method for {@link asgn1Index.RecordCollection#isSorted()}.
     * Check that sorted flag is unset after more records are added after call to <code>sortCollection</code>.
     * @throws IndexException 
     */
    @Test
    public void collectionNotSortedAfterSortingThenAdding() throws IndexException {
    	Record moon = new Record("moon", 0);
    	Record sun = new Record("sun", 0);
        RecordCollection unsortedRecordCollection = new RecordCollection();
    	
    	unsortedRecordCollection.addRecord(sun);
		unsortedRecordCollection.sortCollection();
        assertTrue(unsortedRecordCollection.isSorted());
		unsortedRecordCollection.addRecord(moon);
        assertFalse(unsortedRecordCollection.isSorted());
    }
    
	  /**
     * Test method for {@link asgn1Index.RecordCollection#findClosestRecord()}.
     * Checks that the first record of the collection is the record with the highest similarity
     * @throws IndexException 
     */
	@Test
	public void checkFindClosestRecord() throws IndexException {
		RecordCollection testCollection = new RecordCollection();
		
		Record testMovie = new Record("Test Movie 1", 20);
		Record testMovie2 = new Record("Test Movie 2", 40);
		Record testMovie3 = new Record("Test Movie 3", 60);
		Record testMovie4 = new Record("Test Movie 4", 80);
		
		testCollection.addRecord(testMovie);
		testCollection.addRecord(testMovie2);
		testCollection.addRecord(testMovie3);
		testCollection.addRecord(testMovie4);
		testCollection.sortCollection();
		
		assertTrue(testCollection.findClosestRecord().equals(testMovie4));
	}
	
	  /**
     * Test method for {@link asgn1Index.RecordCollection#findClosestRecord()}.
     * Checks that IndexException is thrown when the collection is not sorted
     * @throws IndexException 
     */
	@Test(expected=IndexException.class)
	public void checkFindClosestRecordNotSorted() throws IndexException {
		RecordCollection testCollection = new RecordCollection();
		
		Record testMovie = new Record("Test Movie 1", 20);
		Record testMovie2 = new Record("Test Movie 2", 40);
		Record testMovie3 = new Record("Test Movie 3", 60);
		Record testMovie4 = new Record("Test Movie 4", 80);
		
		testCollection.addRecord(testMovie);
		testCollection.addRecord(testMovie2);
		testCollection.addRecord(testMovie3);
		testCollection.addRecord(testMovie4);
		
		testCollection.findClosestRecord().equals(testMovie4);
	}
	
	  /**
     * Test method for {@link asgn1Index.RecordCollection#findClosestRecords(int n)}.
     * Checks the records with the highest similarity are returned
     * @throws IndexException 
     */
	@Test
	public void checkFindClosestRecords() throws IndexException {
		RecordCollection testCollection = new RecordCollection();
		List<Record> testClosest = new ArrayList<Record>();
		int numberOfRecords = 2;
		
		Record testMovie = new Record("Test Movie 1", 20);
		Record testMovie2 = new Record("Test Movie 2", 40);
		Record testMovie3 = new Record("Test Movie 3", 60);
		Record testMovie4 = new Record("Test Movie 4", 80);
		
		testClosest.add(testMovie4);
		testClosest.add(testMovie3);
		
		testCollection.addRecord(testMovie);
		testCollection.addRecord(testMovie2);
		testCollection.addRecord(testMovie3);
		testCollection.addRecord(testMovie4);
		
		testCollection.sortCollection();
		assertTrue(testCollection.findClosestRecords(numberOfRecords).equals(testClosest));
	}
	
	  /**
     * Test method for {@link asgn1Index.RecordCollection#findClosestRecords(int n)}.
     * Checks that IndexException is thrown when the collection is not sorted
     * @throws IndexException 
     */
    //Not sorted
	@Test(expected=IndexException.class)
	public void checkFindClosestRecordsNotSorted() throws IndexException {
		RecordCollection testCollection = new RecordCollection();
		int numberOfRecords = 2;
		
		Record testMovie = new Record("Test Movie 1", 20);
		Record testMovie2 = new Record("Test Movie 2", 40);
		Record testMovie3 = new Record("Test Movie 3", 60);
		Record testMovie4 = new Record("Test Movie 4", 80);
		
		testCollection.addRecord(testMovie);
		testCollection.addRecord(testMovie2);
		testCollection.addRecord(testMovie3);
		testCollection.addRecord(testMovie4);
		
		testCollection.findClosestRecords(numberOfRecords);
	}
	
	  /**
     * Test method for {@link asgn1Index.RecordCollection#findClosestRecords(int n)}.
     * Checks that IndexException is thrown when the number of records requested exceeds the records available
     * @throws IndexException 
     */
	@Test(expected=IndexException.class)
	public void checkFindClosestRecordsToManyRecords() throws IndexException {
		RecordCollection testCollection = new RecordCollection();
		List<Record> testClosest = new ArrayList<Record>();
		int numberOfRecords = 5;
		
		Record testMovie = new Record("Test Movie 1", 20);
		Record testMovie2 = new Record("Test Movie 2", 40);
		Record testMovie3 = new Record("Test Movie 3", 60);
		Record testMovie4 = new Record("Test Movie 4", 80);
		
		testClosest.add(testMovie4);
		testClosest.add(testMovie3);
		
		testCollection.addRecord(testMovie);
		testCollection.addRecord(testMovie2);
		testCollection.addRecord(testMovie3);
		testCollection.addRecord(testMovie4);
		
		testCollection.sortCollection();
		testCollection.findClosestRecords(numberOfRecords);
	}
	
	  /**
     * Test method for {@link asgn1Index.RecordCollection#findClosestRecords(int n)}.
     * Checks that IndexException is thrown when the number of records requested exceeds the records available and collection is not sorted
     * @throws IndexException 
     */
	@Test(expected=IndexException.class)
	public void checkFindClosestRecordsNotSortedAndToManyRecords() throws IndexException {
		RecordCollection testCollection = new RecordCollection();
		List<Record> testClosest = new ArrayList<Record>();
		int numberOfRecords = 5;
		
		Record testMovie = new Record("Test Movie 1", 20);
		Record testMovie2 = new Record("Test Movie 2", 40);
		Record testMovie3 = new Record("Test Movie 3", 60);
		Record testMovie4 = new Record("Test Movie 4", 80);
		
		testClosest.add(testMovie4);
		testClosest.add(testMovie3);
		
		testCollection.addRecord(testMovie);
		testCollection.addRecord(testMovie2);
		testCollection.addRecord(testMovie3);
		testCollection.addRecord(testMovie4);
		
		testCollection.findClosestRecords(numberOfRecords);
	}
	
	  /**
     * Test method for {@link asgn1Index.RecordCollection#isSorted()}.
     * Checks that the method returns true after a collection has been sorted
     * @throws IndexException 
     */
	@Test
	public void checkIsSorted() throws IndexException {
		RecordCollection testCollection = new RecordCollection();
		Record testMovie = new Record("Test Movie 1", 20);
		testCollection.addRecord(testMovie);
		testCollection.sortCollection();
		assertTrue(testCollection.isSorted());
	}
	
	  /**
     * Test method for {@link asgn1Index.RecordCollection#isSorted()}.
     * Checks that the method returns false if the collection is not sorted
     * @throws IndexException 
     */
	@Test
	public void checkIsSorted2() throws IndexException {
		RecordCollection testCollection = new RecordCollection();
		Record testMovie = new Record("Test Movie 1", 20);
		testCollection.addRecord(testMovie);
		assertFalse(testCollection.isSorted());
	}
	
	@Test
	public void checkConstructorIsNotNull() throws IndexException {
		RecordCollection testCollection = new RecordCollection();
		assertNotNull(testCollection);
	}
	
    

}
