class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int surplus = 0;
        int deficit = 0;
        int startIndex = 0;
        int req = 0;

        for (int i = 0; i < n; i++) {
            surplus += gas[i];
            req = cost[i];
            if (surplus < req) {
                deficit += req - surplus;
                surplus = 0;
                startIndex = i + 1;
            } else {
                surplus -= req;
            }
        }

        if (surplus >= deficit) return startIndex;
        else return -1;
    }
}

/* 
gas  [1, 2, 3, 4, 5]
cost [3, 4, 5, 1, 2]

i = 0
            surplus += gas[i];
            req = cost[i];
            if (surplus < req) {
                deficit += req - surplus;
                surplus = 0;
                startIndex++;
            } else {
                surplus += gas[i];
                surplus -= cost[i];
            }
*/