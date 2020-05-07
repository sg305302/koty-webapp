package pl.kobietydokodu.koty.repo;

import org.springframework.data.repository.CrudRepository;

import pl.kobietydokodu.model.Kot;


public interface CatRep extends CrudRepository<Kot, Integer> {

}