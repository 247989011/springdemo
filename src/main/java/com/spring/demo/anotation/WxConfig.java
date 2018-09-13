package com.spring.demo.anotation;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration//把要实例化的对象转化成一个Bean，放在IoC容器中，使用的时候可以用·@Autowired·等注解注入
//@ComponentScan("com.spring.demo")//定义扫描的路径从中找出标识了需要装配的类自动装配到spring的bean容器中
@PropertySource(value = "classpath:config.properties")
public class WxConfig {

    @Bean//产生一个bean的方法，并且交给Spring容器管理,生这个Bean对象的方法Spring只会调用一次,默认bean的名称就是其方法名。但是也可以指定名称：
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
    /**
     * 设置微信公众号的appid
     */
    @Value("${wechat.pay.appId}")
    private String appId;

    /**
     * 微信支付商户号
     */
    @Value("${wechat.pay.mchId}")
    private String mchId;

    /**
     * 微信支付商户密钥
     */
    @Value("${wechat.pay.mchKey}")
    private String mchKey;


    /**
     * apiclient_cert.p12文件的绝对路径，或者如果放在项目中，请以classpath:开头指定
     */
    @Value("${wechat.pay.keyPath}")
    private String keyPath;

    public String getAppId() {
        return this.appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getMchKey() {
        return mchKey;
    }

    public void setMchKey(String mchKey) {
        this.mchKey = mchKey;
    }

    public String getKeyPath() {
        return this.keyPath;
    }

    public void setKeyPath(String keyPath) {
        this.keyPath = keyPath;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this,
                ToStringStyle.MULTI_LINE_STYLE);
    }

}
