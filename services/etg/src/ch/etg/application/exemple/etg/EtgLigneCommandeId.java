/*Copyright (c) 2018-2019 sqli.com All Rights Reserved.
 This software is the confidential and proprietary information of sqli.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with sqli.com*/
package ch.etg.application.exemple.etg;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class EtgLigneCommandeId implements Serializable {

    private Integer id;
    private Integer numero;
    private Integer commandeId;
    private Integer articleId;
    private Integer nombreArticle;
    private BigDecimal totalArticle;
    private BigDecimal prixArticle;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumero() {
        return this.numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getCommandeId() {
        return this.commandeId;
    }

    public void setCommandeId(Integer commandeId) {
        this.commandeId = commandeId;
    }

    public Integer getArticleId() {
        return this.articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getNombreArticle() {
        return this.nombreArticle;
    }

    public void setNombreArticle(Integer nombreArticle) {
        this.nombreArticle = nombreArticle;
    }

    public BigDecimal getTotalArticle() {
        return this.totalArticle;
    }

    public void setTotalArticle(BigDecimal totalArticle) {
        this.totalArticle = totalArticle;
    }

    public BigDecimal getPrixArticle() {
        return this.prixArticle;
    }

    public void setPrixArticle(BigDecimal prixArticle) {
        this.prixArticle = prixArticle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EtgLigneCommande)) return false;
        final EtgLigneCommande etgLigneCommande = (EtgLigneCommande) o;
        return Objects.equals(getId(), etgLigneCommande.getId()) &&
                Objects.equals(getNumero(), etgLigneCommande.getNumero()) &&
                Objects.equals(getCommandeId(), etgLigneCommande.getCommandeId()) &&
                Objects.equals(getArticleId(), etgLigneCommande.getArticleId()) &&
                Objects.equals(getNombreArticle(), etgLigneCommande.getNombreArticle()) &&
                Objects.equals(getTotalArticle(), etgLigneCommande.getTotalArticle()) &&
                Objects.equals(getPrixArticle(), etgLigneCommande.getPrixArticle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),
                getNumero(),
                getCommandeId(),
                getArticleId(),
                getNombreArticle(),
                getTotalArticle(),
                getPrixArticle());
    }
}
