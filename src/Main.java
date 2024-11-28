

public class Main {
    public static void main(String[] args) {
        System.out.format("Java version: %s%n", getJavaVersion());
        double sum = Calculator.add(5, 6, 7);
        System.out.format("Sum: %.1f%n", sum);
    }


    /** get the java version that is running the current program
     * @return string containing the java version running the current program
     */
    private static String getJavaVersion()
    {
        Runtime.Version rtv = Runtime.version();
        return String.format("%s.%s.%s.%s", rtv.feature(), rtv.interim(), rtv.update(), rtv.patch());
    }
}