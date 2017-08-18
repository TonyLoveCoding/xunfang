package team.etop.xunfang.common.photos;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by asus on 2017/8/17.
 */
public class GetName {

    public String getName(String photoName){
        String[] str=photoName.split("\\.");
        String string=str[1];
        long time=System.currentTimeMillis();
        String filename=time+"."+string;
        return filename;
    }

}
