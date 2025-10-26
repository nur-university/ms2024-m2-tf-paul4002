package edu.nur.nurtricenter_appointment.core.results;

public class ResultWithValue<T> extends Result {

    private final T value;

    protected ResultWithValue(T value, boolean isSuccess, Error error) {
        super(isSuccess, error);
        this.value = value;
    }

    public T getValue() {
        if (isFailure()) {
            throw new IllegalStateException(
                "The value of a failure result can't be accessed."
            );
        }
        return value;
    }

    // Conversión implícita equivalente: value -> ResultWithValue
    public static <T> ResultWithValue<T> of(T value) {
        if (value != null) {
            return Result.success(value);
        } else {
            return Result.failure(Error.NULL_VALUE);
        }
    }

    public static <T> ResultWithValue<T> validationFailure(Error error) {
        return new ResultWithValue<>(null, false, error);
    }
}

