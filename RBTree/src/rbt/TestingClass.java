package rbt;

import java.io.*;

public class TestingClass {
    private long nano_startTime;
    private long nano_endTime;

    public void testingSetAndGet(int k) throws FileNotFoundException {
        RBTree tree = new RBTree();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("setTest.txt"));
            for (int i = 1; i < k; i++) {
                nano_startTime = System.nanoTime();
                tree.setValue(i, "Element");
                nano_endTime = System.nanoTime();
                writer.write(Long.toString(nano_endTime - nano_startTime));
                writer.newLine();
                writer.flush();
            }
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("getTest.txt"));
            for (int i = k - 1; i > 0; i--) {
                nano_startTime = System.nanoTime();
                tree.getValue(i);
                nano_endTime = System.nanoTime();
                writer.write(Long.toString(nano_endTime - nano_startTime));
                writer.newLine();
                writer.flush();
            }
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void testingMapAndArray(int k, String name) {
        RBTree tree = new RBTree();
        Integer[] arr = new Integer[k];
        int x = k;
        for (; k > 0; k--) {
            tree.setValue(k, "Element");
            arr[x - k] = k;
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(name));
            nano_startTime = System.nanoTime();
            tree.getValue(1);
            nano_endTime = System.nanoTime();
            writer.write(Long.toString(nano_endTime - nano_startTime));
            writer.newLine();
            nano_startTime = System.nanoTime();
            for (int i = 0; i < arr.length; i++) {
                if (a[i] == 1) {
                    break;
                }
            }
            nano_endTime = System.nanoTime();
            writer.write(Long.toString(nano_endTime - nano_startTime));
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
