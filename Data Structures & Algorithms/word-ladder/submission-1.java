class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord) || !wordList.contains(endWord)) {
            return 0;
        }

        Set<String> wordSet = new HashSet<>(wordList);

        Set<String> begin = new HashSet<>();
        begin.add(beginWord);
        Set<String> end = new HashSet<>();
        end.add(endWord);

        int step = 0;

        while (!begin.isEmpty() && !end.isEmpty()) {
            step++;

            if (begin.size() > end.size()) {
                Set<String> tmp = begin;
                begin = end;
                end = tmp;
            }

            Set<String> newBegin = new HashSet<>();

            for (String word : begin) {
                for (int i = 0; i < word.length(); i++) {
                    char[] cw = word.toCharArray();
                    char original = cw[i];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (original == c) {
                            continue;
                        }

                        cw[i] = c;
                        String newWord = new String(cw);
                        if (end.contains(newWord)) {
                            return step + 1;
                        }

                        if (wordSet.contains(newWord)) {
                            newBegin.add(newWord);
                            wordSet.remove(newWord);
                        }
                    }
                }
            }
            System.out.println(newBegin.toString());

            begin = newBegin;
        }

        return 0;
    }
}



