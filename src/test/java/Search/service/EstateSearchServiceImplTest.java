package Search.service;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import team.etop.xunfang.search.bo.EstateSearchBo;
import team.etop.xunfang.search.mapper.EstateSearchMapper;

import java.util.List;

/**
 * @version V1.0
 * @Description:楼盘搜索服务测试
 * @author: TingFeng Zhang
 * @date: 2017/8/13 23:43
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class EstateSearchServiceImplTest {
    @Autowired
    EstateSearchMapper estateSearchMapper;

    @Value("${solr.baseURL}")
    String baseURL;

    /**
     * 测试全量更新是否正常
     * @throws Exception
     */
    @Test
    public void testFullUpdate() throws Exception {
        SolrClient solrClient=new HttpSolrClient.Builder(baseURL).build();
        solrClient.deleteByQuery("*:*");
        solrClient.commit();
        System.out.println("测试");
        List<EstateSearchBo> estateSearchBos = estateSearchMapper.selectAll();
        for(EstateSearchBo estateSearchBo : estateSearchBos){
            System.out.println(estateSearchBo);
        }
    }
}
