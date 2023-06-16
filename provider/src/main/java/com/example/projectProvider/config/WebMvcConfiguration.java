/**
 * @projectName spring-cloud-micro-service-2021
 * @package com.example.projectProvider.config
 * @className com.example.projectProvider.config.WebMvcConfiguration
 */
package com.example.projectProvider.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * WebMvcConfiguration
 * @description WebMvcConfiguration 配置处理String 返回结果result异常，可参见如下文章
 * https://mp.weixin.qq.com/s?__biz=MzU1Nzg4NjgyMw==&mid=2247507501&idx=1&sn=dcaddc2ee6816b9c0ee56418635fa2b9&chksm=fc2c6225cb5beb33a9b8b6b70f68f50be867dd8406098608b89ef0ca7fddedee78e3714db94b&scene=132#wechat_redirect
 * @author chenzhicheng
 * @date 2023/6/16 16:10
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    /**
     * 交换MappingJackson2HttpMessageConverter与第一位元素
     * 让返回值类型为String的接口能正常返回包装结果
     *
     * @param converters initially an empty list of converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        for (int i = 0; i < converters.size(); i++) {
            if (converters.get(i) instanceof MappingJackson2HttpMessageConverter) {
                MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = (MappingJackson2HttpMessageConverter) converters.get(i);
                converters.set(i, converters.get(0));
                converters.set(0, mappingJackson2HttpMessageConverter);
                break;
            }
        }
    }
}
