public class Word
{
    private String word;
    private int count;

    public Word(String w)
    {
        word = w;
        count = 0;
    }

    public String getWord()
    {
        return word;
    }

    public int getCount()
    {
        return count;
    }

    public void increment()
    {
        count++;
    }

    public String toString()
    {
        int updateCount = count + 1;
        return word + "\t\t" + updateCount;
    }

}
