package dao;

import java.util.logging.Level;

/**
 * Cette classe représente l'Exception qui vas gérer les erreurs dans mes DAO.
 */
public class daoException extends Exception {
    private Level level;
    public daoException(Level level, String message){
        super(message);
        setLevel(level);
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
