import java.util.*;

public class JavaAssignment {

    public static void main(String[] args) {
        int[] testSizes = {1000, 10000, 100000, 1000000};

        for (int count : testSizes) {
            System.out.println("Testing size: " + count);

            int[] arrayData = new int[count];
            evaluateArray(arrayData, count);

            HashSet<Integer> hashSetData = new HashSet<>();
            evaluateHashSet(hashSetData, count);

            ArrayList<Integer> arrayListData = new ArrayList<>();
            evaluateArrayList(arrayListData, count);

            LinkedList<Integer> linkedListData = new LinkedList<>();
            evaluateLinkedList(linkedListData, count);
        }
    }

    public static void evaluateArray(int[] dataArray, int count) {
        long start, stop;

        for (int i = 0; i < count; i++) {
            dataArray[i] = i;
        }

        start = System.nanoTime();
        int middleValue = dataArray[count / 2];
        stop = System.nanoTime();
        System.out.println("Time to access middle element: " + (stop - start) + " ns");

        start = System.nanoTime();
        for (int i = 0; i < count; i++) {
            if (dataArray[i] == count / 2) break;
        }
        stop = System.nanoTime();
        System.out.println("Time to search by value: " + (stop - start) + " ns");

        start = System.nanoTime();
        for (int i = count - 1; i > 0; i--) {
            dataArray[i] = dataArray[i - 1];
        }
        dataArray[0] = -1;
        stop = System.nanoTime();
        System.out.println("Time to insert at the start: " + (stop - start) + " ns");

        start = System.nanoTime();
        for (int i = count - 1; i > count / 2; i--) {
            dataArray[i] = dataArray[i - 1];
        }
        dataArray[count / 2] = -1;
        stop = System.nanoTime();
        System.out.println("Time to insert in the middle: " + (stop - start) + " ns");

        start = System.nanoTime();
        dataArray[count - 1] = -1;
        stop = System.nanoTime();
        System.out.println("Time to insert at the end: " + (stop - start) + " ns");

        start = System.nanoTime();
        for (int i = 0; i < count - 1; i++) {
            dataArray[i] = dataArray[i + 1];
        }
        stop = System.nanoTime();
        System.out.println("Time to delete from the start: " + (stop - start) + " ns");

        start = System.nanoTime();
        for (int i = count / 2; i < count - 1; i++) {
            dataArray[i] = dataArray[i + 1];
        }
        stop = System.nanoTime();
        System.out.println("Time to delete from the middle: " + (stop - start) + " ns");

        start = System.nanoTime();
        dataArray[count - 1] = 0;
        stop = System.nanoTime();
        System.out.println("Time to delete from the end: " + (stop - start) + " ns");
    }

    public static void evaluateHashSet(HashSet<Integer> hashSetData, int count) {
        long start, stop;

        start = System.nanoTime();
        for (int i = 0; i < count; i++) {
            hashSetData.add(i);
        }
        stop = System.nanoTime();
        System.out.println("Time to insert in HashSet: " + (stop - start) + " ns");

        start = System.nanoTime();
        boolean found = hashSetData.contains(count / 2);
        stop = System.nanoTime();
        System.out.println("Time to search in HashSet: " + (stop - start) + " ns");

        start = System.nanoTime();
        hashSetData.remove(count / 2);
        stop = System.nanoTime();
        System.out.println("Time to remove from HashSet: " + (stop - start) + " ns");
    }

    public static void evaluateArrayList(ArrayList<Integer> arrayListData, int count) {
        long start, stop;

        start = System.nanoTime();
        for (int i = 0; i < count; i++) {
            arrayListData.add(i);
        }
        stop = System.nanoTime();
        System.out.println("Time to insert at the end of ArrayList: " + (stop - start) + " ns");

        start = System.nanoTime();
        int middleValue = arrayListData.get(count / 2);
        stop = System.nanoTime();
        System.out.println("Time to access middle element in ArrayList: " + (stop - start) + " ns");

        start = System.nanoTime();
        arrayListData.add(count / 2, -1);
        stop = System.nanoTime();
        System.out.println("Time to insert in the middle of ArrayList: " + (stop - start) + " ns");

        start = System.nanoTime();
        arrayListData.remove(0);
        stop = System.nanoTime();
        System.out.println("Time to remove from the start of ArrayList: " + (stop - start) + " ns");

        start = System.nanoTime();
        arrayListData.remove(count / 2);
        stop = System.nanoTime();
        System.out.println("Time to remove from the middle of ArrayList: " + (stop - start) + " ns");

        start = System.nanoTime();
        arrayListData.remove(arrayListData.size() - 1);
        stop = System.nanoTime();
        System.out.println("Time to remove from the end of ArrayList: " + (stop - start) + " ns");
    }

    public static void evaluateLinkedList(LinkedList<Integer> linkedListData, int count) {
        long start, stop;

        start = System.nanoTime();
        for (int i = 0; i < count; i++) {
            linkedListData.add(i);
        }
        stop = System.nanoTime();
        System.out.println("Time to insert at the end of LinkedList: " + (stop - start) + " ns");

        start = System.nanoTime();
        int middleValue = linkedListData.get(count / 2);
        stop = System.nanoTime();
        System.out.println("Time to access middle element in LinkedList: " + (stop - start) + " ns");

        start = System.nanoTime();
        linkedListData.addFirst(-1);
        stop = System.nanoTime();
        System.out.println("Time to insert at the start of LinkedList: " + (stop - start) + " ns");

        start = System.nanoTime();
        linkedListData.add(count / 2, -1);
        stop = System.nanoTime();
        System.out.println("Time to insert in the middle of LinkedList: " + (stop - start) + " ns");

        start = System.nanoTime();
        linkedListData.removeFirst();
        stop = System.nanoTime();
        System.out.println("Time to remove from the start of LinkedList: " + (stop - start) + " ns");

        start = System.nanoTime();
        linkedListData.remove(count / 2);
        stop = System.nanoTime();
        System.out.println("Time to remove from the middle of LinkedList: " + (stop - start) + " ns");

        start = System.nanoTime();
        linkedListData.removeLast();
        stop = System.nanoTime();
        System.out.println("Time to remove from the end of LinkedList: " + (stop - start) + " ns");
    }
}
