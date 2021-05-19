/**
 * @Description
 * @Author tianbin
 * @Since 2021/5/7
 */
public class TestResult  extends  ResultCode{

    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TestResult{" +
                "data='" + data + '\'' +
                '}';
    }
}
