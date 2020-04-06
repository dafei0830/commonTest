package java8Test;

import java.util.stream.Stream;

/**
 * @Author wuzhenfei
 * @Description
 * @Date 2020/3/26 16:02
 **/
public class StreamTest {

    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(3, 2, 1);
        boolean match = stream.allMatch(integer -> integer > 5);

        System.out.println("match = " + match);
    }





}
