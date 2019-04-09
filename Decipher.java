public class Decipher {
  private static final int WORD_LENGTH = 4;
  private static final int OFFSET = 15;

  private static char offsetCharacter(final int character) {
    return (char) (character == 0 ? 
                   character : character + OFFSET);
  }

  public static String decipher(final int[] encodedCharacters) {
    if (encodedCharacters == null || 
        encodedCharacters.length == 0 || 
        encodedCharacters.length % WORD_LENGTH != 0) {
       throw new IllegalArgumentException("Input array salah, " +
                                          WORD_LENGTH);
    }

    final StringBuilder decoded = 
               new StringBuilder(encodedCharacters.length);

    for (int i = 0; i < encodedCharacters.length; i += WORD_LENGTH){
      decoded.append(offsetCharacter(encodedCharacters[i + 3]));
      decoded.append(offsetCharacter(encodedCharacters[i + 2]));
      decoded.append(offsetCharacter(encodedCharacters[i + 0]));
      decoded.append(offsetCharacter(encodedCharacters[i + 1]));
    }
    return decoded.toString();
  }
}
