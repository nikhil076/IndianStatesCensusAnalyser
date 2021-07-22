package IndianStateCensusAnalyserProblem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

public class CensusAnalyserTest {
	
	public static final String INCORRECT_FILE = "./incorrectSample.txt";
    public static final String INCORRECT_CSV_FILE = "incorrectSample2.csv";
    public static final String CSV_FILE_INDIA_STATE_CODE = "IndiaStateCode";

	@Test
	public void givenIndianCensusCSVFile_ShouldReturnCorrectRecords() throws IOException, IndianCensusAnalyserException
	{
		CensusAnalyser analyser = new CensusAnalyser();
		int count = analyser.loadIndianStateCensusData("./src/test/resources/IndianStateCSV.csv");
		assertEquals(3, count);
	}
	
	 @Test
	    public void givenCSVFile_ReturnException_ifFileNotPresent() throws IOException {
	        try {
	        	CensusAnalyser stateCensusAnalyserMain = new CensusAnalyser();
	            ExpectedException exception = ExpectedException.none();
	            exception.expect(IndianCensusAnalyserException.class);
	            stateCensusAnalyserMain.loadIndianStateCensusData(INCORRECT_FILE);
	        } catch (IndianCensusAnalyserException e) {
	            assertEquals(IndianCensusAnalyserException.CensusException.CENSUS_FILE_PROBLEM, e.exceptionType);
	        }
	    }

}
