package LinearList;

import java.util.Iterator;

public class LinkList<T> extends AbsList<T> implements Iterable<T>
{
    Lnode<T> first = null;
    Lnode<T> last = null;
    Iterable<T> itr = null;
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
    
    ////下面的函数及内部类的实现在下一节将结合算法来讲解
    //    //protected Lnode<T> getNode(int i){return null;}//取得i号节点,内部使用
    //    //public T get(int i){return null;}//取得i号节点值,调用getNode完成具体工作
    //    //public void set(int i, T x){}//修改i号节点值
    //    //public void add(int i, T x){}//将值为x的节点插入到i号位置
    //    //public void addBack(T x){}//将值为x的节点插入尾部
    //    //public void addFront(T x){}//将值为x的节点插入首部
    //    //public void sort(){}//对链表排序
    //    //public void addSort(T x){}//将值为x的节点有序插入链表,调用insertorder实现
    //    //private void insertorder(Lnode<T> s){}//内部使用,具体实现有序插入
    //    //public T remove(int i){return null;}//删除i号节点,调用removeNode实现
    //    //protected Lnode<T> removeNode(int i){return null;}//具体删除i号节点,内部使用
    //    //public T remove(){return null;}//删除头节点
    //    //public int indexof(int begin, int end, T key){return begin;}//查找key,返回逻辑编号
    //    //public T search(T key){return key;}
    //    //public boolean contains(T key){return false;}//判断链表算法是否包含key
    //    //public String toString(){return null;}//转换为串,用于输出
    //    //public Object[] toArray(){return new Object[0];}//转换为object数组
    //    //public <E> E[] toArray(E[] a){return a;}//转换层与链表节点值类型相同的数组
    
    @Override
    public T get(int i){return null;}
    @Override
    public void set(int i, T x){}
    @Override
    public int indexOf(int begin, int end, T o)
    {
        return 0;
    }
    @Override
    public void add(int i, T x){}
    @Override
    public T remove(int i){return null;}
    @Override
    public Iterator<T> iterator(){return null;}
    @Override
    public boolean isEmpty(){return super.isEmpty();}
    @Override
    public int length(){return super.length();}
    @Override
    public void add(T x){super.add(x);}
    @Override
    public void append(T x){super.append(x);}
    @Override
    public int indexOf(T o){return super.indexOf(o);}
    @Override
    public int indexOf(int begin, T o){return super.indexOf(begin, o);}
    @Override
    public T remove(T o){return super.remove(o);}
}
