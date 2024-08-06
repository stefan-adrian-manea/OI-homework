package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Exercise {

    public void solve(BufferedReader br, BufferedWriter writer) throws IOException {
        WordStats.readAndAddWords(br);

        writer.write(WordStats.wordsList.toString());
        writer.newLine();
        writer.write(WordStats.smallestWord());
        writer.newLine();
        writer.write(WordStats.biggestWord());
        writer.newLine();
        writer.write(WordStats.ascWord());
        writer.newLine();
        writer.write(WordStats.descWord());
        writer.newLine();
        writer.write(WordStats.getWordsNumber());
        writer.flush();

    }

    private static class WordStats {
        private static List<String> wordsList;

        public List<String> getWordsList() {
            return wordsList;
        }

        public static void readAndAddWords(BufferedReader br) throws IOException {
            wordsList = new ArrayList<>();
            String line = br.readLine();
            while (line != null) {
                wordsList.add(line);
                line = br.readLine();
            }
//      wordsList = br.lines().collect(Collectors.toList());
        }

        public static String smallestWord() {

            int smallestL = Integer.MAX_VALUE;
            List<String> smallestW = new ArrayList<>();

            for (String word: wordsList){
                int len = word.length();
                if(len < smallestL){
                    smallestL = len;
                    smallestW.clear();
                    smallestW.add(word);
                }else if(len == smallestL){
                    smallestW.add(word);
                }
            }



//            for (String word: wordsList) {
//                smallestL = Math.min(smallestL, word.length());
//            }
//            for (String word: wordsList) {
//                if(word.length() == smallestL){
//                    biggestW.add(word);
//                }
//            }
            return smallestW.size() > 1 ? smallestW.toString() : smallestW.get(0);
        }
        public static String biggestWord() {
            int biggestL = Integer.MIN_VALUE;
            List<String> biggestW = new ArrayList<>();
            for (String word: wordsList) {
                int len = word.length();
                if(len > biggestL){
                    biggestL = len;
                    biggestW.clear();
                    biggestW.add(word);
                }else if(len == biggestL){
                    biggestW.add(word);
                }
            }
//            for (String word: wordsList) {
//                biggestL = Math.max(biggestL, word.length());
//            }
//            for (String word: wordsList) {
//                if(word.length() == biggestL){
//                    biggestW.add(word);
//                }
//            }
            return biggestW.size() > 1 ? biggestW.toString() : biggestW.get(0);
        }

        public static String ascWord(){
//            if (wordsList.isEmpty()) {
//                return null;
//            }
//            String ascWord = wordsList.get(0);
//            for (String word : wordsList) {
//                if (word.compareToIgnoreCase(ascWord) < 0) {
//                    ascWord = word;
//                }
//            }
//            return ascWord;

//            ArrayList<String> copy = new ArrayList<>(wordsList);
//            copy.sort(String.CASE_INSENSITIVE_ORDER);
//            return copy.get(0);


            return wordsList.stream()
                    .min((word1, word2) -> word1.compareToIgnoreCase(word2))
                    .orElse("");
        }
        public static String descWord(){
//            if (wordsList.isEmpty()) {
//                return null;
//            }
//            String descWord = wordsList.get(0);
//            for (String word : wordsList) {
//                if (word.compareToIgnoreCase(descWord) > 0) {
//                    descWord = word;
//                }
//            }
//            return descWord;
//            ArrayList<String> copy = new ArrayList<>(wordsList);
//            copy.sort(String.CASE_INSENSITIVE_ORDER);
//            return copy.get(copy.size()-1);


            return wordsList.stream()
                    .max((word1, word2) -> word1.compareToIgnoreCase(word2))
                    .orElse("");

        }
        public static String getWordsNumber(){
            return wordsList.size() + "";
        }
    }
}
