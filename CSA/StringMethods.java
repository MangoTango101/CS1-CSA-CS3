import java.util.Scanner;

public class StringMethods {
    public StringMethods() {

    }

    public void unusualHello(String name) {
        System.out.println("Hello " + name + ", you dummy!");
    }

    public String stringRipper(String str) {
        int length = str.length();
        char num1 = str.charAt(0);
        char num2 = str.charAt(length - 1);
        return String.valueOf(num1 + num2);
    }

    public boolean evenFooBar(String s) {
        int counter1 = 0;
        int counter2 = 0;
        for (int x = 3; x <= s.length(); x++) {
            if (s.substring(x - 3, x).equals("foo")) {
                counter1++;
            }
            if (s.substring(x - 3, x).equals("bar")) {
                counter2++;
            }
        }
        return counter1 == counter2;
    }
    public int sumString(String str){
        Scanner split = new Scanner(str);
        int num = 0;
        while(split.hasNext())
        {
            if(split.hasNextInt())
                num += (split.nextInt());
            else
                split.next();
        }
        return num;
    }
    public String decode(String key, String code)
    {
        Scanner split = new Scanner(code);
        int[] Array = new int[(code.length() - 1) / 2];
        for(int x = 0; x < Array.length; x++){
            if(split.hasNext()){
                if(split.hasNextInt()){
                    Array[x] = (split.nextInt());
                }
                else{
                    split.next();
                }
            }
        }
        String str = "";
        String newKey = "";
        for(int y = 0; y < key.length(); y++){
            if(y % 2 != 0)
                newKey += key.charAt(y);
        }
        for(int z = 0; z < Array.length; z++)
            str += newKey.charAt(Array[z]);
        return str;
    }
}
