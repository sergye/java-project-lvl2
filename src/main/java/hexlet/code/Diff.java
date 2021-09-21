package hexlet.code;

public final class Diff {
    private String name;
    private String status;
    private Object before;
    private Object after;

    public Diff(String propertyName, String propertyStatus, Object valueBefore, Object valueAfter) {
        this.name = propertyName;
        this.status = propertyStatus;
        this.before = valueBefore;
        this.after = valueAfter;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public Object getBefore() {
        return before;
    }

    public Object getAfter() {
        return after;
    }

}
