package hello.advanced.trace.template;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class TestExam {


    @Test
    void test() {
        final PriorityQueue<BigDecimal> maxReactionTime = new PriorityQueue<>(Collections.reverseOrder()); // 반응 시간 중앙값 계산을 위한 queue
        final PriorityQueue<BigDecimal> minReactionTime = new PriorityQueue<>();

        List<Integer> lst = List.of(4, 9, 7, 1, 7, 10);


        for (Integer i : lst) {
            addReactionTimeForMedian(maxReactionTime, minReactionTime, BigDecimal.valueOf(i));
        }
        System.out.println("maxReactionTime = " + maxReactionTime.peek());
        System.out.println("minReactionTime = " + minReactionTime.peek());
    }

    private void addReactionTimeForMedian(final PriorityQueue<BigDecimal> maxReactionTime, final PriorityQueue<BigDecimal> minReactionTime, final BigDecimal reactionTime) {
        if (maxReactionTime.isEmpty() || reactionTime.compareTo(maxReactionTime.peek()) <= 0) {
            maxReactionTime.add(reactionTime);
        } else {
            minReactionTime.add(reactionTime);
        }
        balanceReactionTimeForMedian(maxReactionTime, minReactionTime);
    }

    private void balanceReactionTimeForMedian(final PriorityQueue<BigDecimal> maxReactionTime, final PriorityQueue<BigDecimal> minReactionTime) {
        if (maxReactionTime.size() > minReactionTime.size() + 1) {
            minReactionTime.add(maxReactionTime.poll());
            return;
        }
        if (minReactionTime.size() > maxReactionTime.size()) {
            maxReactionTime.add(minReactionTime.poll());
        }
    }
}
