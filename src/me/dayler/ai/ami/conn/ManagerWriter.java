/**
 *
 */
package me.dayler.ai.ami.conn;

import me.dayler.common.exception.OperationException;
import me.dayler.nuevatel.ai.ami.action.AmiAction;

/**
 * @author asalazar
 */
public interface ManagerWriter extends Runnable {

    void scheduleAction(AmiAction action, String internalActionId) throws OperationException;

    void setSocket(SocketConnectionFacade socket);

    void terminate();
}
