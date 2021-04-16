/*
 * All rights Reserved, Designed By www.feisuanyz.com
 * @title     DateFunction.java
 * @package   com.feisuanyz.flow.function
 * @version   V1.0
 * @copyright 2020 www.feisuanyz.com Inc. All rights reserved.
 * 注意：本内容仅限于前海飞算云智软件科技（深圳）有限公司内部传阅，除非适用法律要求或书面同意，禁止外泄以及用于其他的商业目的
 */
package com.feisuanyz.function;

import com.feisuanyz.flow.core.cmpt.annotation.function.MethodDesc;
import com.feisuanyz.flow.core.cmpt.annotation.function.ParamDesc;

import java.util.Calendar;
import java.util.Date;

/**
 * <p>
 * 日期相关函数
 * </p>
 * @author 飞算云智
 * @date 2021-03-16 19:59
 */
public class DateFunction {

    private DateFunction() {
    }

    @MethodDesc(desc = "取当前时间", params = {})
    public static Date getSysTime() {
        return new Date();
    }

    @MethodDesc(desc = "判断两个日期是否同一周", params = {
            @ParamDesc(name = "date1", desc = "日期1"),
            @ParamDesc(name = "date2", desc = "日期2")

    })
    public static boolean isSameWeek(Date date1, Date date2) {
        boolean result = false;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        int weekNum1 = calendar.get(Calendar.WEEK_OF_YEAR);

        calendar.setTime(date2);
        int weekNum2 = calendar.get(Calendar.WEEK_OF_YEAR);
        if (weekNum1 == weekNum2) {
            result = true;
        }
        return result;
    }
}
