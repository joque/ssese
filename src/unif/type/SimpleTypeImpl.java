package unif.type;

/** SimpleTypeImpl.java
	*
	* @author <a href="mailto:joque@cit.mak.ac.ug">Jose Ghislain Quenum</a>
	* @version 0.9 - 11/2009
*/

import java.util.HashMap;

public final class SimpleTypeImpl implements Type {
	private final SimpleType simpleType;
	private final TypeMapper substitutions;
	private final SimpleTypeDictionary dict;
	private static final String CLS_NAME = "SimpleTypeImpl";
		
	public SimpleTypeImpl(final String typeName){
		simpleType = SimpleType.getSimpleTypeInstance(typeName);
		substitutions = TypeMapper.getReference();
		dict = SimpeTypeDictionary.getReference();
	}
	
	public SimpleType getSimpleType(){
		return simpleType;
	}
	
	public boolean equals(Object object){
		//Simply return false when the current type is null
		if(this.simpleType == null){
			return false;
		}
		
		if(! (object instanceof SimpleTypeImpl)){
			return false;			
		}
		
		final SimpleTypeImpl simpleTypeImplObject = (SimpleTypeImpl) object;
		final SimpleType simpleTypeObject = simpleTypeImplObject.getSimpleType();
		
		if((simpleTypeObject != null) && (simpleTypeObject.getTypeName().equals(simpleType.getTypeName()))){
			return true;
		} else {
			return false;
		}
	}
		
	public int hashCode(){
		int hashCodeValue = 17;
		if(simpeType != null){
			hashCodeValue = (37 * hashCodeValue) + simpleType.hashCode();			
		}
		
		return hashCodeValue;
	}
	
	public boolean isEquivalent(final Type secondTypeArg){
		//Should do the same as in equals()
		if(this.simpleType == null) return false;
		
		final String secondTypeClsName = secondTypeArg.getClass().getSimpleName();
		if(secondTypeClsName.equals(CLS_NAME)) {
			final SimpleTypeImpl simpleSecondTypeArg = (SimpleTypeImpl) secondTypeArg;
			return isSimpleTypeEquivalence(simpleSecondTypeArg, substitutions);
		} else {
			final ComplexTypeImpl complexSecondTypeArg = (ComplexTypeImpl) secondTypeArg;
			return complexSecondTypeArg.isEquivalent(this);
		}
	}
	
	private boolean isSimpleTypeEquivalence(final SimpleTypeImpl simpleSecondTypeArg){
		boolean equivResult = false;
		
		if(checkDirectMapping(simpleSecondTypeArg)){
			equivResult = true;
		} else {
			if(checkDictionaryEqual(simpleSecondTypeArg)){
				equivResult = true;
			}
		}
		
		return equivResult;
	}
	
	private boolean checkDirectMapping(final SimpleTypeImpl secondType){
		return substitutions.checkDirectMapping(this, secondType);
	}
	
	private boolean checkDictionaryEqual(final SimpleTypeImpl simpleTypeI){
		final SimpleType simpleType = simpleTypeI.getSimpleType();
		if(simpletype == null){
			return false;
		}
		
		final String currentDictVal = dict.get(this.simpleType);
		final String secondDictVal = dict.get(simpleType);
		
		if ((currentDictVal == null) || (secondDictVal == null)){
			return false;
		}
		
		if(currentDictVal.equals(secondDictVal)){
			//should update the mappings
			substitutions.addEntry(this, simpleTypeI);
			return true;
		} else {
			return false;
		}
	}
	
	
	//This is an embbeded dictionary for simple types
	class SimpleTypeDictionary{
		private final HashMap<SimpleType, String> typeDictionary;
		private static SimpleTypeDictionary simpleTypeDict = new SimpleTypeDictionary();
		
		private SimpleTypeDictionary(){
			typeDictionary = new HashMap<SimpleType,String>();
		}
		
		public static SimpleTypeDictionary getReference(){
			return simpleTypeDict;
		}
		
		public void addEntry(final SimpleType mySimpleType, final String value){
			if(mySimpleType == null){
				return;
			}

			typeDictionary.put(mySimpleType, value);
		}
		
		public String getValue(final SimpleType mySimpleType){
			return typeDictionary.get(mySimpleType);
		}
	}
}