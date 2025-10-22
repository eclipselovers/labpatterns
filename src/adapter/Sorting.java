package adapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import domain.ISymptom;


public class Sorting {
	public static Iterator<Object> sortedIterator(InvertedIterator it, Comparator<Object> comparator) {
	      List<Object> list = new ArrayList<>();
	      it.goLast();
	      while (it.hasPrevious()) {
	    	  ISymptom s= (ISymptom)it.previous();
	          list.add(s);
	      }

	      Collections.sort(list, comparator);
	      return list.iterator();
	  }

}
