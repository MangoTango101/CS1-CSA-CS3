public class Dog extends Animal
{
    private boolean goodBoy;

    public Dog(String name, int birthYear, boolean gb)
    {
        super(name, birthYear);
        goodBoy = gb;
    }

    @Override
    public String toString()
    {
        String ret = super.toString();

        if(goodBoy)
        {
            ret += "I am a good boy!";
        }
        else
        {
            ret += "I am a bad boy >:(";
        }

        return ret;
    }
}
