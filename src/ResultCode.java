/**
 * @Description
 * @Author tianbin
 * @Since 2021/5/7
 */
public class ResultCode {
    /**
     */
    private String resultCode;

    private String resultDesc;

    @SuppressWarnings({ "unchecked" })
    public static <T extends ResultCode> T create(Class<T> clazz, String code) {
        ResultCode result = null;
        try {
            result = getInstance(clazz);
            result.setResultCode(code);
            String desc = "111111111";
            result.setResultDesc(desc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) result;
    }

    public static <T extends ResultCode> T createSuccess(Class<T> clazz) {
        return create(clazz, "SUCCESS");
    }
    private static <T extends ResultCode> ResultCode getInstance(Class<T> clazz) throws Exception {
        return (ResultCode) clazz.newInstance();
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }

}
