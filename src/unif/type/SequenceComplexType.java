package unif.type;

/** SequenceComplexType.java
	*
	* @author <a href="mailto:joque@cit.mak.ac.ug">Jose Ghislain Quenum</a>
	* @version 0.9 - 11/2009
*/

import java.util.HashSet;
import java.util.Set;

public final class ChoiceComplexType extends ComplexTypeImpl {
	private static final String CLS_NAME = "ComplexTypeImpl";
	private final TypeList typeElements;
	
	
	public ChoiceComplexType(){
		super("choice");
		typeElements = new TypeList();
	}
	
	//add equals and hashCode methods
	
	public abstract boolean isEquivalentToSimple(final SimpleTypeImpl secondTypeArg){
		return false;
	}
	
}
