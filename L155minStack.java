package leetCode;

import java.util.*;

/**
 * @author zzq
 * @create 2021-08-26-10:54
 */
public class L155minStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        for (int i = 1; i < 100; i++) {
            minStack.push(i);
        }
        System.out.println(minStack);
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println("min: " + minStack.getMin());


        /*int[] arr = new int[]{1, 2, 3, 4, 5};
        arr = Arrays.copyOf(arr,10);
        System.out.println(Arrays.toString(arr));*/


/*        leetCode.MinStack minStack = new leetCode.MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();
        minStack.pop();
        minStack.top();
        minStack.getMin();*/
    }
}

class MinStack {
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public MinStack() {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    @Override
    public String toString() {
        return "leetCode.MinStack{" +
                "xStack=" + xStack +
                "\n, minStack=" + minStack +
                '}';
    }
}


class MinStack2 {
    private int[] elements;
    private int min;
    private int minSize = 10;
    private int count;

    public MinStack2() {
        elements = new int[minSize];
        min = Integer.MAX_VALUE;
        count = 0;
    }

    public void push(int val) {
        ensuerCapacity();
        min = Math.min(min, val);
        elements[count++] = val;
    }

    public void pop() {
        int tmp = elements[count - 1];
        elements[--count] = 0;
        if (tmp == min) {
            min = Integer.MAX_VALUE;
            for (int i = 0; i < count; i++) {
                if (elements[i] < min) {
                    min = elements[i];
                }
            }
        }
    }

    public int top() {
        int top = elements[count - 1];
        return top;
    }

    public int getMin() {
        return min;
    }

    private void ensuerCapacity() {
        if (count >= elements.length - 1) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }
}

