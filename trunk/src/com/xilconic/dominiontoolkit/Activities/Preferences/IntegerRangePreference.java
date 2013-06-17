/*
 * This file is part of Dominion Toolkit.
 *
 *  Dominion Toolkit is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Dominion Toolkit is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with Dominion Toolkit.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.xilconic.dominiontoolkit.Activities.Preferences;

import com.xilconic.dominiontoolkit.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Spinner;

public class IntegerRangePreference extends DialogPreference {
    private final int DEFAULT_MIN_VALUE = 0;
    private final int DEFAULT_MAX_VALUE = 10;
    Spinner minSpinner, maxSpinner;
    int min = DEFAULT_MIN_VALUE, max = DEFAULT_MAX_VALUE;
    
    public IntegerRangePreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        
        // TODO: Read from attributes instead of always overriding
        setDialogLayoutResource(R.layout.integer_range_preference);
        setPositiveButtonText(android.R.string.ok);
        setNegativeButtonText(android.R.string.cancel);
        setDialogTitle(R.string.integerRangePreference_dialog_title);
        setSummary(min, max);
    }
    
    @Override
    protected void onBindDialogView(View view){
        super.onBindDialogView(view);
        
        // Get object references:
        minSpinner = (Spinner) view.findViewById(R.id.minSpinner);
        maxSpinner = (Spinner) view.findViewById(R.id.maxSpinner);
        
        // Update spinners such that they are in sync with persisted range:
        minSpinner.setSelection(min);
        maxSpinner.setSelection(max);
    }

    @Override
    protected void onDialogClosed(boolean positiveResult){
        if (positiveResult){
            min = minSpinner.getSelectedItemPosition();
            max = maxSpinner.getSelectedItemPosition();
            persistInt(createPersistedValue(min, max));
            
            setSummary(min, max);
        }
    }
    
    @Override
    protected void onSetInitialValue(boolean restorePersistedValue, Object defaultValue){
        // Get persisted value or default value:
        int persistedValue;
        if (restorePersistedValue){
            int persistedDefault = createPersistedValue(DEFAULT_MIN_VALUE, DEFAULT_MAX_VALUE);
            persistedValue = getPersistedInt(persistedDefault);
        }else {
            persistedValue = (Integer) defaultValue;
        }

        // Update summary and internals:
        min = getMinValueFromPersisted(persistedValue);
        max = getMaxValueFromPersisted(persistedValue);
        setSummary(min, max);
    }
    
    @Override
    protected Object onGetDefaultValue(TypedArray a, int index){
        int persistedDefault = createPersistedValue(DEFAULT_MIN_VALUE, DEFAULT_MAX_VALUE);
        return a.getInteger(index, persistedDefault);
    }
    
    /**
     * Create the persisted value that is stored in the database.
     * @param min The minimum part of the integer range.
     * @param max The maximum part of the integer range.
     * @return The value as it should appear in the persistence source.
     */
    private static int createPersistedValue(int min, int max){
        return min + 100*max;
    }
    
    /**
     * Retrieves the maximum component of the range from the
     * value from the persistence source.
     * @param persistedValue Persisted value.
     * @return The maximum component of the range 
     *         (should be between 0 and 10, inclusive)
     */
    public static int getMinValueFromPersisted(int persistedValue){
        return persistedValue % 100;
    }
    
    /**
     * Retrieves the minimum component of the range from the
     * value from the persistence source.
     * @param persistedValue Persisted value.
     * @return The minimum component of the range 
     *         (should be between 0 and 10, inclusive)
     */
    public static int getMaxValueFromPersisted(int persistedValue){
        return persistedValue / 100;
    }
    
    /**
     * Helper method to set the summary of this Preference.
     * @param minValue Minimum value component of the range.
     * @param maxValue Maximum value component of the range.
     */
    private void setSummary(int minValue, int maxValue){
        setSummary(String.format("%s: [%d, %d]", 
                getContext().getString(R.string.integerRangePreference_range), min, max));
    }
}
