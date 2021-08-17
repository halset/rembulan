/*
 * Copyright 2016 Miroslav Janíček
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.sandius.rembulan.lib.io;

/**
 * 
 */
public interface SeekableStream {

    /**
     * 
     * @return a long with the position
     */
	long getPosition();

	/**
	 * 
	 * @param newPosition a long with the new position.
	 * @return a long with the new position
	 */
	long setPosition(long newPosition);

	/**
	 * 
	 * @param offset a long with number of bytes to jump ahead.
     * @return a long with the new position
	 */
	long addPosition(long offset);

}
