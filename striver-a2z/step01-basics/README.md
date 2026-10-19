# Step 1 — Basics

Full notes for every problem in this folder. Status and revisit dates are tracked in [PROGRESS.md](../../PROGRESS.md).

## Basic maths

### Reverse a number
**File:** [BasicMaths.java](BasicMaths.java), method `reversedNumber`

**Question.** Reverse the digits of a number, so 1234 becomes 4321.

**Approach — peel digits off the end.** The last digit of a number is the remainder when it is divided by 10, and dividing by 10 removes that digit. Starting from a reversed value of zero, the loop takes the last digit, appends it by multiplying the reversed value by 10 and adding the digit, and then removes that digit from the original. When the original reaches zero, every digit has been moved across in reverse order. Negative numbers need no special handling, because in Java the remainder keeps the sign of the number. Before each multiplication, the method checks whether the reversed value has grown so large that multiplying by 10 would overflow, and returns 0 if so.

- **Time:** O(D), where D is the number of digits — the loop runs once per digit.
- **Extra space:** O(1) — only the reversed value is stored.

**Remember:** check for overflow *before* multiplying by 10, because once the multiplication has overflowed, the number has already wrapped around and the damage cannot be detected. A complete check also covers the exact boundary: when the reversed value equals the largest allowed value divided by 10, the next digit can still push it over the limit, so that digit has to be compared with the last digit of the limit as well.

### Check if a number is a palindrome
**File:** [BasicMaths.java](BasicMaths.java), method `checkPalidrome`

**Question.** Decide whether a number reads the same forwards and backwards, like 121.

**Approach — reverse and compare.** A negative number can never be a palindrome, because the minus sign appears only at the front, so the method returns false straight away. Otherwise it keeps a copy of the original, reverses the digits with the same peel-and-append loop used in "Reverse a number", and compares the reversed value with the copy.

- **Time:** O(D), where D is the number of digits.
- **Extra space:** O(1).

**Remember:** keep a copy of the original before the loop starts, because the loop destroys the number while it peels the digits off. Overflow cannot cause a wrong answer here: a number whose reverse is too large to store cannot be equal to that reverse, so it is correctly reported as not a palindrome.

### Check if a number is an Armstrong number
**File:** [BasicMaths.java](BasicMaths.java), method `isArmstrong`

**Question.** An Armstrong number equals the sum of its own digits, each raised to the power of how many digits the number has. For example, 153 = 1³ + 5³ + 3³.

**Approach — add up the powered digits.** The method first counts the digits by converting the number to text and measuring its length. It then peels the digits off one at a time, raises each to the power of that digit count, and adds the result to a running sum. The number is an Armstrong number if the sum equals the original.

- **Time:** O(D), where D is the number of digits.
- **Extra space:** O(D) for the text version of the number used to count the digits; everything else is constant.

**Remember:** the power is the number of digits, not always 3. 153 uses cubes because it has three digits, but 1634 uses fourth powers: 1⁴ + 6⁴ + 3⁴ + 4⁴ = 1634.

### Find all divisors of a number
**File:** [BasicMaths.java](BasicMaths.java), method `printDivisors`

**Question.** List every number that divides a given number exactly.

**Approach — check only up to the square root.** Divisors come in pairs: if i divides n, then n divided by i divides it too, and the smaller member of every pair is at most the square root of n. So the loop only runs while i × i is at most n. Whenever i divides n, both i and its partner n / i are added, except when they are the same number, which happens when n is a perfect square. The pairs arrive out of order, so the list is sorted at the end.

- **Time:** O(√N + K log K), where K is the number of divisors — the loop runs up to the square root of N, and sorting the divisors adds a little on top.
- **Extra space:** O(K) for the list of divisors.

**Not in the file yet:** the brute force, which tests every number from 1 to N and takes O(N) time.

**Remember:** for a perfect square such as 36, the pair (6, 6) is a single divisor. The `n / i != i` check is what stops 6 from being added twice.

### Check if a number is prime
**File:** [BasicMaths.java](BasicMaths.java), method `isPrime`

**Question.** Decide whether a number has no divisors other than 1 and itself.

**Approach — test divisors up to the square root.** Numbers less than or equal to 1 are not prime, so they return false immediately. For anything larger, the loop tries every i from 2 while i × i is at most n. If any i divides n exactly, n is not prime; if the loop finishes without finding one, n is prime.

- **Time:** O(√N).
- **Extra space:** O(1).

**Not in the file yet:** the brute force, which tries every number from 2 to N − 1 and takes O(N) time.

**Remember:** stopping at the square root is safe. If n had a divisor larger than its square root, the other divisor in that pair would be smaller than the square root, and the loop would already have found it.

### Greatest common divisor of two numbers
**File:** [BasicMaths.java](BasicMaths.java), method `GCD`

**Question.** Find the largest number that divides both of two given numbers.

**Approach — Euclidean algorithm with remainders.** The greatest common divisor of two numbers does not change when the larger one is replaced by its remainder after dividing by the smaller one. The loop repeats that replacement while both numbers are above zero. The moment one of them becomes zero, the other is the answer, which the method returns as the larger of the two.

- **Time:** O(log(min(A, B))), where A and B are the two numbers — each replacement shrinks the numbers quickly.
- **Extra space:** O(1).

**Not in the file yet:** the brute force, which counts down from the smaller number and returns the first value that divides both, taking O(min(A, B)) time.

**Remember:** use the remainder, not subtraction. Repeatedly subtracting the smaller number from the larger one reaches the same answer, but for a pair like 1,000,000 and 1 it takes a million steps where the remainder takes one.

## Basic recursion

### Print 1 to N using recursion
**File:** [Recursion.java](Recursion.java), methods `recursion_1_to_N` and `recursion_1_to_N_backtracking`

**Question.** Print the numbers from 1 to N without using a loop.

**Recursive — print, then recurse.** The method receives the current number i and the limit n. If i has passed n, it stops; otherwise it prints i and calls itself with i + 1. Each call prints one number before handing over to the next, so the numbers come out in increasing order.

- **Time:** O(N) — one call per number.
- **Extra space:** O(N) — the call stack holds one frame for every number until the last call returns.

**Backtracking — recurse, then print.** This version shrinks the problem first: it calls itself with n − 1 and only prints n after that call has returned. The deepest call, which holds the smallest number, finishes first and therefore prints first, so the numbers come out as 1, 2, 3 and onwards while the calls unwind.

- **Time:** O(N).
- **Extra space:** O(N) for the call stack.

**Remember:** the position of the print relative to the recursive call decides the order. Printing before the call produces the numbers on the way down; printing after the call produces them on the way back up, which is the idea every "backtracking" version relies on.

### Print N to 1 using recursion
**File:** [Recursion.java](Recursion.java), methods `recursion_N_to_1` and `recursion_N_to_1_backtracking`

**Question.** Print the numbers from N down to 1 without using a loop.

**Recursive — print, then recurse.** The method prints n and then calls itself with n − 1, stopping once n drops below the starting value. Each call prints before going deeper, so the numbers come out in decreasing order.

- **Time:** O(N).
- **Extra space:** O(N) for the call stack.

**Backtracking — recurse, then print.** This version counts the other way: it calls itself with i + 1 first and only prints i after that call returns. The call holding the largest number finishes first, so the output starts at N and counts down while the calls unwind.

- **Time:** O(N).
- **Extra space:** O(N) for the call stack.

**Remember:** this is the mirror image of "Print 1 to N". Both problems are built from the same two blocks; only the direction the counter moves and the position of the print change.

### Sum of the first N numbers
**File:** [Recursion.java](Recursion.java), method `recursion_sumOfFirstN`

**Question.** Find 1 + 2 + … + N.

**Approach — functional recursion.** The sum of the first N numbers is N plus the sum of the first N − 1 numbers. The method returns exactly that by calling itself with N − 1, and stops at zero, where the sum is 0. The additions happen while the calls return, starting from the smallest number.

- **Time:** O(N).
- **Extra space:** O(N) for the call stack.

**Not in the file yet:** the parameterised version, which carries the running total as an extra argument instead of building it on the way back, and the formula N × (N + 1) / 2, which gives the answer in constant time.

**Remember:** "functional" recursion means the answer is built from what the smaller call returns. That pattern is the foundation of most recursive problems later in the sheet.

### Factorial of N
**File:** [Recursion.java](Recursion.java), method `recursion_factorial`

**Question.** Find N!, the product 1 × 2 × … × N.

**Approach — functional recursion.** The factorial of N is N times the factorial of N − 1. The method returns that product and stops at 1, because both 0! and 1! are 1.

- **Time:** O(N).
- **Extra space:** O(N) for the call stack.

**Not in the file yet:** an iterative loop that multiplies the numbers together without using the call stack.

**Remember:** an `int` can only hold factorials up to 12!, because 13! is already larger than the biggest `int`. Java gives no warning when this happens; the value silently wraps around to a wrong number. A `long` lasts until 20!, and anything larger needs `BigInteger`.

### Reverse an array using recursion
**File:** [Recursion.java](Recursion.java), method `reverseArray`

**Question.** Reverse an array in place without using a loop.

**Approach — swap the ends and recurse inwards.** The method receives the array and two positions, start and end. If start has met or passed end, there is nothing left to swap, so it stops. Otherwise it swaps the elements at start and end and calls itself with start moved one step right and end moved one step left, so each call handles the next pair in from the outside.

- **Time:** O(N) — each element is swapped once.
- **Extra space:** O(N) for the call stack, which holds about N / 2 frames.

**Remember:** the base case `start >= end` covers both even and odd lengths. With an odd length the two positions meet on the middle element, which never needs to move.

### Check if a string is a palindrome
**File:** [Recursion.java](Recursion.java), methods `isPalindrome` and `isPalidrome_recursive`

**Question.** Decide whether a string reads the same forwards and backwards.

**Iterative — clean the string, then compare from both ends.** The first version removes every character that is not a letter or a digit and turns the rest to lowercase, so "A man, a plan, a canal: Panama" becomes one plain run of letters. It then compares the first character with the last, the second with the second-to-last, and so on up to the middle, returning false at the first mismatch.

- **Time:** O(N), where N is the length of the string.
- **Extra space:** O(N) for the cleaned copy of the string.

**Recursive — compare one pair per call.** The second version takes a position i. If i has reached the middle, every pair has matched, so it returns true. Otherwise it compares the character at i with the character in the mirrored position from the end, returns false if they differ, and otherwise calls itself with i + 1.

- **Time:** O(N).
- **Extra space:** O(N) for the call stack, about N / 2 frames.

**Remember:** decide before starting whether case and punctuation count. "Madam" and "A man, a plan, a canal: Panama" are palindromes only when they are ignored; comparing the raw characters treats 'M' and 'm' as different and fails both.

## Basic hashing

### Number hashing with an array
**File:** [Hashing.java](Hashing.java), method `array_hashing`

**Question.** Given some numbers and a series of queries, report how many times each queried number appears.

**Approach — count once, then answer each query instantly.** Instead of scanning the whole input again for every query, the method makes one pass first, using each number as a position in a counting array and adding one to that slot. After that, every query is answered by reading a single slot. The input and the queries are read from the keyboard.

- **Time:** O(N + Q), where N is the number of input values and Q is the number of queries — one pass to count, then constant time per query.
- **Extra space:** O(M), where M is the size of the counting array.

**Remember:** the position in the array *is* the value, so the array must be larger than the biggest value that can appear, and it cannot handle negative values at all. A value outside the array's range throws an out-of-bounds error. For large or negative values, use a HashMap instead.

### Character hashing with an array
**File:** [Hashing.java](Hashing.java), method `array_character_hashing`

**Question.** Given a string and a series of characters, report how many times each character appears.

**Approach — use the character's code as the position.** Every character in Java has a numeric code, and a `char` can be used directly as an array index. The method makes one pass over the string, adding one to each character's slot in an array of 256 slots, and then answers each query by reading that character's slot.

- **Time:** O(L + Q), where L is the length of the string and Q is the number of queries.
- **Extra space:** O(1) — the array always has 256 slots, however long the string is.

**Remember:** 256 slots cover character codes 0 to 255 only, so a character outside that range, such as '€', would crash it. If the input can only contain lowercase letters, 26 slots indexed by `c - 'a'` are enough.

### Hashing with a HashMap
**File:** [Hashing.java](Hashing.java), method `hashing_using_map`

**Question.** Count how often each number appears when the numbers can be very large or negative.

**Approach — map each value to its count.** A HashMap stores each distinct value as a key, with its count as the value, so it only uses space for values that actually appear. For each number, the method reads the current count (treating a new number as zero), adds one, and writes the count back. It then prints every value with its count and answers each query by looking the number up, printing 0 when it is absent.

- **Time:** O(N + Q) on average — every insertion and lookup takes constant time on average.
- **Extra space:** O(K), where K is the number of distinct values.

**Remember:** a HashMap does not keep its entries in the order they were inserted, or in sorted order. For small numbers the printed entries often happen to look sorted, but that is a side effect of how the map is built inside, not something to rely on.

### Frequency of every element in an array
**File:** [Hashing.java](Hashing.java), method `Frequency`

**Question.** Print every distinct element of an array together with how many times it appears.

**Approach — count with a map, then print.** One pass over the array uses `getOrDefault` to read each element's current count, treating a missing element as zero, and stores that count plus one. A second loop walks over the map's entries and prints each value with its count.

- **Time:** O(N) on average.
- **Extra space:** O(K), where K is the number of distinct elements.

**Remember:** `map.getOrDefault(x, 0) + 1` replaces the check-then-read-then-write pattern with a single line. It is the standard counting idiom and worth knowing by heart.

### Highest-frequency element in an array
**File:** [Hashing.java](Hashing.java), method `highest_occuring_element_in_array`

**Question.** Find the element that appears most often in an array.

**Approach — count, then scan for the largest count.** The method counts every element into a map in the same way, then walks over the entries, keeping the key whose count is the largest seen so far, and prints that element with its frequency.

- **Time:** O(N) on average.
- **Extra space:** O(K), where K is the number of distinct elements.

**Not in the file yet:** the lowest-frequency element, which the sheet asks for alongside the highest.

**Remember:** when two elements tie, the one a HashMap scan reports depends on the map's internal order rather than on any rule. It can look as if the smallest element wins for small numbers and then stop being true for larger ones. If a problem asks for the smallest element on a tie, the scan has to compare the keys as well as the counts.
