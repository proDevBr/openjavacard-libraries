/*
 * openjavacard-libraries: OpenJavaCard Libraries
 * Copyright (C) 2017-2018 Ingo Albrecht, prom@berlin.ccc.de
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3.0 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA
 *
 */

package org.openjavacard.lib.auth;

import javacard.framework.APDU;

public class AuthMethodMedium extends AuthMethod {

    private final byte mMediumRequired;

    public AuthMethodMedium(byte mediumRequired) {
        mMediumRequired = mediumRequired;
    }

    @Override
    public boolean verify() {
        byte medium = (byte)(APDU.getProtocol() & APDU.PROTOCOL_MEDIA_MASK);
        return medium == mMediumRequired;
    }

}