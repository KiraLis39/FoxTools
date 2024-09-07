package fox.utils;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class ThreadsScanner {
    public static void scanCurrent() {
        ThreadGroup currentGroup = Thread.currentThread().getThreadGroup();
        Thread[] lstThreads = new Thread[currentGroup.activeCount()];
        currentGroup.enumerate(lstThreads);
        for (int i = 0; i < currentGroup.activeCount(); i++) {
            log.info(ThreadsScanner.class.getSimpleName()
                    .concat("Thread ")
                    .concat(String.valueOf(i))
                    .concat(": ")
                    .concat(lstThreads[i].getName()));
        }
    }
}
