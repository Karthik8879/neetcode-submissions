class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strs.size(); i++) {
            sb
            .append(strs.get(i).length())
            .append("#")
            .append(strs.get(i));
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        for(int i = 0; i < str.length(); i++) {
            int j = i;
            while(str.charAt(j) != '#') {
                j++;
            }
            int len = Integer.parseInt(str.substring(i, j));
            int start = j+1;
            int end = start+len;
            res.add(str.substring(start, end));
            i = end-1;
        }
        return res;
    }
}
