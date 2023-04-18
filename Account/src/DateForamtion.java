import java.text.SimpleDateFormat;
import java.util.Date;
import static java.text.DateFormat.*;

public class DateForamtion {
    public String set() {
        Date date = new Date();
        //格式化日期
        SimpleDateFormat d1 = new SimpleDateFormat
                ("yyyy-MM-dd HH:mm");
        return d1.format(date);

    }
}
