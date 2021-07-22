package IndianStateCensusAnalyserProblem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class IndiaStateCodeTest {

	@Test
	public void givenIndianCensusCSVFile_ShouldReturnCorrectRecords()
			throws IOException, IndianCensusAnalyserException {
		CensusAnalyser analyser = new CensusAnalyser();
		int count = analyser.loadIndianStateCode("./src/test/resources/IndiaStateCode.csv");
		assertEquals(3, count);
	}

}
