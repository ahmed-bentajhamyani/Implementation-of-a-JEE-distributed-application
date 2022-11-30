package ma.fstt.persistence;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "etudiant")
public class Etudiant implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_etudiant")
	private Long idEtudiant;

	@Column(name = "nom", length = 50)
	private String nom;

	@Column(name = "prenom", length = 50)
	private String prenom;

	@Column(name = "cne", length = 15)
	private String cne;

	@Column(name = "adresse", length = 255)
	private String adresse;

	@Column(name = "niveau", length = 15)
	private String niveau;

	public Etudiant(Long idEtudiant, String nom, String prenom, String cne, String adresse, String niveau) {
		super();
		this.idEtudiant = idEtudiant;
		this.nom = nom;
		this.prenom = prenom;
		this.cne = cne;
		this.adresse = adresse;
		this.niveau = niveau;
	}

	public Etudiant(String nom, String prenom, String cne, String adresse, String niveau) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.cne = cne;
		this.adresse = adresse;
		this.niveau = niveau;
	}

	public Etudiant() {
		super();
	}

	public Long getIdEtudiant() {
		return idEtudiant;
	}

	public void setIdEtudiant(Long idEtudiant) {
		this.idEtudiant = idEtudiant;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getCne() {
		return cne;
	}

	public void setCne(String cne) {
		this.cne = cne;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

}
