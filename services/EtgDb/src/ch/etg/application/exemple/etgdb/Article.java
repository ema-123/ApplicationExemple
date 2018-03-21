/*Copyright (c) 2018-2019 sqli.com All Rights Reserved.
 This software is the confidential and proprietary information of sqli.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with sqli.com*/
package ch.etg.application.exemple.etgdb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Article generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`ARTICLE`", uniqueConstraints = {
            @UniqueConstraint(name = "`UK_ARTICLE_NUMERO`", columnNames = {"`NUMERO`"})})
public class Article implements Serializable {

    private Integer id;
    private int numero;
    private String libelle;
    private BigDecimal prix;
    private List<LigneCommande> ligneCommandes;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`NUMERO`", nullable = false, scale = 0, precision = 10)
    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Column(name = "`LIBELLE`", nullable = false, length = 255)
    public String getLibelle() {
        return this.libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Column(name = "`PRIX`", nullable = false, scale = 0, precision = 10)
    public BigDecimal getPrix() {
        return this.prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "article")
    @Cascade({CascadeType.SAVE_UPDATE})
    public List<LigneCommande> getLigneCommandes() {
        return this.ligneCommandes;
    }

    public void setLigneCommandes(List<LigneCommande> ligneCommandes) {
        this.ligneCommandes = ligneCommandes;
    }

    @PostPersist
    public void onPostPersist() {
        if(ligneCommandes != null) {
            for(LigneCommande ligneCommande : ligneCommandes) {
                ligneCommande.setArticle(this);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article)) return false;
        final Article article = (Article) o;
        return Objects.equals(getId(), article.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
