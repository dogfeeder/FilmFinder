package asgn1Collection;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

//This is some free code for you to include (adapting as needed) for inclusion in the MovieListing.java 
//class that you have to create. It is copied from that class before it was deleted. 
public class MovieListing extends java.lang.Object implements Listing {
	
	private int year = 0;
	private String title = null;
	private BitSet keyVector;
	Set<String> keywords = new HashSet<String>();
	
	public MovieListing(String title, int year) throws ListingException {
		this.year = year;
		this.title = title;
		// TODO Auto-generated constructor stub
	}


		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return this.title + ":" + this.year + ":" + "Active keywords:" + this.numKeywords();
		}
	
	
		/* (non-Javadoc)
		 * @see asgn1Collection.Listing#writeKeywords()
		 */
		public String writeKeywords() {
			String str=""; int index=0;
			for (String kw : this.keywords) {
				str += kw +":"; 
				index++;
				if ((index % 10)==0) {
					str += "\n";
				}
			}
			System.out.println(str);
			return str;
		}


		@Override
		public void addKeyword(String kw) throws ListingException {
			this.keywords.add(kw);
		}


		@Override
		public int findSimilarity(Listing l) throws ListingException {
			// TODO Auto-generated method stub
			BitSet a = this.getKeyVector();
			BitSet b = l.getKeyVector();
			BitSet both = (BitSet)a.clone();
			both.and(b);
			return both.cardinality();
		}


		@Override
		public BitSet getKeyVector() throws ListingException {
			return keyVector;
		}


		@Override
		public Set<String> getKeywords() {
			return keywords;
		}


		@Override
		public String getTitle() {
			return title;
		}


		@Override
		public int getYear() {
			return year;
		}


		@Override
		public int numKeywords() {
			return keywords.size();
		}


		@Override
		public void setKeyVector(BitSet bs) {
			this.keyVector = bs;
		}


		@Override
		public String writeKeyVector() throws ListingException {
			return keyVector.toString();
		}
		
}

