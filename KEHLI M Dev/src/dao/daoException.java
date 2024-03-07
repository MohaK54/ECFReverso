package dao;

/**
 * Cette classe représente l'Exception qui vas gérer les erreurs dans mes DAO.
 */
public class daoException extends Exception {
    public daoException(String message){
        super(message);
    }
}
