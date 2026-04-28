class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int maxLength = 0, left = 0;

        for (int right = 0; right < s.length(); right++) {
            char letter = s.charAt(right);

            if (map.containsKey(letter)) {
                left = Math.max(left, map.get(letter) + 1);
            } 
            
            map.put(letter, right);
            maxLength = Math.max(maxLength, right - left + 1);
            
        }

        return maxLength;
    }
}