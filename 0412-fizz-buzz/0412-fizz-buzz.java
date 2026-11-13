
import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<String> fizzBuzz(int n) {

//here we have created the empty array list:--->
        List<String> answer = new ArrayList<>();

        for (int i = 1; i <= n; i++) {

            if (i % 3 == 0 && i % 5 == 0) {
                answer.add("FizzBuzz");
            }
            else if (i % 3 == 0) {
                answer.add("Fizz");
            }
            else if (i % 5 == 0) {
                answer.add("Buzz");
            }
            else {
                answer.add(String.valueOf(i));
            }
        }

        return answer;
    }
}
