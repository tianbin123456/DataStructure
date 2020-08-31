package java8;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Author: T
 * @Date: 2019/11/26 11:02
 * @Description:
 */
public class MyLambda {
    public static void main(String[] args) {
        Consumer<String> consumer = System.out::println;
        consumer.accept("sss");
        Supplier<String> supplier = () -> "sdadasda".replaceAll("a", "b");
        System.out.println(supplier.get());
        Function<String, Integer> function = s -> s.length() + s.length();
        System.out.println(function.apply("ssss"));
    }

}
