package StringList.exceptions;

public class NegativeIndexException extends IllegalArgumentException {
    public NegativeIndexException() {
        super("Индекс не может быть меньше 0");
    }
}
