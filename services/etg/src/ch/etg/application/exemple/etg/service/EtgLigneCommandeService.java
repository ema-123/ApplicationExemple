/*Copyright (c) 2018-2019 sqli.com All Rights Reserved.
 This software is the confidential and proprietary information of sqli.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with sqli.com*/
package ch.etg.application.exemple.etg.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import ch.etg.application.exemple.etg.EtgLigneCommande;
import ch.etg.application.exemple.etg.EtgLigneCommandeId;

/**
 * Service object for domain model class {@link EtgLigneCommande}.
 */
public interface EtgLigneCommandeService {

    /**
     * Creates a new EtgLigneCommande. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on EtgLigneCommande if any.
     *
     * @param etgLigneCommande Details of the EtgLigneCommande to be created; value cannot be null.
     * @return The newly created EtgLigneCommande.
     */
	EtgLigneCommande create(@Valid EtgLigneCommande etgLigneCommande);


	/**
	 * Returns EtgLigneCommande by given id if exists.
	 *
	 * @param etglignecommandeId The id of the EtgLigneCommande to get; value cannot be null.
	 * @return EtgLigneCommande associated with the given etglignecommandeId.
     * @throws EntityNotFoundException If no EtgLigneCommande is found.
	 */
	EtgLigneCommande getById(EtgLigneCommandeId etglignecommandeId) throws EntityNotFoundException;

    /**
	 * Find and return the EtgLigneCommande by given id if exists, returns null otherwise.
	 *
	 * @param etglignecommandeId The id of the EtgLigneCommande to get; value cannot be null.
	 * @return EtgLigneCommande associated with the given etglignecommandeId.
	 */
	EtgLigneCommande findById(EtgLigneCommandeId etglignecommandeId);

    /**
	 * Find and return the EtgLigneCommande for given id  if exists.
	 *
	 * @param id value of id; value cannot be null.
	 * @return EtgLigneCommande associated with the given inputs.
     * @throws EntityNotFoundException if no matching EtgLigneCommande found.
	 */
    EtgLigneCommande getByUniqueKeyId(int id)throws EntityNotFoundException;

	/**
	 * Updates the details of an existing EtgLigneCommande. It replaces all fields of the existing EtgLigneCommande with the given etgLigneCommande.
	 *
     * This method overrides the input field values using Server side or database managed properties defined on EtgLigneCommande if any.
     *
	 * @param etgLigneCommande The details of the EtgLigneCommande to be updated; value cannot be null.
	 * @return The updated EtgLigneCommande.
	 * @throws EntityNotFoundException if no EtgLigneCommande is found with given input.
	 */
	EtgLigneCommande update(@Valid EtgLigneCommande etgLigneCommande) throws EntityNotFoundException;

    /**
	 * Deletes an existing EtgLigneCommande with the given id.
	 *
	 * @param etglignecommandeId The id of the EtgLigneCommande to be deleted; value cannot be null.
	 * @return The deleted EtgLigneCommande.
	 * @throws EntityNotFoundException if no EtgLigneCommande found with the given id.
	 */
	EtgLigneCommande delete(EtgLigneCommandeId etglignecommandeId) throws EntityNotFoundException;

    /**
	 * Deletes an existing EtgLigneCommande with the given object.
	 *
	 * @param etgLigneCommande The instance of the EtgLigneCommande to be deleted; value cannot be null.
	 */
	void delete(EtgLigneCommande etgLigneCommande);

	/**
	 * Find all EtgLigneCommandes matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
	 *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
	 *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching EtgLigneCommandes.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
	 */
    @Deprecated
	Page<EtgLigneCommande> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Find all EtgLigneCommandes matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching EtgLigneCommandes.
     *
     * @see Pageable
     * @see Page
	 */
    Page<EtgLigneCommande> findAll(String query, Pageable pageable);

    /**
	 * Exports all EtgLigneCommandes matching the given input query to the given exportType format.
     * Note: Go through the documentation for <u>query</u> syntax.
	 *
     * @param exportType The format in which to export the data; value cannot be null.
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return The Downloadable file in given export type.
     *
     * @see Pageable
     * @see ExportType
     * @see Downloadable
	 */
    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the EtgLigneCommandes in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
	 * @return The count of the EtgLigneCommande.
	 */
	long count(String query);

	/**
	 * Retrieve aggregated values with matching aggregation info.
     *
     * @param aggregationInfo info related to aggregations.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
	 * @return Paginated data with included fields.

     * @see AggregationInfo
     * @see Pageable
     * @see Page
	 */
	Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable);


}

