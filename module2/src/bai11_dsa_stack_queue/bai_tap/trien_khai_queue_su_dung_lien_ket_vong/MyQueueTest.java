package bai11_dsa_stack_queue.bai_tap.trien_khai_queue_su_dung_lien_ket_vong;

public class MyQueueTest {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.enQueue(6);
        myQueue.enQueue(7);
        myQueue.enQueue(8);
        myQueue.enQueue(9);
        myQueue.deQueue();
        myQueue.deQueue();
        myQueue.displayQueue();
    }
}
