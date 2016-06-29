package enums;

import java.io.Serializable;

import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Tuplizer;

import util.EnumTuplizer;

@Entity
@Table(name = "Benutzerstatus")
//@Tuplizer(impl = EnumTuplizer.class)
@SessionScoped
public enum BenutzerStatus{

	BLOCKIERT, 
	FREIGESCHALTET, 
	NICHT_FREIGESCHALTET;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "value")
	private String name = toString();
}
