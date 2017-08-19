import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by asus on 2017/8/18.
 */
public class time {

    public static void main(String[] arg){
        Calendar cal = Calendar.getInstance();
        // 设置格式化的SimpleDateFormat对象，指定中国语言环境
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        // 创建时区（TimeZone）对象，设置时区为“亚洲/重庆"
        TimeZone TZ = TimeZone.getTimeZone("Asia/Chongqing");
        // 将SimpleDateFormat强制转换为DateFormat
        DateFormat df = null;
        try
        {
            df = (DateFormat)sdf;
        }
        catch(Exception E)
        {
            E.printStackTrace();
        }
        // 为DateFormat对象设置时区
        df.setTimeZone(TZ);
        // 获取时间表达式
        String cdate = df.format(cal.getTime());
        System.out.println(cal.getTime());
        System.out.println(cdate);
    }
}
