package pl.kobietydokodu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Kot {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	
	private String imie;
	
	
	private Float waga;

	private String opiekun;



	public Float getWaga() {
		return waga;
	}


	public void setWaga(Float waga) {
		this.waga = waga;
	}


	public String getOpiekun() {
		return opiekun;
	}


	public void setOpiekun(String opiekuna) {
		this.opiekun = opiekuna;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getImie() {
		return imie;
	}


	public void setImie(String imie) {
		this.imie = imie;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((imie == null) ? 0 : imie.hashCode());
		result = prime * result + ((opiekun == null) ? 0 : opiekun.hashCode());
		result = prime * result + ((waga == null) ? 0 : waga.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kot other = (Kot) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (imie == null) {
			if (other.imie != null)
				return false;
		} else if (!imie.equals(other.imie))
			return false;
		if (opiekun == null) {
			if (other.opiekun != null)
				return false;
		} else if (!opiekun.equals(other.opiekun))
			return false;
		if (waga == null) {
			if (other.waga != null)
				return false;
		} else if (!waga.equals(other.waga))
			return false;
		return true;
	}


	
	
	
}
