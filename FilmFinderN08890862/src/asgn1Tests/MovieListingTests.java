package asgn1Tests;

import static org.junit.Assert.*;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import asgn1Collection.Listing;
import asgn1Collection.ListingException;
import asgn1Collection.MovieListing;
import asgn1Index.IndexException;


public class MovieListingTests {
	  /**
     * Test method for {@link asgn1Collection.MovieListing#MovieListing(String title, int year)}.
     * Check that the constructor sets the title correctly.
     * @throws ListingException 
     */
    @Test
    public void checkTitleSetCorrectly() throws ListingException {
    	String titleTest = "Test Title";
    	MovieListing test = new MovieListing(titleTest, 2001);
    	assertTrue(test.getTitle().equals(titleTest));
    }
    
	  /**
     * Test method for {@link asgn1Collection.MovieListing#MovieListing(String title, int year)}.
     * Check that the constructor sets the year correctly.
     * @throws ListingException 
     */
    @Test
    public void checkYearSetCorrectly() throws ListingException {
    	int year = 2001;
    	MovieListing test = new MovieListing("Movie Test", year);
    	assertTrue(test.getYear() == year);
    }
    
	  /**
     * Test method for {@link asgn1Collection.MovieListing#MovieListing(String title, int year)}.
     * Check that ListingException is thrown if the title is null.
     * @throws ListingException 
     */
    @Test(expected=ListingException.class)
    public void checkNullTitle() throws ListingException {
    	MovieListing test = new MovieListing(null, 1);
    }
    
	  /**
     * Test method for {@link asgn1Collection.MovieListing#MovieListing(String title, int year)}.
     * Check that ListingException is thrown if the year is negative.
     * @throws ListingException 
     */
    @Test(expected=ListingException.class)
    public void checkNegativeyear() throws ListingException {
    	MovieListing test = new MovieListing("Neg year", -1);
    }
    
	  /**
     * Test method for {@link asgn1Collection.MovieListing#MovieListing(String title, int year)}.
     * Check that ListingException is thrown if the title is empty.
     * @throws ListingException 
     */
    @Test(expected=ListingException.class)
    public void checkEmptyTitle() throws ListingException {
    	MovieListing test = new MovieListing("", 1);
    }
    
	  /**
     * Test method for {@link asgn1Collection.MovieListing#MovieListing(String title, int year)}.
     * Check that ListingException is thrown if the title is empty and year is negative.
     * @throws ListingException 
     */
    @Test(expected=ListingException.class)
    public void checkEmptyTitleAndNegativeYear() throws ListingException {
    	MovieListing test = new MovieListing("", -1);
    }
    
	  /**
     * Test method for {@link asgn1Collection.MovieListing#MovieListing(String title, int year)}.
     * Check that ListingException is thrown if the title is null and year is negative.
     * @throws ListingException 
     */
    @Test(expected=ListingException.class)
    public void checkNullTitleAndNegativeYear() throws ListingException {
    	MovieListing test = new MovieListing(null, -1);
    }
    
	  /**
     * Test method for {@link asgn1Collection.MovieListing#toString()}.
     * Check that the toString method prints out in the correct format.
     * @throws ListingException 
     */
    @Test
    public void checktoString() throws ListingException {
    	MovieListing test =  new MovieListing("Test Movie 1", 2015);
    	test.addKeyword("Hello");
    	test.addKeyword("World");
    	String title = test.getTitle();
    	int year = test.getYear();
    	int keywords = test.numKeywords();
    	String toString = test.getTitle() + ":" + test.getYear() + ":" + "Active keywords:" + test.numKeywords();
    	assertTrue(toString.equals(test.toString()));
    }
    
	  /**
     * Test method for {@link asgn1Collection.MovieListing#addKeyword(String kw)}.
     * Checks that keywords are added to the listing correctly.
     * @throws ListingException 
     */
    @Test
    public void checkKeyword() throws ListingException {
    	MovieListing test =  new MovieListing("Test Movie 1", 2015);
    	String Keyword = "Hello";
    	test.addKeyword(Keyword);
    	assertTrue(test.getKeywords().contains(Keyword));
    }
    
	  /**
     * Test method for {@link asgn1Collection.MovieListing#addKeyword(String kw)}.
     * Checks ListingException is thrown if the keyword is null
     * @throws ListingException 
     */
    @Test(expected=ListingException.class)
    public void checkNullKeyword() throws ListingException {
    	MovieListing test =  new MovieListing("Test Movie 1", 2015);
    	String Keyword = null;
    	test.addKeyword(Keyword);
    }
    
	  /**
     * Test method for {@link asgn1Collection.MovieListing#addKeyword(String kw)}.
     * Checks ListingException is thrown if the keyword is empty
     * @throws ListingException 
     */
    @Test(expected=ListingException.class)
    public void checkEmptyKeyword() throws ListingException {
    	MovieListing test =  new MovieListing("Test Movie 1", 2015);
    	String Keyword = "";
    	test.addKeyword(Keyword);
    }
    
	  /**
     * Test method for {@link asgn1Collection.MovieListing#findSimilarity(Listing l)}.
     * Checks if findSimilarity returns the correct number of matches by comparing generated bitsets
     * @throws ListingException 
     */
    @Test
    public void checkSimilarity() throws ListingException {
    	MovieListing test =  new MovieListing("Test Movie 1", 2015);
    	test.addKeyword("Hello"); //1
    	test.addKeyword("World"); //2
    	test.addKeyword("Stars"); //3
    	test.addKeyword("Moons"); //4
    	BitSet bits1 = new BitSet();
    	bits1.set(1);
    	bits1.set(2);
    	bits1.set(3);
    	bits1.set(4);
    	test.setKeyVector(bits1);
    	
    	MovieListing test2 = new MovieListing("Test Movie 2", 2018);
    	test2.addKeyword("Greetings"); //5
    	test2.addKeyword("World"); //2
    	test2.addKeyword("Galaxy"); //6
    	test2.addKeyword("Moons"); //4
    	BitSet bits2 = new BitSet();
    	bits2.set(5);
    	bits2.set(2);
    	bits2.set(6);
    	bits2.set(4);
    	test2.setKeyVector(bits2);    	
    	
    	int matches = 2;
    	
    	assertTrue(test.findSimilarity(test2) == matches);

    }
    
	  /**
     * Test method for {@link asgn1Collection.MovieListing#findSimilarity(Listing l)}.
     * Checks if ListingException is thrown when this.bitset == null
     * @throws ListingException 
     */
    @Test(expected=ListingException.class)
    public void checkSimilarityNull() throws ListingException {
    	MovieListing test =  new MovieListing("Test Movie 1", 2015);
    	test.addKeyword("Hello"); //1
    	test.addKeyword("World"); //2
    	test.addKeyword("Stars"); //3
    	test.addKeyword("Moons"); //4
    	BitSet bits1 = new BitSet();
    	bits1.set(1);
    	bits1.set(2);
    	bits1.set(3);
    	bits1.set(4);
    	test.setKeyVector(bits1);
    	
    	MovieListing test2 = new MovieListing("Test Movie 2", 2018);
    	
    	test.findSimilarity(test2);
    }
    
	  /**
     * Test method for {@link asgn1Collection.MovieListing#findSimilarity(Listing l)}.
     * Checks if ListingException is thrown when l.bitset == null
     * @throws ListingException 
     */
    @Test(expected=ListingException.class)
    public void checkSimilarityNull2() throws ListingException {
    	MovieListing test =  new MovieListing("Test Movie 1", 2015);
    	
    	MovieListing test2 = new MovieListing("Test Movie 2", 2018);
    	test2.addKeyword("Greetings"); //5
    	test2.addKeyword("World"); //2
    	test2.addKeyword("Galaxy"); //6
    	test2.addKeyword("Moons"); //4
    	BitSet bits2 = new BitSet();
    	bits2.set(5);
    	bits2.set(2);
    	bits2.set(6);
    	bits2.set(4);
    	test2.setKeyVector(bits2);    	
    	
    	test.findSimilarity(test2);

    }
    
	  /**
     * Test method for {@link asgn1Collection.MovieListing#findSimilarity(Listing l)}.
     * Checks if ListingException is thrown when both bitsets are null
     * @throws ListingException 
     */
    // both null
    @Test(expected=ListingException.class)
    public void checkSimilarityNull3() throws ListingException {
    	MovieListing test =  new MovieListing("Test Movie 1", 2015);
    	MovieListing test2 = new MovieListing("Test Movie 2", 2018);
    	
    	test.findSimilarity(test2);
    }
    
	  /**
     * Test method for {@link asgn1Collection.MovieListing#getKeyVector()}.
     * Checks the correct Key Vector(bitset) is returned
     * @throws ListingException 
     */
    //normal
    @Test
    public void checkGetKeyVector() throws ListingException {
    	MovieListing test =  new MovieListing("Test Movie 1", 2015);
    	test.addKeyword("Hello"); //1
    	test.addKeyword("World"); //2
    	test.addKeyword("Stars"); //3
    	test.addKeyword("Moons"); //4
    	BitSet bits1 = new BitSet();
    	bits1.set(1);
    	bits1.set(2);
    	bits1.set(3);
    	bits1.set(4);
    	test.setKeyVector(bits1);
    	assertTrue(test.getKeyVector() == bits1);
    }
    
	  /**
     * Test method for {@link asgn1Collection.MovieListing#getKeyVector()}.
     * Checks if ListingException is thrown when Key Vector is null
     * @throws ListingException 
     */
    //null Vector
    @Test(expected=ListingException.class)
    public void checkGetKeyVector2() throws ListingException {
    	MovieListing test =  new MovieListing("Test Movie 1", 2015);
    	test.getKeyVector();
    }
    
	  /**
     * Test method for {@link asgn1Collection.MovieListing#getKeywords()}.
     * Checks if the correct set is returned by comparing manually created set
     * @throws ListingException 
     */
    //getKeyWords normal
    @Test
    public void checkGetKeyWords() throws ListingException {
    	MovieListing test =  new MovieListing("Test Movie 1", 2015);
    	test.addKeyword("Hello"); 
    	test.addKeyword("World"); 
    	test.addKeyword("Stars"); 
    	test.addKeyword("Moons"); 
    	
    	Set<String> keywords = new HashSet<String>();
    	keywords.add("Hello");
    	keywords.add("World");
    	keywords.add("Stars");
    	keywords.add("Moons");
    	
    	
    	assertTrue(test.getKeywords().equals(keywords));
    }
    
	  /**
     * Test method for {@link asgn1Collection.MovieListing#getTitle()}.
     * Checks if the correct title is returned
     * @throws ListingException 
     */
    @Test
    public void checkGetTitle() throws ListingException {
    	String title = "Test Movie 1";
    	MovieListing test =  new MovieListing(title, 2015);
    	assertTrue(test.getTitle().equals(title));
    }
    
	  /**
     * Test method for {@link asgn1Collection.MovieListing#getYear()}.
     * Checks if the correct year is returned
     * @throws ListingException 
     */
    @Test
    public void checkGetYear() throws ListingException {
    	int year = 2015;
    	MovieListing test =  new MovieListing("Test Movie 1", year);
    	assertTrue(test.getYear() == year );
    }
    
	  /**
     * Test method for {@link asgn1Collection.MovieListing#numKeywords()}.
     * Checks if the correct amount of keywords is retained
     * @throws ListingException 
     */
    @Test
    public void checkNumKeywords() throws ListingException {
    	MovieListing test =  new MovieListing("Test Movie 1", 2015);
    	test.addKeyword("Hello"); 
    	test.addKeyword("World"); 
    	test.addKeyword("Stars"); 
    	test.addKeyword("Moons"); 
    	int keywords = 4;
    	
    	assertTrue(test.numKeywords() == keywords);
    }
    
	  /**
     * Test method for {@link asgn1Collection.MovieListing#setKeyVector(BitSet bs)}.
     * Checks if the correct keyvector is set by comparing to a manually created bitset
     * @throws ListingException 
     */
    //setKeyVector normal
    @Test
    public void checkSetKeyVector() throws ListingException {
    	MovieListing test =  new MovieListing("Test Movie 1", 2015);
    	test.addKeyword("Hello"); //1
    	test.addKeyword("World"); //2
    	test.addKeyword("Stars"); //3
    	test.addKeyword("Moons"); //4
    	BitSet bits1 = new BitSet();
    	bits1.set(1);
    	bits1.set(2);
    	bits1.set(3);
    	bits1.set(4);
    	test.setKeyVector(bits1);
    	assertTrue(test.getKeyVector() == bits1);
    }
    
	  /**
     * Test method for {@link asgn1Collection.MovieListing#writeKeyVector()}.
     * Checks if the Key Vector is printed correctly
     * @throws ListingException 
     */
    //WriteKeyVector normal
    @Test
    public void checkWriteKeyVector() throws ListingException {
    	MovieListing test =  new MovieListing("Test Movie 1", 2015);
    	test.addKeyword("Hello"); //1
    	test.addKeyword("World"); //2
    	test.addKeyword("Stars"); //3
    	test.addKeyword("Moons"); //4
    	BitSet bits1 = new BitSet();
    	bits1.set(1);
    	bits1.set(2);
    	bits1.set(3);
    	bits1.set(4);
    	
    	String bitString = bits1.toString();
    	test.setKeyVector(bits1);
    	assertTrue(test.writeKeyVector().equals(bitString));
    }
    
	  /**
     * Test method for {@link asgn1Collection.MovieListing#writeKeyVector()}.
     * Checks if keywords are printed correctly by comparing to manually created string
     * @throws ListingException 
     */
    //WriteKeyWords normal
    @Test
    public void checkWriteKeyWords() throws ListingException {
    	MovieListing test =  new MovieListing("Test Movie 1", 2015);
    	test.addKeyword("Hello"); //1
    	test.addKeyword("World"); //2
    	test.addKeyword("Stars"); //3
    	test.addKeyword("Moons"); //4
    	
    	String keywordString = "Moons:Hello:Stars:World:";
    	
    	assertTrue(test.writeKeywords().equals(keywordString));
    	
    }

    
    
}
