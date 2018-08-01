package br.ufpb.dcx.sisalfa.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

import br.ufpb.dcx.sisalfa.models.Challenge;
import br.ufpb.dcx.sisalfa.models.SisContext;
import br.ufpb.dcx.sisalfa.models.User;

public class SisalfaRepository {

    private SisalfaSQLHelper helper;

    /**
     *
     * Default constructor.
     * @param ctx the application context.
     */
    public SisalfaRepository(Context ctx){
        this.helper = new SisalfaSQLHelper(ctx);
    }


    /**
     *Create a databse table of an user.
     *
     * @param user object to get the data.
     * @return the user table ID.
     */

    public long createUser(User user){
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(SisalfaSQLHelper.COLUMN_PKEY_ID, user.getId());
        cv.put(SisalfaSQLHelper.COLUMN_USERNAME, user.getUsername());
        cv.put(SisalfaSQLHelper.COLUMN_PASSWORD, user.getPassword());
        cv.put(SisalfaSQLHelper.COLUMN_EMAIL, user.getEmail());
        cv.put(SisalfaSQLHelper.COLUMN_FIRST_NAME, user.getFirstName());
        cv.put(SisalfaSQLHelper.COLUMN_LAST_NAME, user.getLastName());
        cv.put(SisalfaSQLHelper.COLUMN_PHOTO, user.getPhoto());
        return db.insert(SisalfaSQLHelper.USER_TABLE, null, cv);

    }


    /**
     *Get an user by his id.
     *
     * @param userId the ID of this user.
     * @return return an user object.
     */

    public User getUserById(long userId){
        SQLiteDatabase db = helper.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + SisalfaSQLHelper.USER_TABLE + " WHERE "
                + SisalfaSQLHelper.COLUMN_PKEY_ID + " = " + userId;
        Log.e("LOG", selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);
        User user = new User();
        if (c != null) {
            while (c.moveToNext()) {
                user.setId(c.getInt(c.getColumnIndex(SisalfaSQLHelper.COLUMN_PKEY_ID)));
                user.setUsername(c.getString(c.getColumnIndex(SisalfaSQLHelper.COLUMN_USERNAME)));
                user.setPassword((c.getString(c.getColumnIndex(SisalfaSQLHelper.COLUMN_PASSWORD))));
                user.setEmail(c.getString(c.getColumnIndex(SisalfaSQLHelper.COLUMN_EMAIL)));
                user.setFirstName(c.getString(c.getColumnIndex(SisalfaSQLHelper.COLUMN_FIRST_NAME)));
                user.setLastName(c.getString(c.getColumnIndex(SisalfaSQLHelper.COLUMN_LAST_NAME)));
                user.setPhoto(c.getString(c.getColumnIndex(SisalfaSQLHelper.COLUMN_PHOTO)));
            }
        }

        return user;
    }

    /**
     * Returns a list with all users.
     *
     * @return returns an list of all users.
     */

    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + SisalfaSQLHelper.USER_TABLE;

        Log.e("LOG", selectQuery);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        if (c.moveToFirst()) {
            do {
                User user = new User();
                user.setId(c.getInt(c.getColumnIndex(SisalfaSQLHelper.COLUMN_PKEY_ID)));
                user.setUsername(c.getString(c.getColumnIndex(SisalfaSQLHelper.COLUMN_USERNAME)));
                user.setPassword((c.getString(c.getColumnIndex(SisalfaSQLHelper.COLUMN_PASSWORD))));
                user.setEmail(c.getString(c.getColumnIndex(SisalfaSQLHelper.COLUMN_EMAIL)));
                user.setFirstName(c.getString(c.getColumnIndex(SisalfaSQLHelper.COLUMN_FIRST_NAME)));
                user.setLastName(c.getString(c.getColumnIndex(SisalfaSQLHelper.COLUMN_LAST_NAME)));
                user.setPhoto(c.getString(c.getColumnIndex(SisalfaSQLHelper.COLUMN_PHOTO)));
                users.add(user);
            } while (c.moveToNext());
        }

        return users;
    }


    /**
     *Update the user informations.
     *
     * @param user the user object.
     * @return returns the user updated.
     */

    public int updateUser(User user){
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(SisalfaSQLHelper.COLUMN_PKEY_ID, user.getId());
        cv.put(SisalfaSQLHelper.COLUMN_USERNAME, user.getUsername());
        cv.put(SisalfaSQLHelper.COLUMN_PASSWORD, user.getPassword());
        cv.put(SisalfaSQLHelper.COLUMN_EMAIL, user.getEmail());
        cv.put(SisalfaSQLHelper.COLUMN_FIRST_NAME, user.getFirstName());
        cv.put(SisalfaSQLHelper.COLUMN_LAST_NAME, user.getLastName());
        cv.put(SisalfaSQLHelper.COLUMN_PHOTO, user.getPhoto());

        return db.update(SisalfaSQLHelper.USER_TABLE, cv,
                SisalfaSQLHelper.COLUMN_PKEY_ID + " = ?",
                new String[] { String.valueOf(user.getId()) });
    }


    /**
     *Delete am user by his id.
     *
     * @param userId the user id that will be deleted.
     */

    public void deleteUser(long userId){
        SQLiteDatabase db = helper.getWritableDatabase();
        db.delete(SisalfaSQLHelper.USER_TABLE, SisalfaSQLHelper.COLUMN_PKEY_ID +
                " = ?", new String[]{ String.valueOf(userId)});
    }


    /**
     * Create a context table.
     *
     * @param context
     * @return
     */
    public long createContext(SisContext context){
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(SisalfaSQLHelper.COLUMN_PKEY_ID, context.getId());
        cv.put(SisalfaSQLHelper.COLUMN_USER_FKEY, context.getAuthor());
        cv.put(SisalfaSQLHelper.COLUMN_NAME, context.getName());
        cv.put(SisalfaSQLHelper.COLUMN_IMAGE, context.getImage());
        cv.put(SisalfaSQLHelper.COLUMN_SOUND, context.getSound());
        cv.put(SisalfaSQLHelper.COLUMN_VIDEO, context.getVideo());
        return db.insert(SisalfaSQLHelper.CONTEXT_TABLE, null, cv);

    }


    /**
     *Get an context by his id.
     *
     * @param contextId the ID of this user.
     * @return return an user object.
     */

    public SisContext getContextrById(long contextId){
        SQLiteDatabase db = helper.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + SisalfaSQLHelper.CONTEXT_TABLE + " WHERE "
                + SisalfaSQLHelper.COLUMN_PKEY_ID + " = " + contextId;
        Log.e("LOG", selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);
        SisContext sisContext = new SisContext();
        if (c != null) {
            while (c.moveToNext()) {
                sisContext.setId(c.getInt(c.getColumnIndex(SisalfaSQLHelper.COLUMN_PKEY_ID)));
                sisContext.setAuthor(c.getInt(c.getColumnIndex(SisalfaSQLHelper.COLUMN_USER_FKEY)));
                sisContext.setName(c.getString(c.getColumnIndex(SisalfaSQLHelper.COLUMN_NAME)));
                sisContext.setImage(c.getString(c.getColumnIndex(SisalfaSQLHelper.COLUMN_IMAGE)));
                sisContext.setSound(c.getString(c.getColumnIndex(SisalfaSQLHelper.COLUMN_SOUND)));
                sisContext.setVideo(c.getString(c.getColumnIndex(SisalfaSQLHelper.COLUMN_VIDEO)));

            }
        }

        return sisContext;
    }

    /**
     * Returns a list with all contexts.
     *
     * @return returns an list of all users.
     */

    public List<SisContext> getAllContexts(){
        List<SisContext> sisContexts = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + SisalfaSQLHelper.CONTEXT_TABLE;

        Log.e("LOG", selectQuery);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        if (c.moveToFirst()) {
            do {
                SisContext sisContext = new SisContext();
                sisContext.setId(c.getInt(c.getColumnIndex(SisalfaSQLHelper.COLUMN_PKEY_ID)));
                sisContext.setAuthor(c.getInt(c.getColumnIndex(SisalfaSQLHelper.COLUMN_USER_FKEY)));
                sisContext.setName(c.getString(c.getColumnIndex(SisalfaSQLHelper.COLUMN_NAME)));
                sisContext.setImage(c.getString(c.getColumnIndex(SisalfaSQLHelper.COLUMN_IMAGE)));
                sisContext.setSound(c.getString(c.getColumnIndex(SisalfaSQLHelper.COLUMN_SOUND)));
                sisContext.setVideo(c.getString(c.getColumnIndex(SisalfaSQLHelper.COLUMN_VIDEO)));
                sisContexts.add(sisContext);
            } while (c.moveToNext());
        }

        return sisContexts;
    }


    /**
     *Update the context informations.
     *
     * @param context the context object.
     * @return returns the context updated.
     */

    public int updateContext(SisContext context){
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(SisalfaSQLHelper.COLUMN_PKEY_ID, context.getId());
        cv.put(SisalfaSQLHelper.COLUMN_USER_FKEY, context.getAuthor());
        cv.put(SisalfaSQLHelper.COLUMN_NAME, context.getName());
        cv.put(SisalfaSQLHelper.COLUMN_IMAGE, context.getImage());
        cv.put(SisalfaSQLHelper.COLUMN_SOUND, context.getSound());
        cv.put(SisalfaSQLHelper.COLUMN_VIDEO, context.getVideo());

        return db.update(SisalfaSQLHelper.CONTEXT_TABLE, cv,
                SisalfaSQLHelper.COLUMN_PKEY_ID + " = ?",
                new String[] { String.valueOf(context.getId()) });
    }


    /**
     *Delete am context by his id.
     *
     * @param contextId the user id that will be deleted.
     */

    public void deleteContext(long contextId){
        SQLiteDatabase db = helper.getWritableDatabase();
        db.delete(SisalfaSQLHelper.CONTEXT_TABLE, SisalfaSQLHelper.COLUMN_PKEY_ID +
                " = ?", new String[]{ String.valueOf(contextId)});
    }


    /**
     * Create a challenge table.
     *
     * @param challenge
     * @return
     */
    public long createChallenge(Challenge challenge){
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        System.out.println("CRIANDO CHALLENGE, ID DO CONTEXTO: "+challenge.getContext().getId());
        cv.put(SisalfaSQLHelper.COLUMN_PKEY_ID, challenge.getId());
        cv.put(SisalfaSQLHelper.COLUMN_CONTEXT_FKEY, challenge.getContext().getId());
        cv.put(SisalfaSQLHelper.COLUMN_USER_FKEY, challenge.getAuthor());
        cv.put(SisalfaSQLHelper.COLUMN_WORD, challenge.getWord());
        cv.put(SisalfaSQLHelper.COLUMN_IMAGE, challenge.getImage());
        cv.put(SisalfaSQLHelper.COLUMN_SOUND, challenge.getSound());
        cv.put(SisalfaSQLHelper.COLUMN_VIDEO, challenge.getVideo());

        return db.insert(SisalfaSQLHelper.CHALLENGE_TABLE, null, cv);

    }


    /**
     *Get an challenge by his id.
     *
     * @param challengeId the ID of this user.
     * @return return an user object.
     */

    public Challenge getChallengeById(long challengeId){
        SQLiteDatabase db = helper.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + SisalfaSQLHelper.CHALLENGE_TABLE + " WHERE "
                + SisalfaSQLHelper.COLUMN_PKEY_ID + " = " + challengeId;
        Log.e("LOG", selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);
        Challenge challenge = new Challenge();
        if (c != null) {
            while (c.moveToNext()) {
                SisContext sisContext = getContextrById((long)c.getInt(c.getColumnIndex(SisalfaSQLHelper.COLUMN_CONTEXT_FKEY)));
                challenge.setId(c.getInt(c.getColumnIndex(SisalfaSQLHelper.COLUMN_PKEY_ID)));
                challenge.setId(c.getInt(c.getColumnIndex(SisalfaSQLHelper.COLUMN_USER_FKEY)));
                challenge.setWord(c.getString(c.getColumnIndex(SisalfaSQLHelper.COLUMN_WORD)));
                challenge.setImage(c.getString(c.getColumnIndex(SisalfaSQLHelper.COLUMN_IMAGE)));
                challenge.setSound(c.getString(c.getColumnIndex(SisalfaSQLHelper.COLUMN_SOUND)));
                challenge.setVideo(c.getString(c.getColumnIndex(SisalfaSQLHelper.COLUMN_VIDEO)));
                challenge.setContext(sisContext);
            }
        }

        return challenge;
    }

    /**
     * Returns a list with all challenges.
     *
     * @return returns an list of all users.
     */

    public List<Challenge> getAllChallenges(){
        List<Challenge> challenges = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + SisalfaSQLHelper.CHALLENGE_TABLE;

        Log.e("LOG", selectQuery);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        if (c.moveToFirst()) {
            do {
                Challenge challenge = new Challenge();

                challenge.setId(c.getInt(c.getColumnIndex(SisalfaSQLHelper.COLUMN_PKEY_ID)));
                challenge.setId(c.getInt(c.getColumnIndex(SisalfaSQLHelper.COLUMN_USER_FKEY)));
                challenge.setWord(c.getString(c.getColumnIndex(SisalfaSQLHelper.COLUMN_WORD)));
                challenge.setImage(c.getString(c.getColumnIndex(SisalfaSQLHelper.COLUMN_IMAGE)));
                challenge.setSound(c.getString(c.getColumnIndex(SisalfaSQLHelper.COLUMN_SOUND)));
                challenge.setVideo(c.getString(c.getColumnIndex(SisalfaSQLHelper.COLUMN_VIDEO)));

                SisContext sisContext = getContextrById((long)c.getInt(c.getColumnIndex(SisalfaSQLHelper.COLUMN_CONTEXT_FKEY)));
                challenge.setContext(sisContext);

                challenges.add(challenge);
            } while (c.moveToNext());
        }



        return challenges;
    }


    public List<Challenge> getChallengesByContext(int contextId){
        List<Challenge> challenges = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + SisalfaSQLHelper.CHALLENGE_TABLE + " WHERE "+SisalfaSQLHelper.COLUMN_CONTEXT_FKEY+" = "+contextId;

        Log.e("LOG", selectQuery);

        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        if (c.moveToFirst()) {
            do {
                Challenge challenge = new Challenge();
                SisContext sisContext = getContextrById((long)c.getInt(c.getColumnIndex(SisalfaSQLHelper.COLUMN_CONTEXT_FKEY)));
                System.out.println("Nome do contexto do GetChallengesBYID"+sisContext.getName());


                challenge.setId(c.getInt(c.getColumnIndex(SisalfaSQLHelper.COLUMN_PKEY_ID)));
                challenge.setId(c.getInt(c.getColumnIndex(SisalfaSQLHelper.COLUMN_USER_FKEY)));
                challenge.setWord(c.getString(c.getColumnIndex(SisalfaSQLHelper.COLUMN_WORD)));
                System.out.println("CHALLENGE DO GETCHABYID: " + c.getString(c.getColumnIndex(SisalfaSQLHelper.COLUMN_WORD)));
                challenge.setImage(c.getString(c.getColumnIndex(SisalfaSQLHelper.COLUMN_IMAGE)));
                challenge.setSound(c.getString(c.getColumnIndex(SisalfaSQLHelper.COLUMN_SOUND)));
                challenge.setVideo(c.getString(c.getColumnIndex(SisalfaSQLHelper.COLUMN_VIDEO)));
                challenge.setContext(sisContext);
                challenges.add(challenge);
            } while (c.moveToNext());
        }
        System.out.println("TAMANHO DA LISTA DO GETCHALLENGESBYID"+challenges.size());
        return challenges;
    }


    /**
     *Update the challenge informations.
     *
     * @param challenge the context object.
     * @return returns the context updated.
     */

    public int updateChallenge(Challenge challenge){
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(SisalfaSQLHelper.COLUMN_PKEY_ID, challenge.getId());
        cv.put(SisalfaSQLHelper.COLUMN_CONTEXT_FKEY, challenge.getContext().getId());
        cv.put(SisalfaSQLHelper.COLUMN_USER_FKEY, challenge.getAuthor());
        cv.put(SisalfaSQLHelper.COLUMN_WORD, challenge.getWord());
        cv.put(SisalfaSQLHelper.COLUMN_IMAGE, challenge.getImage());
        cv.put(SisalfaSQLHelper.COLUMN_SOUND, challenge.getSound());
        cv.put(SisalfaSQLHelper.COLUMN_VIDEO, challenge.getVideo());
        return db.update(SisalfaSQLHelper.CHALLENGE_TABLE, cv,
                SisalfaSQLHelper.COLUMN_PKEY_ID + " = ?",
                new String[] { String.valueOf(challenge.getId()) });
    }


    /**
     *Delete am challenge by his id.
     *
     * @param challengeId the user id that will be deleted.
     */

    public void deleteChallenge(long challengeId){
        SQLiteDatabase db = helper.getWritableDatabase();
        db.delete(SisalfaSQLHelper.CHALLENGE_TABLE, SisalfaSQLHelper.COLUMN_PKEY_ID +
                " = ?", new String[]{ String.valueOf(challengeId)});
    }

    public void closeDB() {
        SQLiteDatabase db = helper.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }
}
