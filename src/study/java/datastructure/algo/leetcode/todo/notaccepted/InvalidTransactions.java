package study.java.datastructure.algo.leetcode.todo.notaccepted;

// 1169
// Medium

import java.util.*;

public class InvalidTransactions {

    public static void main(String[] args) {
        String[] transC = {
                "alice,20,800,mtv","alice,50,100,mtv","alice,51,100,frankfurt"
        };

        for (String tempStr : invalidTransactions(transC)) {
            System.out.println(tempStr);
        }
    }

    public static List<String> invalidTransactions(String[] transactions) {
        ArrayList<String> res = new ArrayList<>();
        Set<String> invalid = new HashSet<>();
        Map<String, Map<String, Integer>> transactionMap = new HashMap<>();

        for (int i = 0; i < transactions.length; i++) {
            String[] currSplit = transactions[i].split(",");
            String currName = currSplit[0];
            String currTime = currSplit[1];
            String currAmount = currSplit[2];
            String currCity = currSplit[3];

            // Check for amount
            if (Integer.parseInt(currAmount) > 1000) {
                res.add(transactions[i]);
                continue;
            }

            // Check for name
            if (transactionMap.containsKey(currName)) {
                // Check for city
                Iterator<String> itr = transactionMap.get(currName).keySet().iterator();
                while (itr.hasNext()) {
                    String oldString = itr.next();
                    String[] oldSplit = oldString.split(",");
                    String oldTime = oldSplit[1];
                    String oldCity = oldSplit[3];

                    // If different city and more than 60 minutes then add to invalid
                    if (!oldCity.equals(currCity) && Math.abs(Integer.parseInt(oldTime) + Integer.parseInt(currTime)) >= 60) {
                        int oldStringCount = transactionMap.get(currName).get(oldString);
                        for (int j = 0; j < oldStringCount; j++) {
                            res.add(oldString);
                        }
                        invalid.add(transactions[i]);
                    } else if (transactionMap.get(currName).containsKey(transactions[i])){
                        transactionMap.get(currName).put(transactions[i], transactionMap.get(currName).get(transactions[i]) + 1);
                    } else {
                        transactionMap.get(currName).put(transactions[i], transactionMap.get(currName).getOrDefault(transactions[i], 0) + 1);
                    }
                }

            } else {
                HashMap<String, Integer> newMap = new HashMap<>();
                newMap.put(transactions[i], newMap.getOrDefault(transactions[i], 0) + 1);
                transactionMap.put(currName, newMap);
            }
        }

        res.addAll(invalid);
        return res;
    }

}
