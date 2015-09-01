package CSVManager;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.*;


/**
 * Created by Ангелин on 29.08.2015.
 */
public class Reader implements CSVReader {
    private File file;
    private final String SEPARATOR = ";";
    private final Logger LOG = Logger.getLogger(Reader.class);

    @Override
    public List<Product> readFromFile(String fileName) throws FileNotFoundException, InvalidNumberOfLinesException, IncorrectValueException{
        file = new File(fileName);
        String line;
        List<Product> list = new LinkedList<>();
        try(BufferedReader read = new BufferedReader(new FileReader(file))) {
            while ((line = read.readLine()) != null){
                list.add(convertOneProduct(line));
            }
        } catch (IOException e) {
            LOG.error("Catch IO Exception!!!", e);
        }
        LOG.info("Данные считаны из файла '"+fileName+"' в List<Product>. Вышло - "+list.size()+" обьектов.");
        return list;
    }
    // Метод конвертирующий одну строку в один обьект Product
    private Product convertOneProduct(String line) throws InvalidNumberOfLinesException, IncorrectValueException{
        Product obj = new Product();
        String[] str = line.split(SEPARATOR);
        if(str.length > 4){
            LOG.warn("Неверное количество столбцов!!! В файле '"+file.getName()+"', у продукта "+str[0]+" больше 4-х значений!");
            throw new InvalidNumberOfLinesException();
        }
        else if(str.length < 4){
            LOG.warn("Неверное количество столбцов!!! В файле '"+file.getName()+"', у продукта "+str[0]+" меньше 4-х значений!");
            throw new InvalidNumberOfLinesException("");
        }
        for (int i = 0; i < 3; i++){
            if (testOnValidation(str[i])){
                LOG.warn("Неверный тип данных!!! В файле '"+file.getName()+"', столбец № "+(i+1)+" содержит числовое значение!");
                throw new IncorrectValueException();
            }
        }
        obj.setName(str[0]);
        obj.setTradeMark(str[1]);
        obj.setArticle(str[2]);
        obj.setPrice(Integer.parseInt(str[3]));
        return obj;
    }

    // Внутренний метод проверяющий с помощью регулярных выражений строку на валидность, возвращает true если в строке одни числа!
    private boolean testOnValidation(String str){
        Pattern p = Pattern.compile("^\\d+$");
        Matcher m = p.matcher(str);
        return m.matches();
    }
}
