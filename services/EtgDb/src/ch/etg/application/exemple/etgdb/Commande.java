/*Copyright (c) 2018-2019 sqli.com All Rights Reserved.
 This software is the confidential and proprietary information of sqli.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with sqli.com*/
package ch.etg.application.exemple.etgdb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Commande generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`COMMANDE`")
public class Commande implements Serializable {

    private Integer id;
    private String client;
    private Date dateCommande;
    private int commandeStatut;
    private StatutCommande statutCommande;
    private List<LigneCommande> ligneCommandes;
    private BigDecimal total;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`CLIENT`", nullable = false, length = 255)
    public String getClient() {
        return this.client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    @Column(name = "`DATE_COMMANDE`", nullable = false)
    public Date getDateCommande() {
        return this.dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    @Column(name = "`COMMANDE_STATUT`", nullable = false, scale = 0, precision = 10)
    public int getCommandeStatut() {
        return this.commandeStatut;
    }

    public void setCommandeStatut(int commandeStatut) {
        this.commandeStatut = commandeStatut;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`COMMANDE_STATUT`", referencedColumnName = "`ID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_COMMANDE_TO_STATUT_COVzr36`"))
    @Fetch(FetchMode.JOIN)
    public StatutCommande getStatutCommande() {
        return this.statutCommande;
    }

    public void setStatutCommande(StatutCommande statutCommande) {
        if(statutCommande != null) {
            this.commandeStatut = statutCommande.getId();
        }

        this.statutCommande = statutCommande;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "commande")
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
                ligneCommande.setCommande(this);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Commande)) return false;
        final Commande commande = (Commande) o;
        return Objects.equals(getId(), commande.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

