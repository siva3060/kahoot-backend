

@Service
public class GameService{

	@Autowired
	GameRepository gameRepository;

	public void createGame(int gameId){
		gameRepository.save(gameId)
	}
	//end of class GameService
}
