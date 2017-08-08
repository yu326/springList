/*
 *
 * Copyright (c) 2017, inter3i.com. All rights reserved.
 * All rights reserved.
 *
 * Author: Administrator
 * Created: 2017/04/12
 * Description:
 *
 */

package yu.dao;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/23.
 */

public interface UserDao {
    List<Map<Object,Object>> query();
    Map getUserDirectCode(Map param1);
    Map getSourceId(Map param2);
}