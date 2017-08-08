package yu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yu.dao.UserDao;
import yu.service.IUserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by koreyoshi on 2017/8/7.
 */
@Service
public class UserService implements IUserService {
    @Autowired
    private UserDao userDao;


    public List<Map<Object,Object>>   query() {
        Map param = new HashMap();
//        param.put("1",1);
        List<Map<Object,Object>> love = userDao.query();
        return love;
//        return param;

    }
}
