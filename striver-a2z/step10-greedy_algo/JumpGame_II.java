public class JumpGame_II {
  public static void main(String[] args) {
    // LeetCode 45 guarantees the last index is reachable - every input here respects that.
    check("[2,3,1,1,4]", minJumps(new int[]{2,3,1,1,4}), 2);
    check("[2,3,0,1,4]", minJumps(new int[]{2,3,0,1,4}), 2);
    check("[1,1,1,1] (one step at a time)", minJumps(new int[]{1,1,1,1}), 3);
    check("[10,1,1,1] (one jump covers it all)", minJumps(new int[]{10,1,1,1}), 1);
    check("[1,2]", minJumps(new int[]{1,2}), 1);
    check("[0] (already at the end)", minJumps(new int[]{0}), 0);
  }

  public static int minJumps(int[] nums){
    int minJumps = 0;
    int prevJump = 0;
    int furthestJump = 0;
    while(furthestJump < nums.length - 1){
      int furthest = furthestJump;
      for(int i = prevJump; i <= furthestJump; i++){
        furthest = Math.max(furthest, i + nums[i]);
      }
      prevJump = furthestJump + 1;
      furthestJump = furthest;
      minJumps++;
    }
    return minJumps;
  }

  // ---- test helpers ----

  private static void check(String label, Object got, Object expected){
    boolean ok = String.valueOf(got).equals(String.valueOf(expected));
    System.out.println((ok ? "PASS  " : "FAIL  ") + label + "  ->  " + got + (ok ? "" : "   (expected " + expected + ")"));
  }
}
