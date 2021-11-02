public class BenderDriver{
  public static void main(String [] args){
    FireBender sophie = new FireBender("Sophie");
    AirBender jill = new AirBender("Jill");
    FireBender abby = new FireBender("Abby", 100, 100, 40, true);
    AirBender bob = new AirBender("Bob", 50, 30, true);
    System.out.println(sophie.toString());
    System.out.println(jill.toString());
    System.out.println(abby.toString());
    System.out.println(bob.toString());
    sophie.attack(jill);
    bob.attack(abby);
    System.out.println(jill.toString());
    System.out.println(abby.toString());
    sophie.fireArmy();
    System.out.println(sophie.toString());
    bob.healthIncrease(50);
    System.out.println(bob.toString());
    bob.avatarState("Fire", sophie);
    System.out.println(sophie.toString());
    abby.setHealth(80);
    System.out.println(bob.spiritualProjection(abby));
  }
}
