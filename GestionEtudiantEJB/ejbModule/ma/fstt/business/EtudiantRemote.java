package ma.fstt.business;

import java.util.List;
import jakarta.ejb.Remote;
import ma.fstt.persistence.Etudiant;

@Remote
public interface EtudiantRemote {
	public List<Etudiant> getAllEtudiants();
	public Etudiant getEtudiant(Long id);
	public void addEtudiant(Etudiant etudiant);
	public void updateEtudiant(Etudiant etudiant);
	public void deleteEtudiant(Etudiant etudiant);
}
