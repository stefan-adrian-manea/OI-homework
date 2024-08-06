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

        File inputFile = new File("./test/in/test" + String.valueOf(testNumber) + "a.in");
        File inputFile2 = new File("./test/in/test" + String.valueOf(testNumber) + "b.in");
        String outputPath = "./test/out/test" + String.valueOf(testNumber) + ".out";
        String referencePath = "./test/ref/test" + String.valueOf(testNumber) + ".ref";

        try (BufferedWriter bfw = new BufferedWriter(new FileWriter(outputPath));
             Scanner sca = new Scanner(inputFile);
             Scanner scb = new Scanner(inputFile2);) {

            Exercise exercise = new Exercise();
            exercise.solve(bfw, sca, scb);

            long differingLine = filesCompareByLine(outputPath, referencePath);
            Assert.assertEquals(differingLine, -1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
