package LinkedListImplementation;

public class LinkedList {

    public static class Node {
        Node next;
        int val;
        public Node(int val)
        {
            this.val = val;
        }
        public Node(Node next,int val)
        {
            this.next = next;
            this.val = val;
        }
    }
    static Node head;
    static int length;

    public static void main(String[] args) {
        insert_node(1,1);
        insert_node(2,2);
        insert_node(3,3);
        insert_node(4,4);
        insert_node(3,13);
        insert_node(2,25);
        print_ll();
        delete_node(2);
        print_ll();

    }
    public static void insert_node(int position, int value) {
        // @params position, integer
        // @params value, integer
        Node node = new Node(value);
        if(position>length+1) return;
        if(position==1)
        {
            node.next = head;
            head = node;
        }
        else {
            int pos=1;
            Node temp = head;
            while (pos<position-1)
            {
                temp = temp.next;
                pos++;
            }
            node.next = temp.next;
            temp.next = node;
        }
        length++;


    }

    public static void delete_node(int position) {
        // @params position, integer
        if(position>length) return;
        if(position==1)
        {
            head = head.next;
        }
        else
        {
            int pos=1;
           Node current = head.next;
           Node previous = head;

           while(current!=null)
           {
               pos++;
               if(position==pos)
               {
                   previous.next = current.next;
               }
               current = current.next;
               previous = previous.next;
           }
        }

        length--;
    }

    public static void print_ll() {
        // Output each element followed by a space
        Node temp = head;
        while(temp!=null)
        {
            System.out.print(temp.val+" --> ");
            temp = temp.next;
        }
        System.out.println();
        System.out.println("Length is : " + length);
    }

}
