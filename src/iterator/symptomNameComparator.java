package iterator;

import java.util.Comparator;

public class symptomNameComparator implements Comparator<String>{

		@Override
	public int compare(String symptom1, String symptom2) {
		return symptom1.compareTo(symptom2);
	}
}
