package iterator;
import java.util.Iterator;

import adapter.InvertedIterator;
import adapter.Sorting;


import domain.Covid19Pacient;
import domain.Symptom;

	public class Main {

		public static void main(String[] args) {
			Covid19Pacient p=new Covid19Pacient("Ane", 29);
			p.addSymptom(new Symptom("s1", 10, 10), 1);
			p.addSymptom(new Symptom("s2", 10, 10), 2);
			p.addSymptom(new Symptom("s3", 10, 10), 3);
			p.addSymptom(new Symptom("s4", 10, 10), 4);
			p.addSymptom(new Symptom("s5", 10, 10), 5);
			
			InvertedIterator invertedIterator=new InvertedIteratorCovid19PacientAdapter(p.getSymptoms());
			invertedIterator.goLast();
			Iterator<Object> itsymptname = Sorting.sortedIterator(invertedIterator, new symptomNameComparator());
			Iterator<Object> itsymptindex = Sorting.sortedIterator(invertedIterator, new severityIndexComparator());
			System.out.println("\n Symptom name arabera ordenatuta: \n");
			while(itsymptname.hasNext())
				System.out.println(itsymptname.next());
			System.out.println("\n Severity index arabera ordenatuta: \n");
			while(itsymptindex.hasNext())
				System.out.println(itsymptindex.next());
		}

	}

