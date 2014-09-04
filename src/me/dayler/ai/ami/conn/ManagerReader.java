/**
 *
 */
package me.dayler.ai.ami.conn;

import java.util.ArrayDeque;

import me.dayler.common.exception.OperationException;

/**
 * @author asalazar
 */
public interface ManagerReader extends Runnable {

    void dispatchEvent(ArrayDeque<String> eventArgs) throws OperationException;

    void setSocket(SocketConnectionFacade socket);

    void terminate();
}
