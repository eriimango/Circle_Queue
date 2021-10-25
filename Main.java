// This program implements a circular queue using an array
// author: ericka howard

class Circle_Queue {
    int SIZE = 8;
    int front; // = -1;
    int rear; //= -1;
    int elements[] = new int[SIZE];

    Circle_Queue() {
        front = -1;
        rear = -1;
    }

    boolean isFull() {
        if (front == 0 && rear == SIZE - 1) {
            return true;
        }
        if (front == rear + 1) {
            return true;
        }
        return false;
    }

    boolean isEmpty() {
        if (front == -1)
            return true;
        else
            return false;
    }

    void delete(int k) {
        for (int i = front + k; i < rear - 1; i++) {
            elements[i] = elements[i + 1];
        }
        rear = rear - 1;
        elements[rear] = Integer.parseInt(null);
    }

    void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full!");
        } else {
            if (front == -1)
                front = 0;
            rear = (rear + 1) % SIZE;
            elements[rear] = value;
            System.out.println("Inserted " + value);
        }
    }


    int dequeue() {
        int value;
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return (-1);
        } else {
            value = elements[front];
            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % SIZE;
            }
            return (value);
        }
    }

    void print() {
    int i = 0;
      if(isEmpty())

    {
        System.out.println("Empty Queue");
    } else

    {
        System.out.println("Front ->" + front);
        System.out.println("Elements ->");
        for (i = front; i != rear; i = (i + 1) % SIZE)
            System.out.print(elements[i] + " ");
        System.out.println(elements[i]);
        System.out.println("Rear ->" + rear);
    }
    }

    public static void main(String[] args) {
        Circle_Queue q = new Circle_Queue();

        q.dequeue();

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        q.enqueue(7);
        q.enqueue(8);

        q.enqueue(9);

        q.print();

        int item = q.dequeue();

        if (item != -1) {
            System.out.println("Deleted Element is " + item);
        }
        q.print();
        q.enqueue(10);
        q.print();
        q.enqueue(11);
    }
}