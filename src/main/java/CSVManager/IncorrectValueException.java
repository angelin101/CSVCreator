package CSVManager;

import java.io.IOException;

/**
 * Created by Ангелин on 30.08.2015.
 */
public class IncorrectValueException extends Exception{
    private String msg;
    public IncorrectValueException(){
        msg = "";
    }
    public IncorrectValueException(String s){
        this.msg = s;
    }
    @Override
    public String getMessage() {
        return "Неверный тип данных!"+msg;
    }
}
