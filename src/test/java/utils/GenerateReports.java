package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;

public class GenerateReports {

	static List<String> jsonFiles(String directory) {
		List<String> jsonFiles = new ArrayList<>();
		File dir = new File(directory);
		for (File file : dir.listFiles()) {
			if (file.getName().endsWith(".json")) {
				jsonFiles.add("target/json/" + file.getName());
			}
		}

		return jsonFiles;
	}

	public static void main(String[] args) {
		String timestamp= (new SimpleDateFormat("yyyy.MM.dd.HH.mm").format(new Date())).replace('.','_');
		File reportOutputDirectory = new File("target/cucumberReports_"+timestamp);
		List<String> jsonFiles = jsonFiles("target/json/");
		
		String buildNumber = "1";
		String projectName = "Brijendra cucumberProject";
		boolean skippedFails =true;
		boolean pendingFails =false;
		boolean undefinedFails = true;
		boolean missingFails =true;
		boolean runWithJenkins = false;
		boolean parallelTesting = false;

		
		Configuration configuration = new Configuration(reportOutputDirectory, projectName);
		
		//configuration.setStatusFlags(skippedFails, pendingFails, undefinedFails, missingFails);
		configuration.setRunWithJenkins(runWithJenkins);
		configuration.setBuildNumber(buildNumber);
		//configuration.setJenkinsBasePath("");
		configuration.setParallelTesting(false);
		
		configuration.addClassifications("Platform", "Windows");
		configuration.addClassifications("Browser", "Firefox");
		configuration.addClassifications("Branch", "release/1.0");
		
		ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
		Reportable result = reportBuilder.generateReports();
	
	}

}
