package model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Kommentare")
public class Kommentar implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2995107663554379051L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "text")
	private String text;
	
	@JoinColumn(name = "kommentar_id")
	private Kommentar kommentar;

	@OneToOne
	@JoinColumn(name = "benutzer_id")
	private Benutzer ersteller;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	
	public Kommentar getKommentar() {
		return kommentar;
	}
	
	public void setKommentar(Kommentar kommentar) {
		this.kommentar = kommentar;
	}
	
	public Benutzer getErsteller() {
		return ersteller;
	}
	
	public void setErsteller(Benutzer ersteller) {
		this.ersteller = ersteller;
	}

	
	
}
