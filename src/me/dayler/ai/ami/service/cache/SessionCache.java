package me.dayler.ai.ami.service.cache;

import me.dayler.ai.ami.service.context.SessionCtx;
import me.dayler.common.exception.OperationException;

/**
 * Session cache for AMI Service.
 *
 * @author asalazar
 */
public interface SessionCache {

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

}