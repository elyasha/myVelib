public class test {

    public static void main(String[] args) {
        String s = "nana";
        int a = 3;

        try {
            int b = Integer.parseInt(s);
            System.out.println(b);

        }
        catch (NumberFormatException numberFormatException) {
            System.out.println(numberFormatException.getMessage());;
        }


    }

}
