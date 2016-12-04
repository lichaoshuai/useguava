package utility;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Ordering;
import com.sun.org.apache.xpath.internal.operations.Or;

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
        integerList.add(8);
        System.out.println(JSON.toJSONString(integerList));

        Ordering<Integer> ordering = Ordering.natural();
        System.out.println(ordering.isOrdered(integerList));
        //整数默认排序是从小到大，string按照字典。reserve整好与之相反
        integerList = ordering.reverse().sortedCopy(integerList);

        System.out.println(ordering.isOrdered(integerList));
        System.out.println(integerList);
//        Integer integer = ordering.min(integerList);
//        System.out.println(integer);

    }

}
