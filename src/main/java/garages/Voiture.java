package garages;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.io.PrintStream;

import java.util.HashSet;
import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import java.lang.IllegalStateException;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

@RequiredArgsConstructor
@ToString
/**
 * Représente une voiture qui peut être stationnée dans des garages.
 */
public class Voiture {

	@Getter
	@NonNull
	private final String immatriculation;
	@ToString.Exclude // On ne veut pas afficher les stationnements dans toString
	private final List<Stationnement> myStationnements = new LinkedList<>();

	/**
	 * Fait rentrer la voiture au garage
	 * Précondition : la voiture ne doit pas être déjà dans un garage
	 *
	 * @param g le garage où la voiture va stationner
	 * @throws IllegalStateException Si déjà dans un garage
	 */
	public void entreAuGarage(Garage g) throws IllegalStateException {
		// Et si la voiture est déjà dans un garage ?
		if (estDansUnGarage())
			throw new IllegalStateException("la voiture est deja dans un garage");

		Stationnement s = new Stationnement(this, g);
		myStationnements.add(s);
	}

	/**
	 * Fait sortir la voiture du garage
	 * Précondition : la voiture doit être dans un garage
	 *
	 * @throws IllegalStateException si la voiture n'est pas dans un garage
	 */
	public void sortDuGarage() throws IllegalStateException {
		if (!estDansUnGarage()){
			throw new IllegalStateException("la voiture n'est pas dans un garage");

		}
		myStationnements.get(myStationnements.size() - 1).terminer();
		// TODO: Implémenter cette méthode
		// Trouver le dernier stationnement de la voiture
		// Terminer ce stationnement
	}

	/**
	 * Calcule l'ensemble des garages visités par cette voiture
	 * 
	 * @return l'ensemble des garages visités par cette voiture
	 */
	public Set<Garage> garagesVisites() {
		// TODO: Implémenter cette méthode
		Set<Garage> garages = new HashSet<>();
		for (Stationnement s : myStationnements){
			garages.add(s.getGarageVisite());
		}
		return garages;
	}

	/**
	 * Détermine si la voiture est actuellement dans un garage
	 * 
	 * @return vrai si la voiture est dans un garage, faux sinon
	 */
	public boolean estDansUnGarage() {
		// TODO: Implémenter cette méthode
		if (myStationnements.isEmpty())
			return false;
		else
			return myStationnements.getLast().estEnCours();
		// Vrai si le dernier stationnement est en cours
	}

	/**
	 * Pour chaque garage visité, imprime le nom de ce garage suivi de la liste des
	 * dates d'entrée / sortie dans ce garage
	 * <br>
	 * Exemple :
	 * 
	 * <pre>
	 * Garage Castres:
	 *		Stationnement{ entree=28/01/2019, sortie=28/01/2019 }
	 *		Stationnement{ entree=28/01/2019, en cours }
	 *  Garage Albi:
	 *		Stationnement{ entree=28/01/2019, sortie=28/01/2019 }
	 * </pre>
	 *
	 * @param out l'endroit où imprimer (ex: System.out pour imprimer dans la
	 *            console)
	 */
	public void imprimeStationnements(PrintStream out) {
		// TODO: Implémenter cette méthode
		// Utiliser les méthodes toString() de Garage et Stationnement
		Map<Garage, List<Stationnement>> stationnementsParGarage = new HashMap<>();
		for (Stationnement s : myStationnements){
			stationnementsParGarage.computeIfAbsent(s.getGarageVisite(), k -> new ArrayList<>()).add(s);

		}
		for ( Map.Entry<Garage , List<Stationnement>> entry : stationnementsParGarage.entrySet()){
			out.println("Garage" + entry.getKey().toString() + ":");
			for (Stationnement s : entry.getValue()){
				out.println("\t" + s);
			}
		}

	}

}
