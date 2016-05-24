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
	private Integer id;
	private String text;
	private Kommentar kommentar;
	private Benutzer ersteller;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "text")
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	@JoinColumn(name = "kommentar_id")
	public Kommentar getKommentar() {
		return kommentar;
	}
	
	public void setKommentar(Kommentar kommentar) {
		this.kommentar = kommentar;
	}
	
	@OneToOne
	@JoinColumn(name = "benutzer_id")
	public Benutzer getErsteller() {
		return ersteller;
	}
	
	public void setErsteller(Benutzer ersteller) {
		this.ersteller = ersteller;
	}

	
	
}
