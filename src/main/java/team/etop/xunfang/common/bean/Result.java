package team.etop.xunfang.common.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZYZ on 2017/8/10
 */
public class Result implements Serializable{
    public static final int SUCCESS = 1;
    public static final int FAILURE = -1;

    private static final long serialVersionUID = 5576237395711742681L;

    private boolean success = false;

    private String msg = "";

    private Object obj = null;
    private Map<String,Object> map=new HashMap<String,Object>();

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }



    public Result add(String key, Object value){
        this.getMap().put(key,value);
        return this;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
