public class CustomLinkedList<E> implements CustomList<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    @Override
    public int size() {
        return size;
    }

    //{}, first = null, last = null
    //{e1, prev = null, next = null}, first = e1, last = e1
    //{e1, prev = null, next = e2 -> e2, prev = e1, next = null}, first = e1, last = e1
    //{e1, prev = null, next = e2 -> e2, prev = e1, next = e3 -> e3, prev = e2, next = null}, first = e1, last = e1
    //e2.prev(e1).next(e2) = e2.next(e3)  ===> e1.next = e3
    //e2.next(e3).prev(e2) = e2.prev(e1) ===> e3.prev = e1

    @Override
    public void append(E o) {

        if(size > 0) {
            Node newNode = new Node (null, last, o);
            last.next = newNode;
            last = newNode;
        } else {
            Node newNode = new Node(null, null, o);
            first = newNode;
            last = newNode;
        }

        size ++;
    }

    @Override
    public E get(int index) {
        if(index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node ret = getNode(index);
        return (E)ret.value;
    }

    private Node getNode(int index) {
        Node ret = first;
        for(int i =0; i<index; i++) {
            ret = ret.next;
        }
        return ret;
    }

    @Override
    public E removeById(int index) {
        if(index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Node ret = getNode(index);

        ret.prev.next = ret.next;
        ret.next.prev = ret.prev;
        size--;

        return (E)ret.value;
    }

    @Override
    public boolean remove(E o) {
        return false;
    }

    private static class Node<E> {
        E value;
        Node next;
        Node prev;

        public Node(Node next, Node prev, E value) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}


//User <- UserAdmin, Student, Teacher.