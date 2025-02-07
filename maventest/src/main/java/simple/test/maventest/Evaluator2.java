package simple.test.maventest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Evaluator2 {
	public static List<String> shift(List<String> original, int leftPose,
			int rightPose) {
		int gap = Math.abs(leftPose - rightPose);
		for (int i = 0; i < gap; i++) {
			original.add(original.get(original.size() - 1));
		}
		int pose = (leftPose < rightPose) ? leftPose : rightPose;
		for (int i = 0; i < gap; i++) {
			for (int k = original.size() - 1; k > pose; k--) {
				original.set(k, original.get(k - 1));
			}
			original.set(pose, "=====");
		}
		return original;
	}

	public static void main(String[] Args) throws IOException {
		System.out.println("Hello world...");
		File ref = new File("resource/prompts-original");
		File hyp = new File("resource/resultOutput");
		System.out.println("Hello world...");
		BufferedReader readRef = new BufferedReader(new FileReader(ref));
		BufferedReader readHyp = new BufferedReader(new FileReader(hyp));
		String refLine;

		while ((refLine = readRef.readLine()) != null) {
			String hypLine = readHyp.readLine();
			System.out.println("REF : " + refLine);
			System.out.println("HYP : " + hypLine);
			refLine = refLine.replace(".", " ");
			List<String> refWords = new ArrayList<String>(Arrays.asList(refLine
					.split(" ")));
			List<String> hypWords = new ArrayList<String>(Arrays.asList(hypLine
					.split(" ")));

			for (int idx = 0; idx < refWords.size(); idx++) {
				int store = Integer.MAX_VALUE;
				int index = 0;
				int hit = 20;
				Boolean same = false;
				for (int idxx = 0; idxx < hypWords.size(); idxx++) {
					if ((refWords.get(idx) != "=====")
							&& (hypWords.get(idxx) != "=====")) {
						hit = refWords.get(idx).compareToIgnoreCase(
								hypWords.get(idxx));
						if (hit == 0) {
							same = true;
							System.out.println(refWords.get(idx) + ":::::"
									+ hypWords.get(idxx));
							if (Math.abs(idx - idxx) < store) {
								store = Math.abs(idx - idxx);
								index = idxx;
							}
						}
					}
				}
				if ((same == true) && (idx != index)) {
					if (index > idx) {
						refWords = shift(refWords, idx, index);
					} else if (idx > index) {
						hypWords = shift(hypWords, idx, index);
					}
				}
			}
		}
		readRef.close();
	}
}
