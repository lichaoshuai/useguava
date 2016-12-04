package utility;

import com.google.common.base.Optional;

/**
 * Created by chaoshuai.li on 2016/12/3.
 */
public class OptionalUse {

    public static void main(String[] args) {

        //生成实例，判断是否为null
        System.out.println(Optional.of("").isPresent());
        //对于null，get的时候是空指针
        //System.out.println(Optional.of(null).get());
        //生成非空optional 判断是否是指定值
        System.out.println(Optional.fromNullable("hello").or("hello"));
        //absent方式生成的实例，里面只有一个absent类的对象，但是不为空
        System.out.println(Optional.absent().orNull());
        //由于absent方式生成的对象中没有我们指定的类型（只有一个absent对象），所以调用isPresent方法是为false
        System.out.println(Optional.absent().isPresent());
    }


}
