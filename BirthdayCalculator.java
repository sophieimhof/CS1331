public class BirthdayCalculator {
  public static void main (String[] args){
    int birthMonth = 1;
    int birthDay = 23;
    int birthYear = 1996;
    int bdayCalculation = birthMonth;
    int x = bdayCalculation + 18;
    x *= 25;
    x -= 333;
    x *= 8;
    x -= 554;
    x /= 2;
    x += birthDay;
    x *= 5;
    x += 692;
    x *= 20;
    x += (birthYear%100);
    x -= 32940;
    bdayCalculation = x;
    System.out.println("Birthday: " + bdayCalculation);
  }
}
