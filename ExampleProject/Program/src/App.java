public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World ! again");
        System.out.println(Factorial((0)));
        System.out.println(Factorial((1)));
        System.out.println(Factorial((2)));
        System.out.println(Factorial((3)));
        System.out.println(Factorial((4)));
    }

    private static int Factorial(int n){

        int res = 1;
        for (int i = 1; i <= n; i++) {
            res = res * i;
        }
        return  res;
    }
}
