import java.util.Scanner;

public class SecretDecoder {
  public static void main (String[] args){
    String secretMessage;
    String plainMessage;
    String cipherType;
    char[][] rot5Cipher = {{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'},{'f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','a','b','c','d','e'}};
    char[][] noalphaCipher = {{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'},{'`','~','1','!','2','@','3','#','4','$','5','%','6','^','7','&','8','*','9','(','0',')','-','_','=','+'}};
    Scanner myScanner = new Scanner(System.in);
    myScanner.useDelimiter("\\n");
    System.out.print("Enter the secret message: ");
    secretMessage = myScanner.next();
    System.out.print("Enter the cipher type (i.e. ROT5 or noalpha): ");
    cipherType = myScanner.next();
    secretMessage = secretMessage.toLowerCase();
    char [] secretChars = secretMessage.toCharArray();
    int i;
    int j;
    int rot5 = cipherType.compareToIgnoreCase("ROT5");
    int noalph = cipherType.compareToIgnoreCase("noalpha");
    plainMessage= "";
    if (rot5 == 0) {
      for (i= 0 ; i< secretMessage.length(); i++) {
        for (j=0; j<26; j++) {
          if (secretChars[i] == rot5Cipher[1][j]) {
            secretChars[i] = rot5Cipher[0][j];
            break;
          }
        }
      }
      plainMessage = new String(secretChars);
    }
    else if (noalph == 0) {
      for (i= 0 ; i< secretMessage.length(); i++) {
        for (j=0; j<26; j++) {
          if (secretChars[i] == noalphaCipher[1][j]) {
            secretChars[i] = noalphaCipher[0][j];
            break;
          }
      }
    }
      plainMessage = new String(secretChars);
    }
    else {
      System.out.printf("Cipher type: %s\nCiphertext : %s\nERROR      : This cipher type is unsupported\n", cipherType, secretMessage);
    }
  if (rot5==0 | noalph==0) {
    System.out.printf("Cipher type: %s\nCiphertext : %s\nPlaintext  : %s\n", cipherType, secretMessage, plainMessage);
  }
}
}
