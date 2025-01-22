package example.ex01;

import static java.util.stream.Collectors.joining;

import java.util.Arrays;
import java.util.List;

public class WhyJava8 {
    private static final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    /* 출력 예시: 1 : 2 : 3 : 4 : 5 : 6 : 7 : 8 : 9 : 10 */

    public static void main(String[] args) {
        simpleTask();
    }

    private static void simpleTask() {
        /* for loop 사용 */
        final StringBuilder stringBuilder1 = new StringBuilder();
        final int size = numbers.size();
        for (int i = 0; i < size; i++) {
            stringBuilder1.append(numbers.get(i));
            if (i != size - 1) {
                stringBuilder1.append(" : ");
            }
        }

        /* for-each 사용 */
        final StringBuilder stringBuilder = new StringBuilder();
        final String separator = " : ";
        for (final Integer number : numbers) {
            stringBuilder.append(number).append(separator);
        }
        final int stringLength = stringBuilder.length();
        if (stringLength > 0) {
            stringBuilder.delete(stringLength - separator.length(), stringLength);
        }
        System.out.println(stringBuilder.toString());

        /* Java 8 버전 */
        final String result = numbers.stream()
                .map(String::valueOf)
                .collect(joining(" : "));
        System.out.println(result);
    }


}
