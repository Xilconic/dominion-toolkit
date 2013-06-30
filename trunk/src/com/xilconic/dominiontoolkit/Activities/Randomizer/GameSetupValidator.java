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
package com.xilconic.dominiontoolkit.Activities.Randomizer;

import java.util.Dictionary;
import java.util.List;

import com.xilconic.dominiontoolkit.Activities.Preferences.DominionToolkitPreferences;
import com.xilconic.dominiontoolkit.DominionCards.CardsDB;
import com.xilconic.dominiontoolkit.DominionCards.DominionSet;
import com.xilconic.dominiontoolkit.Utils.ResourcesHelper;

import android.content.Context;

public class GameSetupValidator {
    private Context context;
    
    public GameSetupValidator(Context context){
        this.context = context;
    }
    
    public String validate(){
        String errorMessage = "";
        
        errorMessage = ValidateUserSettings();
        if (errorMessage.length() != 0) return errorMessage;
        
        return errorMessage;
    }

    private String ValidateUserSettings() {
        String errorMessage = "";
        
        errorMessage = ValidateDominionSetRangePreferences();
        if (errorMessage.length() != 0) return errorMessage;
        
        return errorMessage;
    }

    private String ValidateDominionSetRangePreferences() {
        List<DominionSet> activeDominionSets = DominionToolkitPreferences.getActiveDominionSets(context);
        Dictionary<DominionSet, Integer> dominionSetMinimums = DominionToolkitPreferences.getMinimumCardCount(context);
        Dictionary<DominionSet, Integer> dominionSetMaximums = DominionToolkitPreferences.getMaximumCardCount(context);
        
        int minCount = 0, maxCount = 0;
        for (DominionSet dominionSet : activeDominionSets) {
            Integer min = dominionSetMinimums.get(dominionSet);
            if (min > CardsDB.getCardsFromDominionSet(dominionSet).size()){
                return String.format("Gewenst minimum aantal kaarten van de set '%s' groter dan aantal kaarten in de set zelf.", 
                        ResourcesHelper.getDominionSetName(context, dominionSet));
            }
            
            Integer max = dominionSetMaximums.get(dominionSet);
            if (min > max){
                return String.format("Gewenst minimum aantal kaarten voor de set '%s' groter dan het gewenste maximum aantal kaarten uit die set.",
                        ResourcesHelper.getDominionSetName(context, dominionSet));
            }
            minCount += min;
            maxCount += max;
        }
        
        if (minCount > 10){
            return "Som van de gewenste minima is groter dan het aantal toegestane koningkrijk kaarten.";
        }
        if (maxCount < 10){
            return "Som van de gewenste maxima is minder dan het aantal toegestane koningkrijk kaarten.";
        }
        
        return "";
    }
}
