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
		if (year > 0 && title != null && !title.isEmpty()) {
			this.year = year;
			this.title = title;
		} else {
			throw new ListingException(String.format("Invalid title and year: %s, %d", title, year));
		}

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
			if (kw != null && !kw.isEmpty()) {
				this.keywords.add(kw);
			} else {
				throw new ListingException(String.format("Invalid Keyword: %s", kw));
			}
		}


		@Override
		public int findSimilarity(Listing l) throws ListingException {
			if (this.getKeyVector() != null && l.getKeyVector() != null) {
				BitSet a = this.getKeyVector();
				BitSet b = l.getKeyVector();
				BitSet both = (BitSet)a.clone();
				both.and(b);
				return both.cardinality();
			} else {
				throw new ListingException("1 Or more null Vectors");
			}
		}


		@Override
		public BitSet getKeyVector() throws ListingException {
			if (keyVector != null) {
				return keyVector;
			} else {
				throw new ListingException("Bitset Is Null");
			}
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
			if (keyVector != null) {
				return keyVector.toString();
			} else {
				throw new ListingException("Bitset Is Null");
				
			}
		}
		
}

