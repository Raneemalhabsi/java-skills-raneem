public class PatternMaker{
    // Print a number triangle
    public static void printNumberTriangle(int rows) {
        for (int i=1; i< rows;i++){
            for (int j=1; j< i; j++){
                System.out.print(j+ " ");
            }
            System.out.println();
        }
    }

    // Print multiplication table
    public static void printMultiplicationTable(int number, int limit) {
        int result =0;
        for (int i=1; i<=limit; i++){
            result = number * i;
            System.out.println(number + "x" + i + "=" + result);
        }
// Print: number x 1 = result, number x 2 = result, etc.
// Up to the limit
    }

    public static void main(String[] args) {
        printNumberTriangle(5);
        System.out.println();
        printMultiplicationTable(7, 10);
    }
}
