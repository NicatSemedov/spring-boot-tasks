package task.restapi.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ProductType {
    SIMPLE(1),
    VARIABLE(2),
    GROUPED(3),
    EXTERNAL(4);

    private final int value;

    public static ProductType fromInteger(int value) {
        switch (value) {
            case 1:
                return SIMPLE;
            case 2:
                return VARIABLE;
            case 3:
                return GROUPED;
            case 4:
                return EXTERNAL;
            default:
                return null;
        }
    }
}
