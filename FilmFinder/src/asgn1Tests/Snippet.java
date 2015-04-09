package asgn1Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import asgn1Index.IndexException;
import asgn1Index.Record;
import asgn1Index.RecordCollection;

//The test for the addRecord call after the ArrayList has been sorted. Please listen to the 
//podcast for details. 
//Note that you will have to declare appropriate variables to make this work, but these will 
//be required for most of your tests. 

//This test should end up in the class RecordCollectionTests

public class Snippet {
	  /** @author samuelbr
	     * Test method for {@link asgn1Index.RecordCollection#isSorted()}.
	     * Check that sorted flag is unset after more records are added after call to <code>sortCollection</code>.
	     * @throws IndexException 
	     */
	    @Test
	    public void collectionNotSortedAfterSortingThenAdding() throws IndexException {
	    	Record moon = new Record("moon", 0);
	    	Record sun = new Record("sun", 0);
	        RecordCollection unsortedRecordCollection = null; // need to fix this somehow ???? cant be null
	    	
	    	unsortedRecordCollection.addRecord(sun);
			unsortedRecordCollection.sortCollection();
	        assertTrue(unsortedRecordCollection.isSorted());
			unsortedRecordCollection.addRecord(moon);
	        assertFalse(unsortedRecordCollection.isSorted());
	    }
	
}

