package garages;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Représente un stationnement d'une voiture dans un garage.
 * Cette classe utilise Lombok pour générer automatiquement certaines méthodes.
 */
@RequiredArgsConstructor
@Getter
public class Stationnement {

	/** La voiture qui est stationnée. */
	private final Voiture myCar;

	/** Le garage où la voiture est stationnée. */
	private final Garage myGarage;

	/** La date d'entrée du stationnement. */
	private final Date entree = new Date(); // Aujourd'hui

	/** La date de fin du stationnement, null si le stationnement est en cours. */
	private Date fin;

	/**
	 * Termine le stationnement en cours.
	 * Cette méthode enregistre la date de fin du stationnement.
	 */
	public void terminer() {
		// On enregistre la date de fin du stationnement
		fin = new Date(); // Date du jour
	}

	/**
	 * Vérifie si le stationnement est en cours.
	 * 
	 * @return true si le stationnement est en cours, false sinon
	 */
	public boolean estEnCours() {
		// Le stationnement est en cours si on ne connaît pas la date de fin
		return (fin == null);
	}

	/**
	 * Retourne une représentation textuelle du stationnement.
	 * 
	 * @return Une chaîne représentant l'état du stationnement, incluant la date d'entrée
	 *         et soit "en cours" soit la date de sortie
	 */
	@Override
	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy");
		return String.format("Stationnement{ entree=%s, %s }",
				dateFormat.format(entree),
				estEnCours() ? "en cours" : "sortie=" + dateFormat.format(fin));
	}

}
