/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author charlotte
 */
@Entity
@Table(name = "CLIENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findByNumclient", query = "SELECT c FROM Client c WHERE c.numclient = :numclient"),
    @NamedQuery(name = "Client.findByNomclient", query = "SELECT c FROM Client c WHERE c.nomclient = :nomclient"),
    @NamedQuery(name = "Client.findByPrenomclient", query = "SELECT c FROM Client c WHERE c.prenomclient = :prenomclient"),
    @NamedQuery(name = "Client.findByMotdepasse", query = "SELECT c FROM Client c WHERE c.motdepasse = :motdepasse"),
    @NamedQuery(name = "Client.findByAdrNumrue", query = "SELECT c FROM Client c WHERE c.adrNumrue = :adrNumrue"),
    @NamedQuery(name = "Client.findByAdrNomrue", query = "SELECT c FROM Client c WHERE c.adrNomrue = :adrNomrue"),
    @NamedQuery(name = "Client.findByNumtel", query = "SELECT c FROM Client c WHERE c.numtel = :numtel"),
    @NamedQuery(name = "Client.findByEmail", query = "SELECT c FROM Client c WHERE c.email = :email")})
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NUMCLIENT")
    private Integer numclient;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NOMCLIENT")
    private String nomclient;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PRENOMCLIENT")
    private String prenomclient;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "MOTDEPASSE")
    private String motdepasse;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "ADR_NUMRUE")
    private String adrNumrue;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ADR_NOMRUE")
    private String adrNomrue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMTEL")
    private long numtel;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EMAIL")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numclient")
    private Collection<Commande> commandeCollection;
    @JoinColumns({
        @JoinColumn(name = "ADR_CODEPOSTAL", referencedColumnName = "CODEPOSTAL"),
        @JoinColumn(name = "ADR_LOCALITE", referencedColumnName = "VILLE")})
    @ManyToOne(optional = false)
    private Localite localite;

    public Client() {
    }

    public Client(Integer numclient) {
        this.numclient = numclient;
    }

    public Client(Integer numclient, String nomclient, String prenomclient, String motdepasse, String adrNumrue, String adrNomrue, long numtel, String email) {
        this.numclient = numclient;
        this.nomclient = nomclient;
        this.prenomclient = prenomclient;
        this.motdepasse = motdepasse;
        this.adrNumrue = adrNumrue;
        this.adrNomrue = adrNomrue;
        this.numtel = numtel;
        this.email = email;
    }

    public Integer getNumclient() {
        return numclient;
    }

    public void setNumclient(Integer numclient) {
        this.numclient = numclient;
    }

    public String getNomclient() {
        return nomclient;
    }

    public void setNomclient(String nomclient) {
        this.nomclient = nomclient;
    }

    public String getPrenomclient() {
        return prenomclient;
    }

    public void setPrenomclient(String prenomclient) {
        this.prenomclient = prenomclient;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public String getAdrNumrue() {
        return adrNumrue;
    }

    public void setAdrNumrue(String adrNumrue) {
        this.adrNumrue = adrNumrue;
    }

    public String getAdrNomrue() {
        return adrNomrue;
    }

    public void setAdrNomrue(String adrNomrue) {
        this.adrNomrue = adrNomrue;
    }

    public long getNumtel() {
        return numtel;
    }

    public void setNumtel(long numtel) {
        this.numtel = numtel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<Commande> getCommandeCollection() {
        return commandeCollection;
    }

    public void setCommandeCollection(Collection<Commande> commandeCollection) {
        this.commandeCollection = commandeCollection;
    }

    public Localite getLocalite() {
        return localite;
    }

    public void setLocalite(Localite localite) {
        this.localite = localite;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numclient != null ? numclient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.numclient == null && other.numclient != null) || (this.numclient != null && !this.numclient.equals(other.numclient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Client[ numclient=" + numclient + " ]";
    }
    
}
