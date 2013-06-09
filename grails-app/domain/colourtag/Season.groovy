package colourtag

/**
 * Created with IntelliJ IDEA.
 * User: barry
 * Date: 6/9/13
 * Time: 1:33 PM
 * To change this template use File | Settings | File Templates.
 */
public enum Season {
    UNKNOWN(0), SPRING(1), SUMMER(2), AUTUMN(3), WINTER(4)

    Season(int value) { this.value = value }

    private final int value

    public int value() { return value }

    private static final Map<Integer, Season> intToTypeMap = new HashMap<Integer, Season>()

    static {
        for (Season type : Season.values()) {
            intToTypeMap.put(type.value, type);
        }
    }

    public static Season fromInt(int i) {
        Season type = intToTypeMap.get(Integer.valueOf(i));
        if (type == null)
            return Season.UNKNOWN;
        return type;
    }


}