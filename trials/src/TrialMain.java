import java.io.*;
import java.util.*;

public class TrialMain {

	public static void main(String[] args) throws IOException {
		File resource = new File("res");
		ArrayList<File> database = new ArrayList<File>();
		ArrayList<File> speechFiles = new ArrayList<File>();
		ArrayList<File> promptFiles = new ArrayList<File>();
		System.out.println(resource.listFiles());
		database = changeDirectory(resource);

		for (int i = 0; i < database.size(); i++) {
			if (database.get(i).isDirectory() == true) {
				System.out.println(database.get(i).getName());
				File dirr = new File("created/hi");
				dirr.mkdirs();
				File newone = new File (dirr, "res.txt");
				PrintWriter write = new PrintWriter(newone, "UTF-8");
				write.close();
				File resout = new File("out/resout.txt");
				FileUtils.
				//File hypothesisFile = new File("created/hi/speechOutput.txt");
				//outFile.println("helo worlkjslddd...");
				//outFile.close();
				for (File each : database.get(i).listFiles()) {
					if (each.getName().compareTo("wav") == 0) {
						speechFiles = changeDirectory(each);
					}
					if (each.getName().compareTo("etc") == 0) {
						promptFiles = changeDirectory(each);
						for (File files : promptFiles) {
							if (files.getName().compareTo("prompts-original") == 0) {
								File prompt = files;
							}
						}
					}
				}
			}
		}
	}

	public static ArrayList<File> changeDirectory(File currentPath) {
		ArrayList<File> folders = new ArrayList<File>();
		for (File eachPath : currentPath.listFiles()) {
			folders.add(eachPath);
		}
		return folders;
	}
}