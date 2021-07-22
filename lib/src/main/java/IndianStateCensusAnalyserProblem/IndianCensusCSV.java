package IndianStateCensusAnalyserProblem;

import com.opencsv.bean.CsvBindByName;

public class IndianCensusCSV {

	@CsvBindByName(column = "State")
	String state;
	
	@CsvBindByName(column = "Population", required = true)
	float population;
	
	@CsvBindByName(column = "AreaInSqKm")
	float areaInSqFt;
	
	@CsvBindByName(column = "DensityPerSqKm", required = true)
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
