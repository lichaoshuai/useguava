package collect;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.*;
import com.google.common.primitives.Ints;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import static com.google.common.collect.Sets.newHashSet;

/**
 * Created by chaoshuai.li on 2016/12/5.
 */
public class ListUse {

    public static void main(String[] args) {

        //使用of方法创建不变list
        ImmutableList<String> stringImmutableList = ImmutableList.of("hello", "world");
        System.out.println(JSON.toJSONString(stringImmutableList));
        //使用transform将list转换成我们需要的list
        List<String> newList = Lists.transform(stringImmutableList, new Function<String, String>() {
            public String apply(String input) {
                return input + "1";
            }
        });
        System.out.println(JSON.toJSONString(newList));

        Map<String, String> map = new HashMap<String, String>();
        map.put("hello", "world");
        //使用现有的map创建不可变map
        ImmutableMap<String, String> immutableMap = ImmutableMap.copyOf(map);
        System.out.println(JSON.toJSONString(immutableMap));
        //使用index或者uniqueIndex将可遍历的list转换成map
        Map<String, String> newMap = Maps.uniqueIndex(stringImmutableList, new Function<String, String>() {
            public String apply(String input) {
                return input;
            }
        });
        System.out.println(JSON.toJSONString(newMap));

        //对基本类型进行比较 同理还有Ints，Doubles，Floats，Shorts，Bytes以及Bools等工具
        int value = Ints.compare(12, 34);
        System.out.println(value);

        //Joiner连接
        String[] subdirs = {"usr", "local", "lib"};
        String directory = Joiner.on("/").join(subdirs);
        System.out.println(directory);
        //对于基本类型还可以如下处理
        int[] numbers = {1, 2, 3, 4, 5};
        String numbersAsString = Joiner.on(";").join(Ints.asList(numbers));
        System.out.println(numbersAsString);

        //splitter在切割的时候有多重选择
        String str = "test1 , ,test2 , test3";
        Iterable<String> stringIterable = Splitter.on(",")
                .omitEmptyStrings()
                .trimResults()
                .split(str);
        System.out.println(stringIterable);

        //集合的交集并集差集操作
        HashSet setA = newHashSet(1, 2, 3, 4, 5);
        HashSet setB = newHashSet(4, 5, 6, 7, 8);
        //并集
        Sets.SetView<Integer> union = Sets.union(setA, setB);
        System.out.println(JSON.toJSONString(union));
        //差集 A-B
        Sets.SetView<Integer> difference = Sets.difference(setA, setB);
        System.out.println(JSON.toJSONString(difference));
        //交集
        Sets.SetView<Integer> interSection = Sets.intersection(setA, setB);
        System.out.println(JSON.toJSONString(interSection));

        Map<String, String> mapA = new HashMap<String, String>();
        mapA.put("1", "hello");
        mapA.put("2", "world");
        mapA.put("3", "nihao");
        Map<String, String> mapB = new HashMap<String, String>();
        mapB.put("1", "hello");
        mapB.put("2", "world1");
        mapB.put("4", "nihao");
        MapDifference differenceMap = Maps.difference(mapA, mapB);
        //判断两个map集合是否相等
        boolean isEquals = differenceMap.areEqual();
        System.out.println(isEquals);
        //在两个集合中都存在，但是值不想等的key
        Map entriesDiffering = differenceMap.entriesDiffering();
        System.out.println(JSON.toJSONString(entriesDiffering));
        //在左边集合中存在但是在右边不存在的key-value
        Map entriesOnlyOnLeft = differenceMap.entriesOnlyOnLeft();
        System.out.println(JSON.toJSONString(entriesOnlyOnLeft));
        //在右边集合中存在但是在左边不存在的key-value
        Map entriesOnlyOnRight = differenceMap.entriesOnlyOnRight();
        System.out.println(JSON.toJSONString(entriesOnlyOnRight));
        //在两个集合中都存在并且key-value都想等的数据
        Map entriesInCommon = differenceMap.entriesInCommon();
        System.out.println(JSON.toJSONString(entriesInCommon));


    }
}
