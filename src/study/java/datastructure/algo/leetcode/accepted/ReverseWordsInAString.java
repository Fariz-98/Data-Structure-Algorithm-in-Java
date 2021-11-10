package study.java.datastructure.algo.leetcode.accepted;

// 151
// Medium

public class ReverseWordsInAString {

    public static void main(String[] args) {
        System.out.println(reverseWords("a good   example"));
    }

    public static String reverseWords(String s) {
        // Remove trailing and leading spaces
        String sTrimmed = s.trim();

        StringBuilder stringBuilder = new StringBuilder();

        String[] splits = sTrimmed.split(" ");

        for (int i = splits.length - 1; i >= 0; i--) {
            if (splits[i].equals(""))
                continue;
            if (i == 0) {
                stringBuilder.append(splits[i].trim());
                break;
            }
            stringBuilder.append(splits[i].trim()).append(" ");
        }

        return stringBuilder.toString();
    }

}
