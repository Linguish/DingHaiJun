package LinearList;

public class Lnode<T> implements Comparable<Lnode<T>>
{
    public T data;
    public Lnode<T> next;
    /**
     * 构造函数
     *
     * @param key 默认赋值
     */
    public Lnode(T key)
    {
        data = key;
        next = null;
    }
    /**
     * @param e 比较的值,判断是否相等使用
     * @return 如果相等true, 否则false
     */
    public boolean equals(Object e)
    {
        Lnode<T> node = (Lnode<T>)e;
        return data.equals(node.data);
    }
    
    /**
     * 实现接口 Compareable的 compareTo 方法，用于链表节点比较大小
     *
     * @param e 用于比较的值
     * @return
     */
    public int compareTo(Lnode<T> e)
    {
        Comparable<T> x;
        if(data instanceof Comparable)
        {
            x = (Comparable<T>)data;
            return (int)x.compareTo(e.data);
        }
        else
        { throw new ClassCastException("类型无法比较"); }
    }
    public String toString(){return data.toString();}
}
