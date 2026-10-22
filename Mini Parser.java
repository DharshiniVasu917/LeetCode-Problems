class Solution {
    public NestedInteger deserialize(String s) {
        if (Character.isDigit(s.charAt(0)) || s.charAt(0) == '-')
            return new NestedInteger(Integer.parseInt(s));
        else {
            String ss = s.substring(1, s.length() - 1) + ",";
            //System.out.println(ss);
            NestedInteger ni = new NestedInteger();
            for (int i = 0, cnt = 0, last = 0; i < ss.length(); i++) {
                if (ss.charAt(i) == '[')
                    cnt++;
                if (ss.charAt(i) == ']')
                    cnt--;
                if (ss.charAt(i) == ',' && cnt == 0) {
                    //System.out.println(">>" + ss.substring(last, i) + "<<");
                    if (last != i)
                        ni.add(deserialize(ss.substring(last, i)));
                    last = i + 1;
                }
            }
            return ni;
        }
    }
}
