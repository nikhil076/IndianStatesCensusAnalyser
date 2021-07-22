package IndianStateCensusAnalyserProblem;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import org.apache.commons.lang3.exception.ExceptionUtils;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

public class CensusAnalyser {

	public static void main(String args[]) {
		System.out.println("Welcome to Indian censun analyser");
	}

	public int loadIndianStateCensusData(String filePath) throws IOException, IndianCensusAnalyserException {
		try {
			Reader reader = Files.newBufferedReader(Paths.get(filePath));
			CsvToBeanBuilder<IndianCensusCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
			csvToBeanBuilder.withType(IndianCensusCSV.class);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<IndianCensusCSV> csvToBean = csvToBeanBuilder.build();
			Iterator<IndianCensusCSV> censusCSVIterator = csvToBean.iterator();
			int numberOfEntries = 0;
			while (censusCSVIterator.hasNext()) {
				numberOfEntries++;
				IndianCensusCSV censusCSV = censusCSVIterator.next();
			}
			return numberOfEntries;
		} catch (IOException e) {
			throw new IndianCensusAnalyserException(IndianCensusAnalyserException.CensusException.CENSUS_FILE_PROBLEM,
					"Incorrect File");
		} catch (RuntimeException e) {
			if (ExceptionUtils.indexOfType(e, CsvDataTypeMismatchException.class) != -1) {
				if (e.getMessage().equalsIgnoreCase("CSV Header contains Error")) {
					throw new IndianCensusAnalyserException(
							IndianCensusAnalyserException.CensusException.INCORRECT_HEADER_PROBLEM, "Incorrect Header");
				} else {
					throw new IndianCensusAnalyserException(
							IndianCensusAnalyserException.CensusException.DELIMITER_ISSUE, "Incorrect Delimiter Issue");
				}
			} else {
				e.printStackTrace();
				throw new RuntimeException();
			}
		}
	}
}
