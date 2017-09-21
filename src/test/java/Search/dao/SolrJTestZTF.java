package Search.dao;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import team.etop.xunfang.modules.mapper.*;
import team.etop.xunfang.modules.po.Estate;
import team.etop.xunfang.search.mapper.DicMapper;
import util.EstateUtil.getEstateZTF;

import java.io.IOException;

/**
 * @version V1.0
 * @Description:solr的测试
 * @author: TingFeng Zhang
 * @date: 2017/8/12 14:55
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class SolrJTestZTF {

    @Autowired
    DicMapper dicDao;

    @Autowired
    SolrClient solrClient;

    @Autowired
    EffectPictureMapperGenerate effectPictureDao;

    @Autowired
    EstateMapperGenerate estateDao;


    @Autowired
    RealEstatePictureMapperGenerate realEstatePictureMapperGenerate;

    @Autowired
    PrototypeRoomPictureMapperGenerate prototypeRoomPictureMapperGenerate;

    @Autowired
    SamplePlanningPictureMapperGenerate samplePlanningPictureMapperGenerate;

    @Test
    /**
     * 新增文档
     */
    public void creteDoc() throws IOException, SolrServerException {
        SolrInputDocument solrInputFields=new SolrInputDocument();
        Estate estate = getEstateZTF.returnEstate(dicDao, effectPictureDao,realEstatePictureMapperGenerate,prototypeRoomPictureMapperGenerate,samplePlanningPictureMapperGenerate);
        estateDao.insert(estate);
        solrInputFields.addField("id",estate.getId());
        solrInputFields.addField("estate_visit_times",estate.getVisitTimes());
        solrInputFields.addField("estate_min_price",estate.getMinPrice());
        solrInputFields.addField("estate_max_price",estate.getMaxPrice());
        solrInputFields.addField("estate_developer_quotes",estate.getDeveloperQuotes());
        solrInputFields.addField("estate_location",estate.getLocation());
        solrInputFields.addField("estate_type",estate.getType());
        solrInputFields.addField("estate_house_type",estate.getHouseType());
        solrInputFields.addField("estate_feature",estate.getFeature());
        solrInputFields.addField("estate_name",estate.getEstateName());
        solrInputFields.addField("estate_address",estate.getEstateAddress());
        solrInputFields.addField("estate_update_time",estate.getUpdateTime());
        solrInputFields.addField("estate_create_time",estate.getCreateTime());
        solrInputFields.addField("estate_thumbnail",estate.getThumbnail());
        solrInputFields.addField("estate_status",estate.getStatus());
        solrInputFields.addField("estate_sale_status",estate.getSaleStatus());
        solrClient.add(solrInputFields);
        solrClient.commit();
    }

    @Test
    /**
     * 删除所有文档
     */
    public  void deleteAllDoc() throws IOException, SolrServerException {
        solrClient.deleteByQuery("*:*");
        solrClient.commit();
    }

}
