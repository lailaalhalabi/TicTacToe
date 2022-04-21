# Time-Complexity-Comparision-Codes

This assignment compares recursive and iterative methods time complexity by creating a game that generates all possible combinations of a random string consists of X and O without '#' using recursion in the first version and iteration in the second version.

---

After running both versions:

With increasing the number of squares, running time and running complexity were increasing dramatically and the file out.txt did not open due to the large size of the program. As a result, the generated size of the string upper bound was limited to 50 to obtain accurate results for comparing the quality of the iterative and recursive methods. Having a limit helped in decreasing time complexity and running time of the program.
After running the program in a for loop 12 run incrementing by 2 from 2# up to 24#, the following were observed:

- The time complexity of recursive and iterative methods was increasing dramatically when the number of squares increases, regardless of the size of the row which didn’t have a big impact on the time complexity as the results illustrate.
- The time complexity in the iterative method was better at the beginning till 12# run. However, after run 14# till 24#, the time complexity of the recursive method was noticeably better than the time complexity of the iterative method when the number of the hidden squares started to grow.
  The reason behind increasing the time complexity is that when finding a hidden square, the method is being called twice. Nevertheless, time complexity of the recursive method is scalable if better storage tools were used and if number of calls inside the method were reduced. Overall, recursion is better to use than iteration if the hidden squares number is big (16# and more).

---

Time Complexity:
In both methods, best-case scenario is O(n) when there is no hidden character, and it is O(2^n) when there are hidden characters that we need to find all subsets. So, the worst-case scenario is O(2^n).

Space Complexity:
Both methods use linear search and have a space complexity of O(1). The recursive method used variables only to store, and the iterative method used stack to store.
