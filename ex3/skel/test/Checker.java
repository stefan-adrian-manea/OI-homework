package test;

import main.Exercise;
import org.junit.Assert;

import java.io.*;
import java.util.Scanner;

public class Checker {
    public static long filesCompareByLine(String path1, String path2) throws IOException {
        try (BufferedReader bf1 = new BufferedReader(new FileReader(path1));
             BufferedReader bf2 = new BufferedReader(new FileReader(path2))) {

            long lineNumber = 1;
            String line1 = "", line2 = "";
            while ((line1 = bf1.readLine()) != null) {
                line2 = bf2.readLine();
                if (line2 == null || !line1.equals(line2)) {
                    return lineNumber;
                }
                lineNumber++;
            }
            if (bf2.readLine() == null) {
                return -1;
            } else {
                return lineNumber;
            }
        }
    }

    public static void testCase(int testNumber) {

        File inputFile = new File("./test/in/test" + String.valueOf(testNumber) + ".in");
        String outputPath = "./test/out/test" + String.valueOf(testNumber) + ".out";
        String referencePath = "./test/ref/test" + String.valueOf(testNumber) + ".ref";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath));
             BufferedReader inputReader = new BufferedReader(new FileReader(inputFile));
             Scanner inputScanner = new Scanner(inputFile);) {

            Exercise exercise = new Exercise();
            exercise.solve(inputReader, writer);

            long differingLine = filesCompareByLine(outputPath, referencePath);
            Assert.assertEquals(differingLine, -1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
