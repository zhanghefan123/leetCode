package JavaBasic.Basic04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class Person{
    void show(String s)
    {
        System.out.println(s);
    }
}

public class ExtendSection {
    public static void main(String[] args) {
        testConsumer();

    }



    // 含有函数式接口Predicate的静态方法
    public static List<String> filterString(List<String> list, Predicate<String> pre)
    {
        List<String> res = new ArrayList<>();
        for(String item:list)
        {
            if(pre.test(item))
            {
                res.add(item);
            }
        }
        return res;
    }

    // 调用匿名内部类的方法。
    public static void testConsumer()
    {
        List<String> list = Arrays.asList("北京","南京","天津","东京","西晋","普京");
        List<String> listAfterFilter = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                if(s.contains("京"))
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
        });
        for(String item : listAfterFilter)
        {
            System.out.println(item);
        }
    }
}

