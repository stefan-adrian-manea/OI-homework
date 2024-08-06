package main;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exercise {
  
  public void solve(BufferedWriter bufferedWriter, Scanner scanner) throws IOException {
      String firstWord = scanner.nextLine();
      String secondWord = scanner.nextLine();
      while (scanner.hasNext()){
        String currentLine = scanner.nextLine();
        if(currentLine.contains(firstWord)){
          currentLine = currentLine.replaceAll(firstWord,secondWord);
        }
        bufferedWriter.write(currentLine);
        bufferedWriter.newLine();
      }
      bufferedWriter.flush();
  }
}
