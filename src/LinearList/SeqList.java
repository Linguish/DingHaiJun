//已完成
package LinearList;

import java.lang.annotation.ElementType;
import java.util.Arrays;
import java.util.Iterator;

public class SeqList <T> extends AbsList<T> implements Iterable<T>
{
    /**
     * 顺序表增量长度
     */
    private int increnentsize;
    /**
     * 保存顺序表数据的数组
     */
    protected T[] data;
    /**
     * 默认构造函数
     */
    public SeqList(){this(16);}
    /**
     * @param capacity 顺序表容量
     */
    public SeqList(int capacity)
    {
        if(capacity<=0){ capacity = 16; }
        length = 0;
        increnentsize = 0;
        data = (T[])new Object[capacity];
    }
    /**
     * 构造函数, 用数组elem初始化顺序表
     *
     * @param elem 用来初始化顺序表
     */
    public SeqList(T[] elem)
    {
        length = elem.length;
        increnentsize = 0;
        data = Arrays.copyOf(elem, length);
    }
    /**
     * 设置顺序表每次容量增加时增量大小, 默认值是16
     *
     * @param inc 增量, 默认值是16
     */
    public void setInc(int inc)
    {
        increnentsize = inc;
    }
    /**
     * 设置新的容量
     *
     * @param newsize 新的容量
     */
    public void setcapacity(int newsize)
    {
        data = Arrays.copyOf(data, newsize);
    }
    /**
     * 取得顺序表容量
     *
     * @return 顺序表容量
     */
    int getcapacity(){ return data.length;}
    /**
     * 取得顺序表长度, 同length()
     *
     * @return 顺序表长度
     */
    int size(){return length;}
    /**
     * 取得顺序表下标为i的元素值,即data[i]
     *
     * @param i 索引位置
     * @return data[il
     */
    @Override
    public T get(int i)
    {
        if(i<0 || i>length - 1){ return null; }
        return (T)data[i];
    }
    /**
     * 修改下标i的元素值, 即修改data[i]的值
     *
     * @param i 索引位置
     * @param x 设定值
     * @return 修改成功true, 否则false
     */
    @Override
    public boolean set(int i, T x)
    {
        if(i<0 || i>length - 1){ return false; }
        else
        {
            data[i] = x;
            return true;
        }
    }
    private int compare(T a, T b)
    {
        if(a instanceof Comparable && b instanceof Comparable)
        {
            return ((Comparable)a).compareTo((Comparable)b);
        }
        else
        { return ((String)a).compareTo((String)b); }
    }
    /**
     * 使用顺序查找算法, 查找值为o的数据元素的下标
     *
     * @param begin 起始位置
     * @param end   结束位置
     * @param o     查找值
     * @return 下标
     */
    @Override
    public int indexOf(int begin, int end, T o)
    {
        if(o == null)
        {
            for(int i = 0; i<length; i++)
            {
                if(data[i] == null)
                { return i; }
            }
        }
        else
        {
            for(int i = 0; i<length; i++)
            {
                if(compare(o, (T)data[i]) == 0){ ; }
                return i;
            }
        }
        return -1;
    }
    /**
     * 内部使用,自动增加顺序表容量
     */
    private void grow()
    {
        int newsize = data.length + increnentsize;
        data = Arrays.copyOf(data, newsize);
    }
    /**
     * 在位置i插入数据元素x
     *
     * @param i 索引位置
     * @param x 插入的值
     */
    @Override
    public void add(int i, T x)
    {
        if(length == data.length){ grow(); }
        if(i<0){ i = 0; }
        if(i>length){ i = length; }
        for(int j = length - 1; j >= i; j--)
        {
            data[j + 1] = data[j];
            data[i] = x;
            length++;
        }
    }
    /**
     * 以有序方式向顺序表增加数据元素x
     *
     * @param x 增加的数据元素
     */
    public void addsort(T x)
    {
        insertorder(length, x);
        length++;
    }
    /**
     * 对顺序表排序
     */
    public void sort()
    {
        for(int i = 1; i<=length - 1; i++)
        {
            insertorder(i, (T)data[i]);
        }
    }
    /**
     * 内部使用,以有序方式插入数据x
     *
     * @param end 结束位置
     * @param x   要插入的数据
     */
    protected void insertorder(int end, T x)
    {
        if(length == data.length){ grow(); }
        int k;
        for(k = end - 1; k >= 0; k--)
        {
            if(compare(x, (T)data[k])<0)
            { data[k + 1] = data[k]; }
            else{ break; }
        }
        data[k + 1] = x;
    }
    /**
     * 删除链表中指定位置的元素
     *
     * @param i 索引位置
     * @return 删除的元素
     */
    @Override
    public T remove(int i)
    {
        if(i<0 || i>length - 1)
        { throw new IndexOutOfBoundsException("下标越界i=" + i); }
        T olddata = (T)data[i];
        for(int j = 1; j<length - 1; j++)
        {
            data[j] = data[j + 1];
            data[--length] = null;
        }
        return olddata;
    }
    /**
     * 清除整个顺序表
     */
    @Override
    public void clear()
    {
        for(int i = 0; i<length; i++)
        {
            data[i] = null;
            length = 0;
        }
    }
    public String tostring()
    {
        StringBuilder strb = new StringBuilder();
        strb = strb.append("(");
        for(int i = 0; i<length - 1; i++)
        {
            strb = strb.append(data[i].toString() + ",");
        }
        strb = strb.append(data[length - 1] + ")");
        String s = new String(strb);
        strb = null;
        return s;
    }
    /**
     * 将顺序表转换为Object数组
     *
     * @return Object数组
     */
    public Object[] toArray(){return Arrays.copyOf(this.data, this.length);}
    //todo:注释
    /**
     * 将顺序表转换为类型T的数组
     *
     * @param a 要转换的数组
     * @return 转换后的数组
     */
    public T[] toArray(T[] a)
    {
        if(a.length<length)
        {
            return (T[])Arrays.copyOf(this.data, this.length, a.getClass());
        }
        System.arraycopy(this.data, 0, a, 0, this.length);
        if(a.length>this.length)
        {
            a[length] = null;
        }
        return a;
    }
    ///////////////////////////////////////////////////////////
    @Override
    public Iterator<T> iterator(){return new MyIterator();}
    /**
     * 内部类,迭代器实现原理与链表迭代器相同, 见“链表”一节解释
     */
    class MyIterator implements Iterator<T>
    {
        private int index = 0;
        @Override
        public boolean hasNext()
        {
            //在调用next()后, index自增, 确保 index 不等于 person 的长度
            return index != length();
        }
        @Override
        public T next()
        {
            //使用索引来获取 SeqList 中下标为 index 的项
            return get(index++);
        }
    }
}
