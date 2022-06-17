package org.marsstudio.learn.design.dao;

import org.marsstudio.learn.design.po.School;

public interface ISchoolDao {

    School querySchoolInfoById(Long id);
}
