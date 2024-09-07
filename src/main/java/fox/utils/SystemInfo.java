package fox.utils;

import com.sun.management.OperatingSystemMXBean;
import lombok.Getter;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.SystemUtils;

import java.awt.*;
import java.lang.management.ManagementFactory;
import java.nio.charset.Charset;

@Slf4j
@UtilityClass
public class SystemInfo {
    @Getter
    public static final class MEMORY {
        public static final long totalJvmMemory = Runtime.getRuntime().totalMemory();
        public static final long maxJvmMemory = Runtime.getRuntime().maxMemory();
        public static final long usedJvmMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        public static final long freeJvmMemory = Runtime.getRuntime().freeMemory(); // (Memory / 1048576L) = "мб"
        private static final OperatingSystemMXBean os = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        public static final long totalSystemMemory = os.getTotalMemorySize();
        public static final long freeSystemMemory = os.getFreeMemorySize();
        public static final long totalSwapMemory = os.getTotalSwapSpaceSize();
        public static final long freeSwapMemory = os.getFreeSwapSpaceSize();
        public static final long committedVirtualMemory = os.getCommittedVirtualMemorySize(); // (Memory / 1048576L) = "мб"
    }

    @Getter
    public static final class USER {
        public static final String userLang = SystemUtils.USER_COUNTRY + "_" + SystemUtils.USER_LANGUAGE;
        public static final String userHome = SystemUtils.USER_HOME;
        public static final String userName = SystemUtils.USER_NAME;
        public static final String userDir = SystemUtils.USER_DIR;
    }

    @Getter
    public static final class SYSTEM {
        public static final String timeZone = SystemUtils.USER_TIMEZONE;
        public static final String encode = Charset.defaultCharset().displayName() + "_" + System.getProperty("sun.jnu.encoding");
    }

    @Getter
    public static final class OS {
        public static final String osName = SystemUtils.OS_NAME;
        public static final String osArch = SystemUtils.OS_ARCH;
        public static final String osVersion = SystemUtils.OS_VERSION;
        public static final String osType = System.getenv().get("OS");
    }

    @Getter
    public static final class JAVA {
        public static final String name = SystemUtils.JAVA_VM_NAME;
        public static final String vendor = SystemUtils.JAVA_VM_VENDOR;
        public static final String vmVersion = SystemUtils.JAVA_VM_VERSION;
        public static final String specName = SystemUtils.JAVA_SPECIFICATION_NAME;
        public static final String runtimeName = SystemUtils.JAVA_RUNTIME_NAME;
        public static final String version = SystemUtils.JAVA_VERSION;
        public static final String runtimeVersion = SystemUtils.JAVA_RUNTIME_VERSION;
        public static final String home = SystemUtils.JAVA_HOME;
        public static final String arch = System.getProperty("sun.arch.data.model");
    }

    @Getter
    public static final class CPU {
        public static final String arch = SystemUtils.OS_ARCH;
        public static final String model = System.getProperty("sun.cpu.isalist").toUpperCase();
        public static final String name = System.getenv().get("COMPUTERNAME");
        public static final String identifier = System.getenv().get("PROCESSOR_IDENTIFIER");
        public static final int cores = Runtime.getRuntime().availableProcessors();
    }

    @Getter
    public static final class NET {
        public static final String netHttpHost = System.getProperty("http.proxyHost");
        public static final String netHttpsHost = System.getProperty("https.proxyHost");
        public static final String netFtpHost = System.getProperty("ftp.proxyHost");
        public static final String netSocksHost = System.getProperty("socksProxyHost");
    }

    @Getter
    public static final class SCREEN {
        public static final int screenResolution = Toolkit.getDefaultToolkit().getScreenResolution();
        public static final Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
    }
}
