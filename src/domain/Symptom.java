package domain;

public class Symptom implements ISymptom {
	private String name;
	private int covidImpact;
	private int severityIndex;

	public Symptom(String name, int covidImpact, int severityIndex) {
		this.name = name;
		this.covidImpact = covidImpact;
		this.severityIndex = severityIndex;
	}
	@Override
	public String getName() {
		return name;
	}
	@Override
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int getCovidImpact() {
		return covidImpact;
	}
	@Override
	public void setCovidImpact(int covidImpact) {
		this.covidImpact = covidImpact;
	}
	@Override
	public int getSeverityIndex() {
		return severityIndex;
	}
	@Override
	public void setSeverityIndex(int severityIndex) {
		this.severityIndex = severityIndex;
	}
	@Override
	public String toString() {
		return name;
	}
}
