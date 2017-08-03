package yu.config;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import yu.util.ValidateUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * Created by koreyoshi on 2017/8/3.
 */
//@Configuration
public class ConfigManager {
    public static final String HTTP_PROTOCAL_PERFIX = "http://";
    private AppConfig appConfig = null;

    public ConfigManager() {
        appConfig = AppConfig.getConfig();
    }

    public String geneSolrInsertURL4(final String cacheName) {
        return geneSolrInsertURL4(cacheName, false);
    }

    public String geneSolrInsertURL4(final String cacheName, boolean isCommit) {
        //获取solrname
        String solrName = this.getSolrNameBy(cacheName);
        String host = this.getSolrHostBy(solrName);
        int port = this.getSolrPortBy(solrName);
        return HTTP_PROTOCAL_PERFIX + host + ":" + port + appConfig.solrInserPath + "&commit=" + (isCommit ? "true" : "false");
    }

//    public String geneSolrSmartUpdateURL4(final String cacheName) {
//        Set<String> retainFieldSet = this.getSolrFieldsConfig().getRetainFields();
//        String retainFields = ListUtils.list2StringBy(",", retainFieldSet);
//        return geneSolrSmartUpdateURL4(cacheName, false, retainFields);
//    }

    public String geneSolrSmartUpdateURL4(final String cacheName, final boolean isCommit, final String retainFields) {
        //获取solrname
        String solrName = this.getSolrNameBy(cacheName);
        String host = this.getSolrHostBy(solrName);
        int port = this.getSolrPortBy(solrName);
        return HTTP_PROTOCAL_PERFIX + host + ":" + port + appConfig.solrUpdateSmartPath + ((null == retainFields || 0 == retainFields.length()) ?
                "" : "&retainFields=" + retainFields) + "&commit=" + (isCommit ? "true" : "false");
    }

    public String geneSolrDeleteURL4(final String cacheName) {
        return geneSolrDeleteURL4(cacheName, false);
    }

    public String geneSolrDeleteURL4(final String cacheName, boolean isCommit) {
        String solrName = this.getSolrNameBy(cacheName);
        String host = this.getSolrHostBy(solrName);
        int port = this.getSolrPortBy(solrName);
        return HTTP_PROTOCAL_PERFIX + host + ":" + port + appConfig.solrDeletePath + "&commit=" + (isCommit ? "true" : "false");
    }

    public String geneSolrUpdateURL4(final String cacheName) {
        return geneSolrUpdateURL4(cacheName, false);
    }

    public String geneSolrQeuryURL4(final String cacheName) {
        String solrName = this.getSolrNameBy(cacheName);
        String host = this.getSolrHostBy(solrName);
        int port = this.getSolrPortBy(solrName);
        return HTTP_PROTOCAL_PERFIX + host + ":" + port + appConfig.solrQueryPath;
    }

    public String geneSolrUpdateURL4(final String cacheName, boolean isCommit) {
        String solrName = this.getSolrNameBy(cacheName);
        String host = this.getSolrHostBy(solrName);
        int port = this.getSolrPortBy(solrName);
        return HTTP_PROTOCAL_PERFIX + host + ":" + port + appConfig.solrUpdatePath + "&commit=" + (isCommit ? "true" : "false");
    }

    public String geneSolrFlushURL4(final String cacheName) {
        String solrName = this.getSolrNameBy(cacheName);
        String host = this.getSolrHostBy(solrName);
        int port = this.getSolrPortBy(solrName);
        return HTTP_PROTOCAL_PERFIX + host + ":" + port + appConfig.solrFlushPath;
    }

//    public SolrFieldsConfig getSolrFieldsConfig() {
//        return appConfig.getSolrFieldsConfig();
//    }

    public String getSolrHostBy(final String solrName) {
        if (ValidateUtils.isNullOrEmpt(solrName)) {
            throw new RuntimeException("getSolrHostBy solrname excption,solrName is null.");
        }
        if (ValidateUtils.isNullOrEmpt(appConfig.solrNameSolrHostMap)) {
            throw new RuntimeException("getSolrHostBy solrname excption,solrNameSolrHostMap is null.");
        }
        if (!appConfig.solrNameSolrHostMap.containsKey(solrName)) {
            throw new RuntimeException("getSolrHostBy solrname excption. solrNameSolrHostMap not contains solrName:[" + solrName + "].");
        }
        return appConfig.solrNameSolrHostMap.get(solrName);
    }

    public int getSolrPortBy(final String solrName) {
        if (ValidateUtils.isNullOrEmpt(solrName)) {
            throw new RuntimeException("getSolrPortBy solrname excption,solrName is null.");
        }
        if (ValidateUtils.isNullOrEmpt(appConfig.solrNameSolrPortMap)) {
            throw new RuntimeException("getSolrPortBy solrname excption,solrNameSolrPortMap is null.");
        }
        if (!appConfig.solrNameSolrHostMap.containsKey(solrName)) {
            throw new RuntimeException("getSolrPortBy solrname excption. solrNameSolrPortMap not contains solrName:[" + solrName + "].");
        }
        return appConfig.solrNameSolrPortMap.get(solrName);
    }

    public String getSolrNameBy(final String cacheName) {
        if (ValidateUtils.isNullOrEmpt(cacheName)) {
            throw new RuntimeException("getSolrNameBy cacheName excption,cacheName is null.");
        }
        if (ValidateUtils.isNullOrEmpt(appConfig.cacheNameSolrNameMap)) {
            throw new RuntimeException("getSolrNameBy cacheName excption,cacheNameSolrNameMap is null.");
        }
        if (!appConfig.cacheNameSolrNameMap.containsKey(cacheName)) {
            throw new RuntimeException("getSolrNameBy cacheName excption. cacheNameSolrNameMap not contains cacheName:[" + cacheName + "].");
        }
        return appConfig.cacheNameSolrNameMap.get(cacheName);
    }


    private static class AppConfig {
        private static AppConfig instance = null;

        private Map<String, String> solrNameSolrHostMap = new HashMap<String, String>(4);
        private Map<String, Integer> solrNameSolrPortMap = new HashMap<String, Integer>(4);
        private Map<String, String> cacheNameSolrNameMap = new HashMap<String, String>(4);

        private String solrInserPath = null;
        private String solrUpdatePath = null;
        private String solrUpdateSmartPath = null;
        private String solrDeletePath = null;
        private String solrQueryPath = null;

        private String solrFlushPath = null;

//        private SolrFieldsConfig solrFieldsConfig;

        public static AppConfig getConfig() {
            if (instance != null) {
                return instance;
            }

            synchronized (AppConfig.class) {
                if (instance != null) {
                    return instance;
                }

                //初始化该配置类
                AppConfig tmp = null;
                try {
                    tmp = new AppConfig();
                    Resource resource = new ClassPathResource("appconfig.properties");
                    Properties props = PropertiesLoaderUtils.loadProperties(resource);

                    Iterator it = props.keySet().iterator();
                    String key = null;
                    while (it.hasNext()) {
                        key = (String) it.next();
                        if (key.startsWith("ds.solr.host[")) {
                            tmp.addSolrHost4(getKeyIn(key), (String) props.get(key));
                        } else if (key.startsWith("ds.solr.port[")) {
                            int port = Integer.valueOf((String) props.get(key));
                            tmp.addSolrPort4(getKeyIn(key), port);
                        } else if ("ds.solr.insert.path".equals(key)) {
                            tmp.solrInserPath = (String) props.get(key);
                        } else if ("ds.solr.flush.path".equals(key)) {
                            tmp.solrFlushPath = (String) props.get(key);
                        } else if ("ds.solr.update.path".equals(key)) {
                            tmp.solrUpdatePath = (String) props.get(key);
                        } else if ("ds.solr.delete.path".equals(key)) {
                            tmp.solrDeletePath = (String) props.get(key);
                        } else if (key.startsWith("ds.cacheSolrMap[")) {
                            tmp.cacheNameSolrNameMap.put(getKeyIn(key), (String) props.get(key));
                        } else if ("ds.solr.query.path".equals(key)) {
                            tmp.solrQueryPath = (String) props.get(key);
                        } else if ("ds.solr.updateSmart.path".equals(key)) {
                            tmp.solrUpdateSmartPath = (String) props.get(key);
                        }
                    }

                    //设置solr字段信息配置
//                    tmp.solrFieldsConfig = new SolrFieldsConfig();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                instance = tmp;
                return instance;
            }
        }

        private void addSolrHost4(final String cacheName, final String solrHost) {
            this.solrNameSolrHostMap.put(cacheName, solrHost);
        }

        private void addSolrPort4(final String cacheName, final int solrHost) {
            this.solrNameSolrPortMap.put(cacheName, solrHost);
        }

//        public SolrFieldsConfig getSolrFieldsConfig() {
//            return solrFieldsConfig;
//        }
    }


    private static String getKeyIn(String key) {
        return key.substring(key.indexOf("[") + 1, key.length() - 1);
    }
}
