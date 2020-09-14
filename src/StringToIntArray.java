public class StringToIntArray {
    /**
     * Converts an array of string (containing numbers) to an array of integers
     * @param textArray the array we want to convert to int
     * @return int array
     */
    public static int[] convert(String[] textArray){
        int[] intArray = new int[textArray.length];
        for(int i = 0; i < textArray.length; i++){
            intArray[i] = Integer.parseInt(textArray[i]);
        }
        return intArray;
    }
}
