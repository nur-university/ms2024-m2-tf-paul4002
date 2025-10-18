package edu.nur.nurtricenter_appointment.core.results;


public class Result {

    private final boolean isSuccess;
    private final Error error;

    protected Result(boolean isSuccess, Error error) {
        if ((isSuccess && error != Error.NONE) ||
            (!isSuccess && error == Error.NONE)) {
            throw new IllegalArgumentException("Invalid error");
        }
        this.isSuccess = isSuccess;
        this.error = error;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public boolean isFailure() {
        return !isSuccess;
    }

    public Error getError() {
        return error;
    }

    // Factories
    public static Result success() {
        return new Result(true, Error.NONE);
    }

    public static <T> ResultWithValue<T> success(T value) {
        return new ResultWithValue<>(value, true, Error.NONE);
    }

    // public static Result failure(Error error) {
    //     return new Result(false, error);
    // }

    public static <T> ResultWithValue<T> failure(Error error) {
        return new ResultWithValue<>(null, false, error);
    }
}

class ResultWithValue<T> extends Result {

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
