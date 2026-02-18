import java.util.Arrays;
import java.util.Random;

public class MainService {

    private static float GRAVITY = 9.80665f;

        public static final void main(String[] args) {


            //-------0.uzdevums
                String[] names = { "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt",
        "Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron",
        "Kate" };
        int[] times = { 341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393,
        299, 343, 317, 265 };

        int howManyElements = names.length;
        if(names.length >times.length) {
            howManyElements = times.length;
        }
        for (int i=0; i < howManyElements ; i++) {
            // System.out.println(names[i] + " " + times[i] + " sec");

        }


        // --------1.uzdevums
        try {
            double res1 = positionCalc(10, 5, 0);
            System.out.println("Bumbinas pozicija ir " + res1 + " m");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }


        //-------------- 2.uzdevums
        int N = 5;
               System.out.println("2.uzdevums");
        try {
            int res2 = factorialForLoop(N);
            System.out.println(N + " faktorials ir " + res2);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        //------------- 3.uzdevums
       int array_N = 10;
       double lower = 4;
       double upper = 10;
       System.out.println("3.uzdevums");
        try {
            double[] res3 = generateArray(array_N, lower, upper);
            System.out.println(Arrays.toString(res3));
            double res4 = getMean(res3);
            System.out.println(res4);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }



        // -------------- 4.uzdevums
     int array_N2 = 20;
       System.out.println("4.uzdevums");
        try {
            double[][] res5 = generateMatrix(array_N2);
            System.out.println(Arrays.toString(res5));
            double res6 = getProduct(res5,2,3);
            System.out.println(res6);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }








    //  ----------- 1.uzdevums ----------
    private static double positionCalc(double initialVelocity, double
initialPosition, double fallingTime) throws Exception{
    //x(t) = 0.5 × a*t^2 + v_0*t + x_0

    if(initialVelocity >= 0 && initialPosition >= 0 && fallingTime >= 0){

    double result = 0.5 * GRAVITY * Math.pow(fallingTime,2)
     + initialVelocity * fallingTime + initialPosition;

    return result;
    }
    else {
        throw new Exception("Nevar aprekinat, jo kads no ievades datiem nav korekts");
    }
}

    // ------------- 2.uzdevums --------------
private static int factorialForLoop(int N) throws Exception{

    if (N>0){
        int res = 1;
        for (int i = 1; i<=N;i++){
            res *= i;
        }
        return res;
    }
    else {
        throw new Exception("Nevar aprekinat, jo N ir negativs vai 0");
    }
}

    //----------- 3.uzdevums -------------
    private static double[] generateArray(int N, double lower, double upper) throws Exception {
        if (N<=0) {
            throw new Exception("Nevar izveidot masivu, kura garums ir negativs vai 0");
        }


        double[] randomNumbers = new double[N];
        Random rand = new Random();

        for (int i = 0 ; i < N ; i++){
            randomNumbers[i] = lower + (upper - lower) * rand.nextDouble();
        }

        return randomNumbers;
    }

private static double getMean(double[] array) throws Exception{
    if (array == null){//ienakosais masivs ir bez references jeb nav notikusi inicializacija
        throw new Exception("Ienakosais masivs nav inicializets un tam nav adrese");
    }

    if(array.length == 0){
        throw new Exception("Nevar aprekinat videjo vertibu, jo masiva nav elementu");
    }

        double sum = 0;
        for (int i = 0 ; i < array.length ; i++){
            sum +=array[i];
        }
        double meanValue = sum/array.length;

    return meanValue;
}




// ------------- 4.uzdevums -----------------
    private static double[][] generateMatrix(int N) throws Exception{
      if (N<=0) {
            throw new Exception("Nevar izveidot matricu, kura garums ir negativs vai 0");
        }


        double[][] randomNumbers2 = new double[N][N];
        Random rand = new Random();
        for (int j = 0 ; j < N ; j++){
            for (int i = 0 ; i < N ; i++){
                randomNumbers2[j][i] = 1 + (20 - 1) * rand.nextDouble();
            }
        }
 

        return randomNumbers2;
    }
    private static double getProduct(double[][] matrix, int i, int j) throws Exception{
            if (matrix == null){//ienakosais masivs ir bez references jeb nav notikusi inicializacija
        throw new Exception("Ienakosais masivs nav inicializets un tam nav adrese");
    }

    if (i <= 0 || j<=0){
    throw new Exception("dotas koordinatas nav pareizas");
    }
    if (i > matrix.length || j> matrix[0].length){
    throw new Exception("vertibas ir arpus matricas");
    }
    double result_product = matrix[i][j];

    return result_product;
    }


}
