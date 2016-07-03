package util;

/**
 * @author MacBook
 * Klasse zur Sortierung des Filters
 *
 */
public class SortFilter {

	public boolean sterneUp = false;
	public boolean erscheinungsjahr = false;
	public boolean name = false;
	public boolean upload = false;

	/**
	 * Methode ob Sterne auf oder absteigen
	 * @param bool
	 * @return
	 */
	public boolean sterneBool(boolean bool) {
		if (bool == true) {
			sterneUp = true;
		} else {
			sterneUp = false;
		}

		return sterneUp;
	}

	/**
	 * Methode, ob Erscheinungsjahr vorliegt
	 * @param bool
	 * @return
	 */
	public boolean erscheinungsjahrBool(boolean bool) {
		if (bool == true) {
			erscheinungsjahr = true;
		} else {
			erscheinungsjahr = false;
		}

		return erscheinungsjahr;
	}
	
	/**
	 * Methode ob Upload vorliegt
	 * @param bool
	 * @return
	 */
	public boolean uploadBool(boolean bool) {
		if (bool == true) {
			upload = true;
		} else {
			upload = false;
		}

		return upload;
	}

	/**
	 * Methode ob Name vorliegt
	 * @param bool
	 * @return
	 */
	public boolean nameBool(boolean bool) {
		if (bool == true) {
			name = true;
		} else {
			name = false;
		}

		return name;
	}

	
	
	/**
	 * Methode, ob Upload vorgenommen wurde
	 * @return
	 */
	public boolean isUpload() {
		return upload;
	}

	/**
	 * Methode um Upload zu setzen
	 * @param upload
	 */
	public void setUpload(boolean upload) {
		this.upload = upload;
	}

	/**
	 * Methode, ob Erscheinungsjahr vorgenommen wurde
	 * @return
	 */
	public boolean isErscheinungsjahr() {
		return erscheinungsjahr;
	}

	/**
	 * Methode um Upload zu setzen
	 * @param erscheinungsjahr
	 */
	public void setErscheinungsjahr(boolean erscheinungsjahr) {
		this.erscheinungsjahr = erscheinungsjahr;
	}

	/**
	 * Methode, ob Name vorliegt
	 * @return
	 */
	public boolean isName() {
		return name;
	}

	/**
	 * Methode, ob Name zu setzen
	 * @param name
	 */
	public void setName(boolean name) {
		this.name = name;
	}

	/**
	 * Methode um Sterne zu erhöhen
	 * @return
	 */
	public boolean isSterneUp() {
		return sterneUp;
	}

	/**
	 * Methode um Sterne zu erhöhen
	 * @param sterneUp
	 */
	public void setSterneUp(boolean sterneUp) {
		this.sterneUp = sterneUp;
	}

}
