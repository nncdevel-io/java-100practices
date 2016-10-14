import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Calendar;

/**
 * 040用のエラー出力クラス.
 *
 * @author jsfkdt
 */
public class MyUncaughtExceptionHandler implements UncaughtExceptionHandler {
    
    /**
     * キャッチされなかった例外を取得し、
     * トレース情報と現在時刻を標準出力して、強制終了します.
     *
     * @param thread スレッド情報
     * @param throwable エラー情報
     */
    public void uncaughtException(Thread thread, Throwable throwable) {
        //アプリケーションの終了
        System.out.println("例外が発生しました。\n");
        
        /* 現在時刻の取得 */
        String time = nowTime();
        
        /* 現在時刻を標準エラー出力 */
        System.err.println(time);
        
        /* エラーのトレース情報を出力 */
        throwable.printStackTrace();
        
        /* 強制終了 */
        System.exit(1);
    }
    
    /**
     * 現在時刻を返すメソッド.
     * 
     * @return 現在時刻
     */
    public String nowTime() {
        Calendar calendar = Calendar.getInstance();
        
        // 時を取得
        int h = calendar.get(calendar.HOUR_OF_DAY);
        // 分を取得
        int m = calendar.get(calendar.MINUTE);
        //秒を取得
        int s = calendar.get(calendar.SECOND);
        
        return h + ":" + m + ":" + s;
    }
}