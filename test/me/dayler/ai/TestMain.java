package me.dayler.ai;

import me.dayler.ai.ami.service.AmiService;
import me.dayler.ai.ami.service.AmiServiceFactory;
import me.dayler.ai.ami.service.cache.CacheServiceFactory;
import me.dayler.ai.ami.service.cache.SessionCacheFactory;
import me.dayler.ai.ami.service.cache.SessionCacheLoader;
import me.dayler.ai.ami.service.cache.SessionRemovalListener;
import me.dayler.common.exception.OperationException;

import org.apache.log4j.xml.DOMConfigurator;

import java.io.IOException;

/**
 * 
 * 
 * Test class to check services.
 *
 * @author asalazar
 */
public class TestMain {

    private static final int TEST_PING_TIMEOUT = 60000;
    private static final int TEST_LISTENER_COUNT = 4;
    private static final boolean TEST_USE_SSL = false;
    private static final java.lang.String TEST_SECRET = "pwd";
    private static final java.lang.String TEST_USERNAME = "manager";
    private static final int TEST_PORT = 5038;
    private static final java.lang.String TEST_HOSTNAME = "10.40.99.88";

    public static void main(String[] args) throws IOException, InterruptedException, OperationException {
        System.out.println("START TestMain.main() ...");

        // Configure log4j for testing purposes.
        // BasicConfigurator.configure();
        DOMConfigurator.configure("/cf/properties/voip/log4j.xml");

        AmiServiceFactory factory = new AmiServiceFactory();
        factory.setHostName(TEST_HOSTNAME)
                .setPort(TEST_PORT)
                .setUserName(TEST_USERNAME)
                .setSecret(TEST_SECRET)
                .setUseSSL(TEST_USE_SSL)
                .setListenerCount(TEST_LISTENER_COUNT)
                .setPingTimeout(TEST_PING_TIMEOUT);

        AmiService service = factory.getService();
        service.registerHandler(SimpleAmiServiceHandler.class);

        // Create cache factory.
        SessionCacheFactory cacheFactory = new SessionCacheFactory();
        cacheFactory.setExpireAfterWrite(5000)
            .setExpireAfterAccess(2000)
            .setConcurrencyLevel(TEST_LISTENER_COUNT)
            .setCacheLoader(new SessionCacheLoader(service))
            .setRemovalListener(new SessionRemovalListener(service));

        // Create cache service factory
        CacheServiceFactory cacheServiceFactory = new CacheServiceFactory();
        cacheServiceFactory.setExpireAfterWrite(5000)
            .setExpireAfterAccess(2000)
            .setConcurrencyLevel(TEST_LISTENER_COUNT)
            .setCacheLoader(new TestSessionCallCacheLoader());
     // TODO implement removal listener
        //.setRemovalListener(new SessionRemovalListener(service));

        service.start(cacheFactory, cacheServiceFactory);

        System.out.println("Try to login");
        service.doLogin();
        Thread.sleep(180000);

        System.out.println("Try to logoff");
        service.doLogoff();
        service.stop();
        System.out.println("END TestMain.main() ...");
    }
}
  