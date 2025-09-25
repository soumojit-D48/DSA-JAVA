import java.util.ArrayList;
import java.util.List;

public class test {
    //  public int[] longestCommonPrefix(String[] words) {
    //     int n = words.length;
    //     int[] answer = new int[n];

    //     for (int i = 0; i < n; i++) {
    //         // Step 1: Remove the i-th word
    //         List<String> modified = new ArrayList<>();
    //         for (int j = 0; j < n; j++) {
    //             if (j != i) {
    //                 modified.add(words[j]);
    //             }
    //         }

    //         // Step 2: Find max common prefix length among adjacent pairs
    //         int maxPrefix = 0;
    //         for (int j = 0; j < modified.size() - 1; j++) {
    //             int common = getCommonPrefixLength(modified.get(j), modified.get(j + 1));
    //             maxPrefix = Math.max(maxPrefix, common);
    //         }

    //         // Step 3: Save result
    //         answer[i] = maxPrefix;
    //     }

    //     return answer;
    // }

    // Helper to calculate common prefix length between two strings
    private int getCommonPrefixLength(String a, String b) {
        int len = Math.min(a.length(), b.length());
        int i = 0;
        while (i < len && a.charAt(i) == b.charAt(i)) {
            i++;
        }
        return i;
    }

    public int[] longestCommonPrefix(String[] words) {
        int n = words.length;
        int[] ans = new int[n];
        int[] prefix = new int[n - 1];  // prefix[i] = common prefix of words[i] and words[i+1]

        // Step 1: Precompute prefix lengths between adjacent words
        for (int i = 0; i < n - 1; i++) {
            prefix[i] = commonPrefix(words[i], words[i + 1]);
        }

        // Step 2: For each index i, skip affected pairs and take max of the rest
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < n - 1; j++) {
                if (j == i || j + 1 == i) continue; // skip pairs that involve removed index
                max = Math.max(max, prefix[j]);
            }
            ans[i] = max;
        }

        return ans;
    }

    // Helper method to get common prefix length between two strings
    private int commonPrefix(String a, String b) {
        int len = Math.min(a.length(), b.length());
        int i = 0;
        while (i < len && a.charAt(i) == b.charAt(i)) {
            i++;
        }
        return i;
    }
}
