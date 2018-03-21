/*Copyright (c) 2018-2019 sqli.com All Rights Reserved.
 This software is the confidential and proprietary information of sqli.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with sqli.com*/
package ch.etg.application.exemple.etgdb;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * StatutCommande generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`STATUT_COMMANDE`")
public class StatutCommande implements Serializable {

    private Integer id;
    private String libelle;
    private List<Commande> commandes;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`ID`", nullable = false, scale = 0, precision = 10)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "`LIBELLE`", nullable = false, length = 255)
    public String getLibelle() {
        return this.libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "statutCommande")
    @Cascade({CascadeType.SAVE_UPDATE})
    public List<Commande> getCommandes() {
        return this.commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    @PostPersist
    public void onPostPersist() {
        if(commandes != null) {
            for(Commande commande : commandes) {
                commande.setStatutCommande(this);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StatutCommande)) return false;
        final StatutCommande statutCommande = (StatutCommande) o;
        return Objects.equals(getId(), statutCommande.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

