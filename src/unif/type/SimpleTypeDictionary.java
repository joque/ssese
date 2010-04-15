package unif.type;

/** ComplexTypeImpl.java
	*
	*This is an embbeded dictionary for simple types
	*Since our type equivalene does not consider all the simple 
	*built-in types XML, we offer a generalization, where we elect a 
	* representative per category
	* @author <a href="mailto:joque@me.com">Jose Ghislain Quenum</a>
	* @version 0.9 - 11/2009
*/

import java.util.Map;
import java.util.HashMap;

public final class SimpleTypeDictionary{
	private final Map<SimpleType, String> typeDictionary;
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