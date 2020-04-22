package AVM;

import java.util.*;

class Algorithm {
	static int change;
	static void Greedy(int TotalPrice,int currentMoney) {
		change = currentMoney - TotalPrice;
        int[] coin = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10};
        int[] temp = new int[1000001];

        if(TotalPrice > currentMoney)
        {
        	System.out.println("돈이 부족합니다.");
	return;
        }

        Arrays.fill(temp, 1000000000);
        temp[change] = 0;

        long starttime = System.currentTimeMillis();

        for (int c = 0; c < coin.length; c++)
            for (int i = change; i >= coin[c]; i--)
		if(temp[i - coin[c]] > temp[i]+1)
			temp[i-coin[c]] = temp[i]+1;

        long endtime = System.currentTimeMillis();
        long runtime = endtime - starttime;

        System.out.println(temp[0] == 1000000000 ? -1 : temp[0]);
        System.out.println("runtime : " + runtime + "ms");
    }
}

