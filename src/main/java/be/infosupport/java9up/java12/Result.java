package be.infosupport.java9up.java12;

public class Result {
    private Integer min;
    private Integer max;

    public Result(Integer min, Integer max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public String toString() {
        return "{count=" + count + ", sum=" + sum + "}";
    }
}