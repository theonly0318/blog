package top.guoshihua.blog.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

/**
 * @ClassName CustomizeDataSourceInitializer
 * @Description: 自定义数据库初始化配置类
 * @Author guoshihua
 * @Date 2020/8/2 0002 下午 5:53
 * @Version V1.0
 * @See 版权声明
 **/
@Configuration
public class CustomizeDataSourceInitializer {
    @Value("${spring.datasource.schema}")
    private Resource sqlScriptSchema;
    @Value("${spring.datasource.separator}")
    private String separator;

    @Bean
    public DataSourceInitializer dataSourceInitializer(@Qualifier("druidDataSource") DataSource dataSource){
        DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
        dataSourceInitializer.setDataSource(dataSource);
        dataSourceInitializer.setDatabasePopulator(databasePopulator());
        return dataSourceInitializer;
    }

    private DatabasePopulator databasePopulator(){
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(sqlScriptSchema);
        populator.setSeparator(separator); // 分隔符，默认为;
        return populator;
    }
}
