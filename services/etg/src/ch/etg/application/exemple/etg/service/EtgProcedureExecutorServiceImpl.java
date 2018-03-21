/*Copyright (c) 2018-2019 sqli.com All Rights Reserved.
 This software is the confidential and proprietary information of sqli.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with sqli.com*/

package ch.etg.application.exemple.etg.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wavemaker.runtime.data.dao.procedure.WMProcedureExecutor;

@Service
public class EtgProcedureExecutorServiceImpl implements EtgProcedureExecutorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EtgProcedureExecutorServiceImpl.class);

    @Autowired
    @Qualifier("etgWMProcedureExecutor")
    private WMProcedureExecutor procedureExecutor;


}


