class Solution {
    public String reverseVowels(String s) {
        Set<Character> vowel = new HashSet<>(Arrays.asList('a', 'o', 'e', 'i', 'u', 'A', 'O', 'E', 'I', 'U'));
        char [] ca = s.toCharArray();

        int left = 0, right = ca.length - 1;
        while(left < right) {
            if(!vowel.contains(ca[left])) {
                left ++;
                continue;
            }

            if(!vowel.contains(ca[right])) {
                right --;
                continue;
            }

            swap(ca, left++, right--);
        }

        return new String(ca);
    }

    public void swap(char [] ca, int i, int j) {
        char temp = ca[i];
        ca[i] = ca[j];
        ca[j] = temp;
    }
}