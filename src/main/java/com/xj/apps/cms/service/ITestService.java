package com.xj.apps.cms.service;

import com.xj.apps.cms.bean.Test;

import java.util.List;

public interface ITestService {
    List<Test> findAll();

    void saveOrUpdate(Test test);
}
