package unif.type;

/** TypeMapper.java
	*
	* @author <a href="mailto:joque@cit.mak.ac.ug">Jose Ghislain Quenum</a>
	* @version 0.9 - 11/2009
*/

import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public final class TypeMapper{
	private final HashMap<? extends Type, Set<? extends Type>> mappings;
	private static TypeMapper mapper = new TypeMapper();
	
	private TypeMapper(){
		mappings = new HashMap<? extends Type, Set<? extends Type>>();
	}
	
	public static TypeMapper getReference(){
		return mapper;
	}
	
	public void addEntry(final Type leftHandType, final Type rightHandType){
		if(mappings.containsKey(leftHandtype)){
			Set<? extends Type> vals = mappings.get(leftHandType);
			vals.add(rightHandType);
		} else {
			Set<Type> rightVals = new HashSet<Type>();
			rightVals.add(rightHandType);
			mappings.put(leftHandType, rightVals);
		}
	}
	
	//this is the checkMapping1 in the initial implementation
	public boolean checkDirectMapping(final Type leftHandType, final Type rightHandType){
		
		for(Map.Entry<? extends Type,Set<? extends Type>> substEntry: mappings.entrySet()){
			final Type entryKey = substEntry.getKey();
			final Set<? extends Type> entryValue = substEntry.getValue();
			//do the check and return the result
		}
	}
	
}