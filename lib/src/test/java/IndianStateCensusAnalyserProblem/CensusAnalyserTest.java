package IndianStateCensusAnalyserProblem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class CensusAnalyserTest {

	@Test
	public void givenIndianCensusCSVFile_ShouldReturnCorrectRecords() throws IOException
	{
		CensusAnalyser analyser = new CensusAnalyser();
		int count = analyser.loadIndianStateCensusData("./src/test/resources/IndianStateCSV.csv");
		assertEquals(3, count);
	}
}
