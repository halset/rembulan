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

package net.sandius.rembulan.lib;

/**
 * 
 */
public class UnexpectedArgumentException extends IllegalArgumentException {

	/**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     * @param message the message to use for the exception
     */
    public UnexpectedArgumentException(String message) {
		super(message);
	}

    /**
     * 
     * @param expected a {@link String} with the expected value.
     * @param actual a {@link String} with the actual value that is different from the expected value.
     */
	public UnexpectedArgumentException(String expected, String actual) {
		this(expected + " expected, got " + actual);
	}

}
