public class CustomArrayList<E> implements CustomList<E>{

    private Object[] source;
    private int size = 0;

    private static final int DEFAULT_CAPACITY = 16;

    public CustomArrayList() {
        source = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void append(E o) {
        if(size == source.length) {
            Object[] newSource = new Object[size*2]; // source: {1, 2, 3}
            System.arraycopy(source, 0, newSource, 0, source.length); // newSource = {0, 0, 0, 0, 0, 0}
            source = newSource; // newSource = {1, 2, 3, 0, 0, 0}
        }
        source[size] = o;
        size++;
    }

    @Override
    public E get(int index) {

        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        return (E)source[index];

    }

    @Override
    public E removeById(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Object o = source[index];

        System.arraycopy(source, index + 1, source, index, size - index);

//        Object [] newSource = new Object[source.length];
//        for(int i = 0; i< newSource.length; i++) {
//            System.out.println(source[i]);
//            if(i < index) {
//                newSource[i] = source[i];
//            }
//            if(i >= index) {
//                newSource[i] =source[i+1];
//            }
//        }

        size --;

        return (E) o;
    }

    @Override
    public boolean remove(E e) {

        return false;
    }
}
