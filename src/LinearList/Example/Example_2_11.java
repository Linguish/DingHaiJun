/**
 * Josephus问题：
 * 设编号为1，2，···，n 的n个人围坐在一圈，
 * 约定编号为k（1≤k≤n）的人从1开始报数，
 * 数到m的那个人出列，
 * 他的下一位又从1开始报数，
 * 数到m的那个人再出列。
 * 依此类推，直到所有人都出列为止，
 * 由此产生一个出队编号的序列。
 * <p>
 * 要求用顺序表实现。
 */
package LinearList.Example;

import LinearList.SeqList;

import java.util.Scanner;

public class Example_2_11
{
    public static void main(String[] args) throws Exception
    {
        //n个人
        System.out.print("输入人数n：");
        SeqList<Integer> n = new SeqList<>(new Scanner(System.in).nextInt());
        //从第k个开始数
        System.out.print("从第k个开始数：");
        int k = new Scanner(System.in).nextInt() - 1;
        if(k<0 || k>n.length())
        {throw new Exception("输入数据不合法，请保证1≤k≤n");}
        //数到m
        System.out.print("数到m出列：");
        int m = new Scanner(System.in).nextInt();
        //初始化编号
        for(int i = 0; i<n.getcapacity(); i++)
        {n.addsort(i + 1);}
        
        System.out.println("出列顺序为：");
        
        //目前数到的数
        int temp = 1;
        //有人没出列，就一直遍历
        while(n.length() != 0)
        {
            //如果到尾部了就从头开始
            if(k >= n.length()){k = 0;}
            
            //如果数到了m就出列
            if(temp == m)
            {
                //出列
                System.out.println(n.remove(k));
                //出列后下一个人从1开始数
                temp = 0;
                //出列后此人后面的人在线性表中的位置自动往前移
                //补偿编号
                k--;
            }
            //下一个人继续数
            k++;
            //数的树加一
            temp++;
        }
    }
}
