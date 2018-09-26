/*
https://www.interviewbit.com/problems/add-one-to-number/

Given a non-negative number represented as an array of digits,
add 1 to the number ( increment the number represented by the digits ).
The digits are stored such that the most significant digit is at the head of the list.

Example:
If the vector has [1, 2, 3] the returned vector should be [1, 2, 4] as 123 + 1 = 124.

NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer.
      For example, for this problem, following are some good questions to ask :
Q : Can the input have 0’s before the most significant digit. Or in other words, is 0 1 2 3 a valid input?
A : For the purpose of this question, YES
Q : Can the output have 0’s before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.
*/

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
        int start = 0;
        while (start < a.size() && a.get(start) == 0) {
            start++;
        }

        int end = a.size() - 1;
        int sum;
        int carry = 1;

        for (int i = end; i >= start; i--) {
            sum = a.get(i) + carry;
            carry = sum / 10;
            a.set(i, sum % 10);
            if (carry == 0) {
                break;
            }
        }

        if (carry == 1) {
            if (start > 0) {
                start = start - 1;
                a.set(start, 1);
            } else {
                a.add(0, 1);
            }
        }

        return new ArrayList<>(a.subList(start, a.size()));
    }
}
