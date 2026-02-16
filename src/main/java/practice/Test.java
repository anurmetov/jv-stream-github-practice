package practice;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> input = List.of("5", "301", "323", "423","3");

        StreamPractice streamPractice = new StreamPractice();

        System.out.println(streamPractice.findMinEvenNumber(input));
    }
}
