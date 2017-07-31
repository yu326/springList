package yu;

/**
 * Created by koreyoshi on 2017/7/31.
 */
public class MyArrayList<AnyType> implements Iterable<AnyType> {

    //默认容量
    private static final int DEFAULT_CAPACITY=10;

    private int theSize;
    private AnyType[] theItems;

    public MyArrayList(){
        clear();
    }

    public void clear(){
        theSize=0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public int size(){
        return theSize;
    }

    public boolean isEmpty(){
        return size()==0;
    }

    public void trimToSize(){
        ensureCapacity(size());
    }

    public AnyType get(int idx){
        if(idx<0 || idx>=size())
            throw new ArrayIndexOutOfBoundsException();
        return theItems[idx];
    }

    public AnyType set(int idx,AnyType newVal){
        if(idx<0 || idx>=size())
            throw new ArrayIndexOutOfBoundsException();
        AnyType old=theItems[idx];
        theItems[idx]=newVal;
        return old;
    }

    public void ensureCapacity(int newCapacity){
        if(newCapacity<theSize)
            return;
        //旧数组复制到新数组
        AnyType[] old=theItems;
        theItems=(AnyType[])new Object[newCapacity];
        for(int i=0;i<size();i++)
            theItems[i]=old[i];
    }

    public boolean add(AnyType x){
        add(size(),x);
        return true;
    }

    //真正赋予size()和theItems.length意义的
    public void add(int idx,AnyType x){
        //实际大小达到默认数组长度，先扩容
        if(theItems.length==size())
            ensureCapacity(size()*2+1);
        //不用考虑细微情况，逻辑合理就没错
        //加一个元素，最后一个元素下标变成theSize,扩了容，实际大小+1,不越界
        for(int i=theSize;i>idx;i--)
            theItems[i]=theItems[i-1];
        theItems[idx]=x;

        theSize++;//真正大小+1
    }

    public AnyType remove(int idx){
        AnyType removedItem=theItems[idx];
        for(int i=idx;i<size()-1;i++)
            theItems[i]=theItems[i+1];
        //写成了++,造成后面测试错误！太蠢了！！！
        theSize--;
        return removedItem;
    }

    public java.util.Iterator<AnyType> iterator(){
        return new ArrayListIterator();//直接返回这个内部类的实例
    }

    //内部类实现迭代器
    private class ArrayListIterator implements java.util.Iterator<AnyType>{
        private int current=0;
        public boolean hasNext(){
            return current<size();
        }
        //实现了Iterator<AnyType>接口，
        //但如果将ArrayListIterator定义为泛型，这里就需要将返回的AnyType再强转为AnyType,不知道为什么！
        //可能是因为AnyType是外部那个类的泛型，又是这里这个类的泛型（迭代器参数类型）
        //返回的外部类的AnyType对于ArrayListIterator<AnyType>来说是Object类型
        public AnyType next(){
            if(!hasNext())
                throw new java.util.NoSuchElementException();
            //这里实现+1,是后+1,所以这里current实际代表next
            return theItems[current++];
        }

        //这里返回void是遵循Iterator<AnyType>接口规范
        public void remove(){
            //MyArraList.this代表外层类MyArrayList的对象
            //--current这里暂解释为remove在next方法后调用，next让current++,
            //这里让current回到原来位置，删除它
            //因为如果不调用next直接remove,current会出现<0情况
            MyArrayList.this.remove(--current);
        }
    }
}