import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        String[] dict = {"hot","dot","dog","lot","log","cog"};
        List<String> words = Arrays.asList(dict);
        System.out.println(ladderLength("hit", "cog", words));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<String>();
        Set<String> unvisited = new HashSet<String>(wordList);
        Set<String> visited = new HashSet<String>();

        if (!unvisited.contains(endWord)) return 0;
        int level = 1;
        q.add(beginWord);
        ++level;
        q.add(null);
        while(!q.isEmpty()) {
            String tmp = q.remove();
            if (tmp == null) {
                ++level;
                if(!q.isEmpty()) q.add(null);
                continue;
            }
            unvisited.remove(tmp);
            visited.add(tmp);
            char[] ch = tmp.toCharArray();
            for(int i=0; i<ch.length; i++) {
                for(char c = 'a'; c<='z'; c++) {
                    char old = ch[i];
                    ch[i] = c;
                    String nval = new String(ch);
                    if (unvisited.contains(nval)) {
                        if (nval.equals(endWord)) {
                            return level;
                        } else {
                            q.add(nval);
                        }
                    }
                    ch[i] = old;
                }
            }
        }
        return 0;
    }
}
