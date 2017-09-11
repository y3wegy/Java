package prod.bean;

import java.util.Map;

/**
 * Created by a549238 on 4/5/2017.
 */
public abstract class AbstractRecord implements ParseAble {

    public abstract void add(String fieldName,Object value);

    public boolean shouldAdd(String fieldName){
        return getFiledNameMap().containsKey(fieldName);
    }

    public void afterAction(){}

    public abstract Map<String,Object> getValueMap();
    public abstract Map<String,String> getFiledNameMap();
    public boolean isEmpty(){
        boolean isEmpty =true;
        for(Object value :getValueMap().values() ){
            if(value !=null){
                isEmpty =false;
            }
        }
        return isEmpty;
    }
}
