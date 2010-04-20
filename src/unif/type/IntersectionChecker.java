package unif.type;

/** IntersectionChecker.java
	*
	* @author <a href="mailto:joque@me.com">Jose Ghislain Quenum</a>
	* @version 0.9 - 11/2009
*/

import java.util.Collection;

public final class IntersectionChecker{
	private static IntersectionChecker checker = new IntersectionChecker();
	
	private IntersectionChecker(){
	}
	
	public static IntersectionChecker getReference(){
		return checker;
	}
	
	public boolean checkIntersection(final Type secondTypeArg, final Collection<Type> typeElements){
		boolean result = false;
		final String argClassName = secondTypeArg.getClass().getSimpleName();
		if(argClassName.equals("SimpletypeImpl")){
			final SimpleTypeImpl simpleSecond = (SimpleTypeImpl) secondTypeArg;
			if(typeElements.contains(simpleSecond)){
				result = true;
			}
		} else {
			if(argClassName.equals(ChoiceComplexType.CLS_NAME)){
				final ChoiceComplexType choiceSecond = (ChoiceComplexType) secondTypeArg;
				final TypeSet secondElements = choiceSecond.getElements();
				if(typeElements.retainAll(secondElements.getElements())){
					result = true;
				}
			} else {
				if(argClassName.equals(AllComplexType.CLS_NAME)){
					final AllComplexType allSecond = (AllComplexType) secondTypeArg;
					final TypeSet secondElements = allSecond.getElements();
					if(typeElements.retainAll(secondElements.getElements())){
						result = true;
					}
				} else {
					if(argClassName.equals(SequenceComplexType.CLS_NAME)){
						final SequenceComplexType seqSecond = (SequenceComplexType) secondTypeArg;
						final TypeList secondElements = seqSecond.getElements();
						if(typeElements.retainAll(secondElements.getElements())){
							result = true;
						}
					}
				}
			}
		}

		return result;
	}	
}