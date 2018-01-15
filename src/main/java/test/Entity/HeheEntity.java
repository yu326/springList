package test.Entity;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * Created by koreyoshi on 2017/11/21.
 */
@Service
@Data
public class HeheEntity {

    //版本号
    private static final long serialVersionUID = 1L;

    //属性
    private int id;
    private int age;
    private String name;
    private Date date;

    public HeheEntity(){

    }

    public HeheEntity(Map map){
        this.id = Integer.valueOf(map.get("id").toString());
        this.age = Integer.valueOf(map.get("age").toString());
        this.name = map.get("name").toString();
        this.date = (Date) map.get("date");
    }



}
