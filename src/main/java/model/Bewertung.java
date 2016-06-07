package model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Bewertungen")
@ManagedBean(name="bewertung")
@RequestScoped
public class Bewertung implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8842428397839522473L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@OneToOne
	@JoinColumn(name = "ersteller_id")
	private Benutzer ersteller;
	
	@Column(name="sterne")
	private double sterne;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Benutzer getErsteller() {
		return ersteller;
	}
	public void setErsteller(Benutzer ersteller) {
		this.ersteller = ersteller;
	}
	public double getSterne() {
		return sterne;
	}
	public void setSterne(double sterne) {
		this.sterne = sterne;
	}
	

}
