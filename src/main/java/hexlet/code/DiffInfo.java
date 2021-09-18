package hexlet.code;

import java.util.Map;

public final class DiffInfo {
    private Map<String, Object> dataFile1;
    private Map<String, Object> dataFile2;
    private Map<String, String> diff;

    public DiffInfo(Map<String, Object> data1,
                    Map<String, Object> data2,
                    Map<String, String> differ) {
        this.dataFile1 = data1;
        this.dataFile2 = data2;
        this.diff = differ;
    }

    public Map<String, Object> getDataFile1() {
        return dataFile1;
    }

    public Map<String, Object> getDataFile2() {
        return dataFile2;
    }

    public Map<String, String> getDiff() {
        return diff;
    }

}
