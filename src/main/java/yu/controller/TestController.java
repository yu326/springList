package yu.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import yu.service.IUserService;
import yu.test.Yu;

import java.io.IOException;
import java.util.List;

/**
 * Created by koreyoshi on 2017/7/25.
 */

@Controller
@RequestMapping("test")
public class TestController {

    private static final Logger logger = LogManager.getLogger(TestController.class);

    //注解
//    @Autowired
//    private TitleService titleService;
//
//    @Autowired
//    private ConfigManager configManager;

//    @Autowired
//    private Outer outer;

    @Autowired
    private Yu yu;


    @Autowired
    private IUserService iUserService;


    @RequestMapping("index")
    @ResponseBody
    public  String index() throws IOException {



        geta();



//        测试注入
//        String s = outer.getSolrNameBy("Test");
//        System.out.println(s);
//        String s = yu.getSolrName("cache01");
//        String selectUrl = yu.geneSolrSelect("cache01");
//        System.out.println(s);
//        System.out.println(selectUrl);

//        String title = titleService.setTitle();
//        System.out.println(title);
//        String url = configManager.geneSolrInsertURL4("cache01");
//        String url1 = configManager.geneSolrInsertURL4("cache2");
//
//        System.out.println(url);
//        System.out.println(url1);


//        引入配置文件
//        Resource resource = new ClassPathResource("appconfig.properties");
//        Properties props = PropertiesLoaderUtils.loadProperties(resource);
//
//        Iterator it = props.keySet().iterator();
//        String key = null;
//
//        while (it.hasNext()) {
//            key = (String) it.next();
//
//            System.out.println(key);
//            String Value = (String) props.get(key);
//            System.out.println(Value);
//        }




        //输出日志文件
//        logger.info("the first jsp pages");
//        logger.debug("the debug message");
//        logger.error("the error message");
        //返回一个index.jsp这个视图
        return "index";
    }
    public void geta(){
        List a = iUserService.query();
        System.out.println(a);
    }
}
