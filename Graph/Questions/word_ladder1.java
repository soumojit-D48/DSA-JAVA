import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class word_ladder1 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int level = 1;

        while (!q.isEmpty()) {
            int qsize = q.size();
            
            for(int i = 0; i < qsize; i++){
                String word = q.poll();
                char[] charArr = word.toCharArray();

                for(int j = 0; j < word.length(); j++){
                    char originalChar = charArr[j];

                    for(char c = 'a'; c <= 'z'; c++){
                        charArr[j] = c;
                        String newWord = new String(charArr);

                        if(newWord.equals(endWord)) return level + 1;

                        if(wordSet.contains(newWord)){
                            wordSet.remove(newWord);
                            q.offer(newWord);
                        }
                    }
                    charArr[j] = originalChar; // back to original state
                }
            }
            level++; // level up before next word // its happen after the for loop
            // Process all nodes at the current level, so that you can increment level only after finishing this level. 
        }
        return 0;
    }
}
