/**
 * Клас FibonachiNumb із полями порядкового номеру числа Фібоначчі{@link FibonachiNumb {@number}}
 * і значення самого числа {@link FibonachiNumb {@value}.
 * @author Олена Плисюк
 */
public class FibonachiNumb {

    private int number;
    private long value;

    public FibonachiNumb()
    {

    }

    public void setNumber(int number)
    {
        this.number = number;
    }

    public void setValue(long value)
    {
        this.value = value;
    }


    public FibonachiNumb(int number, long value)
    {
        this.number = number;
        this.value = value;
    }

    public int getNumber()
    {
        return number;
    }

    public long getValue()
    {
        return value;
    }
}
