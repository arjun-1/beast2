package beast.evolution.datatype;

import beast.core.Description;
import beast.evolution.datatype.DataType.Base;

@Description("Datatype for integer sequences")
public class IntegerData extends Base {

    //since the stateCount may vary per user, we use a static to set 
    //this variable when importing
    private static int nrOfStates;

    public static void setNrOfStates(int newNrOfStates) {
        nrOfStates = newNrOfStates;
    }

    public IntegerData() {
    	// i - iMin in {0,1,...,iMax = 14 = 15 -1} represents all the possible
        // states for our repeats. Thus 0,1,...,14 are codes for the states
        // i - iMin = 0,1,...,14. Furthermore, 15 codes for the ambigiuous 
        // state: 15 could thus mean any of the 15 states mentioned before.

        //stateCount is overwritten in the substitutionmodel, using
        //setStateCount()
        stateCount = nrOfStates;
        mapCodeToStateSet = new int[stateCount + 1][];
        for (int i = 0; i < stateCount; i++) {
            mapCodeToStateSet[i] = new int[1];
            mapCodeToStateSet[i][0] = i;
        }
        int[] all = new int[stateCount];
        for (int i = 0; i < stateCount; i++) {
            all[i] = i;
        }
        mapCodeToStateSet[stateCount] = all;

        codeLength = -1;
        codeMap = null;
    }
    
    @Override
    public String getTypeDescription() {
        return "integer";
    }
    
    @Override
    public boolean isAmbiguousState(int state) {
    	return state == stateCount;
    }
    
    @Override
    public char getChar(int state) {
    	if (state == stateCount) {
    		return '?';
    	}
        return (char)('0' + state);
    }

}
