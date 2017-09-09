package util.Generator;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

public class CustomGenerator{

    @Test
    /**
     * 根据数据库生成相应mapper
     */
    public void testGenerator() throws InterruptedException {
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir("src\\main\\java");
        gc.setFileOverride(true);
        gc.setActiveRecord(true);
        gc.setEnableCache(true);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList
        gc.setAuthor("ZTF");

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sMapperGenerate");
        gc.setXmlName("%sMapper");
        gc.setServiceName("%sServiceGenerate");
        gc.setServiceImplName("%sServiceImplGenerate");
        gc.setControllerName("%sControllerGenerate");

        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        /*dsc.setTypeConvert(new MySqlTypeConvert(){
            // 自定义数据库表字段类型转换【可选】
            @Override
            public DbColumnType processTypeConvert(String fieldType) {
                System.out.println("转换类型：" + fieldType);
                return super.processTypeConvert(fieldType);
            }
        });*/

        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUrl("jdbc:mysql://localhost:3306/xunfang?useUnicode=true&characterEncoding=UTF-8&generateSimpleParameterMetadata=true&serverTimezone=UTC");
        dsc.setUsername("root");
        dsc.setPassword("admin");
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
//         strategy.setTablePrefix(new String[] { "tbl_" });// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        // strategy.setInclude(new String[] { "user" }); // 需要生成的表
        // strategy.setExclude(new String[]{"test"}); // 排除生成的表
        // 自定义 mapper 父类
         strategy.setSuperMapperClass("team.etop.xunfang.common.bean.SuperMapper");
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("team.etop.xunfang");
        pc.setEntity("po");
        pc.setModuleName("modules");
        mpg.setPackageInfo(pc);

        // 执行生成
        mpg.execute();
    }

}