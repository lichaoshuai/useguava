package collect;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Function;
import com.google.common.collect.*;

/**
 * Created by chaoshuai.li on 2016/12/5.
 */
public class NewCollection {

    public static void main(String[] args) {
        //多值set
        Multiset<String> multiset1 = HashMultiset.create();
        multiset1.add("a", 2);
        Multiset<String> multiset2 = HashMultiset.create();
        multiset2.add("a", 5);
        multiset1.containsAll(multiset2); //返回true；因为包含了所有不重复元素，
        //虽然multiset1实际上包含2个"a"，而multiset2包含5个"a"
        Multisets.containsOccurrences(multiset1, multiset2); // returns false
        multiset2.removeAll(multiset1);//multiset2移除所有"a"，虽然multiset1只有2个"a"
        multiset2.isEmpty(); // returns true


        ImmutableSet digits = ImmutableSet.of("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
        Function<String, Integer> lengthFunction = new Function<String, Integer>() {
            public Integer apply(String string) {
                return string.length();
            }
        };
        ImmutableListMultimap<Integer, String> digitsByLength = Multimaps.index(digits, lengthFunction);

        Table<Object, Object, Object> table = HashBasedTable.create();
        table.put("hello" , "world" , "nihao");
        System.out.println(table);
        System.out.println(JSON.toJSONString(table.cellSet()));
        System.out.println(JSON.toJSONString(table.column("world")));
        System.out.println(JSON.toJSONString(table.columnMap()));
        System.out.println(JSON.toJSONString(table.get("hello" , "world")));
    }
}
