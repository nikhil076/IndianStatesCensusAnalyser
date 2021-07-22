package IndianStateCensusAnalyserProblem;

public class IndianCensusCSV {

	String state;
	float population;
	float areaInSqFt;
	float densityPerSqFt;
	
	public IndianCensusCSV(String state, float population, float areaInSqFt, float densityPerSqFt) {
		super();
		this.state = state;
		this.population = population;
		this.areaInSqFt = areaInSqFt;
		this.densityPerSqFt = densityPerSqFt;
	}

	public IndianCensusCSV() {
		super();
	}
}
