# Step 4 — Binary search on answers

Full notes for every problem in this folder. Status and revisit dates are tracked in [PROGRESS.md](../../../PROGRESS.md).

Every problem here uses the same idea. The answer is a number inside a known range, and there is a check that says whether a candidate answer is good enough. Because that check flips from "no" to "yes" exactly once as the candidate grows, binary search can find the smallest candidate that passes without trying them all.

## Nth root of a number
**File:** [NthRoot.java](NthRoot.java), method `Nth_Root`

**Question.** Find the whole number whose Nth power equals a given number M, or return -1 if no such whole number exists.

**Optimal — binary search on the root.** The root, if it exists, lies between 1 and M. The method takes the middle of that range and raises it to the power N by repeated multiplication. If the result equals M, the middle is the root. If it is larger than M, the root must be smaller, so the search moves left; if it is smaller, the search moves right. If the range runs out, M is not a perfect Nth power.

- **Time:** O(N × log M) — about log M guesses, each needing up to N multiplications.
- **Extra space:** O(1).

**Not in the file yet:** the brute force, which tries every whole number from 1 upwards until its Nth power reaches M, in O(N × M) time in the worst case.

**Remember:** raising the middle to the power N overflows very quickly, so multiply in a `long` and stop as soon as the product passes M; the exact value no longer matters once it is too big. Also make sure the search range covers every possible answer before starting.

## Koko eating bananas
**File:** [KokoEatingBanana.java](KokoEatingBanana.java), methods `minEatingSpeed_brute`, `calculateTotalHours` and `minEatingSpeed_optimal`

**Question.** Koko has several piles of bananas and H hours. Each hour she picks one pile and eats up to K bananas from it. Find the smallest speed K that lets her finish every pile within H hours.

**Brute — try every speed from 1 upwards.** For each speed, the helper `calculateTotalHours` works out how many hours all the piles would take, and the first speed that fits within H is the answer. A speed equal to the largest pile always works, because then every pile takes exactly one hour.

- **Time:** O(N × P), where N is the number of piles and P is the size of the largest pile.
- **Extra space:** O(1).

**Optimal — binary search on the speed.** A faster speed never takes more hours, so the check "does this speed finish in time?" flips from no to yes exactly once. The method binary searches the speeds from 1 to the largest pile: when a speed finishes in time, it is recorded and the search tries slower speeds; when it does not, the search tries faster ones.

- **Time:** O(N × log P) — about log P guesses, each adding up the hours for every pile.
- **Extra space:** O(1).

**Remember:** each pile takes the ceiling of pile ÷ speed hours, because Koko cannot start another pile within the same hour. Compute that ceiling with whole numbers as `(pile + speed - 1) / speed` rather than with floating point. Keep the total in a `long`, because at speed 1 the total is the sum of every pile, which can overflow an `int`.

## Smallest divisor given a threshold
**File:** [SmallerDivisor.java](SmallerDivisor.java), method `smallestDivisor`

**Question.** Choose a positive divisor, divide every number in the array by it rounding up, and add the results. Find the smallest divisor that keeps this total within a given threshold.

**Optimal — binary search on the divisor.** A larger divisor never makes the total bigger, so the check "is the total within the threshold?" flips once. The method binary searches divisors from 1 up to the largest element; dividing by the largest element turns every term into 1, which is the smallest total possible. For each candidate it adds up the rounded-up quotients, stopping early once the total passes the threshold, because the exact amount no longer matters. A divisor that passes is recorded and the search tries smaller ones; one that fails sends the search towards larger ones.

- **Time:** O(N × log X), where X is the largest element.
- **Extra space:** O(1).

**Not in the file yet:** the brute force, which tries every divisor from 1 upwards in O(N × X) time.

**Remember:** this is the same template as Koko eating bananas wearing a different costume: find a check that flips from "no" to "yes" exactly once, then binary search for the first value where it says yes.

## Minimum days to make M bouquets
**File:** [MinDaysToMakeBouquets.java](MinDaysToMakeBouquets.java), method `minDays`

**Question.** Each flower blooms on a given day. A bouquet needs K flowers that are next to each other and have all bloomed. Find the earliest day on which M bouquets can be made, or -1 if it can never happen.

**Optimal — binary search on the day.** If M × K is more than the number of flowers, the answer is -1 straight away. Otherwise, waiting longer can only make more flowers bloom, so the check "can M bouquets be made by this day?" flips once, and the method binary searches days between the earliest and the latest bloom day. To check a day, it walks the flowers counting a run of consecutive bloomed ones; when an unbloomed flower breaks the run, the run contributes its length divided by K bouquets and the count restarts. A day that produces enough bouquets sends the search earlier; one that does not sends it later.

- **Time:** O(N × log D), where D is the gap between the earliest and latest bloom days.
- **Extra space:** O(1).

**Not in the file yet:** the brute force, which checks every day from the earliest to the latest bloom day in O(N × D) time.

**Remember:** only adjacent flowers count, so the run must restart at every flower that has not bloomed, and the last run must still be counted after the loop ends. Work out M × K as a `long`, because the product can overflow an `int` even when both numbers fit.
