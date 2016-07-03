package model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author MacBook
 *
 */
@Entity
@Table(name = "Kommentare")
public class Kommentar implements Serializable{

	private static final long serialVersionUID = -2995107663554379051L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "text")
	private String text;
	
	@OneToMany
	@JoinColumn(name = "kommentar_id")
	private List<Kommentar> kommentar = new ArrayList<Kommentar>(0);

	@OneToOne
	@JoinColumn(name = "benutzer_id")
	private Benutzer ersteller;
	
	
	/**
	 * Getter ID Kommentare
	 * @return
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Setter ID Kommentare
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	/**
	 * Getter Kommentar Text
	 * @return
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * Setter Kommentar Text
	 * @param text
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	/**
	 * Getter Liste Kommentare
	 * @return
	 */
	public List<Kommentar> getKommentar() {
		return kommentar;
	}

	/**
	 * Setter Liste Kommentare
	 * @param kommentar
	 */
	public void setKommentar(List<Kommentar> kommentar) {
		this.kommentar = kommentar;
	}
	
	
	/**
	 * Getter Kommentar Ersteller
	 * @return
	 */
	public Benutzer getErsteller() {
		return ersteller;
	}
	
	/**
	 * Setter Kommentar Ersteller
	 * @param ersteller
	 */
	public void setErsteller(Benutzer ersteller) {
		this.ersteller = ersteller;
	}
	
}
