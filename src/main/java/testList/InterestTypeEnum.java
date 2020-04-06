package testList;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <ul>
 * <li></li>
 * <li>Created by Suoyunpeng on 2018/8/7.</li>
 * </ul>
 */
@Getter
@AllArgsConstructor
public enum InterestTypeEnum {

    YEAR("YEAR", "年利率"),
    QUARTER("QUARTER", "季利率"),
    MONTH("MONTH", "月利率"),
    WEEK("WEEK", "周利率"),
    DAY("DAY", "日利率"),
    TERM("TERM","期利率"),
    STATIC("STATIC","固定利率");

    private String value;

    private String desc;


    public static InterestTypeEnum getInterestTypeEnumByValue(String value){
//        if(value!=null) {
            for (InterestTypeEnum interestTypeEnum : InterestTypeEnum.values()) {
                if (interestTypeEnum.getValue().equals(value)) {
                    return interestTypeEnum;
                }
            }
//        }
        return null;
    }
}
