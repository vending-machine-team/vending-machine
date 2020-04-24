package AVM;

import java.util.*;

class Algorithm {
	static int change;
	static void Greedy(int TotalPrice,int currentMoney) {
		change = currentMoney - TotalPrice;
        int[] coin = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10};
        int[] temp = new int[1000001];
        int[] backtrack = new int[1000001];
        int[] num = new int[coin.length];

        Arrays.sort(coin);
        if(TotalPrice > currentMoney)
        {
            System.out.println("돈이 부족합니다.");
            return;
        }

        Arrays.fill(temp, 1000000000);
        Arrays.fill(backtrack, -1);
        temp[change] = 0;

        long starttime = System.currentTimeMillis();

        for (int c = 0; c < coin.length; c++)
            for (int i = change; i >= coin[c]; i--)
                if(temp[i - coin[c]] > temp[i]+1)
                {
                    temp[i-coin[c]] = temp[i]+1;
                    backtrack[i-coin[c]] = c;
                }

        if(temp[0] == 1000000000)
            System.out.println("딱 맞게 거슬러줄 수 없습니다.");
        else
        {
            for(int i=num.length-1;i>=0;i--)
            {
                System.out.print(coin[i]);
                if(i!=0)
                    System.out.print(", ");
            }
            System.out.println(" 단위의 화폐 중에");

            int cur = 0;
            while(cur != change)
            {
                num[backtrack[cur]]++;
                cur+=coin[backtrack[cur]];
            }
            for(int i=0;i<num.length;i++)
            {
                if(num[i] == 0)
                    continue;
                System.out.println(coin[i] + " 원 화폐 " + num[i] + "개");
            }
            System.out.println("총 " + temp[0] + "개의 동전을 거슬렀습니다.");
        }

        long endtime = System.currentTimeMillis();
        long runtime = endtime - starttime;

        System.out.println("실행시간 : " + runtime + "ms");
    }
}