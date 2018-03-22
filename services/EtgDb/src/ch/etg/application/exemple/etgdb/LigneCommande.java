/*Copyright (c) 2018-2019 sqli.com All Rights Reserved.
 This software is the confidential and proprietary information of sqli.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with sqli.com*/
package ch.etg.application.exemple.etgdb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * LigneCommande generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`LIGNE_COMMANDE`")
public class LigneCommande implements Serializable {

    private Integer id;
    private Integer commandeId;
    private int nombreArticle;
    private int articleId;
    private Article article;
    private Commande commande;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`COMMANDE_ID`", nullable = true, scale = 0, precision = 10)
    public Integer getCommandeId() {
        return this.commandeId;
    }

    public void setCommandeId(Integer commandeId) {
        this.commandeId = commandeId;
    }

    @Column(name = "`NOMBRE_ARTICLE`", nullable = false, scale = 0, precision = 10)
    public int getNombreArticle() {
        return this.nombreArticle;
    }

    public void setNombreArticle(int nombreArticle) {
        this.nombreArticle = nombreArticle;
    }

    @Column(name = "`ARTICLE_ID`", nullable = false, scale = 0, precision = 10)
    public int getArticleId() {
        return this.articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`ARTICLE_ID`", referencedColumnName = "`ID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_LIGNE_COMMANDE_TO_ARTHWeuq`"))
    @Fetch(FetchMode.JOIN)
    public Article getArticle() {
        return this.article;
    }

    public void setArticle(Article article) {
        if(article != null) {
            this.articleId = article.getId();
        }

        this.article = article;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`COMMANDE_ID`", referencedColumnName = "`ID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_LIGNE_COMMANDE_TO_COM0NpDF`"))
    @Fetch(FetchMode.JOIN)
    public Commande getCommande() {
        return this.commande;
    }

    public void setCommande(Commande commande) {
        if(commande != null) {
            this.commandeId = commande.getId();
        }

        this.commande = commande;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LigneCommande)) return false;
        final LigneCommande ligneCommande = (LigneCommande) o;
        return Objects.equals(getId(), ligneCommande.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

