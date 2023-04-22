package algorithms.string.palindrome;

public class Client {
    public static void main(String[] args) {
        PalindromeAlgo algo = new PalindromeAlgo();
        System.out.println(algo.isPalindrome("racecar"));
        System.out.println(algo.longestPalindrome("babad"));
    }
}
