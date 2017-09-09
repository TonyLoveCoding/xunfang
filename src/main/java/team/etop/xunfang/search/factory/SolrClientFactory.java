package team.etop.xunfang.search.factory;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import team.etop.xunfang.common.Exception.SolrClientFactoryException;

/**
 * @version V1.0
 * @Description:Solr客户端对象工厂
 * @author: TingFeng Zhang
 * @date: 2017/8/16 15:55
 */
public class SolrClientFactory {
    public SolrClient getSolrClientInstance(String baseURL) throws SolrClientFactoryException {
        if(!"".equals(baseURL)&&baseURL!=null){
            return  new HttpSolrClient.Builder(baseURL).build();
        }
        throw new SolrClientFactoryException("URL地址错误！");
    }
}
