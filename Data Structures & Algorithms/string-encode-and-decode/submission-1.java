class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strs.size(); i++) {
            sb.append(strs.get(i));
            sb.append((char)257);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != (char)257) {
                sb.append(str.charAt(i));
            } else {
                res.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return res;
    }
}
