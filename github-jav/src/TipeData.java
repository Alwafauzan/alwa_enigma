/**
 * TipeData
 */
public class TipeData {

    public static void main(String[] args) {
        double doubleValue = 100.99;
        float floatValue = (float) doubleValue; // casting dari double ke float
        long longValue = (long) floatValue; // casting dari float ke long
        int intValue = (int) longValue; // casting dari long ke int
        short shortValue = (short) intValue; // casting dari int ke short
        byte byteValue = (byte) shortValue; // casting dari short ke byte
        System.out.println(byteValue);
    }
}