package Algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class WordDictionary {
    private Map<Integer,HashSet<String>> mapset;

    public WordDictionary() {
        mapset = new HashMap<>();
    }

    public void addWord(String word) {
        HashSet<String> set = mapset.getOrDefault(word.length(),new HashSet<>());
        set.add(word);
        mapset.putIfAbsent(word.length(),set);
    }

    public boolean search(String word) {
        if(!mapset.containsKey(word.length())){
            return false;
        }
        HashSet<String> set = mapset.get(word.length());
        if(word.contains(".")){
            char[] wc = word.toCharArray();
            for (String index: set) {
                int flag = wc.length;
                char[] indexc = index.toCharArray();
                for (int j = 0; j < wc.length ; j++) {
                    if (indexc[j] == wc[j] || wc[j]=='.') {
                        flag--;
                        if(flag == 0){
                            return true;
                        }
                    }else{
                        break;
                    }
                }
            }
            return false;
        }else{
            return set.contains(word);
        }
    }

    public static void main(String[] args) {
        WordDictionary w = new WordDictionary();
        w.addWord("at");
        w.addWord("and");
        w.addWord("an");
        w.addWord("add");
        System.out.println(w.search("a"));
        System.out.println(w.search(".at"));
        w.addWord("bat");
        System.out.println(w.search(".at"));
    }
}
