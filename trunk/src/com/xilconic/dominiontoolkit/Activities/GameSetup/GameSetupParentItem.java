package com.xilconic.dominiontoolkit.Activities.GameSetup;

import java.util.ArrayList;

import com.xilconic.dominiontoolkit.DominionCards.AmountOfDominionGameItem;

public class GameSetupParentItem {
	private String title;
	private ArrayList<AmountOfDominionGameItem> arrayChildren;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public ArrayList<AmountOfDominionGameItem> getArrayChildren() {
		return arrayChildren;
	}
	public void setArrayChildren(ArrayList<AmountOfDominionGameItem> arrayChildren) {
		this.arrayChildren = arrayChildren;
	}
	
	@Override
	public String toString(){
		return title;
	}
}
