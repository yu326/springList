package yu.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * Created by koreyoshi on 2017/8/3.
 */
public class ValidateUtils {
    public static boolean isNullOrEmpt(Object object) {
        if (object == null) {
            return true;
        }
        if (object instanceof String) {
            return ((String) object).length() > 0 ? false : true;
        } else if (object instanceof Map) {
            return ((Map) object).size() > 0 ? false : true;
        } else if (object instanceof List) {
            return ((List) object).size() > 0 ? false : true;
        } else if (object instanceof JSONObject) {
            return ((JSONObject) object).length() > 0 ? false : true;
        } else if (object instanceof JSONArray) {
            return ((JSONArray) object).length() > 0 ? false : true;
        }
        return false;
    }

    public boolean isNullOrEmpt(Map map, String key){
        if(isNullOrEmpt(key)){
            throw new RuntimeException("isNullOrEmpt for map exception : the key is null");
        }
        if(isNullOrEmpt(map)){
            return true;
        }
        if(map.containsKey(key)){
            Object Value = map.get(key);
            return isNullOrEmpt(Value);
        }else{
            return true;
        }
    }

    public boolean isNullOrEmpt(JSONObject jsonObject,String key) throws JSONException {
        if(isNullOrEmpt(key)){
            throw new RuntimeException("isNullOrEmpt for JSONObject exception : the key is null");
        }
        if(isNullOrEmpt(jsonObject)){
            return true;
        }
        if(jsonObject.isNull(key)){
            Object Value = jsonObject.get(key);
            return isNullOrEmpt(Value);
        }else{
            return true;
        }
    }
}
