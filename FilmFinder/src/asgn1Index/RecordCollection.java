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
		RecordCollection.add(r);
		sorted = false;
	}

	@Override
	public AbstractRecord findClosestRecord() throws IndexException {
		// TODO Auto-generated method stub
		return RecordCollection.get(0);
	}

	@Override
	public List<Record> findClosestRecords(int n) throws IndexException {
		// TODO Auto-generated method stub
		List<Record> closestRecords = new ArrayList<Record>();
		for (int i=0;i<n;i++) {
			closestRecords.add(RecordCollection.get(i));
		}
		return closestRecords;
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
