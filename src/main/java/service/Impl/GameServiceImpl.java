package service.Impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.model.Game;
import domain.model.GameRepository;
import service.GameService;
import service.exception.BusinessException;
import service.exception.NoContentException;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private GameRepository repository;

	@Override
	public List<Game> findAll() {
		List<Game> games = repository.findAll();

		return games;
	}

	@Override
	public Game findById(Long id) {
		Optional<Game> game = repository.findById(id);
		return game.orElseThrow(() -> new NoContentException());
	}

	@Override
	public void insert(Game game) {
		if (Objects.nonNull(game.getId())) {
			throw new BusinessException("O ID é diferente de NULL  na inclusão");	
		}
		repository.save(game);

	}

	@Override
	public void upedate(Long id, Game game) {
		Game gameDb = findById(id);
		if (gameDb.getId().equals(game.getId())) {
			repository.save(game);
		} else {
			throw new BusinessException("Os IDs para as alterações são divergentes");
		}
	}

	@Override
	public void delete(Long id) {
		Game gameDb = findById(id);
		repository.delete(gameDb);
	}

}
