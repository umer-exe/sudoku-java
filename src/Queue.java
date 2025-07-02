public class Queue {

    int index;
    private Queue head;
    private Queue tail;
    private Queue next;
    public int size;

    Queue(int index) {
        this.index = index;
    }

    public void enqueue(int index) {

        Queue temp = new Queue(index);

        if (head == null) {
            head = temp;
            tail = temp;
            head.next = tail;
            size++;
            return;
        }

        tail.next = temp;
        tail = temp;
        size++;
    }

    public int dequeue() {
        int popped = head.index;
        head = head.next;
        size--;
        return popped;
    }

    public void print() {

        Queue temp = head;

        while (temp != null) {
            System.out.print(temp.index + ", ");
            temp = temp.next;
            System.out.println(temp.index);
            temp = temp.next;
        }
    }
}
