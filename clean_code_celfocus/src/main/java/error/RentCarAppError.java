package error;

public class RentCarAppError extends Exception{

    // TODO add more exceptions and error messages.
    private static final String TRY_AGAIN = "try again";

    private static final String ERROR_CREATING_PERSON = "error creating person";
    private static final String INVALID_USER_NAME = "this name is not acceptable";
    private static final String NOT_IMPLEMENTED = "not implemented yet";

    public static final Exception INVALID_PERSON_NAME
            = new Exception(INVALID_USER_NAME);

 public static final Exception METHOD_NOT_IMPLEMENTED
            = new Exception(NOT_IMPLEMENTED);

}
