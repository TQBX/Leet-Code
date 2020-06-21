package queue_stack;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Summerday
 */
public class Solution2 {

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());

        System.out.println("30".compareTo("3"));
    }

}

class MedianFinder {
    private Queue<Integer> A,B;
    /** initialize your data structure here. */
    public MedianFinder() {
        A = new PriorityQueue<>();
        B = new PriorityQueue<>((o1, o2) -> o2-o1);
    }

    public void addNum(int num) {
        if(A.size()!=B.size()){
            A.add(num);
            B.add(A.poll());
        }else {
            B.add(num);
            A.add(B.poll());
        }
    }

    public double findMedian() {
        return A.size()!=B.size()?A.peek():(A.peek()+B.peek())/2.0;
    }
}
