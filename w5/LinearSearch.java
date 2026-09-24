public class LinearSearch {
    public static int indexOf(String s, char c) {
        // check each index of the string
        for (int i = 0; i < s.length(); i++) {
            // return the index if the char at that index is c
            if (s.charAt(i) == c) {
                return i;
            }
            // don't do anything when the char doesn't match, let loop continue
        }
        // if loop finishes without returning, -1 indicates we couldn't find c
        return -1;
    }
}
