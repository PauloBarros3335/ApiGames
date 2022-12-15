package controlle.Games;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import controlle.BaseRestController;
import domain.model.Game;
import service.GameService;

@RestController
public class GameRestController extends BaseRestController{

	@Autowired
	private GameService businessLayer;

	@GetMapping("games")
	//@RequestMapping(method = RequestMethod.GET, path = "games")
	public ResponseEntity<List<Game>> findAll() {
		List<Game> games = businessLayer.findAll();
		return ResponseEntity.ok(games);
	}

	@GetMapping("games/{id}")
	//@RequestMapping(method = RequestMethod.GET, path = "games/{id}")
	public ResponseEntity<Game> findById(@PathVariable Long id) {
		Game game = businessLayer.findById(id);
		return ResponseEntity.ok(game);
	}

	@PostMapping("games")
	//@RequestMapping(method = RequestMethod.POST, path = "games")
	public ResponseEntity<Game> insert(@RequestBody Game game) {
		businessLayer.insert(game);
		return ResponseEntity.ok(game);
	}

	@PutMapping("games/{id}")
	//@RequestMapping(method = RequestMethod.PUT, path = "games/{id}")
	public ResponseEntity<Game> update(@PathVariable Long id, @RequestBody Game game) {
		businessLayer.upedate(id, game);
		return ResponseEntity.ok(game);
	}

	@DeleteMapping("games/{id}")
	//@RequestMapping(method = RequestMethod.DELETE, path = "games/{id}")
	public ResponseEntity<Game> delete(@PathVariable Long id) {
		businessLayer.delete(id);
		return ResponseEntity.ok().build();
	}
}