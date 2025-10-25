package iterator;

import java.util.Comparator;

public class severityIndexComparator implements Comparator<Integer>{

		@Override
	public int compare(Integer index1, Integer index2) {
		return index2 - index1;
	}

}
