package StringList.exceptions;

public class NullStringException extends IllegalArgumentException {
    public NullStringException() {
        super("Вместо валидной строки передан null");
    }
}
