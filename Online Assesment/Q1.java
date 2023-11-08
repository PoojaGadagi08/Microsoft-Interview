A domino is a rectangular tile divided into two square parts. There are between 1 and dots on each of the parts.

There is an array A of length 2*N, representing N dominoes. Dominoes are arranged in line in the order in which they appear in array A. The number of dots on the left and the right parts of the K-th domino are A[2K] and A[2*K+1], respectively. For example, an array A=[2,4,1,3,4,6,2,4, 1, 6] represents a sequence of five domino tiles: (2, 4), (1, 3), (4, 6), (2, 4), and (1,6).

In a correct domino sequence, each pair of neighboring tiles should have the same number of dots on their adjacent parts. For example, tiles (2, 4) and (4, 6) form a correc domino sequence and tiles (2, 4) and (1,3) do not.

What is the minimum number of domino tiles that must be removed from the sequence so that the remaining tiles form a correct domino sequence? It is not allowed to reorder or rotate the dominoes.

Write a function:

int solution(int a[], int M);

that, given an array A representing a sequence of N domino tiles, returns the minimum number of tiles that must be removed so that the remaining tiles form a correct domino sequence.





  import java.util.*;

class Solution {
    public int solution(int[] A) {
        int N = A.length;

        if (N < 2) {
            return 0; // No tiles can be chosen if there are less than 2 tiles
        }

        int[] arr = new int[N / 2];
        int index = 0;

        // Extract pairs from the input array
        for (int i = 0; i < N; i += 2) {
            int left = A[i];
            int right = A[i + 1];
            int pair = left * 10 + right;
            arr[index++] = pair;
        }

        int cnt = 0;

        // Count valid neighboring pairs
        for (int i = 0; i < arr.length - 1; i++) {
            int rem = arr[i] % 10;
            for (int j = i + 1; j < arr.length; j++) {
                int div = arr[j] / 10;

                if (rem == div || rem == arr[j] % 10) {
                    cnt++;
                }
            }
        }

        // Calculate and return the minimum number of tiles to remove
        return N - cnt * 2;
    }
}
