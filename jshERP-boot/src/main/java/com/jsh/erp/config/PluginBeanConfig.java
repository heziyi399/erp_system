package com.jsh.erp.config;

import com.gitee.starblues.extension.mybatis.SpringBootMybatisExtension;
import com.gitee.starblues.integration.application.AutoPluginApplication;
import com.gitee.starblues.integration.application.PluginApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: jishenghua
 * @Version: 1.0
 * @Create Date Time: 2019-05-30 15:53
 * @Update Date Time:
 * @see
 */
//扩展 PluginApplication
//扩展说明
//方法一：自主实现 PluginApplication 接口。
//方法二：继承 DefaultPluginApplication 或者 AutoPluginApplication， 重写自定义方法
//http://www.starblues.cn/extension-doc/%E8%87%AA%E5%AE%9A%E4%B9%89%E6%89%A9%E5%B1%95.html#%E6%89%A9%E5%B1%95-pluginapplication
@Configuration
public class PluginBeanConfig {
    @Bean
    public PluginApplication pluginApplication(){
        PluginApplication pluginApplication = new AutoPluginApplication();
        pluginApplication.addExtension(new SpringBootMybatisExtension());
        return pluginApplication;
    }
}
