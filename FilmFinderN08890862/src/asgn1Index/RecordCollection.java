package asgn1Index;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecordCollection extends AbstractRecordCollection {
	
	List<Record> RecordCollection = new ArrayList<Record>();
	boolean sorted = false;

	public RecordCollection() {
		
	}
	
	@Override
	public void addRecord(Record r) throws IndexException {
		if (r != null) {
			RecordCollection.add(r);
			sorted = false;
		} else {
			throw new IndexException("Record is null");
		}
	}

	@Override
	public AbstractRecord findClosestRecord() throws IndexException {
		if (isSorted()) { 
			return RecordCollection.get(0);
		} else {
			throw new IndexException("List is not sorted");
		}
	}

	@Override
	public List<Record> findClosestRecords(int n) throws IndexException {
		if (isSorted() && n <= RecordCollection.size()) { 
			List<Record> closestRecords = new ArrayList<Record>();
			for (int i=0;i<n;i++) {
				closestRecords.add(RecordCollection.get(i));
			}
			return closestRecords;
		} else {
			throw new IndexException("List is not sorted or Number of results queried exceeds available results");
		}
	}

	@Override
	public boolean isSorted() {
		return sorted;
	}

	@Override
	public void sortCollection() {
		Collections.sort(RecordCollection);
		Collections.reverse(RecordCollection);
		sorted = true;

	}

}
