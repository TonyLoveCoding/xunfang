package team.etop.xunfang.common.modifyTime;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by asus on 2017/9/16.
 */
public class ModifyTime {
    public Date modify(String time) throws Exception{
        Date date=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        date=format.parse(time);
        long rightTime=date.getTime() + 24 * 60 * 60 * 1000;
        time=format.format(rightTime);
        date=format.parse(time);
        return date;
    }
}
