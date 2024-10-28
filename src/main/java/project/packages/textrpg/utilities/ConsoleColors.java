package project.packages.textrpg.utilities;

//class for changing text in console using ANSI escape codes

public class ConsoleColors {
    // Reset color
    public static final String RESET = "\033[0m";  // Reset to default
    // Text colors
    public static final String RED = "\033[31m";    // Red
    public static final String GREEN = "\033[32m";  // Green
    public static final String YELLOW = "\033[33m"; // Yellow
    public static final String BLUE = "\033[34m";   // Blue
    public static final String MAGENTA = "\033[35m"; // Magenta
    public static final String CYAN = "\033[36m";   // Cyan
    public static final String WHITE = "\033[37m";  // White
}
