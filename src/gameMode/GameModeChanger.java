package gameMode;

import java.util.HashMap;
import java.util.Map;

public class GameModeChanger {

    Basic gameMode;

    public GameModeChanger(String gameModeTitle) {
        switch (gameModeTitle) {
            case "Basic":
                gameMode = new Basic();
                break;
            case "GoldenHat":
                gameMode = new GoldenHat();
                break;
            case "Team":
                gameMode = new Team();
                break;
            case "TotalTeam":
                gameMode = new TotalTeam();
                break;
            case "Tower":
                gameMode = new Tower();
                break;
        }
    }

    public void startgame () {
        
    }
}
