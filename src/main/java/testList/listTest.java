package testList;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.IntStream;

import com.google.common.collect.Maps;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author wuzhenfei
 * @Description
 * @Date 2019/10/11 17:34
 **/

public class listTest {

    private static final int NUM_INC = 1_000;

    @Test
    void handleList(){

        Student student = new Student();
        List<Grade> grades = student.getGrades();
        IntStream.range(0,NUM_INC).forEach(i->{
            System.out.println("i = " + i);
        });
    }

    @Test
    void enumTest(){
//        InterestTypeEnum interestTypeEnumByValue = InterestTypeEnum.getInterestTypeEnumByValue(null);
//        System.out.println("interestTypeEnumByValue = " + interestTypeEnumByValue);
        InterestTypeEnum interestTypeEnumByValue = null;
        String value = interestTypeEnumByValue.getValue();

        System.out.println("value = " + value);
    }

    @Test
    void testEquals(){

//        String a = "aa";
//        boolean equals = a.equals(null);
//        System.out.println("equals = " + equals);

        Map<String, String>  map = Maps.newHashMap();
        map.put("aa","bb");
        List<String> list = Lists.newArrayList();
        Optional.ofNullable(map.get("aaa")).ifPresent(a->list.add(a.toString()));
        Optional.ofNullable(map.get("aa")).ifPresent(a->list.add(a.toString()));
        System.out.println("list = " + list);


    }

    @Test
    void testJoin(){
        List<Integer> list = null;
        String join = StringUtils.join(list, ",");
        System.out.println("join = " + join);
    }
}
