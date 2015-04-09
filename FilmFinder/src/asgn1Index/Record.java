package asgn1Index;

public class Record extends AbstractRecord implements Comparable<Record> {
	
	public Record(String title, int similarity) throws IndexException {
		this.title = title;
		this.similarity = similarity;
	}

	@Override
	public int getSimilarity() {
		return similarity;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public int compareTo(Record r) {
		if (this.similarity > r.similarity) {
			return 1;			
		} else if (r.similarity == this.similarity) {
			return 0;
		} else {
			return -1;
		}
	}

}
