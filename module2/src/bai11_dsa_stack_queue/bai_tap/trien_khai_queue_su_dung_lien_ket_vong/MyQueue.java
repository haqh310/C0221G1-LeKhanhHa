package bai11_dsa_stack_queue.bai_tap.trien_khai_queue_su_dung_lien_ket_vong;

public class MyQueue {
    private Node front;
    private Node rear;
    public MyQueue(){
        this.front=null;
        this.rear =null;
    }
    public void enQueue(int data){
        Node temp = new Node(data);
        if (this.front ==  null)
            this.front = temp;
        else
            this.rear.link = temp;

        this.rear = temp;
        this.rear.link = this.front;
    }
    public Node deQueue(){
        if (this.front ==  null)
        {
            return null;
        }
        Node value;
        if (this.front == this.rear)
        {
            value = this.front.link;
            this.front =  null;
            this.rear =  null;
        }
        else
        {
            Node  temp = this.front;
            value = temp.link;
            this.front = this.front .link;
            this.rear.link= this.front;
        }

        return value ;
    }
    public void displayQueue(){
        Node  temp = this.front;
        System.out.printf("Elements in Circular Queue are: ");
        while (temp .link != this.front)
        {
            System.out.printf("%d ", temp.data);
            temp = temp .link;
        }
        System.out.printf("%d", temp .data);
    }
    public class Node{
        private int data;
        private Node link;
        public Node(int data){
            this.data = data;
            this.link = null;
        }
    }
}
