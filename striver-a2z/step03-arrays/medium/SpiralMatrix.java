/*
 * Problem: Print the matrix in spiral manner — Striver A2Z Step 3 (medium)
 * Solved: 2026-07-20 | TC: O(N*M), SC: O(1) if considered else O(N*M) for extra list.
 * Revisit: [date]
 */

import java.util.ArrayList;

public class SpiralMatrix {
  public static void main(String[] args) {
    int[][] arr = {{1,2,3,4},{5,6,7,8}};
    System.out.println(elementsOfMatrixInSpiralManner(arr));
  }

  public static ArrayList<Integer> elementsOfMatrixInSpiralManner(int[][] arr){
    int n = arr.length;
    int m = arr[0].length;
    ArrayList<Integer> ans = new ArrayList<>();
    int left = 0, right = m - 1, top = 0, bottom = n - 1;

    while(right >= left && bottom >= top){
      //right
      for(int i = left; i <= right; i++){
        ans.add(arr[top][i]);
      }
      top++;

      //down
      for(int i = top; i <= bottom; i++){
        ans.add(arr[i][right]);
      }
      right--;

      if(bottom >= top){
        //left
        for(int i = right; i >= left; i--){
          ans.add(arr[bottom][i]);
        }
        bottom--;
      }
        
      if(right >= left){
        //up
        for(int i = bottom; i >= top; i--){
          ans.add(arr[i][left]);
        }
        left++;
      }
        
    }

    return ans;
  }
  
}
