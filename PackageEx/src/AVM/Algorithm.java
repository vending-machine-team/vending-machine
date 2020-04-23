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

        if(TotalPrice > currentMoney)
        {
            System.out.println("���� �����մϴ�.");
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
            System.out.println("�� �°� �Ž����� �� �����ϴ�.");
        else
        {
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
                System.out.println(coin[i] + " �� ȭ�� " + num[i] + "��");
            }
            System.out.println("�� " + temp[0] + "���� ������ �Ž������ϴ�.");
        }

        long endtime = System.currentTimeMillis();
        long runtime = endtime - starttime;

        System.out.println("����ð� : " + runtime + "ms");
    }
}