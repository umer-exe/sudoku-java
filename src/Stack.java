public class Stack {

    private int index;
    private Stack head;
    private Stack next;

    Stack(int index) {
        this.index = index;
    }

    public void push(int index) {

        Stack temp = new Stack(index);

        if (head == null) {
            head = temp;
            return;
        }

        temp.next = head;
        head = temp;
    }

    public int pop() {
        int popped = peek();
        head = head.next;
        return popped;
    }

    public int peek() {
        if (head == null) {
            return -2;
        }
        return head.index;
    }
}
