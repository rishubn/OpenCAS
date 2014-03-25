package org.mathlib.core;

import java.util.HashMap;
import java.util.Map;

public class TokenMap {
	private static Map<String,Token> tMap = new HashMap<String,Token>();
	
	public static void addTok(Token o){
		tMap.put(o.toString(), o);
	}
	public static boolean isToken(String t)
    {
        if(tMap.containsKey(t.trim())){ return true; }else{ return false; }
    }
	public static Map<String, Token> getMap(){
		return tMap;
	}

    public static Token getTok(String s)
    {

        if(isToken(s))
        {
            return tMap.get(s);
        }
        return null;



    }

}
