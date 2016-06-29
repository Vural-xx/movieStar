package util;

public class SortFilter {

	public boolean sterneUp = false;
	public boolean erscheinungsjahr = false;
	public boolean name = false;
	public boolean upload = false;

	public boolean sterneBool(boolean bool) {
		if (bool == true) {
			sterneUp = true;
		} else {
			sterneUp = false;
		}

		return sterneUp;
	}

	public boolean erscheinungsjahrBool(boolean bool) {
		if (bool == true) {
			erscheinungsjahr = true;
		} else {
			erscheinungsjahr = false;
		}

		return erscheinungsjahr;
	}
	
	public boolean uploadBool(boolean bool) {
		if (bool == true) {
			upload = true;
		} else {
			upload = false;
		}

		return upload;
	}

	public boolean nameBool(boolean bool) {
		if (bool == true) {
			name = true;
		} else {
			name = false;
		}

		return name;
	}

	
	
	public boolean isUpload() {
		return upload;
	}

	public void setUpload(boolean upload) {
		this.upload = upload;
	}

	public boolean isErscheinungsjahr() {
		return erscheinungsjahr;
	}

	public void setErscheinungsjahr(boolean erscheinungsjahr) {
		this.erscheinungsjahr = erscheinungsjahr;
	}

	public boolean isName() {
		return name;
	}

	public void setName(boolean name) {
		this.name = name;
	}

	public boolean isSterneUp() {
		return sterneUp;
	}

	public void setSterneUp(boolean sterneUp) {
		this.sterneUp = sterneUp;
	}

}
