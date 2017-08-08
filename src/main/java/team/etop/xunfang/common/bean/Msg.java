package team.etop.xunfang.common.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashMap;
import java.util.Map;

/**
 * @version V1.0
 * @Description:
 * @author: TingFeng Zhang
 * @date: 2017/8/8 18:22
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Msg {
    private int code;
    private String msg;
    private String tip;
    private Map<String,Object> extend=new HashMap<String,Object>();

    public static Msg success(){
        Msg result = new Msg();
        result.setCode(100);
        result.setMsg("操作成功");
        return result;
    }

    public static Msg fail(){
        Msg result = new Msg();
        result.setCode(200);
        result.setMsg("操作失败");
        return result;
    }

    public static Msg noPermission(){
        Msg result = new Msg();
        result.setCode(300);
        result.setMsg("没有权限");
        return result;
    }

    public static Msg reject(){
        Msg result = new Msg();
        result.setCode(400);
        result.setMsg("拒绝请求");
        return result;
    }

    public static Msg success(String tip){
        Msg result = new Msg();
        result.setCode(100);
        result.setTip(tip);
        result.setMsg("操作成功");
        return result;
    }

    public static Msg fail(String tip){
        Msg result = new Msg();
        result.setCode(200);
        result.setTip(tip);
        result.setMsg("操作失败");
        return result;
    }

    public static Msg noPermission(String tip){
        Msg result = new Msg();
        result.setCode(300);
        result.setTip(tip);
        result.setMsg("没有权限");
        return result;
    }

    public static Msg reject(String tip){
        Msg result = new Msg();
        result.setCode(400);
        result.setTip(tip);
        result.setMsg("拒绝请求");
        return result;
    }

    public Msg add(String key,Object value){
        this.getExtend().put(key,value);
        return this;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
}
