package org.mathlib.core;

import org.mathlib.core.Functions.*;
import org.mathlib.core.Operators.*;

public class PopulateMaps {
	public static void Populate(){
		TokenMap.addTok(new Add());
		TokenMap.addTok(new Subtract());
		TokenMap.addTok(new Multiply());
		TokenMap.addTok(new Division());
		TokenMap.addTok(new Exponent());
		TokenMap.addTok(new Paran(")"));
		TokenMap.addTok(new Paran("("));
		TokenMap.addTok(new Modulo());
        TokenMap.addTok(new Sine());
        TokenMap.addTok(new Cosine());
        TokenMap.addTok(new Tangent());
        TokenMap.addTok(new ArcSine());
        TokenMap.addTok(new ArcCosine());
        TokenMap.addTok(new Tangent());
        TokenMap.addTok(new AbsoluteValue());
        TokenMap.addTok(new Log());
        TokenMap.addTok(new Ln());
	}
}
