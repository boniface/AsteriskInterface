/**
 *
 */
package me.dayler.ai.ami.conn;

import java.io.IOException;
import java.net.InetAddress;

/**
 * The SocketConnectionFacade provides read and write operation for
 * communication over TCP/IP sockets.<p>
 * It hides the details of the underlying I/O system used for socket
 * communication.
 *
 * @author srt
 * @version $Id: SocketConnectionFacade.java 959 2008-02-02 23:56:59Z srt $
 */
public interface SocketConnectionFacade {
    /**
     * Reads a line of text from the socket connection. The current thread is
     * blocked until either the next line is received or an IOException
     * encounters.<p>
     * Depending on the implementation different newline delimiters are used
     * ("\r\n" for the Manager API and "\n" for AGI).
     *
     * @return the line of text received excluding the newline delimiter.
     * @throws IOException if the connection has been closed.
     */
    String readLine() throws IOException;

    /**
     * Sends a given String to the socket connection.
     *
     * @param s the String to send.
     * @throws IOException if the String cannot be sent, maybe because the
     *                     connection has already been closed.
     */
    void write(String s) throws IOException;

    /**
     * Flushes the socket connection by sending any buffered but yet unsent
     * data.
     *
     * @throws IOException if the connection cannot be flushed.
     */
    void flush() throws IOException;

    /**
     * Closes the socket connection including its input and output stream and
     * frees all associated resources.<p>
     * When calling close() any Thread currently blocked by a call to readLine()
     * will be unblocked and receive an IOException.
     *
     * @throws IOException if the socket connection cannot be closed.
     */
    void close() throws IOException;

    /**
     * Returns the connection state of the socket.
     *
     * @return <code>true</code> if the socket successfully connected to a
     * server
     */
    boolean isConnected();

    /**
     * Returns the local address this socket connection.
     *
     * @return the local address this socket connection.
     * @since 0.2
     */
    InetAddress getLocalAddress();

    /**
     * Returns the local port of this socket connection.
     *
     * @return the local port of this socket connection.
     * @since 0.2
     */
    int getLocalPort();

    /**
     * Returns the remote address of this socket connection.
     *
     * @return the remote address of this socket connection.
     * @since 0.2
     */
    InetAddress getRemoteAddress();

    /**
     * Returns the remote port of this socket connection.
     *
     * @return the remote port of this socket connection.
     * @since 0.2
     */
    int getRemotePort();
}
