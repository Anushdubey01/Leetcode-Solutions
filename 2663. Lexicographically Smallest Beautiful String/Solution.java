class Solution {
  public String smallestBeautifulString(String s, int k) {
    StringBuilder sb = new StringBuilder(s);

    for (int i = s.length() - 1; i >= 0; --i) {
      do {
        sb.setCharAt(i, (char) (sb.charAt(i) + 1));
      } while (containsPalindrome(sb, i));
      if (sb.charAt(i) < 'a' + k)
        return changeSuffix(sb, i + 1);
    }

    return "";
  }

  private boolean containsPalindrome(StringBuilder sb, int i) {
    return (i > 0 && sb.charAt(i) == sb.charAt(i - 1)) ||
        (i > 1 && sb.charAt(i) == sb.charAt(i - 2));
  }

  private String changeSuffix(StringBuilder sb, int i) {
    for (int j = i; j < sb.length(); ++j)
      for (sb.setCharAt(j, 'a'); containsPalindrome(sb, j);
           sb.setCharAt(j, (char) (sb.charAt(j) + 1)))
        ;
    return sb.toString();
  }
}
