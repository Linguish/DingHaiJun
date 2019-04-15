/**
 * @author 梁国熙
 */
package LinearList;

public interface List<T>
{
    boolean isEmpty();
    int length();
    T get(int i);
    void set(int i, T x);
    void add(int i, T x);
    T remove(int i);
    int indexOf(T x);
}
