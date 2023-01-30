package day18;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class C01_Log4J {

//1. Logger object olustur:
   private static Logger logger = LogManager.getLogger(C01_Log4J.class.getName());

//2. Logger fonksiyonuyla istenilen fonksiyonu kullan
//        logger.debug("Debug logger");
//        logger.info("Info logger");
//        logger.error("Error logger");
//        logger.fatal("Fatal logger");

    @Test
    public void test01() {
        logger.fatal("Fatal Log!");
        logger.error("Error Log!");
        logger.warn("Warn Log!");
        logger.debug("Debug Log!");
        logger.info("Info Log!");
    }
}
