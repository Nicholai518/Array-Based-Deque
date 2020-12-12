package sample;

public class Deque
{
    // Inner Node Class or maybe use already created doubly linked list as a field
//    private class Node
//    {
//        // Might be considered Fields, maybe just variables. Not sure
//        String value;       // Holds String Value
//        Node next;          // Holds successor node
//        Node previous;      // Holds Predecessor Node
//
//        // Constructor
//        public Node(String value, Node next, Node previous)
//        {
//            this.value = value;
//            this.next = next;
//            this.previous = previous;
//        }
//    }

    // Trying to add more inner classes to handle queue exceptions
    class QueueOverFlowException extends RuntimeException
    {

    }

    class EmptyQueueException extends RuntimeException
    {

    }

    // Fields for Deque class
    private int front = 0;
    private int rear = 1;
    private int count = 0;
    private String[] q;

//    private Node front;
//    private Node rear;
//    private String[] namesForDeque;

    // Constructor

    public Deque()
    {

    }

    public Deque(int capacity)
    {
        q = new String[capacity];

    }




    // Methods

    // addFront
    public void addFront(String e)
    {

        if(count == q.length)
        {
            throw new RuntimeException("The deque is full! Must remove an element first, before you can add more");
        }

        // add to front if there is room
        q[front] = e;

        // Decrement front
        front --;

        // need to circularly link array
        if (front == -1)
        {
            // Need to move front to the end of the first
            front = q.length -1;

            // Need to keep track of how many elements we have because arrays can only hold the capacity amount
            count++;
        }
        else
        {
            count++;
        }

    }

    public String removeFront()
    {

        if(count == 0)
        {
            throw new RuntimeException("Array is empty, there is no front Element!");
        }

        // Get the next element "in line"
        front++;

        // If at the end of the array, circle back to the front
        if (front == q.length)
        {
            front = 0;
        }

        String e = q[front];    // Store the value currently at front
        q[front] = null;        // set front to Null
        count --;               // Removed one element so lower the count

        // return the element that WAS at the front
        return e;
    }
    // addRear
    public void addRear(String e)
    {

        // Check to see if there is space to add element
        if(count == q.length)
        {
            throw new RuntimeException("The deque is full! Must remove an element first, before you can add more");
        }

        // add to rear if there is room
        q[rear] = e;

        // increment rear
        rear ++;

        // need to circularly link array
        if (rear == q.length)
        {
            // Need to move front to the end of the first
            rear = 0;

            // Need to keep track of how many elements we have because arrays can only hold the capacity amount
            count ++;
        }
        else
        {
            count++;
        }

    }

    public String removeRear()
    {

        if(count == 0)
        {
            throw new RuntimeException("Array is empty, there is no front Element!");
        }

        // Get element BEFORE rear, so the LAST element that was added because Rear normally open / null
        rear--;

        // If at the end of the array, circle back to the front
        if (rear < 0)
        {
            rear = q.length -1;
        }

        String e = q[rear];    // Store the value currently at rear
        q[rear] = null;        // set rear to Null now that we have stored element
        count --;               // Removed one element so lower the count

        // return the element that WAS at the rear
        return e;
    }

    // Capacity setter
    public void setCapacity(int desiredCapacity)
    {
        q = new String[desiredCapacity];
    }


    /**
     *  Returns boolean value based on if Deque is empty
     * @return true or false depending on if Deque is empty
     */
    public boolean empty()
    {
        return q.length == 0;
    }

    @Override
    public String toString()
    {
        // Variables
        String data ="";

        // if empty
        if(count == 0)
        {
            return " ";
        }

        // Not empty
        else
        {

            for (String str: q)
            {
                data += str + " ";
            }
//
//            while(count < q.length)
//            {
//                data = front + " ";
//                front++;
//                count++;
//            }
        }

        return data;
    }

}
