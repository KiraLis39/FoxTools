package fox;

import com.sun.management.OperatingSystemMXBean;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.awt.Toolkit;
import java.io.File;
import java.lang.management.ManagementFactory;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Properties;

@Slf4j
public class SystemInfo {
    private static final OperatingSystemMXBean os = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
    private final MEMORY mem = new MEMORY();

    public String getAllSystemParameters() {
        StringBuilder sb = new StringBuilder();
        Properties mass = System.getProperties();
        ArrayList<?> lstK = new ArrayList<>(mass.keySet());
        ArrayList<?> lstV = new ArrayList<>(mass.values());

        int i = 0;
        while (lstK.size() > i) {
            sb.append(lstK.get(i)).append(": ").append(lstV.get(i));
            i++;
        }

        return sb.toString();
    }

    public void printAll() {
        log.info("vendor: " + System.getProperty("java.vm.vendor"));
        log.info("vendor.url: " + System.getProperty("java.vendor.url"));

        log.info("\t*** СВОЙСТВА ПК ***");

        log.info("\t*** USER ***");
        log.info("Имя пользователя:\t" + System.getProperty("user.name"));
        log.info("Страна и язык: \t" + System.getProperty("user.country") + "_" + System.getProperty("user.language"));
        log.info("Кодировка системы: " + Charset.defaultCharset().displayName() + " (" + System.getProperty("sun.jnu.encoding") + ")");
        log.info("Временная зона:\t" + (System.getProperty("user.timezone") == null ? System.getProperty("user.timezone") : "none"));
        log.info("Домашний каталог:\t" + System.getProperty("user.home"));
        log.info("Текущий каталог:\t" + System.getProperty("user.dir"));

        log.info("\t*** OS ***");
        log.info("Имя данной ОС:\t" + System.getProperty("os.name"));
        log.info("Версия данной ОС:\t" + System.getProperty("os.version"));
        log.info("Архитектура ОС:\t" + System.getProperty("os.arch"));
        log.info("Семейство ОС:\t" + System.getenv().get("OS"));

        log.info("\t*** PC ***");
        log.info("Имя компьютера:\t" + System.getenv().get("COMPUTERNAME"));
        log.info("Имя процессора:\t" + System.getProperty("sun.cpu.isalist").toUpperCase());
        log.info("Архитектура процессора:\t" + System.getProperty("sun.arch.data.model") + "bit");
        log.info("Ядер процессора:\t" + Runtime.getRuntime().availableProcessors());
        log.info("О процессоре:\t" + System.getenv().get("PROCESSOR_IDENTIFIER"));

        log.info("\t*** JVM ***");
        log.info("Текущая Java-машина:\t" + System.getProperty("java.vm.name") + "\n\t\t" + System.getProperty("java.specification.name") + "\n\t\t" + System.getProperty("java.runtime.name"));
        log.info("Версия Java-машины:\t" + System.getProperty("java.vm.version") + " (" + System.getProperty("java.runtime.version") + " )");
        log.info("Каталог Java-машины:\t" + System.getProperty("java.home"));
        log.info("Архетиктура Java:\t" + System.getProperty("sun.arch.data.model") + "bit");

        log.info("\t*** NET ***");
        log.info("http.proxyHost    =\t" + System.getProperty("http.proxyHost"));
        log.info("https.proxyHost  =\t" + System.getProperty("https.proxyHost"));
        log.info("ftp.proxyHost      =\t" + System.getProperty("ftp.proxyHost"));
        log.info("socksProxyHost  =\t" + System.getProperty("socksProxyHost"));

        log.info("\t*** SCREEN ***");
        log.info("Разрешение экрана в dpi: " + Toolkit.getDefaultToolkit().getScreenResolution());
        log.info("Разрешение экрана в px: " + (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth() + " х " + (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());

        log.info("\t*** HDD ***");
        File[] roots = File.listRoots();
        for (File root : roots) {
            log.info("Диск: " + root.getAbsolutePath());
            log.info("Всего места: " + (root.getTotalSpace() / 1048576 / 1024) + " Гб. или " + (root.getTotalSpace() / 1048576) + " мб.");
            log.info("Свободно: " + (root.getFreeSpace() / 1048576 / 1024) + " Гб. или " + (root.getFreeSpace() / 1048576) + " мб.");
            log.info("Занято: " + ((root.getTotalSpace() / 1048576 / 1024) - (root.getFreeSpace() / 1048576 / 1024)) + " Гб. " + "или " + ((root.getTotalSpace() / 1048576) - (root.getFreeSpace() / 1048576)) + " мб.");
        }

        log.info("\t*** MEMORY ***");
        log.info("Данная программа использует " +
                (mem.getUsedJvmMemory() / 1048576L) + "мб из " +
                (mem.getTotalJvmMemory() / 1048576L) + "мб выделенных под неё.");

        log.info("Max memory:\t" + mem.getMaxJvmMemory() + " byte (" + (mem.getMaxJvmMemory() / 1048576L) + "mb)");
        log.info("Used memory:\t" + mem.getUsedJvmMemory() + " byte (" + (mem.getUsedJvmMemory() / 1048576L) + "mb)");
        log.info("Free memory:\t" + mem.getFreeJvmMemory() + " byte (" + (mem.getFreeJvmMemory() / 1048576L) + "mb)");

        log.info("\nДополнительно:\n"
                + "Всего ОЗУ > " + (os.getTotalMemorySize() / 1048576L) + "мб,\n"
                + "Свободно ОЗУ > " + (os.getFreeMemorySize() / 1048576L) + "мб,\n"
                + "Free Swap Size > " + (os.getFreeSwapSpaceSize() / 1048576L) + "мб,\n"
                + "Commited Virtual Memory > " + (os.getCommittedVirtualMemorySize() / 1048576L) + "мб.\n");

        log.info("\t*** FINAL ***");
    }

    public static class MEMORY {
        public long getTotalJvmMemory() {
            return Runtime.getRuntime().totalMemory();
        }

        public long getMaxJvmMemory() {
            return Runtime.getRuntime().maxMemory();
        }

        public long getUsedJvmMemory() {
            return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        }

        public long getFreeJvmMemory() {
            return Runtime.getRuntime().freeMemory();
        } // (Memory / 1048576L) = "мб"

        public long getTotalSystemMemory() {
            return os.getTotalMemorySize();
        }

        public long getFreeSystemMemory() {
            return os.getFreeMemorySize();
        }

        public long getTotalSwapMemory() {
            return os.getTotalSwapSpaceSize();
        }

        public long getFreeSwapMemory() {
            return os.getFreeSwapSpaceSize();
        }

        public long getCommittedVirtualMemory() {
            return os.getCommittedVirtualMemorySize();
        } // (Memory / 1048576L) = "мб"
    }

    public static class USER {
        public static String getUSER_LANG() {
            return System.getProperty("user.country") + "_" + System.getProperty("user.language");
        }

        public static String getUSER_HOME() {
            return System.getProperty("user.home");
        }

        public static String getUSER_NAME() {
            return System.getProperty("user.name");
        }

        public static String getUSER_DIR() {
            return System.getProperty("user.dir");
        }
    }

    public static class OS {
        public static String getOS_NAME() {
            return System.getProperty("os.name");
        }

        public static String getOS_ARCH() {
            return System.getProperty("os.arch");
        }

        public static String getOS_VERSION() {
            return System.getProperty("os.version");
        }

        public static String getOS_ENCODE() {
            return Charset.defaultCharset().displayName() + "_" + System.getProperty("sun.jnu.encoding");
        }

        public static String getOS_TIMEZONE() {
            return System.getProperty("user.timezone");
        }

        public static String getOS_TYPE() {
            return System.getenv().get("OS");
        }
    }

    public static class JAVA {
        public static String VM_NAME() {
            return System.getProperty("java.vm.name") + "\n" + System.getProperty("java.specification.name") + "\n"
                    + System.getProperty("java.runtime.name");
        }

        public static String JAVA_VERSION() {
            return System.getProperty("java.version") + "\n" + System.getProperty("java.runtime.version");
        }

        public static String JAVA_HOME() {
            return System.getProperty("java.home");
        }

        public static String JAVA_ARCH() {
            return System.getProperty("sun.arch.data.model") + "bit";
        }
    }

    public static class CPU {
        public static String getCPU_ARCH() {
            return System.getProperty("sun.arch.data.model") + "bit";
        }

        public static String getCPU_MODEL() {
            return System.getProperty("sun.cpu.isalist").toUpperCase();
        }

        public static String getCPU_NAME() {
            return System.getenv().get("COMPUTERNAME");
        }

        public static int getCPU_CORES() {
            return Runtime.getRuntime().availableProcessors();
        }

        public static String getCPU_IDENTIFIER() {
            return System.getenv().get("PROCESSOR_IDENTIFIER");
        }
    }

    @Getter
    public static class NET {
        public String getNetHttpHost() {
            return System.getProperty("http.proxyHost");
        }

        public String getNetHttpsHost() {
            return System.getProperty("https.proxyHost");
        }

        public String getNetFtpHost() {
            return System.getProperty("ftp.proxyHost");
        }

        public String getNetSocksHost() {
            return System.getProperty("socksProxyHost");
        }
    }

    public static class SCREEN {
        public static int SCREEN_SIZE_DPI() {
            return Toolkit.getDefaultToolkit().getScreenResolution();
        }

        public static String SCREEN_SIZE() {
            return Toolkit.getDefaultToolkit().getScreenSize().getWidth() + " х "
                    + Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        }
    }
}
