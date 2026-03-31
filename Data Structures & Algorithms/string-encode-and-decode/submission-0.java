class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder("");
        for (String str : strs) {
            sb.append(str.length() + "#" + str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();

        while(str.length() > 0) {
            String[] strs = str.split("#", 2);
            int len = Integer.valueOf(strs[0]);
            res.add(strs[1].substring(0, len));
            str = strs[1].substring(len);
        }

        return res;
    }
}
