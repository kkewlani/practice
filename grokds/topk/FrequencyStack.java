package topk;

import java.util.HashMap;
import java.util.PriorityQueue;

public class FrequencyStack {

    public static int orderSequence = 1 ;
    class Value {

        int number;

        int frequency;
        int sequence;

         public Value(int number, int frequency, int sequence) {
             this.number = number;
             this.frequency = frequency;
            this.sequence = sequence;
         }

    }
    HashMap<Integer, Integer> frequencyMap = new HashMap<>();
    PriorityQueue<Value> maxHeap = new PriorityQueue<>((v1, v2) -> {
        if (v1.frequency != v2.frequency) {
            return v2.frequency - v1.frequency;
        } else {
            return v2.sequence - v1.sequence;
        }
    });

    public void push(int num) {
        frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) +1);
        maxHeap.offer(new Value(num, frequencyMap.get(num), orderSequence++));
    }

    public int pop() {
        if(maxHeap.isEmpty()) {
            return -1;
        }

        int num = maxHeap.poll().number;

        if (frequencyMap.get(num) > 1) {
            frequencyMap.put(num, frequencyMap.get(num)-1);
        } else {
            frequencyMap.remove(num);
        }
        return num;
    }

    public static void main(String[] args) {
        FrequencyStack frequencyStack = new FrequencyStack();
        frequencyStack.push(1);
        frequencyStack.push(2);
        frequencyStack.push(3);
        frequencyStack.push(2);
        frequencyStack.push(1);
        frequencyStack.push(2);
        frequencyStack.push(5);
        System.out.println(frequencyStack.pop());
        System.out.println(frequencyStack.pop());
        System.out.println(frequencyStack.pop());
    }
}
