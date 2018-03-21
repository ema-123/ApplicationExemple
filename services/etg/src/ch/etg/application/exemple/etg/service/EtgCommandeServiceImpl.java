/*Copyright (c) 2018-2019 sqli.com All Rights Reserved.
 This software is the confidential and proprietary information of sqli.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with sqli.com*/
package ch.etg.application.exemple.etg.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.wavemaker.runtime.data.dao.WMGenericDao;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import ch.etg.application.exemple.etg.EtgCommande;


/**
 * ServiceImpl object for domain model class EtgCommande.
 *
 * @see EtgCommande
 */
@Service("etg.EtgCommandeService")
@Validated
public class EtgCommandeServiceImpl implements EtgCommandeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EtgCommandeServiceImpl.class);


    @Autowired
    @Qualifier("etg.EtgCommandeDao")
    private WMGenericDao<EtgCommande, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<EtgCommande, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "etgTransactionManager")
    @Override
	public EtgCommande create(EtgCommande etgCommande) {
        LOGGER.debug("Creating a new EtgCommande with information: {}", etgCommande);

        EtgCommande etgCommandeCreated = this.wmGenericDao.create(etgCommande);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(etgCommandeCreated);
    }

	@Transactional(readOnly = true, value = "etgTransactionManager")
	@Override
	public EtgCommande getById(Integer etgcommandeId) throws EntityNotFoundException {
        LOGGER.debug("Finding EtgCommande by id: {}", etgcommandeId);
        return this.wmGenericDao.findById(etgcommandeId);
    }

    @Transactional(readOnly = true, value = "etgTransactionManager")
	@Override
	public EtgCommande findById(Integer etgcommandeId) {
        LOGGER.debug("Finding EtgCommande by id: {}", etgcommandeId);
        try {
            return this.wmGenericDao.findById(etgcommandeId);
        } catch(EntityNotFoundException ex) {
            LOGGER.debug("No EtgCommande found with id: {}", etgcommandeId, ex);
            return null;
        }
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "etgTransactionManager")
	@Override
	public EtgCommande update(EtgCommande etgCommande) throws EntityNotFoundException {
        LOGGER.debug("Updating EtgCommande with information: {}", etgCommande);

        this.wmGenericDao.update(etgCommande);
        this.wmGenericDao.refresh(etgCommande);

        return etgCommande;
    }

    @Transactional(value = "etgTransactionManager")
	@Override
	public EtgCommande delete(Integer etgcommandeId) throws EntityNotFoundException {
        LOGGER.debug("Deleting EtgCommande with id: {}", etgcommandeId);
        EtgCommande deleted = this.wmGenericDao.findById(etgcommandeId);
        if (deleted == null) {
            LOGGER.debug("No EtgCommande found with id: {}", etgcommandeId);
            throw new EntityNotFoundException(String.valueOf(etgcommandeId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "etgTransactionManager")
	@Override
	public void delete(EtgCommande etgCommande) {
        LOGGER.debug("Deleting EtgCommande with {}", etgCommande);
        this.wmGenericDao.delete(etgCommande);
    }

	@Transactional(readOnly = true, value = "etgTransactionManager")
	@Override
	public Page<EtgCommande> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all EtgCommandes");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "etgTransactionManager")
    @Override
    public Page<EtgCommande> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all EtgCommandes");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "etgTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service etg for table EtgCommande to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "etgTransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "etgTransactionManager")
	@Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}

