package LinearList;

import java.util.Iterator;

public abstract class AbsList<T> implements Iterable<T>, List<T>
{
    protected int length;
    /**
     * 返回第i个位置的元素
     *
     * @param i 索引位置
     * @return 第i个元素
     */
    abstract public T get(int i);
    /**
     * 设定第i个位置的元素的值
     *
     * @param i 索引位置
     * @param x 设定值
     * @return 修改成功true, 否则false
     */
    abstract public boolean set(int i, T x);
    /**
     * 查找从begin到end范围内的关键字, 返回下标
     *
     * @param begin 起始位置
     * @param end   结束位置
     * @param o     关键字
     * @return 下标
     */
    abstract public int indexOf(int begin, int end, T o);
    /**
     * 插入x作为第i个元素
     *
     * @param i 索引位置
     * @param x 插入的值
     */
    abstract public void add(int i, T x);
    abstract public void clear();
    /**
     * 删除第i个位置的元素并返回删除对象
     *
     * @param i 索引位置
     * @return 被删除的元素
     */
    abstract public T remove(int i);
    /**
     * 返回一个迭代器
     *
     * @return 迭代器
     */
    abstract public Iterator<T> iterator();
    /**
     * 判断是否为空
     *
     * @return 空则返回true, 否则false
     */
    public boolean isEmpty(){return length == 0;}
    /**
     * 返回线性表长度
     *
     * @return 线性表长度
     */
    public int length(){return length;}
    /**
     * 在线性表最后插入元素x
     *
     * @param x 要插入的元素
     */
    public void add(T x){add(length, x);}
    public void append(T x){add(length, x);}
    public int indexOf(T o){return indexOf(0, length, o);}
    public int indexOf(int begin, T o){return indexOf(begin, length, o);}
    /**
     * 删除元素o并返回删除对象
     *
     * @param o 要删除的元素
     * @return 删除的对象
     */
    public T remove(T o){return remove(indexOf(o));}
}
