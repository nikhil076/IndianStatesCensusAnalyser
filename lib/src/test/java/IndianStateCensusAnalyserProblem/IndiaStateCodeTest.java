package IndianStateCensusAnalyserProblem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class IndiaStateCodeTest {
	
	public static final String INCORRECT_FILE = "./incorrectSample.txt";
	public static final String INCORRECT_CSV_FILE = "incorrectSample2.csv";

	@Test
	public void givenIndianCensusCSVFile_ShouldReturnCorrectRecords()
			throws IOException, IndianCensusAnalyserException {
		CensusAnalyser analyser = new CensusAnalyser();
		int count = analyser.loadIndianStateCode("./src/test/resources/IndiaStateCode.csv");
		assertEquals(3, count);
	}

	@Test
	public void givenCSVFile_ReturnException_ifFileNotPresent() throws IOException {
		try {
			CensusAnalyser stateCensusAnalyserMain = new CensusAnalyser();
			ExpectedException exception = ExpectedException.none();
			exception.expect(IndianCensusAnalyserException.class);
			stateCensusAnalyserMain.loadIndianStateCode(INCORRECT_FILE);
		} catch (IndianCensusAnalyserException e) {
			assertEquals(IndianCensusAnalyserException.CensusException.CENSUS_FILE_PROBLEM, e.exceptionType);
		}
	}
	
	@Test
	public void givenIncorrectCSVFile_ThrowExceptionForIncorrectCSVFile() {
		try {
			CensusAnalyser stateCensusAnalyserMain = new CensusAnalyser();
			ExpectedException exception = ExpectedException.none();
			exception.expect(IndianCensusAnalyserException.class);
			stateCensusAnalyserMain.loadIndianStateCode(INCORRECT_CSV_FILE);
		} catch (IndianCensusAnalyserException e) {
			assertEquals(IndianCensusAnalyserException.CensusException.INCORRECT_TYPE_ISSUE, e.exceptionType);
		}
	}

}
