package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: T
 * @Date: 2019/11/26 13:41
 * @Description:
 */
public class MySteam {

    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("s1");
        list.add("s2");
        list.add("s3");
        list.add("s4");
        list.add("s5");
        String[] strings=list.stream().filter((s -> s.length()>1)).toArray(String[]::new);
        Arrays.stream(strings).forEach(System.out::println);

    }

}
