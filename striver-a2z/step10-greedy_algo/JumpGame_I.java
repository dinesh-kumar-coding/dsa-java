public class JumpGame_I {
  public static void main(String[] args) {
    check("[2,3,1,1,4]", canJump(new int[]{2,3,1,1,4}), true);
    check("[3,2,1,0,4] (stuck on the 0)", canJump(new int[]{3,2,1,0,4}), false);
    check("[2,0,0] (jump over the zero)", canJump(new int[]{2,0,0}), true);
    check("[1,0,1,0]", canJump(new int[]{1,0,1,0}), false);
    check("[0] (already at the end)", canJump(new int[]{0}), true);
    check("[0,1]", canJump(new int[]{0,1}), false);
  }

  public static boolean canJump(int[] nums){
    int maxJump = 0;
    for(int i = 0; i < nums.length; i++){
      if(i > maxJump) return false;
      maxJump = Math.max(maxJump, i + nums[i]);
      if(maxJump >= nums.length - 1) return true;
    }
    return true;
  }

  // ---- test helpers ----

  private static void check(String label, Object got, Object expected){
    boolean ok = String.valueOf(got).equals(String.valueOf(expected));
    System.out.println((ok ? "PASS  " : "FAIL  ") + label + "  ->  " + got + (ok ? "" : "   (expected " + expected + ")"));
  }
}
