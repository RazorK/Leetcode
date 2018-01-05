class Solution {
    // Given an array of words and a length L, format the text such that each line
    // has exactly L characters and is fully (left and right) justified.
    //
    // You should pack your words in a greedy approach; that is, pack as many words
    // as you can in each line. Pad extra spaces ' ' when necessary so that each line
    // has exactly L characters.
    //
    // Extra spaces between words should be distributed as evenly as possible. If
    // the number of spaces on a line do not divide evenly between words, the empty
    // slots on the left will be assigned more spaces than the slots on the right.
    //
    // For the last line of text, it should be left justified and no extra space
    // is inserted between words.
    //
    // For example,
    // words: ["This", "is", "an", "example", "of", "text", "justification."]
    // L: 16.
    //
    // Return the formatted lines as:
    // [
    //    "This    is    an",
    //    "example  of text",
    //    "justification.   "
    // ]
    // Note: Each word is guaranteed not to exceed L in length.
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<String>();
        if(maxWidth == 0 || words.length == 0) {
            result.add("");
            return result;
        }
        int index = 0;
        while(true) {
            if(index >= words.length) {
                return result;
            }
            List<Integer> insert = new ArrayList<>();
            int counter = 0;
            int left_blank = 0;
            boolean last_line = false;

            while(true) {
                if(index >= words.length) {
                    last_line = true;
                    break;
                }
                counter += words[index].length() + 1;
                if(counter<maxWidth) {
                    insert.add(index++);
                    continue;
                } else if(counter == maxWidth) {
                    insert.add(index++);
                    left_blank = insert.size();
                    break;
                } else {
                    if(counter == maxWidth + 1){
                        insert.add(index++);
                        left_blank = insert.size() - 1;
                        break;
                    } else {
                        left_blank = maxWidth -
                            (counter - words[index].length() - 1) + insert.size();
                        break;
                    }
                }
            }
            char [] line = new char[maxWidth];
            Arrays.fill(line,' ');
            if(last_line) {
                int ptr = 0;
                for(int word : insert ) {
                    for(int i=0; i<words[word].length(); i++) {
                        line[ptr++] = words[word].charAt(i);
                    }
                }
                result.add(String.valueOf(line));
                return result;
            } else {
                int common = left_blank / insert.size();
                int left_remain = left_blank % insert.size();
                int ptr = 0;
                for(int word : insert ) {
                    for(int i=0; i<words[word].length(); i++) {
                        line[ptr++] = words[word].charAt(i);
                    }
                    ptr += common;
                    if(left_remain>0){
                        ptr++;
                        left_remain--;
                    }
                }
                result.add(String.valueOf(line));
            }
        }
    }
}
