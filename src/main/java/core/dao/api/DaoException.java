package core.dao.api;

public class DaoException extends RuntimeException {
    public DaoException(Throwable e) {
        initCause(e);
    }
}
