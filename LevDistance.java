import java.io.*;
import java.util.*;

/**
 *
 * @author Ramya
 */
public class LevDistance {

    private final HashSet<String> dictionarySet = new HashSet<>();

    public  LevDistance(String word1, String word2) throws FileNotFoundException {
        setDictionary();
        System.out.println("Distance: "+ findDistance(word1,word2));
    }

    private void setDictionary() throws FileNotFoundException {
        File file = new File("dictionary words.txt");
        Scanner scanner = new Scanner(file);
        while(scanner.hasNext()){
            dictionarySet.add(scanner.next());
        }
    }

    private int findDistance (String first, String comparing) {
        int levDistance = 0;
        HashSet<String> currentNeighbors = new HashSet<>();
        HashSet<String> newNeighbors = new HashSet<>();

        if(first.equals(comparing)) {
            return 0;
        }

        currentNeighbors.add(first);
        do {
            for(String word: currentNeighbors) {
                newNeighbors.addAll(getNeighbors(word));
            }
            levDistance++;

            if(newNeighbors.contains(comparing)) return levDistance;

            currentNeighbors.clear();
            currentNeighbors.addAll(newNeighbors);
            newNeighbors.clear();

            if(currentNeighbors.isEmpty()){
                newNeighbors.add(comparing);
            }

        } while (!newNeighbors.contains(comparing));

        return -1;
    }

    private HashSet<String> getNeighbors(String word){
        HashSet<String> neighbors = new HashSet<>();

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < word.length(); j++) {
                String newWord = word.substring(0, j) + (char) (i + 97) + word.substring(j + 1);

                if (dictionarySet.contains(newWord) && !newWord.equals(word)) {
                    neighbors.add(newWord);
                }
            }
        }
        return neighbors;
    }

}