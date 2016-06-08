package beast.evolution.datatype;

import beast.core.Description;
import beast.evolution.datatype.DataType.Base;

@Description("Datatype for integer sequences")
public class IntegerData extends Base {

    public IntegerData() {
    	
    	int nrOfStates = 15;
        stateCount = nrOfStates;
        mapCodeToStateSet = new int[nrOfStates + 1][];
        for (int i = 0; i < nrOfStates; i++) {
            mapCodeToStateSet[i] = new int[1];
            mapCodeToStateSet[i][0] = i;
        }
        int[] all = new int[nrOfStates];
        for (int i = 0; i < nrOfStates; i++) {
            all[i] = i;
        }
        mapCodeToStateSet[nrOfStates] = all;

        codeLength = -1;
        codeMap = null;
    }
    
    @Override
    public String getTypeDescription() {
        return "integer";
    }
    
    @Override
    public boolean isAmbiguousState(int state) {
    	return state == 15;
    }
    
    @Override
    public char getChar(int state) {
    	if (state == 15) {
    		return '?';
    	}
        return (char)('0' + state);
    }

}
