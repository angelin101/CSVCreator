package CSVManager;

/**
 * Created by Ангелин on 30.08.2015.
 */
public class InvalidNumberOfLinesException extends Exception{
    private String msg;
    public InvalidNumberOfLinesException(String s) {
        this.msg = s;
    }

    @Override
    public String getMessage() {
        return "Неверное количество столбцов!"+msg;
    }
}
