package org.tarantool.snapshot;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ReadableByteChannel;
import java.util.Arrays;

/**
 * <p>
 * SnapShotReader class.
 * </p>
 * 
 * @author dgreen
 * @version $Id: $
 */
public class SnapshotReader extends TupleReader {

	/**
	 * <p>
	 * Constructor for SnapShotReader.
	 * </p>
	 * 
	 * @param channel
	 *            a {@link java.nio.channels.ReadableByteChannel} object.
	 * @throws java.io.IOException
	 *             if any.
	 */
	public SnapshotReader(ReadableByteChannel channel) throws IOException {
		super(channel, Const.SNAP_TAG);
		ByteBuffer snapHeader = ByteBuffer.allocate(Const.SNAP_HEADER.length).order(ByteOrder.LITTLE_ENDIAN);
		readFullyAndFlip(snapHeader);
		if (!Arrays.equals(Const.SNAP_HEADER, snapHeader.array())) {
			throw new IllegalStateException("Snapshot file should have header " + new String(Const.SNAP_HEADER));
		}
	}

}
