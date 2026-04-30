package com.dsa.problems;

public class MaxWealth {
    static int getMaxWealth (int[][] accounts) {

        int maxWealth = 0;

        for (int[] accountBalances: accounts) {
            int totalBalance = 0;

            for (int balance: accountBalances) {
                totalBalance += balance;
            }

            if (totalBalance > maxWealth) {
                maxWealth = totalBalance;
            }
        }

        return maxWealth;
    }

    public static void main(String[] args) {
        int[][] wealthInfo = {{2, 4, 1}, {6, 7}, {1, 3, 5}};
        int maxWealth = getMaxWealth(wealthInfo);

        System.out.println(maxWealth);
    }
}
