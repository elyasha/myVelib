package core.components;

/**
 * Singleton class. Eagerly initialized static instance guarantees thread safety.
 */
public final class Terminal {
    // singleton pattern

    /**
     * Private constructor so nobody can instantiate the class.
     */
    private Terminal() {
    }

    /**
     * Static to class instance of the class.
     */
    private static final Terminal INSTANCE = new Terminal();

    /**
     * To be called by user to obtain instance of the class.
     *
     * @return instance of the singleton.
     */
    public static Terminal getInstance() {
        return INSTANCE;
    }

}
