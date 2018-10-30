package com.company.game.manager;

import com.company.game.constants.Constants;
import com.company.game.domain.Player;
import com.company.game.plot.City;
import com.company.game.utils.DisplayUtil;
import com.company.game.utils.InputReaderUtil;

import java.io.*;

/**
 * ActionManagerImpl holds implementation of all actions taken by user
 */
public class ActionManagerImpl implements IActionManager {


    public ActionManagerImpl() {
    }

    /**
     * createPlayer will create a new character with pre configured properties
     */
    @Override
    public Player createPlayer() {

        DisplayUtil.printToConsole("Enter your name:");
        String name = InputReaderUtil.getValidStringInput();
        return new Player(name, Constants.MAX_HEALTH,Constants.MED_KITS,
                Constants.EXPERIENCE, Constants.DEFAULT_COIN);
    }

    /**
     * User selection to play game
     * @param player
     * @return
     */
    @Override
    public City playGame(Player player) {
        City city = new City(player);
        return city.playGame();
    }


    /**
     * User selection to save game by writing to a file
     * @param city
     */
    @Override
    public void saveGame(City city) {
        boolean saveFailure = false;
        try (FileOutputStream fos = new FileOutputStream(System.getProperty("user.home") + File.separator + "gta.sav"); ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(city);
            oos.close();
        } catch (IOException ioe) {
            saveFailure = true;
        }

        if (saveFailure) {
            DisplayUtil.printToConsole("Error while saving the game!");
        } else {
            DisplayUtil.printToConsole("Game Saved successfully...");
        }

    }

    /**
     * User selection to resume game from saved file
     * @return
     */
    @Override
    public City resumeGame() {
        City result = null;
        boolean savedGameExists = checkSaveGameFiles();
        boolean resumeFailure = false;
        if (savedGameExists) {
            try (FileInputStream fis = new FileInputStream(System.getProperty("user.home") + File.separator + "gta.sav");
                 ObjectInputStream ois = new ObjectInputStream(fis);) {
                result = (City) ois.readObject();
                ois.close();
            } catch (IOException ioe) {
                resumeFailure = true;
            } catch (ClassNotFoundException cnfe) {
                resumeFailure = true;
            }

            if (resumeFailure) {
                DisplayUtil.printToConsole("Error while saving the game!");
            } else {
                DisplayUtil.printToConsole("Game resumed successfully...");
            }
        } else {
            DisplayUtil.printToConsole("No saved game exists!");
        }

        return result;
    }

    /**
     *
     * @return
     */
    private boolean checkSaveGameFiles() {

        File savedFile = new File(System.getProperty("user.home") + File.separator + "gta.sav");
        if (savedFile.exists() && !savedFile.isDirectory()) {
            return true;
        }
        return false;
    }

    @Override
    public void exitGame() {
        System.exit(0);
    }
}
