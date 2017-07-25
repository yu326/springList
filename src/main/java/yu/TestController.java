package yu;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by koreyoshi on 2017/7/25.
 */

@Controller
@RequestMapping("test")
public class TestController {

    private static final Logger logger = LogManager.getLogger(TestController.class);

    @RequestMapping("index")
//    @ResponseBody
    public  String index(){
        //输出日志文件
//        logger.info("the first jsp pages");
        logger.debug("the debug message");
        logger.error("the error message");
        //返回一个index.jsp这个视图
        return "index";
    }
}
