package garages;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Représente un garage où des voitures peuvent stationner.
 * Cette classe utilise Lombok pour générer automatiquement certaines méthodes.
 */

// Génère un constructeur avec les arguments requis (champs marqués avec @NonNull ou final)
@RequiredArgsConstructor
// Génère automatiquement des méthodes getter pour tous les champs
@Getter
// Génère une méthode toString()
@ToString
public class Garage {
	// Marque le champ comme non-null, lançant une NullPointerException si null est passé
	@NonNull
	// Génère une méthode setter pour ce champ
	@Setter
	private String name;

/* Lombok va générer automatiquement le code suivant :

	public Garage(String s) {
		if (null == s) {
			throw new NullPointerException("name is null");
		}
		name = s;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (null == name) {
			throw new NullPointerException("name is null");
		}

		this.name = name;
	}

	@Override
	public String toString() {
		return "Garage " + name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (null == name) {
			throw new IllegalArgumentException("name is null");
		}

		this.name = name;
	}

	@Override
	public String toString() {
		return "Garage " + name;
	}
*/
}
