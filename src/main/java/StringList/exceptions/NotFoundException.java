package StringList.exceptions;

public class NotFoundException extends IllegalArgumentException {
    public NotFoundException() {
        super("Элемент не найден");
    }
}
