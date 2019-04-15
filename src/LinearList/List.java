//已完成
package LinearList;

public interface List<T>
{
    //基本操作
    /**
     * 判断线性表是否为空
     *
     * @return 空则返回true, 否则false
     */
    boolean isEmpty();
    /**
     * 返回线性表长度
     *
     * @return 线性表长度
     */
    int length();
    /**
     * 取得第i个位置的数据元素, 返回数据元素的值
     *
     * @param i 索引位置
     * @return 该位置的值
     */
    T get(int i);
    /**
     * 将第i个位置的元素设置为x
     *
     * @param i 索引位置
     * @param x 设定值
     * @return 修改成功true, 否则false
     */
    boolean set(int i, T x);
    /**
     * 将x插入到第i位置
     *
     * @param i 索引位置
     * @param x 插入的值
     */
    void add(int i, T x);
    /**
     * 删除第i个位置的元素
     *
     * @param i 索引位置
     * @return 删除的元素
     */
    T remove(int i);
    /**
     * 返回数据元素x的表List中的位置
     *
     * @param x 要返回下标的元素
     * @return 下标
     */
    int indexOf(T x);
}
