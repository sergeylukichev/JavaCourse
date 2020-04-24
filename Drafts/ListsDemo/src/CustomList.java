public interface CustomList<E> {

    int size();

    void append(E o);

    E get(int index);

    E removeById(int index);

    boolean remove(E e);


}
