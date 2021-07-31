package Misc;

import java.util.LinkedList;
import java.util.List;

/**
 * @author jakadam on 2020-07-09
 * https://www.youtube.com/watch?v=EtJALCEIxDs
 */
public class ProducerConsumerDemo {
    public static void main(String[] args) {
        BlockingQueue bque= new BlockingQueue(10);
        Thread t1= new Thread(new Producer(bque));
        Thread t2= new Thread(new Consumer(bque));
        t1.start();
        t2.start();
    }
}

class Producer implements Runnable{
    BlockingQueue bque;
    int i=1;
    public Producer(BlockingQueue bque) {
        this.bque=bque;
    }

    @Override
    public void run() {
        while(true){
            try {
                //Thread.sleep(50);
                System.out.println("Producer trying adding "+ i);
                bque.enqueue(i++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable{
    BlockingQueue bque;
    public Consumer(BlockingQueue bque) {
        this.bque=bque;
    }

    @Override
    public void run() {
        while(true){
            try {
                //Thread.sleep(500);
                System.out.println("Consumer consumed "+ bque.dequeue());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class BlockingQueue {

    private List queue = new LinkedList();
    private int  limit = 10;

    public BlockingQueue(int limit){
        this.limit = limit;
    }


    public synchronized void enqueue(int item) throws InterruptedException {
        while(this.queue.size() == this.limit) {
            System.out.println("Queue full. Producer put on wait.");
            wait();
        }
        this.queue.add(item);
        if(this.queue.size()< limit) {
            notifyAll();
        }
    }


    public synchronized Object dequeue()
            throws InterruptedException{
        while(this.queue.size() == 0){
            System.out.println("Queue Empty. Consumer put on wait.");
            wait();
        }
        if(this.queue.size() == this.limit){
            notifyAll();
        }

        return this.queue.remove(0);
    }

}
