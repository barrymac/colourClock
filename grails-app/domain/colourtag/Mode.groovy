package colourtag

/**
 * Created with IntelliJ IDEA.
 * User: barry
 * Date: 6/9/13
 * Time: 1:33 PM
 * To change this template use File | Settings | File Templates.
 */
public enum Mode {
    UNKNOWN(0), SPRING(1), SUMMER(2), AUTUMN(3), WINTER(4)

    Mode(int value) { this.value = value }

    private final int value

    public int value() { return value }

    private static final Map<Integer, Mode> intToTypeMap = new HashMap<Integer, Mode>()

    static {
        for (Mode type : Mode.values()) {
            intToTypeMap.put(type.value, type);
        }
    }

    public static Mode fromInt(int i) {
        Mode type = intToTypeMap.get(Integer.valueOf(i));
        if (type == null)
            return Mode.UNKNOWN;
        return type;
    }


}