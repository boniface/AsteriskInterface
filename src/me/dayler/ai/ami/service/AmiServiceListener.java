/**
 *
 */
package me.dayler.ai.ami.service;

import java.util.List;

import me.dayler.ai.ami.event.AmiEventArgs;
import me.dayler.ai.ami.service.cache.SimpleCacheService;
import me.dayler.ai.ami.service.context.SessionCtx;
import me.dayler.common.exception.OperationException;
import me.dayler.nuevatel.ai.ami.action.AmiAction;

/**
 * @author asalazar
 */
public interface AmiServiceListener extends Runnable {

    void service(AmiEventArgs eventArgs) throws OperationException;

    void terminate();

    void setServiceHandlers(List<AmiServiceHandler> handlers);

    void scheduleAction(AmiAction action, String internalActionId) throws OperationException;

    /**
     * 
     * @param uniqueSessionId Unique identifier for the session.
     * 
     * @return SessionCtx match with the uniqueSessionId.
     * 
     * @throws OperationException If the SessionCtx could not be retrieved.
     */
    SessionCtx getSessionCtx(String uniqueSessionId) throws OperationException;

    SimpleCacheService getCacheService();

    void invalidateSession(String sessionCtxId);
}
