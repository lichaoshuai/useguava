package utility;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Ordering;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chaoshuai.li on 2016/12/4.
 */
public class OrderUse {

    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<Integer>();
        integerList.add(10);
        integerList.add(5);
        integerList.add(10);
        integerList.add(8);
        System.out.println(JSON.toJSONString(integerList));

        //默认排序
        Ordering<Integer> ordering = Ordering.natural();
        System.out.println(ordering.isOrdered(integerList));
        //整数默认排序是从小到大，string按照字典。reserve整好与之相反
        integerList = ordering.reverse().sortedCopy(integerList);
        System.out.println(JSON.toJSONString(integerList));
        //isOrdered判断是否已排序,如果排序的时候是反序，判断的时候也需要是反序
        System.out.println(ordering.reverse().isOrdered(integerList));
        //判断是否是严格有序，有两个相同元素返回false
        System.out.println(ordering.reverse().isStrictlyOrdered(integerList));

        //转换成toString方式之后的排序结果：[10, 5, 8]
        integerList = Ordering.usingToString().sortedCopy(integerList);

        //排序之后的最小值
        Integer integer = ordering.min(integerList);
        System.out.println(integer);

        List<String> stringList = new ArrayList<String>();
        stringList.add("hello");
        stringList.add("world");
        stringList.add("");
        stringList.add(null);
        //null值在前排序
        stringList = Ordering.natural().nullsFirst().sortedCopy(stringList);
        System.out.println(stringList);

    }

}
