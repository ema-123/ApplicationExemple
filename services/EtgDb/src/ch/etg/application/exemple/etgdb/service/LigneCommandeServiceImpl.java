/*Copyright (c) 2018-2019 sqli.com All Rights Reserved.
 This software is the confidential and proprietary information of sqli.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with sqli.com*/
package ch.etg.application.exemple.etgdb.service;

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

import ch.etg.application.exemple.etgdb.LigneCommande;


/**
 * ServiceImpl object for domain model class LigneCommande.
 *
 * @see LigneCommande
 */
@Service("EtgDb.LigneCommandeService")
@Validated
public class LigneCommandeServiceImpl implements LigneCommandeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LigneCommandeServiceImpl.class);


    @Autowired
    @Qualifier("EtgDb.LigneCommandeDao")
    private WMGenericDao<LigneCommande, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<LigneCommande, Integer> wmGenericDao) {
        this.wmGenericDao = wmGenericDao;
    }

    @Transactional(value = "EtgDbTransactionManager")
    @Override
	public LigneCommande create(LigneCommande ligneCommande) {
        LOGGER.debug("Creating a new LigneCommande with information: {}", ligneCommande);

        LigneCommande ligneCommandeCreated = this.wmGenericDao.create(ligneCommande);
        // reloading object from database to get database defined & server defined values.
        return this.wmGenericDao.refresh(ligneCommandeCreated);
    }

	@Transactional(readOnly = true, value = "EtgDbTransactionManager")
	@Override
	public LigneCommande getById(Integer lignecommandeId) throws EntityNotFoundException {
        LOGGER.debug("Finding LigneCommande by id: {}", lignecommandeId);
        return this.wmGenericDao.findById(lignecommandeId);
    }

    @Transactional(readOnly = true, value = "EtgDbTransactionManager")
	@Override
	public LigneCommande findById(Integer lignecommandeId) {
        LOGGER.debug("Finding LigneCommande by id: {}", lignecommandeId);
        try {
            return this.wmGenericDao.findById(lignecommandeId);
        } catch(EntityNotFoundException ex) {
            LOGGER.debug("No LigneCommande found with id: {}", lignecommandeId, ex);
            return null;
        }
    }


	@Transactional(rollbackFor = EntityNotFoundException.class, value = "EtgDbTransactionManager")
	@Override
	public LigneCommande update(LigneCommande ligneCommande) throws EntityNotFoundException {
        LOGGER.debug("Updating LigneCommande with information: {}", ligneCommande);

        this.wmGenericDao.update(ligneCommande);
        this.wmGenericDao.refresh(ligneCommande);

        return ligneCommande;
    }

    @Transactional(value = "EtgDbTransactionManager")
	@Override
	public LigneCommande delete(Integer lignecommandeId) throws EntityNotFoundException {
        LOGGER.debug("Deleting LigneCommande with id: {}", lignecommandeId);
        LigneCommande deleted = this.wmGenericDao.findById(lignecommandeId);
        if (deleted == null) {
            LOGGER.debug("No LigneCommande found with id: {}", lignecommandeId);
            throw new EntityNotFoundException(String.valueOf(lignecommandeId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(value = "EtgDbTransactionManager")
	@Override
	public void delete(LigneCommande ligneCommande) {
        LOGGER.debug("Deleting LigneCommande with {}", ligneCommande);
        this.wmGenericDao.delete(ligneCommande);
    }

	@Transactional(readOnly = true, value = "EtgDbTransactionManager")
	@Override
	public Page<LigneCommande> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all LigneCommandes");
        return this.wmGenericDao.search(queryFilters, pageable);
    }

    @Transactional(readOnly = true, value = "EtgDbTransactionManager")
    @Override
    public Page<LigneCommande> findAll(String query, Pageable pageable) {
        LOGGER.debug("Finding all LigneCommandes");
        return this.wmGenericDao.searchByQuery(query, pageable);
    }

    @Transactional(readOnly = true, value = "EtgDbTransactionManager")
    @Override
    public Downloadable export(ExportType exportType, String query, Pageable pageable) {
        LOGGER.debug("exporting data in the service EtgDb for table LigneCommande to {} format", exportType);
        return this.wmGenericDao.export(exportType, query, pageable);
    }

	@Transactional(readOnly = true, value = "EtgDbTransactionManager")
	@Override
	public long count(String query) {
        return this.wmGenericDao.count(query);
    }

    @Transactional(readOnly = true, value = "EtgDbTransactionManager")
	@Override
    public Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable) {
        return this.wmGenericDao.getAggregatedValues(aggregationInfo, pageable);
    }



}

