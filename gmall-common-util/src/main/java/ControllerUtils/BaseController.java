package ControllerUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yufei
 * @create 2018-08-02 9:42
 */
public class BaseController {

    private static ThreadLocal<Map<String,Object>> threadLocal = new ThreadLocal<Map<String,Object>>();

    public void start() {

        Map<String, Object> map = new HashMap<String, Object>();

        threadLocal.set(map);
    }

    public void success(boolean param) {
        threadLocal.get().put("success",param);
    }

    public void menage(String param) {
        threadLocal.get().put("menage",param);
    }

    public void data(Object obj) {
        threadLocal.get().put("data",obj);
    }

    public Object end() {
        return threadLocal.get();
    }
}
