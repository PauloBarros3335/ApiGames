package service;

import java.util.List;

import domain.model.Game;

public interface GameService {

	List<Game> findAll();

	Game findById(Long id);

	void insert(Game game);

	void upedate(Long id, Game game);

	void delete(Long id);

}
