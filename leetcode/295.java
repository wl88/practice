public class MedianFinder {
    private Queue<Integer> min;
    private Queue<Integer> max;
    private int minSize = 0;
    private int maxSize = 0;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        min = new PriorityQueue<Integer>(10, new Comparator<Integer>() {
                public int compare(Integer a, Integer b) {
                    return b-a;
                }
            });
        max = new PriorityQueue<Integer>(10, new Comparator<Integer>() {
                public int compare(Integer a, Integer b) {
                    return a-b;
                }
            });

        
    }
    
    public void addNum(int num) {
        //TODO: should have keep track of minValue and maxValue
        if (max.isEmpty() && min.isEmpty()) {
            min.add(num);
            minSize++;
            return;
        } else if (max.isEmpty()) {
            if (min.peek() < num) {
                max.add(num);
                maxSize++;
            } else {
                min.add(num);
                minSize++;
            }
        } else if (min.isEmpty()) {
            if (max.peek() > num) {
                min.add(num);
                minSize++;
            } else {
                max.add(num);
                maxSize++;
            }
        } else {
            if (max.peek() <= num) {
                max.add(num);
                maxSize++;
            }
            else {
                min.add(num);
                minSize++;
            }
        }
        
        //System.out.println("add: " + num);
        //System.out.println("min: " + min +" size: " + minSize);
        //System.out.println("max: " + max +" size: " + maxSize);
        
        while (minSize - maxSize > 1) {
            max.add(min.poll());
            minSize--;
            maxSize++;
        }
        
        while (maxSize - minSize > 1) {
            min.add(max.poll());
            maxSize--;
            minSize++;
        }
        //System.out.println("min: " + min +" size: " + minSize);
        //System.out.println("max: " + max +" size: " + maxSize);
    }
    
    public double findMedian() {
        if (minSize < maxSize) {
            //System.out.println("return max");
            return max.peek();
        }
        else if (minSize > maxSize) {
            //System.out.println("return min");
            return min.peek();
        }
        else return ((double)min.peek() + (double) max.peek())/2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */