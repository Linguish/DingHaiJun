package LinearList;

import java.util.Iterator;

public class LinkList<T> extends AbsList<T> implements Iterable<T>
{
    /**
     * 首指针
     */
    Lnode<T> first = null;
    /**
     * 尾指针
     */
    Lnode<T> last = null;
    /**
     * 当前指针
     */
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
    protected Lnode<T> getNode(int i)
    {
        if(i<0 || i>length - 1){ return null; }
        if(i == 0){ return first; }
        Lnode<T> p = first;
        int j = 0;
        while(p != null && j<i)
        {
            p = p.next;
            j++;
        }
        return p;
    }
    /**
     * 取得i号节点值, 调用getNode完成具体工作
     *
     * @param i 索引位置
     * @return data[i]
     */
    @Override
    public T get(int i)
    {
        Lnode<T> p = getNode(i);
        if(p == null){return null;}
        else{return p.data;}
    }
    /**
     * 修改i号节点值
     *
     * @param i 索引位置
     * @param x 设定值
     * @return 修改成功true, 否则false
     */
    public boolean set(int i, T x)
    {
        Lnode<T> p = getNode(i);
        if(p == null){return false;}
        else
        {
            p.data = x;
            return true;
        }
    }
    /**
     * 将值为x的节点插入到i号位置
     *
     * @param i 索引位置
     * @param x 插入的值
     */
    public void add(int i, T x)
    {
        Lnode<T> p, s;
        int j = i - 1;
        s = new Lnode<T>(x, null);
        if(first == null || length == 0)
        {
            //在空链表中插入结点s
            first = s;
            last = s;
        }
        else if(j<0)
        {
            //在首节点之前插入结点s
            s.next = first;
            first = s;
        }
        else if(j >= length - 1)
        {
            //在尾部插入结点s
            last.next = s;
            last = s;
        }
        else
        {
            //在链表中间插入结点s
            p = getNode(j);
            s.next = p.next;
            p.next = s;
        }
        length++;
    }
    /**
     * 将值为x的节点插入尾部
     *
     * @param x
     */
    public void addBack(T x){add(length, x);}
    /**
     * 将值为x的节点插入首部
     *
     * @param x 要插入的元素
     */
    public void addFront(T x){add(0, x);}
    /**
     * 对链表排序
     */
    public void sort()
    {
        LinkList<T> sl = new LinkList<T>();
        Lnode<T> p;
        p = this.removeNode(0);
        while(p != null)
        {
            sl.insertOrder(p);
            p = this.removeNode(0);
        }
        this.first = sl.first;
        this.last = sl.last;
        this.length = sl.length;
    }
    /**
     * 将值为x的节点有序插入链表,调用insertorder实现
     *
     * @param x 要插入的元素
     */
    public void addSort(T x)
    {
        Lnode<T> s = new Lnode<T>(x, null);
        insertOrder(s);
    }
    /**
     * 内部使用, 具体实现有序插入
     *
     * @param s 要插入的元素
     */
    private void insertOrder(Lnode<T> s)
    {
        Lnode<T> p1, p2;
        length = length + 1;
        if(first == null)
        {    //空链表
            first = s;
            last = first;
            return;
        }
        if(compare(s, first)<0)
        {
            s.next = first;
            first = s;
            return;
        }
        if(compare(s, last) >= 0)
        {
            last.next = s;
            last = s;
            return;
        }
        //被插节点p在p1和p2之前
        p2 = first;
        p1 = p2;
        while(p2 != null)
        {
            if(compare(s, p2)>0)
            {
                p1 = p2;
                p2 = p2.next;
            }
            else{break;}
        }
        s.next = p2;
        p1.next = s;
        return;
    }
    /**
     * 删除i号节点, 调用removeNode实现
     *
     * @param i 索引位置
     * @return 删除的元素
     */
    public T remove(int i)
    {
        Lnode<T> p = removeNode(i);
        if(p != null){return p.data;}
        else{return null;}
    }
    /**
     * 具体删除i号节点,内部使用
     *
     * @param i 索引位置
     * @return 删除的节点
     */
    protected Lnode<T> removeNode(int i)
    {
        Lnode<T> p, q;
        if(first == null)
        { return null; }
        if(i == 0)
        {
            p = first;
            first = first.next;
            length = length - 1;
            return p;
        }
        if(i >= 1 && i<=length - 1)
        {
            p = getNode(i - 1);
            q = p.next;
            p.next = q.next;
            if(q == last)
            {last = p;}
            length = length - 1;
            return q;
        }
        return null;
    }
    /**
     * 删除头节点
     *
     * @return 删除前的头节点
     */
    public T remove(){return removeNode(0).data;}
    /**
     * 查找key,返回逻辑编号
     *
     * @param begin 起始位置
     * @param end   终止位置
     * @param key   关键字
     * @return 索引位置
     */
    public int indexOf(int begin, int end, T key)
    {
        Lnode<T> p = getNode(begin);
        int i = begin;
        while(p != null && i<end)
        {
            if(p.data.equals(key)){ return i; }
            p = p.next;
            i++;
        }
        return -1;
    }
    /**
     * 同indexOf, 一般不用, 主要用于实现字典
     *
     * @param key 关键字
     * @return
     */
    public T search(T key)
    {
        Lnode<T> p = getNode(0);
        while(p != null)
        {
            if(p.data.equals(key)){ return p.data; }
            p = p.next;
        }
        return null;
    }
    /**
     * 判断链表算法是否包含key
     *
     * @param key 关键字
     * @return 包含则返回true, 否则false
     */
    public boolean contains(T key)
    {
        if(indexOf(key) == -1){ return false; }
        else{ return true; }
    }
    /**
     * 转换为串,用于输出
     *
     * @return String对象
     */
    public String toString()
    {
        Lnode<T> p = first;
        if(p == null)
        {return "( )";}
        String str = "(";
        while(p != null)
        {
            if(p == last)
            {
                str = str + p.data.toString() + ")";
                break;
            }
            else{str = str + p.data.toString() + "->";}
            p = p.next;
        }
        return str;
    }
    /**
     * 转换为Object数组
     *
     * @return Object数组
     */
    public Object[] toArray()
    {
        Object[] a = new Object[length];
        Lnode<T> p = first;
        for(int i = 0; i<length; i++)
        {
            a[i] = p.data;
            p = p.next;
        }
        return a;
    }
    /**
     * 转换层与链表节点值类型相同的数组
     *
     * @param a   要转换的数组
     * @param <E> 泛型参数
     * @return 泛型数组
     *///todo:待测试
    public <E> E[] toArray(E[] a)
    {
        if(a.length<length)
        {
            a = (E[])java.lang.reflect.Array.newInstance(
                    a.getClass().getComponentType(), length);
        }
        int i = 0;
        Object[] result = a;
        Lnode<T> x = this.first;
        for(i = 0; i<length; i++)
        {
            result[i] = x.data;
            x = x.next;
        }
        
        if(a.length>length)
        { a[length] = null; }
        return a;
    }
    
    /**
     * 返回迭代器
     *
     * @return 迭代器
     */
    public Iterator<T> iterator()
    {
        this.itr = new LinkIterator();
        return this.itr;
    }
    
    /**
     * 实现迭代器的内部类
     */
    private class LinkIterator implements Iterator<T>
    {
        private int index = 0;
        private Lnode<T> current = first;
        @Override
        public boolean hasNext()
        {
            // 只要在调用next()后，index自加，
            // 确保index不等于person的长度
            return (index != length() && current != null);
        }
        
        @Override
        public T next()
        {
            T temp = current.data;
            current = current.next;
            index++;
            return temp;
        }
        public int nextIndex(){return index++;}
    }
}