package StringList.exceptions;

public class IndexOutOfBoundsException extends IllegalArgumentException {
    public IndexOutOfBoundsException() {
        super("Переданный индекс выходит за пределы StringList");
    }
}
