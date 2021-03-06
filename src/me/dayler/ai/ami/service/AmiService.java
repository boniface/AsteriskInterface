/**
 *
 */
package me.dayler.ai.ami.service;

import java.io.IOException;
import java.util.Properties;

import me.dayler.ai.ami.event.AmiEventArgs;
import me.dayler.ai.ami.service.cache.CacheServiceFactory;
import me.dayler.ai.ami.service.cache.SessionCacheFactory;
import me.dayler.ai.ami.service.cache.SimpleCacheService;
import me.dayler.ai.ami.service.context.SessionCtx;
import me.dayler.common.exception.OperationException;
import me.dayler.nuevatel.ai.ami.action.AmiAction;

/**
 * Execute service to catchup AMI events.
 *
 * @author asalazar
 */
public interface AmiService {

    /**
     * 
     * Initialize service.
     *
     * @throws IOException
     * @throws OperationException
     */
    void start(SessionCacheFactory cacheFactory, CacheServiceFactory cacheServiceFactory) throws IOException, OperationException;

    /**
     * End service execution.
     *
     * @throws InterruptedException
     * @throws IOException
     */
    void stop() throws InterruptedException, IOException;

    /**
     * Execute Login action to asterisk ami service.
     *
     * @throws OperationException When login has an error on its execution.
     */
    void doLogin() throws OperationException;

    /**
     * Execute Logoff action to asterisk ami service.
     *
     * @throws OperationException When logoff has an error on its execution.
     */
    void doLogoff() throws OperationException;

    /**
     * @return True if the service is running.
     */
    boolean isRunning();

    /**
     * Schedule an action to send.
     *
     * @param action           The action to schedule
     * @param internalActionId Unique identifier for the action.
     * @throws OperationException When the schedule action cannot be performed.
     */
    void scheduleAction(AmiAction action, String internalActionId) throws OperationException;

    /**
     * Schedule an event or action response to be consumed by the listeners.
     *
     * @param eventArgs Event args.
     * @throws OperationException If the event cannot be proceed.
     */
    void offerEvent(AmiEventArgs eventArgs) throws OperationException;

    /**
     * @return Scheduled event args if it is available.
     */
    AmiEventArgs pollEvent();

    /**
     * Register service handler for the service.
     *
     * @param srvHandler Service handler to register.
     */
    void registerHandler(Class<? extends AmiServiceHandler> srvHandler);

    /**
     * Gets session related to session ID. If it does not exists returns <b>null</b>
     *
     * @param sessionId The ID for the session to find.
     * @return Session associated with sessionId
     * @throws OperationException Error occurred while session is retrieved.
     */
    SessionCtx getSession(String sessionId) throws OperationException;

    /**
     * Discards a session for the cache.
     *
     * @param sessionId Session ID for the session to Discards.
     */
    void invalidateSession(String sessionId);

    void setProperties(Properties properties);

    SimpleCacheService getCacheService();
}
