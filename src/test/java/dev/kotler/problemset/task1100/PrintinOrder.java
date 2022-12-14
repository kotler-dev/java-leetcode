package dev.kotler.problemset.task1100;

/*

https://leetcode.com/problems/print-in-order/

1114. Print in Order

Suppose we have a class:

public class Foo {
  public void first() { print("first"); }
  public void second() { print("second"); }
  public void third() { print("third"); }
}
The same instance of Foo will be passed to three different threads. Thread A will call first(), thread B will call second(), and thread C will call third(). Design a mechanism and modify the program to ensure that second() is executed after first(), and third() is executed after second().

Note:

We do not know how the threads will be scheduled in the operating system, even though the numbers in the input seem to imply the ordering. The input format you see is mainly to ensure our tests' comprehensiveness.



Example 1:

Input: nums = [1,2,3]
Output: "firstsecondthird"
Explanation: There are three threads being fired asynchronously. The input [1,2,3] means thread A calls first(), thread B calls second(), and thread C calls third(). "firstsecondthird" is the correct output.
Example 2:

Input: nums = [1,3,2]
Output: "firstsecondthird"
Explanation: The input [1,3,2] means thread A calls first(), thread B calls third(), and thread C calls second(). "firstsecondthird" is the correct output.

*/

public class PrintinOrder {
//    private final Lock lock = new ReentrantLock();
//    private final Condition isSecond = lock.newCondition();
//    private final Condition isThird = lock.newCondition();

    private volatile int counter;

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        counter++;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (counter < 1) continue;
        printSecond.run();
        counter++;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (counter < 2) continue;
        printThird.run();
    }
}
