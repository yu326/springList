package test.Entity;

import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by koreyoshi on 2017/11/21.
 */
@Data
public class HelloEntity implements Serializable {

    @Autowired
    private HeheEntity heheEntity;
    //版本号
    private static final long serialVersionUID = 1L;
    //属性
    private String id;
    private String age;
    private String name;
    private Date  date;

    public HelloEntity() {

    }

    public HelloEntity(HeheEntity heheEntity) {
        BeanUtils.copyProperties(heheEntity, this);

        int eventId = heheEntity.getId();
        if (eventId != 0) {
            this.setId(String.valueOf(eventId));
        }
        int age = heheEntity.getAge();
        if (age != 0) {
            this.setAge(String.valueOf(age));
        }
    }

    @Override
    public String toString() {
        return "HelloEntity{id=" + id + ",name= " + name + ",age= " + age + "}";
    }


}
