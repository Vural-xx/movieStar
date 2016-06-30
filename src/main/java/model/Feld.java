package model;

import java.io.Serializable;

public class Feld implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7316328572613877358L;
	private String label;
    private String value;

    public Feld() {
        //
    }

    public Feld(String label) {
        this.label = label;
    }

    public Feld(String label, String value) {
        this.label = label;
        this.value = value;
    }

    
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    

}