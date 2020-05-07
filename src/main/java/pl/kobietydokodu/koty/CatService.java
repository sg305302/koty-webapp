package pl.kobietydokodu.koty;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.kobietydokodu.koty.dto.KotDTO;
import pl.kobietydokodu.koty.repo.CatRep;
import pl.kobietydokodu.model.Kot;

@Service
public class CatService {

	@Autowired
	CatRep repo;

	public void dodajKota(KotDTO kotDto) {
		Kot kot = new Kot();

		kot.setImie(kotDto.getImie());
		kot.setOpiekun(kotDto.getImieOpiekuna());
		kot.setWaga(kotDto.getWaga());
		repo.save(kot);

	}

	public List<KotDTO> getKoty() {
		List<KotDTO> koty = new ArrayList<KotDTO>();
		Iterable<Kot> cats = repo.findAll();
		for (Kot kot2 : cats) {
			koty.add(new KotDTO(kot2.getId(), kot2.getImie(), kot2.getWaga(), kot2.getOpiekun()));
		}
		return koty;
	}

	public KotDTO getKotById(Integer id) {
		Kot kot2 = repo.findOne(id);
		if (kot2 != null) {
			return new KotDTO(kot2.getId(), kot2.getImie(), kot2.getWaga(), kot2.getOpiekun());
		}
		return null;
	}

}
