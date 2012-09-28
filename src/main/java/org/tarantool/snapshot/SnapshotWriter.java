package org.tarantool.snapshot;

import static org.tarantool.snapshot.Const.SNAP_HEADER;
import static org.tarantool.snapshot.Const.SNAP_TAG;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.WritableByteChannel;

/**
 * <p>
 * SnapshotWriter class.
 * </p>
 * 
 * @author dgreen
 * @version $Id: $
 */
public class SnapshotWriter extends TupleWriter {

	/**
	 * <p>
	 * Constructor for SnapshotWriter.
	 * </p>
	 * 
	 * @param channel
	 *            a {@link java.nio.channels.WritableByteChannel} object.
	 * @throws java.io.IOException
	 *             if any.
	 */
	public SnapshotWriter(WritableByteChannel channel) throws IOException {
		super(channel, SNAP_TAG);
		ByteBuffer header = ByteBuffer.wrap(SNAP_HEADER).order(ByteOrder.LITTLE_ENDIAN);
		header.position(header.capacity());
		flipAndWriteFully(header);
	}

}
