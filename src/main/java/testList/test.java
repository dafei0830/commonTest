package testList;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author wuzhenfei
 * @Description
 * @Date 2019/11/12 17:28
 **/
public class test {

    public String reporting(String[] postions, int[] datas) {

        Map pm = new HashMap<String, Integer>();
        for (int i = 0; i < postions.length; i++) {
            Object o = pm.get(postions[i]);
            if(o==null){
                pm.put(postions[i], datas[i]);
            }else {
                pm.put(postions[i],Math.max((int)o,datas[i]));
            }
        }
        return pm.toString();
    }

}
