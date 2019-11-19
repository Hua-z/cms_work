package com.xj.apps.cms.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.xj.apps.cms.dao")
public class MybatisConfig {

}
