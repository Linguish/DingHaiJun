/**
 * 用链表实现一元多项式的加法运算及多项式的输出
 * 提示：任意一元多项式可以抽象为一个由“系数-指数”二元组定义的Java类。
 */
package LinearList.Example;

import LinearList.LinkList;

import java.util.Scanner;

public class Example_2_12
{
    private static class PloyItem
    {
        /**
         * 系数
         */
        private double coef;
        /**
         * 指数
         */
        private int exp;
        public PloyItem(){}
        public PloyItem(double coef, int exp)
        {
            this.coef = coef;
            this.exp = exp;
        }
        
        /**
         * 将指数相同的两项相加
         *
         * @param input 加数
         * @return 结果
         */
        public PloyItem add(PloyItem input){return new PloyItem(input.coef + this.coef, this.exp);}
        public double getCoef(){return coef;}
        public int getExp(){return exp;}
        public void setCoef(double coef){this.coef = coef;}
        public void setExp(int exp){this.exp = exp;}
        /**
         * 生成随机系数不大于10，指数不大于exp的多项式
         *
         * @param exp 指数的上界
         * @return 多项式
         */
        public LinkList<PloyItem> create(int exp)
        {
            LinkList<PloyItem> ret = new LinkList<>();
            for(int i = 0; i<exp; i++)
            {
                ret.addBack(new PloyItem(10*Math.random(), i));
            }
            return ret;
        }
        
        @Override
        public String toString()
        {
            String ret;
            if(exp == 0)
            { ret = String.format("%.2f", coef); }
            else if(exp == 1)
            { ret = String.format("%.2fx", coef); }
            else
            { ret = String.format("%.2fx^%d", coef, exp); }
            return ret;
        }
    }
    
    /**
     * 输出多项式
     *
     * @param input 要输出的多项式
     */
    public static void printItem(LinkList<PloyItem> input)
    {
        for(int i = 0; i<input.length() - 1; i++)
        {System.out.print(input.get(i) + " + ");}
        System.out.println(input.get(input.length() - 1));
    }
    /**
     * 将两个多项式相加
     *
     * @param input1 多项式一
     * @param input2 多项式二
     * @return 相加的结果
     */
    public static LinkList<PloyItem> addItem(LinkList<PloyItem> input1, LinkList<PloyItem> input2)
    {
        LinkList<PloyItem> ret = new LinkList<>();
        int i = 0, j = 0;
        while(i<input1.length() || j<input2.length())
        {
            if(input1.get(i).exp<input2.get(j).exp)
            {
                i++;
                continue;
            }
            else if(input1.get(i).exp>input2.get(j).exp)
            {
                j++;
                continue;
            }
            else
            {
                ret.addBack(input1.get(i).add(input2.get(j)));
                i++;
                j++;
            }
            
            if(i == input1.length() && j<input2.length())
            {
                for(; j<input2.length(); j++)
                {ret.addBack(input2.get(j));}
            }
            else if(j == input2.length() && i<input1.length())
            {
                for(; i<input1.length(); i++)
                {ret.addBack(input1.get(i));}
            }
        }
        
        return ret;
    }
    
    public static void main(String[] args)
    {
        PloyItem temp = new PloyItem();
        
        Scanner exp = new Scanner(System.in);
        System.out.print("多项式m的次数不大于：");
        LinkList<PloyItem> m = temp.create(exp.nextInt());
        System.out.print("多项式n的次数不大于：");
        LinkList<PloyItem> n = temp.create(exp.nextInt());
        
        System.out.print("m = ");
        printItem(m);
        System.out.print("n = ");
        printItem(n);
        
        System.out.print("m+n = ");
        printItem(addItem(m, n));
    }
}
