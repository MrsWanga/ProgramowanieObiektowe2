package ak.po.figures;

public class LessThanZero extends IllegalArgumentException{
    private static final String MESSAGE = "Wymiar bryły musi być większy lub równy 0. Podano wartość: ";
    LessThanZero(double less) { super(MESSAGE + less); }
}
