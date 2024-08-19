public class Runner {
    public static void main(String[] args) {
        Rectangle one = new Rectangle(3,4);
        Rectangle two = new Rectangle(2,2);
        Rectangle three = new Rectangle(1,6);
        System.out.println(one);
        one.setWidth(6);
        System.out.println(one.getWidth());
        System.out.println(two.getArea());
        System.out.println(three.getPerimeter());
    }
}

