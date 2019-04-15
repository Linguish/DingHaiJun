package LinearList;

import java.util.Iterator;

public class LinkList<T> extends AbsList<T> implements Iterable<T>
{
    Lnode<T> first = null;
    Lnode<T> last = null;
    Iterator<T> itr = null;
    public LinkList()
    {
        length = 0;
        this.itr = new LinkIterator();
    }
    
    private int compare(Lnode<T> a, Lnode<T> b)
    {return a.compareTo(b);}
    
    public void clear()
    {
        first = last = null;
        length = 0;
    }
    public void removeAll(){clear();}
    
    //////////////////////////////////////////////////
    //
    // 下面的函数及内部类的实现在下一节将结合算法来讲解
    //
    /////////////////////////////////////////////////
    
    /**
     * 取得i号节点,内部使用
     *
     * @param i 第i个位置
     * @return data[i]
     */
    protected Lnode<T> getNode(int i){return null;}
    /**
     * 取得i号节点值, 调用getNode完成具体工作
     *
     * @param i 索引位置
     * @return data[i]
     */
    @Override
    public T get(int i){return null;}
    /**
     * 修改i号节点值
     *
     * @param i 索引位置
     * @param x 设定值
     * @return 修改成功true, 否则false
     */
    public boolean set(int i, T x){return false;}
    /**
     * 将值为x的节点插入到i号位置
     *
     * @param i 索引位置
     * @param x 插入的值
     */
    public void add(int i, T x){}
    /**
     * 将值为x的节点插入尾部
     *
     * @param x
     */
    public void addBack(T x){}
    /**
     * 将值为x的节点插入首部
     *
     * @param x 要插入的元素
     */
    public void addFront(T x){}
    /**
     * 对链表排序
     */
    public void sort(){}
    /**
     * 将值为x的节点有序插入链表,调用insertorder实现
     *
     * @param x 要插入的元素
     */
    public void addSort(T x){}
    /**
     * 内部使用, 具体实现有序插入
     *
     * @param s 要插入的元素
     */
    private void insertorder(Lnode<T> s){}
    /**
     * 删除i号节点, 调用removeNode实现
     *
     * @param i 索引位置
     * @return 删除的元素
     */
    public T remove(int i){return null;}
    /**
     * 具体删除i号节点,内部使用
     *
     * @param i 索引位置
     * @return 删除的节点
     */
    protected Lnode<T> removeNode(int i){return null;}
    /**
     * 删除头节点
     *
     * @return 删除前的头节点
     */
    public T remove(){return null;}
    /**
     * 查找key,返回逻辑编号
     *
     * @param begin 起始位置
     * @param end   终止位置
     * @param key   关键字
     * @return 索引位置
     */
    public int indexOf(int begin, int end, T key){return begin;}
    /**
     * 同indexOf, 一般不用, 主要用于实现字典
     *
     * @param key 关键字
     * @return
     */
    public T search(T key){return key;}
    /**
     * 判断链表算法是否包含key
     *
     * @param key 关键字
     * @return 包含则返回true, 否则false
     */
    public boolean contains(T key){return false;}
    /**
     * 转换为串,用于输出
     *
     * @return String对象
     */
    public String toString(){return null;}
    /**
     * 转换为Object数组
     *
     * @return Object数组
     */
    public Object[] toArray(){return new Object[0];}
    /**
     * 转换层与链表节点值类型相同的数组
     *
     * @param a   要转换的数组
     * @param <E> 泛型参数
     * @return 泛型数组
     */
    public <E> E[] toArray(E[] a){return a;}
    
    /**
     * 返回迭代器
     *
     * @return 迭代器
     */
    public Iterator<T> iterator(){return null;}
    
    /**
     * 实现迭代器的内部类
     */
    private class LinkIterator implements Iterator<T>
    {
        @Override
        public boolean hasNext(){return false;}
        @Override
        public T next(){return null;}
    }
}