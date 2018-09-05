public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs) {
            for(int i=0; i<str.length(); i++) {
                char cur = str.charAt(i);
                if(cur == '|' || cur == '/') {
                    sb.append('/');
                }
                sb.append(cur);
            }
            sb.append('|');
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);

            if(cur == '|') {
                res.add(sb.toString());
                sb = new StringBuilder();
                continue;
            }

            if(cur == '/') {
                cur = s.charAt(++i);
            }
            sb.append(cur);
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));