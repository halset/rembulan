package net.sandius.rembulan.lib.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;

/**
 *
 * @param <R> the token type
 */
public abstract class AbstractTokenizer<R> {

  /**
   * 
   */
  protected static final byte LINE_FEED = (byte) '\n';

  /**
   * 
   */
  protected final ByteBuffer byteBuffer;
  
  /**
   * 
   */
  protected ByteArrayOutputStream output;
  
  /**
   * 
   */
  protected long skip;

  /**
   * @param byteBuffer the buffer to use
   */
  public AbstractTokenizer(ByteBuffer byteBuffer) {
    super();
    this.byteBuffer = byteBuffer;
  }

  /**
   * 
   * @param channel the channel to use for positioning
   * @return the next token or null if there are no more
   * @throws IOException when somethings go wrong
   */
  public final R nextToken(SeekableByteChannel channel) throws IOException {
    reset();
    output = new ByteArrayOutputStream();
    byteBuffer.limit(byteBuffer.capacity());
    byteBuffer.rewind();

    long mark = channel.position();
    skip = 0;

    int remainingBytes = 0;

    read_loop: while (true) {
      if (remainingBytes == 0) {
        byteBuffer.rewind();
        int bytesReadFromChannel = channel.read(byteBuffer);
        if (bytesReadFromChannel == -1) {
          break;
        }
        byteBuffer.flip();
      }

      remainingBytes = byteBuffer.remaining();
      while (remainingBytes > 0) {
        byte b = byteBuffer.get();
        // handle byte (start)
        boolean doContinue = handleByte(b);
        if (!doContinue) {
          break read_loop;
        }
        // handle byte (end)

        remainingBytes = byteBuffer.remaining();
      }
    }

    channel.position(mark + skip + output.size());

    if (output.size() == 0 && skip == 0) {
      return null;
    } else {
      //byte[] bytes = output.toByteArray();
      R result = toResult();
      return result;
    }
  }

  /**
   */
  protected abstract void reset();

  /**
   * 
   * @param b the byte to handle
   * @return boolean true if the byte was handled
   */
  protected abstract boolean handleByte(byte b);

  /**
   * 
   * @return a R with the complete content if possible
   */
  protected abstract R toResult();

}
