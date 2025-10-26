package iterator;

import java.util.Comparator;
import domain.ISymptom;

public class symptomNameComparator implements Comparator<Object>{

    @Override
    public int compare(Object o1, Object o2) {
        ISymptom s1 = (ISymptom) o1;
        ISymptom s2 = (ISymptom) o2;
        if (s1 == null && s2 == null) return 0;
        if (s1 == null) return -1;
        if (s2 == null) return 1;
        return s1.getName().compareTo(s2.getName());
    }
}