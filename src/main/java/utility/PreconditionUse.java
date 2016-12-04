package utility;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by chaoshuai.li on 2016/12/3.
 */
public class PreconditionUse {

    public static void main(String[] args) {
        //boolean check 如果为false 抛出IllegalArgumentException异常
//        Preconditions.checkArgument(false);
        //校验是否为空
        System.out.println(Preconditions.checkNotNull("hello"));

        checkParam(30 , "lili");
        checkParam(5 , "ming");

    }

    public static void checkParam(int age , String name){
        Preconditions.checkState(age > 10 , "年龄必须大于10岁");
        Preconditions.checkArgument(StringUtils.isNotBlank(name) , "姓名不能为空");
        System.out.println("age : "+age +" , name:"+name);
    }

}
