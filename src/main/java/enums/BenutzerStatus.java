package enums;

import javax.faces.bean.SessionScoped;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Tuplizer;

import util.EnumTuplizer;

/**
 * @author MacBook
 * Klasse für Enum BenutzerStatus
 */
@Entity
@Table(name = "Benutzerstatus")
@Tuplizer(impl = EnumTuplizer.class)
public enum BenutzerStatus{

	BLOCKIERT, 
	FREIGESCHALTET, 
	NICHT_FREIGESCHALTET;
	
	@Id
	public String name = toString();

}
