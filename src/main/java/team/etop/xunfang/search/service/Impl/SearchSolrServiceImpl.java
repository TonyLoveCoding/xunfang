package team.etop.xunfang.search.service.Impl;

import org.apache.solr.client.solrj.SolrClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import team.etop.xunfang.common.util.SearchUtil;
import team.etop.xunfang.search.bo.EstateSearchBo;
import team.etop.xunfang.search.mapper.EstateSearchMapper;
import team.etop.xunfang.search.service.SearchSolrService;

import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Service
public class SearchSolrServiceImpl implements SearchSolrService{
    @Autowired
    EstateSearchMapper estateSearchMapper;
    @Autowired
    SolrClient solrClient;
    @Value("${solr.fullUpdateURL}")
    String fullUpdateURL;

    /**
     * 全量更新
     * @throws Exception
     */
    @Override
    public void fullUpdate() throws Exception {
            //创建一个URL对象
            URL url=new URL(fullUpdateURL);
            //打开一个HttpURLConnection连接
            HttpURLConnection urlConn=(HttpURLConnection)url.openConnection();
            //设置连接超时的时间
            urlConn.setDoOutput(true);
            //在使用post请求的时候，设置不能使用缓存
            urlConn.setUseCaches(false);
            //设置该请求为post请求
            urlConn.setRequestMethod("GET");
            urlConn.setInstanceFollowRedirects(true);
            //配置请求content-type
            urlConn.setRequestProperty("Content-Type", "application/json, text/javascript");
            //执行连接操作
            urlConn.connect();
            //发送请求的参数
            DataOutputStream dos=new DataOutputStream(urlConn.getOutputStream());
            dos.flush();
            dos.close();
            if(urlConn.getResponseCode()==200){
                //显示
                InputStreamReader isr = new InputStreamReader(urlConn.getInputStream(), "utf-8");
                int i;
                String strResult = "";
                // read
                while ((i = isr.read()) != -1) {
                    strResult = strResult + (char) i;
                }
                isr.close();
            }
    }

    /**
     * 增加(更新)楼盘-在索引中创建新文档
     * @param estateSearchBo
     * @throws Exception
     */
    @Override
    public void addEstate(EstateSearchBo estateSearchBo) throws Exception {
        solrClient.add(SearchUtil.EstateToDoc(estateSearchBo));
        solrClient.commit();
    }

    /**
     * 删除楼盘-在索引中删除文档
     * @param id
     * @throws Exception
     */
    @Override
    public void deleteEstate(Long id) throws Exception {
        solrClient.deleteByQuery("id:"+id);
        solrClient.commit();
    }
}
