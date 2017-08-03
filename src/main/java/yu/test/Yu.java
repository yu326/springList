package yu.test;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

/**
 * Created by koreyoshi on 2017/8/3.
 */
@Configuration
public class Yu {
    private Yi yi = null;
    public static final String HTTP_PROTOCAL_PERFIX = "http://";

    public Yu() {
        yi = Yi.getconfig();
    }

    public String getNameByKey(String key) {
        return yi.demoMap.get(key);
    }

    public String getSolrName(final String cacheName) {
        return yi.cacheSolrMap.get(cacheName);
    }

    public String getSolrHost(final String solrName) {
        return yi.cacheSolrHostMap.get(solrName);
    }

    public String getSolrPort(final String solrName) {
        return yi.cacheSolrPortMap.get(solrName);
    }

    public String geneSolrSelect(String cacheName) {
        boolean isCommit = false;
        String solrName = getSolrName(cacheName);
        String solrHost = getSolrHost(solrName);
        String solrPort = getSolrPort(solrName);
        return HTTP_PROTOCAL_PERFIX + solrHost + ":" + solrPort + yi.solrQueryPath;
    }

    public String geneSolrInsert(String cacheName) {
        boolean isCommit = false;
        String solrName = getSolrName(cacheName);
        String solrHost = getSolrHost(solrName);
        String solrPort = getSolrPort(solrName);
        return HTTP_PROTOCAL_PERFIX + solrHost + ":" + solrPort + yi.solrInsertPath + "&commit=" + (isCommit ? "true" : "false");
    }


    public static class Yi {
        private static Yi instance = null;

        private HashMap<String, String> demoMap = new HashMap<String, String>(4);
        private HashMap<String, String> cacheSolrMap = new HashMap<String, String>(4);
        private HashMap<String, String> cacheSolrHostMap = new HashMap<String, String>(4);
        private HashMap<String, String> cacheSolrPortMap = new HashMap<String, String>(4);
        private String solrFlushPath = null;
        private String solrInsertPath = null;
        private String solrUpdatePath = null;
        private String solrDeletePath = null;
        private String solrUpdateSmartPath = null;
        private String solrQueryPath = null;

        public static Yi getconfig() {
            if (instance != null) {
                return instance;
            }
            synchronized (Yi.class) {
                if (instance != null) {
                    return instance;
                }
                Yi tmp = null;
                try {
                    tmp = new Yi();
                    Resource resource = new ClassPathResource("solrconfig.properties");
                    Properties props = PropertiesLoaderUtils.loadProperties(resource);
                    Iterator it = props.keySet().iterator();
                    String key = null;
                    while (it.hasNext()) {
                        key = (String) it.next();
                        System.out.println(key);
                        if (key.startsWith("ds.solrMap[")) {
                            tmp.addSolrMap(getKeyIn(key), (String) props.get(key));
                        } else if (key.startsWith("ds.solr.host[")) {
                            tmp.addSolrHost(getKeyIn(key), (String) props.get(key));
                        } else if (key.startsWith("ds.solr.port[")) {
                            tmp.addSolrPort(getKeyIn(key), (String) props.get(key));
                        } else if (key.startsWith("ds.solr.flush.path")) {
                            tmp.solrFlushPath = (String) props.get(key);
                        } else if (key.startsWith("ds.solr.insert.path")) {
                            tmp.solrInsertPath = (String) props.get(key);
                        } else if (key.startsWith("ds.solr.update.path")) {
                            tmp.solrUpdatePath = (String) props.get(key);
                        } else if (key.startsWith("ds.solr.delete.path")) {
                            tmp.solrDeletePath = (String) props.get(key);
                        } else if (key.startsWith("ds.solr.updateSmart.path")) {
                            tmp.solrUpdateSmartPath = (String) props.get(key);
                        } else if (key.startsWith("ds.solr.query.path")) {
                            tmp.solrQueryPath = (String) props.get(key);
                        }
                        System.out.println((String) props.get(key));
                    }


                    tmp.addValue();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                instance = tmp;
            }
            return instance;
        }


        public void addValue() {
            this.demoMap.put("test", "123");
        }


        public void addSolrMap(String key, String value) {
            this.cacheSolrMap.put(key, value);
        }

        public void addSolrHost(String key, String value) {
            this.cacheSolrHostMap.put(key, value);
        }

        public void addSolrPort(String key, String value) {
            this.cacheSolrPortMap.put(key, value);
        }


        private static String getKeyIn(String key) {
            return key.substring(key.indexOf("[") + 1, key.length() - 1);
        }
    }
}
