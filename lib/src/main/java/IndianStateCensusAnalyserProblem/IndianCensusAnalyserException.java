package IndianStateCensusAnalyserProblem;

public class IndianCensusAnalyserException extends Exception {
    enum CensusException {
        CENSUS_FILE_PROBLEM, INCORRECT_TYPE_ISSUE, DELIMITER_ISSUE, INCORRECT_HEADER_PROBLEM
    }

    CensusException exceptionType ;

    public IndianCensusAnalyserException(CensusException exceptionType, String message) {
        super(message);
        this.exceptionType = exceptionType;
    }
}