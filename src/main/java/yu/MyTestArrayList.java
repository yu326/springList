package yu;

/**
 * Created by koreyoshi on 2017/7/31.
 */
public class MyTestArrayList<AnyType> {
    //implements Iterable<AnyType>

    //默认容器
    private static final int DEFAULT_CAPACITY = 10;

    private int theSize;
    private AnyType[] theItems;

    public MyTestArrayList() {
        clear();
    }

    public void clear() {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public void ensureCapacity(int newCapacity) {
        if (newCapacity < theSize) {
            return;
        }
        AnyType[] old = theItems;
        theItems = (AnyType[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            theItems[i] = old[i];
        }

    }

    public Boolean add(AnyType x) {
        add(size(), x);
        return true;
    }

    public void add(int idx, AnyType x) {
        if (idx > size()) {
            throw new IndexOutOfBoundsException("Index:" + idx + "  Size :" + size());
        }
        if (theItems.length == size())
            ensureCapacity(size() * 2);
        for (int i = theSize; i > idx; i--)
            theItems[i] = theItems[i - 1];
        theItems[idx] = x;
        theSize++;
    }

    public AnyType get(int idx) {
        if (idx < 0 || idx > size())
            throw new ArrayIndexOutOfBoundsException();
        return theItems[idx];
    }

    public AnyType set(int idx, AnyType x) {
        if (idx < 0 || idx > size())
            throw new ArrayIndexOutOfBoundsException();
        AnyType oldValue = theItems[idx];
        theItems[idx] = x;
        return oldValue;
    }

    public Boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return theSize;
    }

    public AnyType remove(int idx) {
        AnyType deleteItem = theItems[idx];
        for (int i = idx; i < size() - 1; i++) {
            theItems[i] = theItems[i + 1];
        }

        theItems[--theSize] = null;

        theSize--;
        return deleteItem;
    }

}
