/*Copyright (c) 2018-2019 sqli.com All Rights Reserved.
 This software is the confidential and proprietary information of sqli.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with sqli.com*/
package ch.etg.application.exemple.etgdb.dao;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.wavemaker.runtime.data.dao.WMGenericDaoImpl;

import ch.etg.application.exemple.etgdb.Article;

/**
 * Specifies methods used to obtain and modify Article related information
 * which is stored in the database.
 */
@Repository("EtgDb.ArticleDao")
public class ArticleDao extends WMGenericDaoImpl<Article, Integer> {

    @Autowired
    @Qualifier("EtgDbTemplate")
    private HibernateTemplate template;


    @Override
    public HibernateTemplate getTemplate() {
        return this.template;
    }
}

