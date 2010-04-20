package unif.type;

/** SimpleTypeImpl.java
	*
	* @author <a href="mailto:joque@me.com">Jose Ghislain Quenum</a>
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
		dict = SimpleTypeDictionary.getReference();
	}
	
	public SimpleType getSimpleType(){
		return simpleType;
	}
	
	public boolean equals(Object object){
		boolean result = true ;
		
		//Simply return false when the current type is null
		if(this.simpleType == null){
			result = false;
		} else {
			if(! (object instanceof SimpleTypeImpl)){
				result =  false;			
			} else {
				final SimpleTypeImpl simpleTypeImplObject = (SimpleTypeImpl) object;
				final SimpleType simpleTypeObject = simpleTypeImplObject.getSimpleType();

				if((simpleTypeObject == null) || (! simpleTypeObject.getTypeName().equals(simpleType.getTypeName()))){
					result = false;
				}
			}
		}
		
		return result;
	}
		
	public int hashCode(){
		int hashCodeValue = 17;
		if(simpleType != null){
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
			return isSimpleTypeEquivalence(simpleSecondTypeArg);
		} else {
			final ComplexTypeImpl complexSecondTypeArg = (ComplexTypeImpl) secondTypeArg;
			return complexSecondTypeArg.isEquivalent(this);
		}
	}
	
	private boolean isSimpleTypeEquivalence(final SimpleTypeImpl simpleSecondTypeArg){
		boolean equivResult = false;
		
		if(checkDictionaryEqual(simpleSecondTypeArg)){
			equivResult = true;
		}
		
		return equivResult;
	}
	
	private boolean checkDictionaryEqual(final SimpleTypeImpl simpleTypeI){
		final SimpleType simpleType = simpleTypeI.getSimpleType();
		if(simpleType == null){
			return false;
		}
		
		final String currentDictVal = dict.getValue(this.simpleType);
		final String secondDictVal = dict.getValue(simpleType);
		
		if ((currentDictVal == null) || (secondDictVal == null)){
			return false;
		}
		
		//Any equivalence between simple types is strictly 
		//determined by the SimpletypeDictionary
		if(currentDictVal.equals(secondDictVal)){
			return true;
		} else {
			return false;
		}
	}
}