/*
*My name is Sophie Imhof and I like ice cream
*/
public class Groceries {
  public static void main (String[] args){
    String name = "Brad";
    int cash = 50;
    double taxRate = 0.1;
    double subtotal = 42.3;
    double change = cash - (subtotal +subtotal * taxRate);
    System.out.printf("%s has $%.2f dollars remaining!\n%s started with $%d dollars!\n", name, change, name, cash);
  }
}
