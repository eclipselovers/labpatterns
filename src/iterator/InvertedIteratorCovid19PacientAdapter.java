package iterator;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import adapter.InvertedIterator;
import domain.Symptom;

public class InvertedIteratorCovid19PacientAdapter implements InvertedIterator {
	List<Symptom> symptoms=new Vector<Symptom>();
	int position=0;
	
	public InvertedIteratorCovid19PacientAdapter(Set<Symptom> s) {
		Iterator<Symptom> i=s.iterator();
		while (i.hasNext())
			symptoms.add(i.next());
		
	}

	@Override
	public Object previous() {
		position--;
		Symptom symptom=symptoms.get(position);
		return symptom;
		
	}

	@Override
	public boolean hasPrevious() {
		return position>0;
	}

	@Override
	public void goLast() {
		position=symptoms.size();
	}

}
