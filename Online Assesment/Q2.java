There is an array consisting of N two-digit numbers. A group of numbers can be chosen from the array if every pair of chosen numbers has at least one common digit. For example, numbers 25 and 56 can be chosen together as they have a common digit 5 but 11 and 22 cannot be chosen together.

What is the maximum number of array elements that can be chosen together?

Write a function:

class Solution (public int solution(int[] numbers); }

that, given an array numbers made of N integers, returns the maximum number of its elements that can be chosen.





  // you can also use imports, for example:
 import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
// class DisjointSet {
//     private int[] size;
//     private int[] parent;

//     public DisjointSet(int N) {
//         size = new int[N];
//         parent = new int[N];

//         Arrays.fill(size, 0);
//         for (int i = 0; i < N; i++) {
//             parent[i] = i;
//         }
//     }

//     public int findParent(int node) {
//         if (parent[node] == node) {
//             return node;
//         }
//         return parent[node] = findParent(parent[node]);
//     }

//     public void unite(int u, int v) {
//         int pu = findParent(u);
//         int pv = findParent(v);

//         if (pu == pv) {
//             return;
//         }

//         if (size[pu] < size[pv]) {
//             parent[pu] = pv;
//             size[pv] += size[pu];
//         } else {
//             parent[pv] = pu;
//             size[pu] += size[pv];
//         }
//     }
// }

class Solution {
   
    public int solution(int[] a) {
        // int n=numbers.length;
        // DisjointSet ds = new DisjointSet(101);

        // for (int i = 0; i < N; i++) {
        //     ds.size[numbers[i]]++;
        // }

        // for (int i = 0; i < N; i++) {
        //     int temp = numbers[i];
        //     while (temp > 0) {
        //         int u = numbers[i];
        //         int v = temp % 10;
        //         temp /= 10;

        //         ds.unite(u, v);
        //     }
        // }

        // int ans = 0;
        // for (int i = 0; i <= 100; i++) {
        //     ans = Math.max(ans, ds.size[i]);
        // }

        // return ans;

List<Integer> v = new ArrayList<>(Collections.nCopies(10, 0));
        List<Integer> num = new ArrayList<>(Collections.nCopies(100, 0));

        for (int x : a) {
            int p = x / 10;
            int q = x % 10;
            v.set(p, v.get(p) + 1);
            if (p != q) {
                v.set(q, v.get(q) + 1);
            }
            int index = Math.max(p, q) * 10 + Math.min(p, q);
            num.set(index, num.get(index) + 1);
        }

        int r = Collections.max(v);

        for (int x = 0; x <= 9; ++x) {
            for (int y = x + 1; y <= 9; ++y) {
                int index1 = y * 10 + x;
                int index2 = y * 10 + x;
                if (num.get(index1) > 0 && num.get(index2) > 0) {
                    for (int z = y + 1; z <= 9; ++z) {
                        int index3 = z * 10 + x;
                        int index4 = z * 10 + y;
                        if (num.get(index3) > 0 && num.get(index4) > 0) {
                            r = Math.max(r, num.get(index3) + num.get(index4) + num.get(index1));
                        }
                    }
                }
            }
        }

        return r;
   }

}
