package leetcode;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
    	int n = gas.length;

    	if (n <= 1)
    		if (gas[0] >= cost[0]) return 0;
    		else return -1;
    	
    	int surplus = 0;
    	int start = 0, now = 1;

    	surplus = gas[start] - cost[start];

    	while (start != now) {
    		if (surplus >= 0) {
    			surplus = surplus + gas[now] - cost[now];
    			now ++;
    			if (now == n)
    				now = 0;
    		}
    		else {
    			if (start == 0)
    				start = n - 1;
    			else
    				start --;
    			surplus = surplus + gas[start] - cost[start];
    		}    		
    	}

    	if (surplus >= 0) return start;
    	else return -1;
    	
    }
}
