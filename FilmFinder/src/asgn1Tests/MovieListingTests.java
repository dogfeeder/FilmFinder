package asgn1Tests;

import static org.junit.Assert.*;

import java.util.BitSet;
import org.junit.Test;

import asgn1Collection.ListingException;
import asgn1Collection.MovieListing;


public class MovieListingTests {
	
    @Test
    public void checkTitleSetCorrectly() throws ListingException {
    	String titleTest = "Test Title";
    	MovieListing test = new MovieListing(titleTest, 2001);
    	assertTrue(test.getTitle().equals(titleTest));
    }
    
    @Test
    public void checkYearSetCorrectly() throws ListingException {
    	int year = 2001;
    	MovieListing test = new MovieListing("Movie Test", year);
    	assertTrue(test.getYear() == year);
    }
    
    @Test(expected=ListingException.class)
    public void checkNullTitle() throws ListingException {
    	MovieListing test = new MovieListing(null, 1);
    }
    
    @Test(expected=ListingException.class)
    public void checkNegativeyear() throws ListingException {
    	MovieListing test = new MovieListing("Neg year", -1);
    }
    
    @Test(expected=ListingException.class)
    public void checkEmptyTitle() throws ListingException {
    	MovieListing test = new MovieListing("", 1);
    }
    
    @Test(expected=ListingException.class)
    public void checkEmptyTitleAndNegativeYear() throws ListingException {
    	MovieListing test = new MovieListing("", -1);
    }
    
    @Test(expected=ListingException.class)
    public void checkNullTitleAndNegativeYear() throws ListingException {
    	MovieListing test = new MovieListing(null, -1);
    }
    
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
    
    @Test
    public void checkKeyword() throws ListingException {
    	MovieListing test =  new MovieListing("Test Movie 1", 2015);
    	String Keyword = "Hello";
    	test.addKeyword(Keyword);
    	assertTrue(test.getKeywords().contains(Keyword));
    }
    
    @Test(expected=ListingException.class)
    public void checkNullKeyword() throws ListingException {
    	MovieListing test =  new MovieListing("Test Movie 1", 2015);
    	String Keyword = null;
    	test.addKeyword(Keyword);
    }
    
    @Test(expected=ListingException.class)
    public void checkEmptyKeyword() throws ListingException {
    	MovieListing test =  new MovieListing("Test Movie 1", 2015);
    	String Keyword = "";
    	test.addKeyword(Keyword);
    }
    
    //normal
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
    //this null
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
    // l null
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
    // both null
    @Test(expected=ListingException.class)
    public void checkSimilarityNull3() throws ListingException {
    	MovieListing test =  new MovieListing("Test Movie 1", 2015);
    	MovieListing test2 = new MovieListing("Test Movie 2", 2018);
    	
    	test.findSimilarity(test2);
    }
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
    //null Vector
    @Test(expected=ListingException.class)
    public void checkGetKeyVector2() throws ListingException {
    	MovieListing test =  new MovieListing("Test Movie 1", 2015);
    	test.getKeyVector();
    }
    
    //getKeyWords normal
    @Test
    public void checkGetKeyWords() throws ListingException {
    	MovieListing test =  new MovieListing("Test Movie 1", 2015);
    	test.addKeyword("Hello"); 
    	test.addKeyword("World"); 
    	test.addKeyword("Stars"); 
    	test.addKeyword("Moons"); 
    	
    	assertTrue(test.getKeywords() != null);
    }
    
    //getTitle normal
    @Test
    public void checkGetTitle() throws ListingException {
    	String title = "Test Movie 1";
    	MovieListing test =  new MovieListing(title, 2015);
    	assertTrue(test.getTitle().equals(title));
    }
    
    //getYear normal
    @Test
    public void checkGetYear() throws ListingException {
    	int year = 2015;
    	MovieListing test =  new MovieListing("Test Movie 1", year);
    	assertTrue(test.getYear() == year );
    }
    
    //NumKeywords normal
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
