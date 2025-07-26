import java.util.*;

class Solution {
    
    static class User {
        int minRate;
        int priceLimit;

        public User(int minRate, int priceLimit) {
            this.minRate = minRate;
            this.priceLimit = priceLimit;
        }

        public static User from(int[] user) {
            return new User(user[0], user[1]);
        }
    }

    static class Result {
        int subscribers;
        int amount;

        public Result(int subscribers, int amount) {
            this.subscribers = subscribers;
            this.amount = amount;
        }
    }

    
    public int[] solution(int[][] users, int[] emoticons) {
        User[] userList = Arrays.stream(users)
            .map(User::from).toArray(User[]::new);
        
        int[] discounts = new int[emoticons.length];
        
        Result result = dfs(0, discounts, emoticons, userList);
        return new int[]{result.subscribers, result.amount};
    }
    
    public Result dfs(int depth, int[] discounts, int[] prices, User[] users) {
        if (depth == prices.length) {
            return evaluate(discounts, prices, users);
        }
        
        Result best = new Result(0, 0);
        
        for (int rate : new int[]{10, 20, 30, 40}) {
            discounts[depth] = rate;
            Result result = dfs(depth + 1, discounts, prices, users);
            
            if (result.subscribers > best.subscribers) {
                best = result;
            } else if (
                result.subscribers == best.subscribers
                && result.amount > best.amount
            ) {
                best = result;
            }
        }
        
        return best;
    }
    
    public Result evaluate(int[] discounts, int[] prices, User[] users) {
        int subscribers = 0;
        int amount = 0;
        
        for (User user : users) {
            int sum = 0;
            
            for (int i = 0; i < prices.length; i++) {
                // 현재 이모티콘의 할인율이 사용자가 원하는 할인율보다 낮으면 스킵
                if (discounts[i] < user.minRate) continue;
                sum += prices[i] * (100 - discounts[i]) / 100;
            }

            if (sum >= user.priceLimit) {
                subscribers++;
            } else {
                amount += sum;
            }
        }
        
        return new Result(subscribers, amount);
    }
}