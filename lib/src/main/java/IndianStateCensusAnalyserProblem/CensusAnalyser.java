package IndianStateCensusAnalyserProblem;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CensusAnalyser {

	public static void main (String args[])
	{
		System.out.println("Welcome to Indian censun analyser");
	}
	public int loadIndianStateCensusData(String filePath) throws IOException
	{
			Reader reader =Files.newBufferedReader(Paths.get(filePath));
			CsvToBeanBuilder<IndianCensusCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
			csvToBeanBuilder.withType(IndianCensusCSV.class);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<IndianCensusCSV> csvToBean = csvToBeanBuilder.build();
			Iterator<IndianCensusCSV> censusCSVIterator = csvToBean.iterator();
			int numberOfEntries =0;
			while(censusCSVIterator.hasNext())
			{
				numberOfEntries++;
				IndianCensusCSV censusCSV = censusCSVIterator.next();
			}
		return numberOfEntries;
	}
}
