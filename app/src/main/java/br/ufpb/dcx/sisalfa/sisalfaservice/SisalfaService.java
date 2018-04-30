package br.ufpb.dcx.sisalfa.sisalfaservice;

import android.os.RemoteException;

import br.ufpb.dcx.sisalfa.models.DataAlreadyExistsException;
import br.ufpb.dcx.sisalfa.models.DataNotFoundException;
import br.ufpb.dcx.sisalfa.models.Challenge;
import br.ufpb.dcx.sisalfa.models.Theme;
import br.ufpb.dcx.sisalfa.models.User;

import java.util.List;

/**
 * Created by rynzler on 29/03/18.
 */

public interface SisalfaService {

    /**
     * Inserts a new Theme into the database.
     *
     * @param context An object that represents a set of related challenges.
     * @return The id of the Theme inserted.
     * @throws RemoteException            if there is any communication problem with the
     *                                    service.
     * @throws DataAlreadyExistsException when the Theme being added already exists.
     */
    public String addTheme(Theme context) throws RemoteException, DataAlreadyExistsException;

    /**
     * Returns a list with all theme.
     *
     * @return a list with all theme.
     * @throws RemoteException if there is any communication problem with the
     *                         service.
     */
    public List<Theme> getAllThemes() throws RemoteException;

    /**
     * Returns a list with all themes created by a given user.
     *
     * @param idUser The id of the user.
     * @return a list with all themes created by a user.
     * @throws RemoteException if there is any communication problem with the
     *                         service.
     */
    public List<Theme> getAllThemesOfUser(String idUser) throws RemoteException;

    /**
     * Gets a given Theme.
     *
     * @param idTheme The id of a Theme.
     * @return The Theme identified by a given id.
     * @throws RemoteException       if there is any communication problem with the
     *                               service.
     * @throws DataNotFoundException when the Theme being searched is not found.
     */
    public Theme getTheme(String idTheme) throws RemoteException, DataNotFoundException;

    /**
     * Updates a given Theme.
     *
     * @param theme The Theme with updated information.
     * @throws RemoteException       if there is any communication problem with the
     *                               service.
     * @throws DataNotFoundException when the Theme being updated is not found.
     */
    public void updateTheme(Theme theme) throws RemoteException, DataNotFoundException;

    /**
     * Deletes a certain Theme.
     *
     * @param idTheme The id of the Theme to be deleted.
     * @throws RemoteException       if there is any communication problem with the
     *                               service.
     * @throws DataNotFoundException when the Theme being deleted is not found.
     */
    public void deleteTheme(String idTheme) throws RemoteException, DataNotFoundException;

    /**
     * Inserts a new Challenge.
     *
     * @param challenge The new Challenge to be inserted.
     * @return the id of the Challenge that was added.
     * @throws RemoteException            if there is any communication problem with the
     *                                    service.
     * @throws DataAlreadyExistsException when the Theme being added already exists.
     */
    public String addChallenge(Challenge challenge) throws RemoteException, DataAlreadyExistsException;

    /**
     * Updates a Challenge.
     *
     * @param newChallenge The Challenge with updated information.
     * @throws RemoteException       if there is any communication problem with the
     *                               service.
     * @throws DataNotFoundException when the Challenge being updated is not found.
     */
    public void updateChallenge(Challenge newChallenge) throws RemoteException, DataNotFoundException;

    /**
     * Returns a list with all the challenges.
     *
     * @return a list with all the challenges.
     * @throws RemoteException if there is any communication problem with the
     *                         service.
     */
    public List<Challenge> getAllChallenges() throws RemoteException;

    /**
     * Returns a list with all the challenges of a given user.
     *
     * @return a list with all the challenges created by a given user.
     * @throws RemoteException if there is any communication problem with the
     *                         service.
     */
    public List<Challenge> getAllChallengesOfUser(String idUser) throws RemoteException;

    /**
     * Gets a given Challenge.
     *
     * @param idChallenge The id of the Challenge to be obtained.
     * @return the Challenge found.
     * @throws RemoteException       if there is any communication problem with the
     *                               service.
     * @throws DataNotFoundException when the Challenge being searched is not found.
     */
    public Challenge getChallenge(String idChallenge) throws RemoteException, DataNotFoundException;

    /**
     * Gets the list of Challenges associated with a given context.
     *
     * @param idTheme The Context id.
     * @return the list of Challenges associated with a given context.
     * @throws RemoteException if there is any communication problem with the
     *                         service.
     */
    public List<Challenge> getChallengesByTheme(String idTheme) throws RemoteException;

    /**
     * Deletes a certain Challenge.
     *
     * @param idChallenge The id of the Challenge to be deleted.
     * @throws RemoteException       if there is any communication problem with the
     *                               service.
     * @throws DataNotFoundException when the Challenge being deleted is not found.
     */
    public void deleteChallenge(String idChallenge) throws RemoteException, DataNotFoundException;


    /**
     * Inserts a new User.
     *
     * @param user The new user.
     * @return the id of the user that was added.
     * @throws RemoteException            if there is any communication problem with the
     *                                    service.
     * @throws DataAlreadyExistsException when the User being added already exists.
     */
    public String addUser(User user) throws RemoteException, DataAlreadyExistsException;

    /**
     * Gets the list of all users.
     *
     * @return the list with all users.
     * @throws RemoteException if there is any communication problem with the
     *                         service.
     */
    public List<User> getAllUsers() throws RemoteException;

    /**
     * Gets a given user.
     *
     * @param idUser The id of a user.
     * @return The user found.
     * @throws RemoteException       if there is any communication problem with the
     *                               service.
     * @throws DataNotFoundException when the user being searched is not found.
     */
    public User getUser(String idUser) throws RemoteException, DataNotFoundException;

    /**
     * Deletes a user with a given id.
     *
     * @param idUser The id of a user.
     * @throws RemoteException       if there is any communication problem with the
     *                               service.
     * @throws DataNotFoundException when the user being deleted is not found.
     */
    public void deleteUser(String idUser) throws RemoteException, DataNotFoundException;

    /**
     * Updates a user with a given id.
     *
     * @param newUser The new user to replace the previews one with this id.
     * @throws RemoteException       if there is any communication problem with the
     *                               service.
     * @throws DataNotFoundException when the user being updated is not found.
     */
    public void updateUser(User newUser) throws RemoteException, DataNotFoundException;
}