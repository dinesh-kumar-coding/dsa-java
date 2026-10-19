public class LemonadeChange {
  public static void main(String[] args) {
    check("[5,5,5,10,20]", lemonadeChange(new int[]{5,5,5,10,20}), true);
    check("[5,5,10,10,20]", lemonadeChange(new int[]{5,5,10,10,20}), false);
    check("[10] (no change on hand)", lemonadeChange(new int[]{10}), false);
    check("[5,5,5,5,20,20]", lemonadeChange(new int[]{5,5,5,5,20,20}), false);
    // For a 20, giving 10+5 must be preferred over 5+5+5 - fives are the scarce change.
    // Giving 5+5+5 here would leave no five for the last 10.
    check("[5,5,5,5,10,20,10,10] (prefer 10+5)", lemonadeChange(new int[]{5,5,5,5,10,20,10,10}), true);
    check("[5]", lemonadeChange(new int[]{5}), true);
  }

  public static boolean lemonadeChange(int[] bills){
    int fiveCount = 0;
    int tenCount = 0;

    for(int i = 0; i < bills.length; i++){
      if(bills[i] == 5){
        fiveCount++;
      } else if(bills[i] == 10){
        if(fiveCount > 0){
          fiveCount--;
          tenCount++;
        } else return false;
      } else{
        if(fiveCount > 0 && tenCount > 0){
          fiveCount--;
          tenCount--;
        } else if(fiveCount > 2){
          fiveCount -= 3;
        } else return false;
      }
    }
    return true;
  }

  // ---- test helpers ----

  private static void check(String label, Object got, Object expected){
    boolean ok = String.valueOf(got).equals(String.valueOf(expected));
    System.out.println((ok ? "PASS  " : "FAIL  ") + label + "  ->  " + got + (ok ? "" : "   (expected " + expected + ")"));
  }
}
