package yu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by koreyoshi on 2017/7/25.
 */

@Controller
@RequestMapping("test")
public class TestController {
    @RequestMapping("index")
    @ResponseBody
    public  String index(){
        //输出日志文件
//        logger.info("the first jsp pages");
        //返回一个index.jsp这个视图
        return "suixin";
    }
}
