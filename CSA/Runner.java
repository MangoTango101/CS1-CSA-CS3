public class Runner {
    public static void main(String[] args){
        StringMethods test = new StringMethods();
        test.unusualHello("Rithvik");
        System.out.println(test.stringRipper("something"));
        System.out.println(test.evenFooBar("foobar"));
        System.out.println(test.sumString("Hi 5 there are 2 or 3 numbers in this String"));
        System.out.println(test.decode(" h e l l o   w o r l d "," 6 4 0 5 3 7 2 "));
    }
}
