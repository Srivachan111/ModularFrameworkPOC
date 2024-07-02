package DataFiles;

import java.io.IOException;
import java.util.Map;

import UtilityLibrary.BaseClass;
import UtilityLibrary.SpreadSheetsUtils;

public class DataParser extends BaseClass {
	private String fileName;
	private String refName;

	public Map candidateData(String refName) throws IOException {
		SpreadSheetsUtils data = new SpreadSheetsUtils(
				System.getProperty("user.dir") + "\\Resources\\TestData\\" + fileName + ".xlsx");
		return data.getDataCollection("CandidateData", "JobTitle", "TestUser5");
	}

	public Map dataSet(String refName) throws IOException {
		SpreadSheetsUtils data = new SpreadSheetsUtils(
				System.getProperty("user.dir") + "\\Resources\\TestData\\" + fileName + ".xlsx");
		return data.getDataCollection("CandidateData", "JobTitle", "TestUser5");
	}

	public DataParser(String fileName) throws IOException {
		this.fileName = fileName;
	}

	public static void main (String [] args) throws IOException {
		DataParser data = new DataParser("TechScoreData");
		System.out.println(data.dataSet("TestUser5"));
	}
}
