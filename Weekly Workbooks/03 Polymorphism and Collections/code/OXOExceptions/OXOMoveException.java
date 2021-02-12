package OXOExceptions;

public class OXOMoveException extends Exception
{
    private int rowNumber;
    private int columnNumber;

    public OXOMoveException()
    {
    }

    public OXOMoveException(int row, int column)
    {
        rowNumber = row;
        columnNumber = column;
    }
    
    protected int getRow()
    {
        return rowNumber;
    }

    protected int getColumn()
    {
        return columnNumber;
    }

}
