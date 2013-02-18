package com.xilconic.dominiontoolkit.DominionCards;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.xilconic.dominiontoolkit.R;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import android.util.Log;

public class DominionToolkitDatabaseHandler extends SQLiteOpenHelper {
	// Database Version:
	private static final int DATABASE_VERSION = 10;
	
	// Database Name:
	private static final String DATABASE_NAME = "dominionToolkitDatabase";
	
	// Context:
	private final Context _context;
	
	public DominionToolkitDatabaseHandler(Context context){
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		
		_context = context;
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DominionCardsTable.CREATE_DOMINION_CARDS_TABLE);
		
		try {
			DominionCardsTable.populateFromDominionCardsFile(_context, db);
		} catch (IOException e) {
			Log.d("DominionToolkitDatabaseHandler", "unable to populare DominionCardsTable");
			e.printStackTrace();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop old database and completely replace with new one:
		db.execSQL("DROP TABLE IF EXISTS " + DominionCardsTable.TABLE_DOMINION_CARDS);
		
		// Recreate database:
		onCreate(db);
	}
	
	//====== Dominion Cards Table interface =========
	// Create
	public void addDominionCard(DominionCard card){
		SQLiteDatabase db = this.getWritableDatabase();
		
		DominionCardsTable.insertDominionCard(db, card);
		db.close();
	}
	
	// Read
	private DominionCard getDominionCard(int id){
		SQLiteDatabase db = this.getReadableDatabase();
		
		DominionCard card = DominionCardsTable.getDominionCard(db, id);
		
		db.close();
		return card;
	}
	
	public ArrayList<DominionCard> getDominionCardsByCardset(List<DominionSet> cardSets){
		SQLiteDatabase db = this.getReadableDatabase();
		
		ArrayList<DominionCard> cardList = DominionCardsTable.getDominionCardsByCardset(db, cardSets);
		
		db.close();
		return cardList;
	}
	
	public ArrayList<DominionCard> getAllDominionCards(){
		SQLiteDatabase db = this.getReadableDatabase();
		
		ArrayList<DominionCard> cardList = DominionCardsTable.getAllDominionCards(db);
		
		db.close();
		return cardList;
	}
	
	// Update
	private int updateDominionCard(DominionCard card){
		SQLiteDatabase db = this.getWritableDatabase();
		
		int affectedRowsNumber = DominionCardsTable.updateDominionCard(db, card);
		
		db.close();
		return affectedRowsNumber;
	}
	
	// Delete
	private void deleteDominionCard(DominionCard card){
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(DominionCardsTable.TABLE_DOMINION_CARDS, 
				DominionCardsTable.KEY_ID + " = ?", 
				new String[]{ String.valueOf(card.get_id()) });
		db.close();
	}
	//= END = Dominion Cards Table interface =========

	private static class DominionCardsTable {
		/**
		 *  Dominion Cards table name
		 */
		public static final String TABLE_DOMINION_CARDS = "dominionCards";
		
		// Dominion Cards Table Column names:
		public static final String KEY_ID = "id";
		public static final String KEY_NAME = "name";
		public static final String KEY_COST = "cost";
		public static final String KEY_ACTION_FLAG = "action_flag";
		public static final String KEY_ATTACK_FLAG = "attack_flag";
		public static final String KEY_REACTION_FLAG = "reaction_flag";
		public static final String KEY_TREASURE_FLAG = "treasure_flag";
		public static final String KEY_VICTORY_FLAG = "victory_flag";
		public static final String KEY_CURSE_FLAG = "curse_flag";
		public static final String KEY_DOMINION_SET = "dominion_set";
		
		// Create table SQLite query:
		public static final String CREATE_DOMINION_CARDS_TABLE = 
				"CREATE TABLE " + TABLE_DOMINION_CARDS + "(" +
					KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
					KEY_NAME + " TEXT," +
					KEY_COST + " INTEGER," +
					KEY_ACTION_FLAG + " INTEGER, " +
					KEY_ATTACK_FLAG + " INTEGER, " +
					KEY_REACTION_FLAG + " INTEGER, " +
					KEY_TREASURE_FLAG + " INTEGER, " +
					KEY_VICTORY_FLAG + " INTEGER," +
					KEY_CURSE_FLAG + " INTEGER," +
					KEY_DOMINION_SET + " TEXT" +
				")";
		
		/**
		 * Inserts the given {@link DominionCard} into the {@link DominionCardsTable} table.
		 * @param db A SQLite database containing the {@link DominionCardsTable} table.
		 * @param card The card to be inserted.
		 * @return The row ID of the newly inserted row, or -1 if an error occurred 
		 */
		public static long insertDominionCard(SQLiteDatabase db, DominionCard card){
			Log.d("DominionCardsTable", "insertDominionCard()...");
			
			// Set content values:
			ContentValues values = createContentValuesFromDominionCard(card);
			
			// Insert into table:
			return db.insert(TABLE_DOMINION_CARDS, null, values);
		}
		
		/**
		 * Retrieves the {@link DominionCard} with the given ID from the given database.
		 * @param db A SQLite database containing the {@link DominionCardsTable} table.
		 * @param id The ID of the requested card.
		 * @return The requested card, or null if it's not in the table.
		 */
		public static DominionCard getDominionCard(SQLiteDatabase db, int id){
			Log.d("DominionCardsTable", "getDominionCard()...");
			
			Cursor cursor = db.query(TABLE_DOMINION_CARDS, // table name
					getAllDominionCardColumns(),
					KEY_ID + "=?", // selection
					new String[] { String.valueOf(id) }, // selection arguments
					null, // group by
					null, // having
					null); // order by
			if (cursor == null)
			{
				// Early exit: return null
				return null;
			}
			
			cursor.moveToFirst();
			return createFromCursorToAllDominionCardColumns(cursor);
		}
		
		/**
		 * Retrieves all {@link DominionCard} items in the database with the given {@link DominionSet}.
		 * @param db A SQLite database containing the {@link DominionCardsTable} table.
		 * @param cardSets A collection of {@link DominionSet} to filter on.
		 * @return All dominion cards of the given sets in the database.
		 */
		public static ArrayList<DominionCard> getDominionCardsByCardset(SQLiteDatabase db, List<DominionSet> cardSets){
			Log.d("DominionCardsTable", "getDominionCardsByCardset()...");
			
			ArrayList<DominionCard> cardList = new ArrayList<DominionCard>();
			if (cardSets.size() == 0) return cardList;
			
			StringBuilder builder = new StringBuilder();
			builder.append(KEY_DOMINION_SET + "=?");
			
			for (int i = 1; i < cardSets.size(); i++) {
				builder.append("OR " + KEY_DOMINION_SET + "=?");
			}
			String selection = builder.toString();
			
			String[] selectionArgs = new String[cardSets.size()];
			for (int i = 0; i < cardSets.size(); i++) {
				selectionArgs[i] = cardSets.get(i).name();
			}
			Cursor cursor = db.query(TABLE_DOMINION_CARDS,
					getAllDominionCardColumns(),
					selection, // selection
					selectionArgs, // selection arguments
					null, // group by
					null, // having
					null); // order by
			
			// Iterate through all the data, if available:
			if (cursor != null && cursor.moveToFirst()){
				do{
					cardList.add(createFromCursorToAllDominionCardColumns(cursor));
				} while (cursor.moveToNext());
			}
			
			// Return the list:
			return cardList;
		}
		
		/**
		 * Retrieves all {@link DominionCard} items in the given database.
		 * @param db A SQLite database containing the {@link DominionCardsTable} table.
		 * @return All dominion cards in the database
		 */
		public static ArrayList<DominionCard> getAllDominionCards(SQLiteDatabase db) {
			Log.d("DominionCardsTable", "getAllDominionCards()...");
			
			ArrayList<DominionCard> cardList = new ArrayList<DominionCard>();
			
			Cursor cursor = db.query(TABLE_DOMINION_CARDS,
					getAllDominionCardColumns(),
					null, // selection
					null, // selection arguments
					null, // group by
					null, // having
					null); // order by
			
			// Iterate through all the data, if available:
			if (cursor != null && cursor.moveToFirst()){
				do{
					cardList.add(createFromCursorToAllDominionCardColumns(cursor));
				} while (cursor.moveToNext());
			}
			
			// Return the list:
			return cardList;
		}
		
		/**
		 * Returns the DominionCards Table Column selection criteria 
		 * for selection all columns.
		 * @return All column keys.
		 */
		private static String[] getAllDominionCardColumns(){
			return new String[] {
					KEY_ID,
					KEY_NAME,
					KEY_COST,
					KEY_ACTION_FLAG,
					KEY_ATTACK_FLAG,
					KEY_REACTION_FLAG,
					KEY_TREASURE_FLAG,
					KEY_VICTORY_FLAG,
					KEY_CURSE_FLAG,
					KEY_DOMINION_SET
				};
		}
		
		/**
		 * Creates a {@link DominionCard} based on the current cursor position.
		 * @Note: Should only be used a cursor built with {@link this.getAllDominionCardColumns}.
		 * @param cursor Cursor at a DominionCard row.
		 * @return The card.
		 */
		private static DominionCard createFromCursorToAllDominionCardColumns(Cursor cursor){
			return new DominionCard(Integer.parseInt(cursor.getString(0)), 
					cursor.getString(1), 
					Integer.parseInt(cursor.getString(2)), 
					Integer.parseInt(cursor.getString(3)) != 0, 
					Integer.parseInt(cursor.getString(4)) != 0,
					Integer.parseInt(cursor.getString(5)) != 0,
					Integer.parseInt(cursor.getString(6)) != 0, 
					Integer.parseInt(cursor.getString(7)) != 0,
					Integer.parseInt(cursor.getString(8)) != 0,
					DominionSet.valueOf(cursor.getString(9)));
		}
		
		/**
		 * Creates the database {@link ContentValues} object based on a {@link DominionCard} object.
		 * @param card The reference card.
		 * @return The ContentValues filled with data from the given card.
		 */
		private static ContentValues createContentValuesFromDominionCard(DominionCard card){
			ContentValues values = new ContentValues();
			values.put(KEY_NAME, card.get_name());
			values.put(KEY_COST, card.get_cost());
			values.put(KEY_ACTION_FLAG, card.isAction() ? 1 : 0);
			values.put(KEY_ATTACK_FLAG, card.isAttack() ? 1 : 0);
			values.put(KEY_REACTION_FLAG, card.isReaction() ? 1 : 0);
			values.put(KEY_TREASURE_FLAG, card.isTreasure() ? 1 : 0);
			values.put(KEY_VICTORY_FLAG, card.isVictory() ? 1 : 0);
			values.put(KEY_CURSE_FLAG, card.isCurse() ? 1 : 0);
			values.put(KEY_DOMINION_SET, card.get_dominionSet().name());
			
			return values;
		}

		/**
		 * Updates a {@link DominionCard} in the database table.
		 * @param db A SQLite database containing the {@link DominionCardsTable} table.
		 * @param card The updated card.
		 * @return The number of affected rows.
		 */
		public static int updateDominionCard(SQLiteDatabase db, DominionCard card){
			Log.d("DominionCardsTable", "updateDominionCard()...");
			
			ContentValues values = createContentValuesFromDominionCard(card);
			
			return db.update(TABLE_DOMINION_CARDS,
					values,
					KEY_ID + " = ?",
					new String[]{ String.valueOf(card.get_id()) });
		}
		
		public static void populateFromDominionCardsFile(Context context, SQLiteDatabase db) throws IOException {
			final Resources resources = context.getResources();
			InputStream inputStream = resources.openRawResource(R.raw.dominioncards);
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			
			try {
				String line;
				boolean firstLine = true;
				while((line = reader.readLine()) != null) {
					// Skip header
					if (firstLine){
						firstLine = false;
						continue;
					}
					
					String[] strings = TextUtils.split(line, ";");
					if(strings.length != 9) continue; // Invalid row, skip
					
					DominionCard card = new DominionCard(-1, 
						strings[0], 
						Integer.parseInt(strings[1]),
						strings[2].length() > 0,
						strings[3].length() > 0,
						strings[4].length() > 0,
						strings[5].length() > 0,
						strings[6].length() > 0,
						strings[7].length() > 0,
						DominionSet.valueOf(strings[8]));
					long id = DominionCardsTable.insertDominionCard(db, card);
					
					if (id < 0)	{
						Log.d("DominionCardsTable", "Unable to add card: " + strings[0].trim());
					}
				}
			} finally {
				reader.close();
			}
			
		}
	}
}
