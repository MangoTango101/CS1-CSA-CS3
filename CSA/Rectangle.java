import java.util.Random;
public class Rectangle {
    private int length, width;
    public Rectangle()
    {
        Random rand = new Random();
        length = rand.nextInt(10) + 1;
        width = rand.nextInt(10) + 1;
    }
    public Rectangle(int lengthy, int widthy){
        length = lengthy;
        width = widthy;
    }
    public int getLength(){
        return length;
    }
    public void setLength(int newLength){
        length = newLength;
    }
    public int getWidth(){
        return width;
    }
    public void setWidth(int newWidth){
        width = newWidth;
    }
    public int getArea(){
        return length * width;
    }
    public int getPerimeter(){
        return length + length + width + width;
    }
    public String toString(){
        return ("L: "+ length +" W: " + width);
    }
}