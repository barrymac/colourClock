package colourtag

/**
 * Created with IntelliJ IDEA.
 * User: barry
 * Date: 6/9/13
 * Time: 1:33 PM
 * To change this template use File | Settings | File Templates.
 */
public enum Tone {
    UNKNOWN(0), LIGHT(1), DARK(2), BRIGHT(3), MUTED(4), COOL(5), WARM(6)

    Tone(int value) { this.value = value }

    private final int value

    public int value() { return value }


    private static final Map<Integer, Tone> intToTypeMap = new HashMap<Integer, Tone>()

    static {
        for (Tone type : Tone.values()) {
            intToTypeMap.put(type.value, type);
        }
    }

    public static Tone fromInt(int i) {
        Tone type = intToTypeMap.get(Integer.valueOf(i));
        if (type == null)
            return Tone.UNKNOWN;
        return type;
    }

}