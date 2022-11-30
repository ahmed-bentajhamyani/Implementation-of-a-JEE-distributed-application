package ma.fstt.business.impl;

import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import ma.fstt.business.EtudiantRemote;
import ma.fstt.persistence.Etudiant;

@Stateless
public class ManageEtudiantBean implements EtudiantRemote {

	@PersistenceContext(unitName = "Etudiant")
	private EntityManager entityManager;

	public ManageEtudiantBean() {
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Etudiant> getAllEtudiants() {
		Query queryObj = entityManager.createQuery("SELECT e FROM Etudiant e");
		List<Etudiant> etudiants = queryObj.getResultList();
		if (etudiants != null && etudiants.size() > 0) {
			for (Etudiant cd : etudiants)
				entityManager.refresh(cd);
			return etudiants;
		} else {
			return null;
		}
	}

	@Override
	public Etudiant getEtudiant(Long id) {
		Etudiant etudiant = entityManager.find(Etudiant.class, id);
		entityManager.refresh(etudiant);
		if (etudiant != null) {
			return etudiant;
		} else {
			return null;
		}
	}

	@Override
	public void addEtudiant(Etudiant etudiant) {
		entityManager.persist(etudiant);
	}

	@Override
	public void updateEtudiant(Etudiant etudiant) {
		Etudiant newEtudiant = getEtudiant(etudiant.getIdEtudiant());
		newEtudiant.setNom(etudiant.getNom());
		newEtudiant.setPrenom(etudiant.getPrenom());
		newEtudiant.setCne(etudiant.getCne());
		newEtudiant.setAdresse(etudiant.getAdresse());
		newEtudiant.setNiveau(etudiant.getNiveau());
	}

	@Override
	public void deleteEtudiant(Etudiant etudiant) {
		if (!entityManager.contains(etudiant)) {
			etudiant = entityManager.merge(etudiant);
		}
		entityManager.remove(etudiant);
	}

}
