package testList;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Author wuzhenfei
 * @Description
 * @Date 2019/10/11 17:35
 **/

@Getter
@Setter
public class Student {

    private String name;

    private Integer age;

    private char sex;

    private List<Grade> grades;

}
