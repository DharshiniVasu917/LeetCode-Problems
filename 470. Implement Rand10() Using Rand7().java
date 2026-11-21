class Solution extends SolBase {
    public int rand10() {
        int val1 = rand7();
        int val2 = rand7();
        while(val1 == 7) 
            val1 = rand7();
        while(val2 > 5)
            val2 = rand7();
        return val1 < 4 ? val2 : val2 + 5;
    }
}
